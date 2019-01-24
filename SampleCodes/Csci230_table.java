/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_table;

/*Demonstrates: 
 *      1) SWING table
 *      2) JScrollPane
 */

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;

public class Csci230_table {

    //main
    public static void main(String[] args) {
     
         //Use the event dispatch thread for Swing components
         EventQueue.invokeLater(new Runnable()
         {
             
            @Override
             public void run()
             {
                 
                Csci230_table csci230_table = new Csci230_table();         
             }
         });
              
    }
    
    public Csci230_table()
    {
        JFrame guiFrame = new JFrame();
        
        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("csci230_table - Table Example");
        guiFrame.setSize(700,200);
      
        //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);
        
        //Create the JTable using the ExampleTableModel implementing 
        //the AbstractTableModel abstract class
        JTable table = new JTable(new ExampleTableModel());
        
        //Set the column sorting functionality on
        table.setAutoCreateRowSorter(true);
        
        //Uncomment the next line if you want to turn the grid lines off
       //table.setShowGrid(false);
        
        //Change the colour of the table - yellow for gridlines 
        //blue for background
        table.setGridColor(Color.YELLOW);
        table.setBackground(Color.CYAN);

        table.setRowHeight(9, 160);
        
        //set the wealth column to be larger than the rest and the Place column 
        //to be smaller
        TableColumn eventColumn = table.getColumnModel().getColumn(2);
        eventColumn.setPreferredWidth(150);
        
        TableColumn sourceColumn = table.getColumnModel().getColumn(6);
        sourceColumn.setPreferredWidth(5);
        
        
        
        //Place the JTable object in a JScrollPane for a scrolling table
        JScrollPane tableScrollPane = new JScrollPane(table);
        
        guiFrame.add(tableScrollPane);
        guiFrame.setVisible(true);
    }
    
    //implement a table model by extending a class to use
    //the AbstractTableModel
    class ExampleTableModel extends AbstractTableModel{
        
        //Two arrays used for the table data
        //Data Source: http://www.forbes.com/forbes-400/list/
        String[] columnNames = {"", "Rank", "Name", "Wealth (B$)", "Change(M$)", "Age"
                        , "Residence", "Source", "Increased?" };
        
        Object[][] data = {
        {"", 1, "<HTML> <strong> Bill Gates </strong> </html>", 81, 4.4, 58, "Medina, WA", "Microsoft", true },
 	{"", 2, "Warren Buffett", 68.3, 27, 84, "Omaha, NE",  "Berkshire Hathaway", true},
 	{"", 3, "Larry Ellison", 48.8, 121.9, 70, "Woodside, CA", "Oracle", true},
 	{"", 4, "Charles Koch", 41.9, 0, 78, "Wichita, KS", "diversified", false},
 	{"", 5, "David Koch", 41.9, 0, 74, "New York, NY", "diversified", false},
 	{"", 6, "Christy Walton & family", 38.5, 36.3, 59, "Jackson, WY", "Walmart", true},
 	{"", 7, "Jim Walton", 37, 8.2, 66, "Bentonville, AR", "WalMart", true},
 	{"", 8, "Alice Walton", 35.5, 8.2, 64, "Fort Worth, TX", "WalMart", true},
 	{"", 9, "S. Robson Walton", 35.5, 5, 70, "Bentonville, AR", "WalMart", true},
 	{"<html><img src='https://imagesvc.timeincapp.com/v3/mm/image?url=https%3A%2F%2Fcdn-img.instyle.com%2Fsites%2Fdefault%2Ffiles%2Fstyles%2F684xflex%2Fpublic%2Fimages%2F2015%2F12%2F120815-mark-zuckerberg.jpg%3Fitok%3DueOx0eEC&w=400&c=sc&poi=face&q=85'/> </html> ", 10, " Mark Zuckerberg ", 34.2, 65.2, 30, "Palo Alto, CA", "Facebook", true}  
        };
        
        @Override
        public int getRowCount()
        {
            return data.length;
        }
        
        @Override
        public int getColumnCount()            
        {
            return columnNames.length;
        }
        
        @Override
        public Object getValueAt(int row, int column)
        {        
            return data[row][column];
        }
        
        //Used by the JTable object to set the column names
        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
        
        //Used by the JTable object to render different
        //functionality based on the data type
        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        
        @Override
        public boolean isCellEditable(int row, int column)
        {
           if (column == 0 || column == 1)
	   {
	        return false;
	   }
	   else
	   {
		return true;
	   }
        }
        
   
    }       
}


