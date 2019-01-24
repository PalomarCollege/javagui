/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_actionlistenerinterface;

/*
* Purpose: Demonstrate  "ActionListener" interface
*/


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Csci230_actionlistenerinterface extends JFrame implements ActionListener{
    private JLabel label1, label2;
    private Integer numClicks=0;
    public Csci230_actionlistenerinterface() {
        super("Csci230_actionlistenerinterface");
        setLayout(new BorderLayout()); 
        label1 = new JLabel("Hello CSCI230");
        label1.setHorizontalAlignment(JLabel.CENTER);
        add(label1, BorderLayout.NORTH);
        
        label2 =  new JLabel();
        label2.setHorizontalAlignment(JLabel.CENTER);
        
        JButton button =  new JButton("I am a hero!!!!");
        button.setSize(60, 20);
        
        /*
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            numClicks ++; 
            label2.setText("You Clicked " + numClicks + " times");
            JOptionPane.showMessageDialog(null, "You clicked me!");
            }
        });
        */
        
        button.addActionListener(this);
        
        
        add(button, BorderLayout.SOUTH);
        add(label2);
        
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        Csci230_actionlistenerinterface frame = new Csci230_actionlistenerinterface();
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // here is the actionPerformed method
    public void actionPerformed(ActionEvent e) {
                numClicks ++;
               
                label2.setText("You Clicked " + e.getActionCommand() +" " + numClicks + " times");  
                JOptionPane.showMessageDialog(null, "You clicked me!");
                
        }
    
}