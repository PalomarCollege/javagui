/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_textarea;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Csci230_textarea {

    public static void main(String[] args) {
        JFrame window = new JFrame("Java Swing Text Area");
        window.setSize(400,400);
        JTextArea text = 
         new JTextArea("This is to show text area",5,20);
        window.add(text);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    
}
