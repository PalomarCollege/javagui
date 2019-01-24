/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_list;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;

public class Csci230_list {

    public static void main(String[] args) {
        JFrame window = new JFrame("Java Swing List");
        window.setSize(400,400);
        
        String[] data = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        JList<String> myList = new JList<String>(data);

        window.add(myList);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }    
}
