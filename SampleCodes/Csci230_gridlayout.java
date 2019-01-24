/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_gridlayout;
/*
*
*  Purpose: Demonstrate Grid Layout
*
*/


import java.awt.*;
import javax.swing.*;
public class Csci230_gridlayout extends JFrame {
    
    private JLabel[] labels = new JLabel[15];
   
    public Csci230_gridlayout() {
        
        super("Grid Layout Manager Demo");
        GridLayout layout = new GridLayout(3,5);
        setLayout(layout);
        
        for (int i=0; i < 15; i++)
        {
            String text = "label_" + Integer.toString(i);
            labels[i] = new JLabel(text, JLabel.CENTER);
            labels[i].setForeground(Color.red);
            add(labels[i]);
        }
            
    }
    
    public static void main(String[] args) {
        Csci230_gridlayout frame = new Csci230_gridlayout();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,480);       
        frame.setVisible(true);
    }}

