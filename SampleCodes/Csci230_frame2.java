/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_frame2;

import javax.swing.JFrame;

public class Csci230_frame2 extends JFrame{
    public Csci230_frame2() {
        super("CSCI230");
        setSize(640, 480);
        //final JLabel label = new JLabel("Hello CSCI230");
        //getContentPane().add(label);
        //add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
    }

    public static void main(String[] args) {
        Csci230_frame2 frame = new Csci230_frame2();
        frame.setVisible(true);
    }
}

