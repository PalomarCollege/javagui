/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_menukey;

/*
 * Demonstrates: 1) Keyboard Mnemonics
 *               2) Key Accelarators
 *               3) Adding the menu to content pane (instead of jFrame)
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;

public class Csci230_menukey {

    public static void main(String[] args) {
      JFrame frame = new ImageViewerFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
    }
}

class ImageViewerFrame extends JFrame
   {
    
   private JLabel label;
   private JFileChooser chooser;
   private static final int DEFAULT_WIDTH = 640;
   private static final int DEFAULT_HEIGHT = 480;
    
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
      //setJMenuBar(menuBar);
      contentPane.add(menuBar, BorderLayout.SOUTH);

      JMenu menu = new JMenu("File");
      menu.setMnemonic(KeyEvent.VK_F);
      
      menuBar.add(menu);
      JMenuItem openItem = new JMenuItem("Open");
      menu.add(openItem);
      openItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_O, ActionEvent.ALT_MASK));
      openItem.addActionListener(new 
         ActionListener()
         {
             @Override
            public void actionPerformed(ActionEvent evt)
            {
               //trigger file chooser dialog
               int r = chooser.showOpenDialog(null);

               // set the image as the icon of the label
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
      exitItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_X, ActionEvent.ALT_MASK));
      exitItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });
      
      JMenu menu1 = new JMenu("Help");
      menu1.setMnemonic(KeyEvent.VK_H);
      JMenuItem aboutItem = new JMenuItem("About");
      aboutItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_A, ActionEvent.ALT_MASK));
      menu1.add(aboutItem);
      menuBar.add(menu1);
      aboutItem.addActionListener(new 
      ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent event)
          {
              JOptionPane.showMessageDialog(null, "CSCI230- Menu & Key!");
          }
      });
   }

  
}



