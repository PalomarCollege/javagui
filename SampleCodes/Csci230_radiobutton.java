/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_radiobutton;

/*
 * Demonstrates:
 * 1) Radio Button;
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Csci230_radiobutton extends JFrame implements ActionListener{
    static String toyotaString = "Toyota";
    static String hondaString = "Honda";
    static String teslaString = "Tesla";
    
    private JLabel label = null; 
    
   public Csci230_radiobutton(){
        super("CSCI230- Radio Button");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        JRadioButton toyotaButton = new JRadioButton(toyotaString);
        toyotaButton.setActionCommand(toyotaString);
        toyotaButton.addActionListener(this);
        toyotaButton.setSelected(true);
        
        JRadioButton hondaButton = new JRadioButton(hondaString);
        hondaButton.setActionCommand(hondaString);
        hondaButton.addActionListener(this);
        
        
        JRadioButton teslaButton = new JRadioButton(teslaString);
        teslaButton.setActionCommand(teslaString);
        teslaButton.addActionListener(this);
        
        ButtonGroup group = new ButtonGroup();
        group.add(toyotaButton);
        group.add(hondaButton);
        group.add(teslaButton);
        
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(toyotaButton);
        radioPanel.add(hondaButton);
        radioPanel.add(teslaButton);
        radioPanel.setPreferredSize(new Dimension(240, 144));
        radioPanel.setMaximumSize(new Dimension(240, 144));
        
        label = new JLabel(); 
        label.setText("Toyota");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(radioPanel);
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
            Csci230_radiobutton frame;
                frame = new Csci230_radiobutton();
            frame.setVisible(true);
    }
    });
                }
    
    
    @Override
        public void actionPerformed(ActionEvent e){
            label.setText(e.getActionCommand());
            
            
    }
}
              

