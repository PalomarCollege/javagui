/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/


package csci230_gridbaglayout;

/*
*
*  Purpose: Demonstrate GridBag Layout
*
*/

import java.awt.*;
import javax.swing.*;
public class Csci230_gridbaglayout extends JFrame {
    
    private JButton[]  buttons= new JButton[16];
   
    public Csci230_gridbaglayout() {
        
        super("GridBagLayout Manager Demo");
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        for (int i=0; i < 6; i++)
        {
            String text = "button_" + Integer.toString(i);
            buttons[i] = new JButton(text);
            buttons[i].setForeground(Color.red);
            gbc.gridx = i;
            gbc.gridy = 0;
            add(buttons[i], gbc);
        }
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        for (int i=6; i < 12; i++)
        {
            String text = "button_" + Integer.toString(i);
            buttons[i] = new JButton(text);
            buttons[i].setForeground(Color.blue);
            gbc.gridx = i-6;
            gbc.gridy = 1;
            gbc.ipady = 20; 
            add(buttons[i], gbc);
        }
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        for (int i=12; i < 15; i++)
        {
            String text = "button_" + Integer.toString(i);
            buttons[i] = new JButton(text);
            buttons[i].setForeground(Color.green);
            gbc.gridx = (i-12) * 2;
            gbc.gridy = 2;
            gbc.ipady = 30; 
            gbc.gridwidth = 2;
            add(buttons[i], gbc);
        }
            
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int i = 15;
        String text = "button_" + Integer.toString(i);
        buttons[i] = new JButton(text);
        buttons[i].setForeground(Color.black);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipady = 20; 
       
        gbc.insets = new Insets(40,0,0,0);
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.gridwidth = 4;
        add(buttons[i], gbc);
    }
    
    public static void main(String[] args) {
        Csci230_gridbaglayout frame = new Csci230_gridbaglayout();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,480);       
        frame.setVisible(true);
    }}

