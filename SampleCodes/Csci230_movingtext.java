/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_movingtext;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Surface extends JPanel {
    private static int locationX =0;
    private static int locationY =0;
    
    public void setLocation(int  x, int y){
        locationX = x;
        locationY = y;
    }
    
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("CSCI230", locationX, locationY);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class Csci230_movingtext extends JFrame {
    static int x =10;
    static int y =50;
    final Timer timer = new Timer(1000, null);
    public Csci230_movingtext() {

        initUI();
    }

    private void initUI() {

        setTitle("Moving Text");

        Surface mysurface = new Surface();
        add(mysurface);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        timer.addActionListener( new ActionListener() { 
            @Override   
            public void actionPerformed(ActionEvent e) {
              x = x+5;  
              mysurface.setLocation(x, y);
              repaint();
            }
            });

        
        timer.start();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                Csci230_movingtext movingtext = new Csci230_movingtext();
                movingtext.setVisible(true);
            }
        });
    }
}
