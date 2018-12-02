package gui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.HashMap;
import java.util.Properties;
import java.util.Vector;
/**
 * 
 * @author klevi, pcorazza 
 * @since Oct 22, 2004
 * <p>
 * Class Description: This class presents a table of all catalogs
 * available in the database, and allows the user to add
 * edit or delete groups. Not all functionality for these buttons
 * is implemented on initial creation of this class.
 * <p>
 * <table border="1">
 * <tr>
 * 		<th colspan="3">Change Log</th>
 * </tr>
 * <tr>
 * 		<th>Date</th> <th>Author</th> <th>Change</th>
 * </tr>
 * <tr>
 * 		<td>Oct 22, 2004</td>
 *      <td>klevi, pcorazza</td>
 *      <td>New class file</td>
 * </tr>
 *<tr>
 * 		<td>19 jan 2005</td>
 *      <td>klevi</td>
 *      <td>modified readdata comment; changed static method, getCatalogtypes, to use class vs instance</td>
 * </tr>
 * </table>
 *
 */
public class MaintainCatalogTypes extends javax.swing.JWindow implements ParentWindow {

	/** Parent is used to return to main screen */
	private Window parent;

	
	/////////////constants
	
	//should be set to 'false' if data for table is obtained from a database
	//or some external file
	private final boolean USE_DEFAULT_DATA = true;
	private final String ADD = "Add";
	private final String EDIT = "Edit";
	private final String DELETE = "Delete";
	private final String BACK = "Back";	
	
	private final String MAIN_LABEL = "Maintain Category Types";
	
	//table configuration
	private Properties headers;  
	
	private final int TABLE_WIDTH = Math.round(0.75f*GuiControl.SCREEN_WIDTH);
    private final int DEFAULT_TABLE_HEIGHT = Math.round(0.75f*GuiControl.SCREEN_HEIGHT);
    private final String TABLE_TITLE = "Name of Category Group";

	//JPanels
	private JPanel mainPanel;
	private JPanel upperSubpanel;
	private JPanel lowerSubpanel;
	
	//other widgets
	private String title;
	private String tableLabelText;
	private JLabel tableLabel;
	private JScrollPane tablePane;
	private JTable table;
	
	
    private DefaultTableModel model;
 

 
	public MaintainCatalogTypes() {
		initializeWindow();
		defineMainPanel();
		getContentPane().add(mainPanel);
	}
	


	private void initializeWindow() {
		setSize(GuiControl.SCREEN_WIDTH,GuiControl.SCREEN_HEIGHT);		
		GuiControl.centerFrameOnDesktop(this);
		
	}
	private void defineMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(GuiControl.FILLER_COLOR);
		mainPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));
		defineUpperPanel();
		defineLowerPanel();
		mainPanel.add(upperSubpanel,BorderLayout.NORTH);
		mainPanel.add(lowerSubpanel,BorderLayout.SOUTH);
			
	}
	private void defineUpperPanel() {
		upperSubpanel = new JPanel();
		upperSubpanel.setLayout(new BorderLayout());
		upperSubpanel.setBackground(GuiControl.FILLER_COLOR);
		
		//create and add label
		createTableLabel();
		upperSubpanel.add(tableLabel,BorderLayout.NORTH);
		
		//create and add table
		createTableAndTablePane();
		JPanel tablePanePanel = GuiControl.createStandardTablePanePanel(table,tablePane);
	
		upperSubpanel.add(tablePanePanel,BorderLayout.CENTER);
		
		
		
	}
	private void createTableLabel() {
		tableLabel = new JLabel(MAIN_LABEL);
		tableLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		Font f = GuiControl.makeVeryLargeFont(tableLabel.getFont());
		f = GuiControl.makeBoldFont(f);
		tableLabel.setFont(f);
		
		
		
	}
	
	private void createTableAndTablePane() {
		updateModel();
		table = new JTable(model);
		tablePane = new JScrollPane();
		tablePane.setPreferredSize(new Dimension(TABLE_WIDTH, DEFAULT_TABLE_HEIGHT));
		tablePane.getViewport().add(table);
		

		
	}
	
	
	
	/**
	 * This method loads data into a concrete subclass of AbstractTableModel,
	 * to be displayed in a JTable. It is called when the GUI is built.<p>
	 * Any time table data needs to be added, changed, or deleted,
	 * updateModel must be called, followed by a call to updateTable.<p>
	 * The the updateModel method, by default,
	 * loads data by reading fake data from the DefaultData
	 * class. For the E-Bazaar project, real data should be inserted somehow into
	 * a variable in this class (by the constructor or some other setter) and
	 * then accessed during execution of updateModel. 
	 */
	private void updateModel() {
		if(model == null) {
	        model = new DefaultTableModel();
    	    
		}
        if(USE_DEFAULT_DATA) {
        	model.addColumn(TABLE_TITLE);			        	
			String[][] defaultData = DefaultData.getCatalogTypes();
	       	for(int i= 0; i < defaultData.length; ++i) {
        		model.addRow(defaultData[i]);
        	}
        }
        else {
        	//students: in this block, cast data to the right type 
        	//and set values in model 
        }
	}	

	
	
    private void updateTable() {
        
        table.setModel(model);
        table.updateUI();
        repaint();
        
    }	

	private void defineLowerPanel() {
		 
		//add button
		JButton addButton = new JButton(ADD);
		addButton.addActionListener(new AddButtonListener());
		
		//edit button
		JButton editButton = new JButton(EDIT);
		editButton.addActionListener(new EditButtonListener());
		
		
		//delete button
		JButton deleteButton = new JButton(DELETE);
		deleteButton.addActionListener(new DeleteButtonListener());
		
		
		//back button
		JButton backButton = new JButton(BACK);
		backButton.addActionListener(new BackButtonListener());
		

		
		
		//create lower panel
		JButton [] buttons = {addButton,editButton,deleteButton,backButton};
		lowerSubpanel = GuiControl.createStandardButtonPanel(buttons);
		
		
	}
	public void setParentWindow(Window parentWindow) {
		parent = parentWindow;
	}
	
	public Window getParentWindow() {
		return parent;
	}
		//data for Listeners
	
	final String ERROR_MESSAGE = "Please select a row.";
	final String ERROR = "Error";
		
	class AddButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
        	
        	AddEditCatalog addType = new AddEditCatalog(GuiControl.ADD_NEW,null);
        	setVisible(false);
        	addType.setParentWindow(MaintainCatalogTypes.this);
        	addType.setVisible(true);
        	
        }        	
 
	
	}
	class EditButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	
        	int selectedRow = table.getSelectedRow();
        	if(selectedRow >= 0) {
        		String selectedType = (String)model.getValueAt(selectedRow,0);
        								       														
        		AddEditCatalog editType = new AddEditCatalog(GuiControl.EDIT,selectedType);
        		editType.setVisible(true);
        		
        		
        	}
        	else {
       			JOptionPane.showMessageDialog(MaintainCatalogTypes.this,         									          
        									  ERROR_MESSAGE,
        									  ERROR, 
        									  JOptionPane.ERROR_MESSAGE);
        		
        	}
        		

        }
	}
	class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	int selectedRow = table.getSelectedRow();
        	if(selectedRow >= 0) {
				// Students: code goes here.
				JOptionPane.showMessageDialog(MaintainCatalogTypes.this, 
										  "Need to write code for this!", 
										  "Information", 
										  JOptionPane.INFORMATION_MESSAGE);        		
        		
        	}
        	else {
       			JOptionPane.showMessageDialog(MaintainCatalogTypes.this,         									          
        									  ERROR_MESSAGE,
        									  ERROR, 
        									  JOptionPane.ERROR_MESSAGE);
        		
        	}        	
        	

        }
	}	
	
	
	class BackButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			if(parent != null) {
				parent.setVisible(true);
			}
		    dispose();		
		}
	}	
	
	public static void main(String args[]) {
	
		(new MaintainCatalogTypes()).setVisible(true);
	}

}