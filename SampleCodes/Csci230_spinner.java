/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_spinner;

/*
 * Demonstrates:
 * 1) Spinner
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Csci230_spinner extends JFrame implements ActionListener{
 
   private JLabel label = new JLabel("Year: 2019"); 
    
   public Csci230_spinner(){
        super("CSCI230-Spinner");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        SpinnerModel yearSpinnerModel =
         new SpinnerNumberModel(2019, //initial value
            2000, //min
            2030, //max
            1);//step
        
        JSpinner yearspinner = new JSpinner(yearSpinnerModel);
        
        yearspinner.addChangeListener(new ChangeListener() {
         public void stateChanged(ChangeEvent e) {
            label.setText("Year : " 
            + ((JSpinner)e.getSource()).getValue());
         }          
      });
        
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
       
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(yearspinner);
       
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(label);
        
        setSize(400,100);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          
   }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
            Csci230_spinner frame;
                frame = new Csci230_spinner();
            frame.setVisible(true);
    }
    });
                }
     
    @Override
        public void actionPerformed(ActionEvent e){
        ;        
    }
}
