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
 * Class Description: This window displays all known products belonging
 * to the selected catalog group. The catalog group is passed into
 * the constructor as  a parameter. In the final version of the
 * application, the products displayed should be all products in
 * the database having category group equal to this parameter. 
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
 * 		<td>Jan 19, 2005</td>
 *      <td>klevi</td>
 *      <td>modifed the readdata comments</td>
 * </tr>
 * </table>
 *
 */
public class ProductListWindow extends javax.swing.JWindow implements ParentWindow {

	//constants
	private final String AVAIL_BOOKS = "List of Available Books";
 	private final String AVAIL_CLOTHING = "List of Available Clothing";
 	
 	
 	/** Parent is used to return to main screen */
	private Window parent;

	
	/////////////constants
	
	//should be set to 'false' if data for table is obtained from a database
	//or some external file
	private final boolean USE_DEFAULT_DATA = true;
	private final String SELECT = "Select";
	private final String BACK = "Back";
	
	
	//table configuration
	private Properties headers;  
	
	private final int TABLE_WIDTH = Math.round(0.75f*GuiControl.SCREEN_WIDTH);
    private final int DEFAULT_TABLE_HEIGHT = Math.round(0.75f*GuiControl.SCREEN_HEIGHT);

	//JPanels
	private JPanel mainPanel;
	private JPanel upperSubpanel;
	private JPanel lowerSubpanel;
	private JPanel labelPanel;
	
	//other widgets
	private String title;
	private String mainLabelText;
	private JLabel mainLabel;
	private JScrollPane tablePane;
	private JTable table;
	
	private String catalogType;
    private DefaultTableModel model;
 
 	private void setTitleAndTableLabel(){
 		title = "Available "+catalogType;
 		mainLabelText = title;
 	}
 	/**
 	 * 
 	 * @param type - the category group (either books or clothes)
 	 */
	public ProductListWindow(String type) {
		this.catalogType = type;
		
		initializeWindow();
		initializeTableHeaderTable();
		defineMainPanel();
		getContentPane().add(mainPanel);
		
		
	}
	
	//this method iniitializes the table of headers for the table columns
	private void initializeTableHeaderTable() {
		headers = new Properties(); 
		headers.setProperty(DefaultData.BOOKS,this.AVAIL_BOOKS);
		headers.setProperty(DefaultData.CLOTHES,this.AVAIL_CLOTHING);		
		
	}

	private void initializeWindow() {
		setTitleAndTableLabel();
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
		JLabel mainLabel = new JLabel(mainLabelText);
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
    	    
		}
        if(USE_DEFAULT_DATA) {
        	String colHeader = headers.getProperty(catalogType);
        	model.addColumn(colHeader);
        	DefaultData data = DefaultData.getInstance();			        	
			String[][] defaultData = data.getCatalogWindowData(catalogType);
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
		 
		//select button
		JButton selectButton = new JButton(SELECT);
		selectButton.addActionListener(new SelectButtonListener());
		
		
		//back button
		JButton backButton = new JButton(BACK);
		backButton.addActionListener(new BackButtonListener());
		
		
		//create lower panel
		JButton [] buttons = {selectButton,backButton};
		lowerSubpanel = GuiControl.createStandardButtonPanel(buttons);
		
		
	}
	public void setParentWindow(Window parentWindow) {
		parent = parentWindow;
	}
	
	public Window getParentWindow() {
		return parent;
	}
		
	class SelectButtonListener implements ActionListener {
		Object readProductDetailsData() {
			DefaultData productData = DefaultData.getInstance();
			return productData.getProductDetailsData();	
		}
        public void actionPerformed(ActionEvent evt) {
        	
        	int selectedRow = table.getSelectedRow();
        	
        	if(selectedRow >= 0) {
        		String type = (String)table.getValueAt(selectedRow,0);
        		System.out.println(type);
        		
        		setVisible(false);
        		
        		HashMap productTable = (HashMap)readProductDetailsData();
        		String[] productParams = (String[])productTable.get(type);
        		//System.out.println("Is product params an instance of Object[]? "+(productParams instanceof Object[]));
        		ProductDetailsWindow pd =  new ProductDetailsWindow(productParams);
        		
        		setVisible(false);
        		pd.setParentWindow(ProductListWindow.this);
        		pd.setVisible(true);
        		
        		
        	}
        	//value of selectedRow is -1, which means no row was selected
        	else {
        		String errMsg = "Please select a row.";
        		JOptionPane.showMessageDialog(ProductListWindow.this,         									          
        									          errMsg,
        									          "Error", 
        									          JOptionPane.ERROR_MESSAGE);

        	}
        	
        }
	}
	
	class BackButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			
			parent.setVisible(true);
			setVisible(false);
		    			
		}
	}		
	
	public static void main(String args[]) {
	
		(new ProductListWindow("Clothes")).setVisible(true);
	}

}