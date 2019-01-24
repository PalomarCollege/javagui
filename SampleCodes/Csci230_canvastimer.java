/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_canvastimer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

class Canvas extends JPanel implements ActionListener{
    private Timer timer;
    private int x, y;
    private double angle=0;
    
    public Canvas()
    {
        timer = new Timer(500, this);
        timer.start();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.black);
        
        g2d.setColor(Color.red);
        Dimension size = getSize();
        g2d.drawLine(0, 0, size.width, size.height);
        
        g2d.setColor(Color.blue);
        g2d.drawLine(0, size.height, size.width, 0);
        
        g2d.setColor(Color.green);
        g2d.drawOval(size.width/4, size.height/4, size.width/2, size.height/2);
        
        g2d.setColor(Color.yellow);
        g2d.drawString("Palomar College", 70, 100);
        
        Toolkit toolkit=Toolkit.getDefaultToolkit();  
        Image image=toolkit.getImage("minion.jpg"); 
        g2d.translate(500, 450);
        g2d.rotate(angle);
        //g2d.rotate(-0.5);
        g2d.scale(2.0, 0.8);
        
        g2d.drawImage(image, x,y,this);  
        
    }
    public void actionPerformed(ActionEvent e) {
        x = x + 1;
        y = y + 1;
        angle = angle + 0.25;
        repaint();
    }
    
}

public class Csci230_canvastimer extends JFrame{   
    
    public Csci230_canvastimer(){
        Canvas mydraw = new Canvas();
        add(mydraw);

        setSize(1000, 900);
        setTitle("2D Shapes");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
            Csci230_canvastimer frame = new Csci230_canvastimer();
            frame.setVisible(true);
        }
        });
    }
        

}


