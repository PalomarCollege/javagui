/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_label;

/*
 * Purpose: Demonstrate Label
 * 
 */
import java.awt.*;
import javax.swing.*;
public class Csci230_label extends JFrame {
    
    private JLabel label1, label2, label3;
    public Csci230_label() {
        super("Label Test");
        setLayout(new FlowLayout());  
        label1 = new JLabel("", new ImageIcon("palomar_college.png"), JLabel.CENTER );
        label2 = new JLabel("CSCI230- Java GUI Class", null, JLabel.CENTER);
        label2.setToolTipText("Java Graphical User Interface");
        label2.setForeground(Color.blue);
        Font font2 = new Font("COURIER", Font.PLAIN, 40);
        /*
         *   Font Family: Serif, TimesRoman, Helvitica, Courier, Courier...
         *   Font Sytle: FONT.PLAIN, FONT.BOLD, FONT.ITALIC, FONT.ITALIC+FONT.BOLD 
         */
        label2.setFont(font2);
        label3 = new JLabel();
        label3.setText("Spring, 2019");
        
        Font font3 = new Font("Helvitica", Font.ITALIC, 20);
        label3.setFont(font3);
        label3.setText("Spring, 2019");
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setVerticalTextPosition(SwingConstants.BOTTOM); 
        add(label1);
        add(label2);
        add(label3);  
    }
    public static void main(String[] args) {
        Csci230_label label = new Csci230_label();
        label.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label.setSize(420,400);       
        label.setVisible(true);
    }}
