/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_windowautocenter;

/*
*  Purpose: Demonstrate window auto center and image display
*/

import java.awt.*;
import javax.swing.*;

public class Csci230_windowautocenter extends JFrame {
    private JLabel label1, label2, label3;
    
    public Csci230_windowautocenter() {
        super("Label Test");
        setLayout(new FlowLayout());  
        label1 = new JLabel("Palomar College", JLabel.CENTER );
        label2 = new JLabel("CSCI230- Java GUI Class", null, JLabel.CENTER);
        label2.setToolTipText("Java Graphical User Interface");
        label2.setForeground(Color.blue);
        Font font = new Font("Serif", Font.PLAIN, 30);
        label2.setFont(font);
        label3 = new JLabel();
        label3.setText("Spring, 2019");
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setVerticalTextPosition(SwingConstants.BOTTOM); 
        add(label1);
        add(label2);
        add(label3);  
    }
    public static void main(String[] args) {
        Csci230_windowautocenter frame = new Csci230_windowautocenter();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //here showing the toolkit
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension size = tk.getScreenSize();
        //tk.beep();
        Image img = tk.getImage("earth.png");
        frame.setIconImage(img);
        frame.setSize((size.width)/2,(size.height)/2);
        frame.setLocation(500, 500);
       
        frame.setTitle("Palomar");
        
        frame.setVisible(true);
    }

 
}
