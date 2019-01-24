/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_checkbox;

/*
 * Demonstrates:
 *1)  BoxLayout
 *2)  actionPerformed override.
 *3)  ActionEvent getSource
 *4)  CheckBox
 */


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Csci230_checkbox extends JFrame implements ActionListener{    
    public Csci230_checkbox(){
        super("Check Box");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        add(Box.createRigidArea(new Dimension(60, 120)));
        JCheckBox checkbox = new JCheckBox("Title Control", true);
        checkbox.setFocusable(false);
        checkbox.addActionListener(this);
        add(checkbox);
        
        setTitle("I have title!");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
            Csci230_checkbox frame;
                frame = new Csci230_checkbox();
                frame.setSize(400, 400);
            frame.setVisible(true);
        }
        });
    }
        
        @Override
        public void actionPerformed(ActionEvent e){
        String com;
        com = e.getActionCommand();
        JCheckBox source = (JCheckBox) e.getSource();
        boolean state = source.isSelected();
        System.out.println(com);
        System.out.println(state);
        if (state) {
            this.setTitle("I have title!");
        } else {
            this.setTitle("");
        }
        
        }

}

