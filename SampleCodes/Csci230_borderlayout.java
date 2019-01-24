/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

/*
*
*  Purpose: Demonstrate Border Layout
*
*/

package csci230_borderlayout;


import java.awt.*;
import javax.swing.*;
public class Csci230_borderlayout extends JFrame {
    
    private JLabel[] labels = new JLabel[5];
   
    public Csci230_borderlayout() {
        
        super("Border Layout Manager Demo");
        //create border layout object
        BorderLayout layout = new BorderLayout();
        //set current panel to use the layout object 
        setLayout(layout);
        
        //create five lables
        for (int i=0; i < 5; i++)
        {
            String text = "label_" + Integer.toString(i);
            labels[i] = new JLabel(text, JLabel.CENTER);
            labels[i].setForeground(Color.red);
        }
        
        //add labels to the current panel
        add(labels[0], BorderLayout.NORTH);
        add(labels[1], BorderLayout.CENTER);
        add(labels[2], BorderLayout.EAST);
        add(labels[3], BorderLayout.WEST);
        add(labels[4], BorderLayout.SOUTH);
            
    }
    
    public static void main(String[] args) {
        Csci230_borderlayout frame = new Csci230_borderlayout();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,480);       
        frame.setVisible(true);
    }}

