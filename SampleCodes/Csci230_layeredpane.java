/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_layeredpane;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Csci230_layeredpane extends JFrame {
  public Csci230_layeredpane() {
    setSize(640, 480);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    JLayeredPane lp = getLayeredPane();
    
    JButton top = new JButton();
    top.setBackground(Color.white);
    top.setText("top");
    top.setBounds(20, 20, 250, 50);
    
    JButton middle = new JButton();
    middle.setBackground(Color.gray);
    middle.setText("middle");
    middle.setBounds(40, 40, 250, 50);
    
    JButton bottom = new JButton();
    bottom.setBackground(Color.black);
    bottom.setText("bottom");
    bottom.setBounds(60, 60, 250, 50);
    //bottom.setOpaque(true);

    lp.add(middle, new Integer(2));
    lp.add(top, new Integer(3));
    lp.add(bottom, new Integer(1));
    
    setVisible(true);
  }

  public static void main(String[] args) {
    new Csci230_layeredpane();
  }
}

