/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_textfield;

import javax.swing.*;    
public class Csci230_textfield {  
public static void main(String[] args) {  
    JFrame f=new JFrame("Code Example - TextField ");  
    JTextField firstName=new JTextField("Type here");  
    firstName.setBounds(55,100,95,35);  
    f.add(firstName);  
    f.setSize(200,200);  
    f.setLayout(null);  
    f.setVisible(true);   
}  
}  