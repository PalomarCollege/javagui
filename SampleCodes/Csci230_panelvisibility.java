/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_panelvisibility;

/*
 * Demonstrates: 
 * 1) GridLayout;
 * 2) Border Factory;
 * 3) Change the visibility of panels
 */

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Csci230_panelvisibility extends JFrame implements ActionListener{
    private JPanel panel, panel2;
    
    public Csci230_panelvisibility()  {
        initGUI();    
    }
    
    public final void initGUI(){
        setTitle("CSCI 230 Panel Visibility Chnage");
        setLayout(new FlowLayout());
        panel = new JPanel();
        panel2 = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        //panel.setBorder(BorderFactory.createLineBorder(Color.red));
        panel.setLayout(new GridLayout(6, 3));
        panel2.setLayout(new GridLayout(2, 1));
        panel2.setBorder(BorderFactory.createEmptyBorder(75, 75, 75, 75));
        
        String[] buttons = {
            "1", "<html> <body> <p align='center'> <strong> <font size='5'> 2 </font> </strong> <br> ABC </p> </body> </html>", 
            "3", "4", "5", "6", "7", "8", "9", "*", "0",
            "#", "+", "Call", "<=", "Abt"
        };
        
        for (int i = 0; i < buttons.length; i++) {
                JButton myb = new JButton(buttons[i]);
                if (i == 13) {
                   myb.setBackground(new Color(0x00ff11));  
                   myb.setOpaque(true);
                   myb.setBorderPainted(false);
                }
                if (i==15) {
                    myb.addActionListener(this);
                }
                panel.add(myb); 
        }

        JLabel about = new JLabel("<html> <body align='center'> <h3> This is the coolest phone dialing pad.</h3><br> Version 0.01 </body> </html>");
        JButton ok = new JButton("ok");
        
        ok.addActionListener(this);
        panel2.add(about);
        panel2.add(ok);
                        
        add(panel);
        add(panel2);
        panel.setVisible(true);
        panel2.setVisible(false);
        setSize(350, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Csci230_panelvisibility ex = new Csci230_panelvisibility();
                ex.setVisible(true);
            }
        });
    }
    
        @Override
        public void actionPerformed(ActionEvent e){
        String com;
        com = e.getActionCommand();
        //JOptionPane.showMessageDialog(null, "You clicked " + com);
        if (com.equals("ok")) {
            panel2.setVisible(false);
            panel.setVisible(true);
        }
        if (com.equals("Abt")) {
            panel.setVisible(false);
            panel2.setVisible(true);
        }
        
        }
    
}
