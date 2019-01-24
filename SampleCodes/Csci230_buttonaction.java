/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_buttonaction;

/*
*  Purpose: Demostrate button and action Listener
*
*/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Csci230_buttonaction extends JFrame{
    private int numClicks=0;
    public Csci230_buttonaction() {
        super("CSCI230");
        setLayout(new BorderLayout()); 
        JLabel label1 = new JLabel("Hello CSCI230");
        label1.setHorizontalAlignment(JLabel.CENTER);
        add(label1, BorderLayout.NORTH);
        final JLabel label2 =  new JLabel();
        label2.setHorizontalAlignment(JLabel.CENTER);
        
        JButton button =  new JButton("Click Me!");
        button.setSize(60, 20);
        //=============
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            numClicks ++; 
            label2.setText("You Clicked " + numClicks + " times");
            JOptionPane.showMessageDialog(null, "You clicked me!");
            }
        });
	//=============
        add(button, BorderLayout.SOUTH);
        add(label2);
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        Csci230_buttonaction frame;
        frame = new Csci230_buttonaction();
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

