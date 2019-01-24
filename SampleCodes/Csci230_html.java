/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_html;

/*
 * Demonstrates: 
 * 1) HTML in SWING 
 * 2) GridLayout;
 * 3) Border Factory;
 */

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Csci230_html extends JFrame{
    public Csci230_html()  {
        initGUI();    
    }
    
    public final void initGUI(){
        setTitle("CSCI 230 html");
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        //panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setLayout(new GridLayout(5, 3, 5, 5));
        
        String[] buttons = {
            "1", "<html> <body> <p align='center'> <strong> <font size='5'> 2 </font> </strong> <br> ABC </p> </body> </html>", 
            "3", "4", "5", "6", "7", "8", "9", "*", "0",
            "#", "+", "Call", "<=" 
        };
        
        for (int i = 0; i < buttons.length; i++) {
                JButton myb = new JButton(buttons[i]);
                if (i == 13) {
                   myb.setBackground(new Color(0x00ff11));  
                   myb.setOpaque(true);
                   myb.setBorderPainted(false);
                }
                panel.add(myb); 
        }

        add(panel);
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Csci230_html ex = new Csci230_html();
                ex.setVisible(true);
            }
        });
    }
}

