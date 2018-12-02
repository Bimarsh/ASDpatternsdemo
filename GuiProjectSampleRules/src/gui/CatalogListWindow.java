package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import gui.CatalogListWindow;

import java.util.Vector;

/**
 * 
 * @author klevi, pcorazza 
 * @since Oct 22, 2004
 * <p>
 * Class Description: This screen presents the list of all E-Bazaar
 * catalogs. As of creation date, there were just two catalogs in the 
 * default data: Books
 * and Clothes. Clicking the Browse button when one of the catalogs
 * has been selected invokes an instance
 * of ProductListWindow, displaying the available items for the selected
 * catalog.
 * Students:  See the readdata method for where data is put into the table.
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
 * <tr>
 * 		<td>jan 19 2005</td>
 *      <td>klevi</td>
 *      <td>modified class and readdata comments</td>
 * </tr>
 * </table>
 *
 */
public class CatalogListWindow extends javax.swing.JWindow implements ParentWindow {
	
	/** Parent is used to return to main screen */
	private Window parent;

	//////////////constants
	
	//should be set to 'false' if data for table is obtained from a database
	//or some external file
	private final boolean USE_DEFAULT_DATA = true;
	

	
	private final String MAIN_LABEL = "Browse Catalog";
	private final String BROWSE = "Browse";
	private final String BACK_TO_MAIN = "Back To Main";
	private final int TABLE_WIDTH = Math.round(0.75f*GuiControl.SCREEN_WIDTH);
    private final int DEFAULT_TABLE_HEIGHT = Math.round(0.75f*GuiControl.SCREEN_HEIGHT);
    private final String[] COLUMN_HEADERS = {"Available Catalogs"};

	//JPanels
	private JPanel mainPanel;
	private JPanel upperSubpanel;
	private JPanel lowerSubpanel;
	private JPanel labelPanel;
	
	//other widgets
	
	private JScrollPane tablePane;
	private JTable table;
	private DefaultTableModel model;
	 
    public static CatalogListWindow instance;
    
	public static CatalogListWindow getInstance() {
		//better if it's not a singleton -- as a singleton, it
		//doesn't refresh properly
		instance=new CatalogListWindow();
		return instance;

	}
	
	private CatalogListWindow() {
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
		createMainLabel();
		upperSubpanel.add(labelPanel,BorderLayout.NORTH);
		
		//create and add table
		createTableAndTablePane();
		JPanel tablePanePanel = GuiControl.createStandardTablePanePanel(table,tablePane);
	
		upperSubpanel.add(tablePanePanel,BorderLayout.CENTER);
		
		
		
	}
	
	private void createMainLabel() {
		JLabel mainLabel = new JLabel(MAIN_LABEL);
		Font f = GuiControl.makeVeryLargeFont(mainLabel.getFont());
		f = GuiControl.makeBoldFont(f);
		mainLabel.setFont(f);
		labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		labelPanel.setBackground(GuiControl.FILLER_COLOR);
		labelPanel.add(mainLabel);		
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
    	    model.addColumn(COLUMN_HEADERS[0]);
		}
        if(USE_DEFAULT_DATA) {
        	DefaultData data = DefaultData.getInstance();			        	
			String[][] defaultData = data.getMainCatalogData();
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
		 
		//browse button
		JButton browseButton = new JButton(BROWSE);
		browseButton.addActionListener(new BrowseButtonListener());
		
		
		//back button
		JButton backButton = new JButton(BACK_TO_MAIN);
		backButton.addActionListener(new BackToMainButtonListener());
		
		
		//create lower panel
		JButton [] buttons = {browseButton,backButton};
		lowerSubpanel = GuiControl.createStandardButtonPanel(buttons);
		
		
	}
	public void setParentWindow(Window parentWindow) {
		parent = parentWindow;
	}
	
	public Window getParentWindow() {
		return parent;
	}
		
	class BrowseButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	int selectedRow = table.getSelectedRow();
        	
        	if(selectedRow >= 0) {
        		String type = (String)table.getValueAt(selectedRow,0);
        		System.out.println(type);
        		
        		setVisible(false);
        		ProductListWindow c = new ProductListWindow(type);
        		c.setParentWindow(CatalogListWindow.this);
        		c.setVisible(true);
        		
        		
        	}
        	//value of selectedRow is -1, which means no row was selected
        	else {
        		String errMsg = "Please select a row.";
        		JOptionPane.showMessageDialog(CatalogListWindow.this,         									          
        									          errMsg,
        									          "Error", 
        									          JOptionPane.ERROR_MESSAGE);

        	}
        }
	}
	
	class BackToMainButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			if(parent != null) {
				parent.setVisible(true);
			}
		    setVisible(false);			
		}
	}
	
	public static void main(String[] args) {
		CatalogListWindow.getInstance().setVisible(true);	
	}	
		

	
}