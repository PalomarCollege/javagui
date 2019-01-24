/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_combobox;

/*
 * Demonstrates:
 * 1) Combo Box;
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Csci230_combobox extends JFrame implements ActionListener{
    static String toyotaString = "Toyota";
    static String hondaString = "Honda";
    static String teslaString = "Tesla";
    
    String[] company = { "Toyota", "Honda", "Tesla" };
    
    private JLabel label = null; 
    
   public Csci230_combobox(){
        super("CSCI230- Combo Box");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        JComboBox companyCombo = new JComboBox(company);
        companyCombo.setSelectedIndex(2);
        companyCombo.addActionListener(this);
        
        label = new JLabel(); 
        label.setText("Toyota");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
       
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(companyCombo);
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
            Csci230_combobox frame;
                frame = new Csci230_combobox();
            frame.setVisible(true);
    }
    });
                }
    
    
    @Override
        public void actionPerformed(ActionEvent e){
            JComboBox myCombo = (JComboBox) e.getSource();
            String myString = (String) myCombo.getSelectedItem();
            label.setText(myString);
            
            
    }
}