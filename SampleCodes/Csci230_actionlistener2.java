/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_actionlistener2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Csci230_actionlistener2 extends JFrame implements ActionListener{
    // need to override actionPerformed()
    public Csci230_actionlistener2() {
        super("CSCI 230");
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        //tooltip
        panel.setToolTipText("A Panel container");
       
        JButton rightButton = new JButton("Left");
        rightButton.setBounds(500, 30, 80, 30); 
        rightButton.addActionListener(this);
        panel.add(rightButton); 
        
        JButton leftButton = new JButton("Right");
        leftButton.setBounds(10, 30, 80, 30); 
        leftButton.addActionListener(this);
        panel.add(leftButton); 
        
        JButton exitButton= new JButton("Exit");  
        //butt.setSize(60, 20);
        exitButton.setBounds(280, 130, 80, 30);  
        exitButton.addActionListener(this);
        panel.add(exitButton); 
          
        setSize(600, 200);
        setLocationRelativeTo(null);
        //pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        //places the application on the Swing Event Queue
        //ensure that all UI updates are concurrency-safe.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
            Csci230_actionlistener2 frame = new Csci230_actionlistener2();
        }
    });
    }
        
    @Override
    public void actionPerformed(ActionEvent e){
        String com;
        com = e.getActionCommand();
        
        if (com.equals("Exit")) {
            System.exit(0);
        }
        else {           
            JOptionPane.showMessageDialog(null, "You clicked " + com);
        }
      
}
}

