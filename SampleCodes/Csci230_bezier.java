/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_bezier;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.QuadCurve2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Csci230_bezier
{
   public static void main(String[] args)
   {
      // Initialize Frame
      JFrame window = new JFrame();
      // Start Frame
      window.setSize(600, 600);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Draw Component
      window.add(new FaceComponent());
      window.setVisible(true);
   }
}
class FaceComponent extends JComponent
{
   @Override
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      
      g2.setColor(Color.BLUE);
      drawBezier(200, 200, 300, 400, 400, 200, g2);
      drawBezier(200, 200, 300, 100, 400, 200, g2);
      
      //let's rotate for 45 degrees from the center of our window:
      //1) first let's move the shape to middle of the screen.
      g2.translate(200,200);
      //2) then let's rotate the shape; 100, 100 is its center.
      //g2.rotate(Math.toRadians(45), 100, 100); 
      g2.rotate(45.0 * 0.0174532925 , 100, 100);
      //then draw the shape.
      drawRect(0, 0,  g2);   
   }
   
   // Draws Rectangle into Grahics2D  
   public void drawRect(int x, int y, Graphics2D myg2)
   {
      myg2.setColor(Color.RED);
      // draw the rectangle
      Rectangle rect = new Rectangle(x, y, 200, 200);
      myg2.draw(rect);   
   }
   
   // Draws Bezier Currve into Grahics2D object 
   public void drawBezier(int x1, int y1, int x2, int y2, int x3, int y3, Graphics2D myg2)
   {
       QuadCurve2D quadcurve = new QuadCurve2D.Float(x1, y1, x2, y2, x3, y3);
       myg2.draw(quadcurve);
   }
}

