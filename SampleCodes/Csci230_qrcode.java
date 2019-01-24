/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_qrcode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Csci230_qrcode
{
   public static void main(String[] args)
   {
      // Initialize Frame
      JFrame window = new JFrame();

      // Start Frame
      window.setSize(1000, 1000);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Draw Component
      window.add(new FaceComponent());
      window.setVisible(true);
   }
}
class FaceComponent extends JComponent
{
   public void paint(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      //http://goqr.me/api/
      String video = "https://www.youtube.com/watch?v=GqMNUPx3MJM";
      String location = "https://api.qrserver.com/v1/create-qr-code/?size=700x700&data=" + video;
      
      try {
          BufferedImage image = ImageIO.read(new URL(location));
          g2.drawImage(image, 0, 0, null);
       } catch (IOException ex) {
           System.out.println("file not found");
           exit(0);
       }
      
      //drawFace(400, 400,  g2);
      
   }
   public void drawFace(int x, int y, Graphics2D myg2)
   {
      int faceRadius = 100;
      int eyeRadius = 20;
      myg2.setColor(Color.RED);
      // draw face
      Ellipse2D.Double face = new Ellipse2D.Double(x+0, y+0, faceRadius, faceRadius);
      myg2.draw(face);
      // draw eyes
      Ellipse2D.Double lEye = new Ellipse2D.Double(x+20, x+20, eyeRadius, eyeRadius);
      myg2.draw(lEye);
      Ellipse2D.Double rEye = new Ellipse2D.Double(x+60, x+20, eyeRadius, eyeRadius);
      myg2.draw(rEye);
      // draw mouth
      myg2.setColor(new Color(23, 123, 140));
      Line2D.Double mouth = new Line2D.Double(x+20, y+60, x+80, y+60);
      myg2.draw(mouth);
   }
}