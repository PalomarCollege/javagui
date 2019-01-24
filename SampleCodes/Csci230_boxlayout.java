/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

/*
*
*  Purpose: Demonstrate Box Layout
*
*/
package csci230_boxlayout;

import java.awt.*;
import javax.swing.*;
public class Csci230_boxlayout extends JFrame {
    
    private JLabel[] labels = new JLabel[15];
   
    public Csci230_boxlayout() {
        
        super("Box Layout Manager Demo");
        BoxLayout layout = new BoxLayout(getContentPane(),BoxLayout.Y_AXIS);
        //BoxLayout layout = new BoxLayout(getContentPane(),BoxLayout.X_AXIS);
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
        Csci230_boxlayout frame = new Csci230_boxlayout();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,480);       
        frame.setVisible(true);
    }}

