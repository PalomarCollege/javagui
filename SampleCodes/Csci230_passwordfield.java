/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_passwordfield;

/*
 * Demonstrates:
 * 1) PasswordField
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Csci230_passwordfield extends JFrame implements ActionListener{
   
    static JTextField username = new JTextField();
    static JPasswordField password = new JPasswordField();
       
    private JLabel label = null; 
    
   public Csci230_passwordfield(){
        super("CSCI230-Code 31");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        username.setText("enter username");
        password.setText("enter password");
        JButton button = new JButton("Submit");
        button.addActionListener(this);
        
        label = new JLabel(); 
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        add(Box.createRigidArea(new Dimension(0, 5)));
        add(username);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(password);
        add(Box.createRigidArea(new Dimension(0, 40)));
        add(button);
        add(Box.createRigidArea(new Dimension(0, 60)));
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
            Csci230_passwordfield frame;
                frame = new Csci230_passwordfield();
            frame.setVisible(true);
    }
    });
          }
      
    @Override
        public void actionPerformed(ActionEvent e){
            String myusername = (String) username.getText();
            char[] mypassword = password.getPassword();
            label.setText(myusername);
            
            for (char i: mypassword)
                System.out.print(i);
             
    }
}
