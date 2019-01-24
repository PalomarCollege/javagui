/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_grayfilter;

/*
 * Demonstrates: 
 * 1)Image GrayFilter
 * 2)Setting Icon to Label
 * 
 */

import java.awt.Image;
import javax.swing.GrayFilter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Csci230_grayfilter {

    public static void main(String[] args) {
       JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon normalIcon = new ImageIcon("lena.jpg");
        Image normalImage = normalIcon.getImage();
        //create a gray image
        Image grayImage = GrayFilter.createDisabledImage(normalImage);
        Icon grayIcon = new ImageIcon(grayImage);
        JLabel grayLabel = new JLabel("Gray", grayIcon, JLabel.CENTER);
        JLabel normalLabel = new JLabel("Normal", normalIcon, JLabel.CENTER);

        frame.add(normalLabel,"Center");
        frame.add(grayLabel,"South");

        frame.setSize(400, 460);
        frame.setVisible(true);
    }
}

