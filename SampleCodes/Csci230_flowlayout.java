/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

/*
*
*  Purpose: Demonstrate Flow Layout
*
*/
package csci230_flowlayout;

import java.awt.*;
import javax.swing.*;
public class Csci230_flowlayout extends JFrame {
    
    private final JLabel[] labels = new JLabel[15];
   
    public Csci230_flowlayout() {
        
        super("Flow Layout Manager Demo");
        //create Flow Layour object
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        
        //create 15 labels
        for (int i=0; i < 15; i++)
        {
            String text = "label_" + Integer.toString(i);
            labels[i] = new JLabel(text, JLabel.CENTER);
            labels[i].setForeground(Color.red);
            add(labels[i]);
        }
        
            
    }
    
    public static void main(String[] args) {
        Csci230_flowlayout frame = new Csci230_flowlayout();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,480);       
        frame.setVisible(true);
    }}


