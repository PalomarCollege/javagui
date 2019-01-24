/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_button;

import javax.swing.*;    
public class Csci230_button {  
public static void main(String[] args) {  
    JFrame f=new JFrame("Code Example - Button ");  
    JButton b=new JButton("Click Me");  
    b.setBounds(55,100,95,35);  
    f.add(b);  
    f.setSize(200,200);  
    f.setLayout(null);  
    f.setVisible(true);   
}  
}  