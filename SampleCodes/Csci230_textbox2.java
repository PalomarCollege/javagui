/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/


package csci230_textbox2;

/*
 * Demonstrates:
 * 1) Textbox
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Csci230_textbox2 extends JFrame implements ActionListener{
    static String toyotaString = "Toyota";
    static String hondaString = "Honda";
    static String teslaString = "Tesla";
    static JTextField text = new JTextField();
    
    String[] company = { "Toyota", "Honda", "Tesla" };
    
    private JLabel label = null; 
    
   public Csci230_textbox2(){
        super("CSCI230- TextBox");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        text.setText("enter a text here....");
        
        JButton button = new JButton("Submit");
        button.addActionListener(this);
        
        label = new JLabel(); 
        label.setText("Toyota");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
       
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(text);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(button);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(label);
        
        setSize(400,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          
   }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
            Csci230_textbox2 frame;
                frame = new Csci230_textbox2();
            frame.setVisible(true);
    }
    });
                }
    
    
    @Override
        public void actionPerformed(ActionEvent e){
            String myString = (String) text.getText();
            label.setText(myString);
            
            
    }
}

