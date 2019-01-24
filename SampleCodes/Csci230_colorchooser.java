/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_colorchooser;

/*
 * Demonstrates:
 *1)  JColorChooser
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Csci230_colorchooser extends JFrame{    
    public Csci230_colorchooser(){
        super("CS230 - Color Chooser");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        add(Box.createRigidArea(new Dimension(60, 120)));
        JButton button = new JButton("Color Control");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     Color newColor;
                     newColor = JColorChooser.showDialog(
                                null, //parent component
                                "Background Color", //Title
                                getContentPane().getBackground()); //the initial color
                     if(newColor != null){
                     getContentPane().setBackground(newColor);
                }
                }
                });
        add(button);
        
        
        setSize(300, 240);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
            Csci230_colorchooser frame = new Csci230_colorchooser();
            frame.setVisible(true);
        }
        });
    }
        
}


