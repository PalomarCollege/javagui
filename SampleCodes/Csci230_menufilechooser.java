/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_menufilechooser;

/* Copyright belongs to Oracle. Updated based on the code published on Oracle's java tutorial web site
 * Demonstrates: 
 * 1) Menu;
 * 2) File Chooser;
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Csci230_menufilechooser {
    
   public static void main(String[] args)
   {
      JFrame frame = new ImageViewerFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

class ImageViewerFrame extends JFrame
{
   public ImageViewerFrame()
   {
      setTitle("ImageViewer");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

      // use a label to display the images
      label = new JLabel();
      Container contentPane = getContentPane();
      contentPane.add(label);

      // set up the file chooser
      chooser = new JFileChooser();
      chooser.setCurrentDirectory(new File("."));

      // set up the menu bar
      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);

      JMenu menu = new JMenu("File");
      menuBar.add(menu);
      
      JMenuItem openItem = new JMenuItem("Open");
      //openItem.setEnabled(false);
      menu.add(openItem);
      menu.add("======");
      openItem.addActionListener(new 
         ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               // show file chooser dialog
               int r = chooser.showOpenDialog(null);

               // if file selected, set it as icon of the label
               if(r == JFileChooser.APPROVE_OPTION)
               {
                  String name
                     = chooser.getSelectedFile().getPath();
                  label.setIcon(new ImageIcon(name));
               }
            }
         });

      
      JMenuItem exitItem = new JMenuItem("Exit");
      menu.addSeparator();
      menu.add(exitItem);
      exitItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });
      
      JMenu menu1 = new JMenu("Help");
      JMenuItem aboutItem = new JMenuItem("About");
      menu1.add(aboutItem);
      menuBar.add(menu1);
      aboutItem.addActionListener(new 
      ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent event)
          {
              JOptionPane.showMessageDialog(null, "CSCI230-Menu & File Chooser");
          }
      });
   }

   private JLabel label;
   private JFileChooser chooser;
   private static final int DEFAULT_WIDTH = 1400;
   private static final int DEFAULT_HEIGHT = 900;
}


