/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_mouseevents;


/*Name: Csci230_mouseevents
 *Demonstrates: Mouse Events 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Csci230_mouseevents {

    JLabel Label;
    JLabel MoveLabel;
    JTextArea Events;
        
    public Csci230_mouseevents()
    {
        JFrame myFrame = new JFrame();
        
        //creating a border to highlight the label areas
        Border outline = BorderFactory.createLineBorder(Color.black);
        
        //mouseLabel will trigger the Mouse click evetns
        Label = new JLabel("Mouse Interaction Label", JLabel.CENTER);
        Label.setBorder(outline);
        
        Label.addMouseListener(new MouseListener()
        {    
            @Override
            public void mouseClicked(MouseEvent e)
            {
                
                Label.setText("The mouse was clicked.");
                Events.append("mouseClicked Event");
                Events.append("# of clickes: " + e.getClickCount() + "\n");
                Events.append("mouse position X: " + e.getX() + " Y: " + e.getY() + "\n");       
            }
            @Override
            public void mousePressed(MouseEvent e)
            {
                
                Label.setText("The mouse button is being held!");
                Events.append("mousePressed Event\n");
            }
            
            @Override
            public void mouseExited(MouseEvent e)
            {
                Label.setText("The mouse is away!");
                Events.append("mouseExited Event\n");
            }
            
            @Override
            public void mouseEntered(MouseEvent e)
            {
                
                Label.setText("the Mouse is here");
                Events.append("mouseEntered Event\n");
            }
            
            @Override
            public void mouseReleased(MouseEvent e)
            {
                
                Label.setText("the mouse button is released");
                Events.append("MouseReleased Event\n");
            }
            
        });
    
        MoveLabel = new JLabel("Drag the Mouse!");
        MoveLabel.setBorder(outline);
        
        //Attach the MouseMotionListener to mouseMoveLabel 
        //as an anonymous inner class.
        //Each method logs the events triggered in the JTextArea
        MoveLabel.addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e)
            {           
                Events.append("mouseDragged Event\n");
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
                Events.append("mouseMoved Event\n");
                
            }
        
        });
        
        
        Events = new JTextArea("The Mouse events are logged here:\n");
        JScrollPane textScroll = new JScrollPane(Events);
        
        //Attach the MouseWheelListener to textScroll 
        textScroll.addMouseWheelListener(new MouseWheelListener(){
        
            @Override
            public void mouseWheelMoved(MouseWheelEvent e)
            {
                Label.setText("The mouse wheel was moved");
            }
        });
        
        myFrame.add(MoveLabel, BorderLayout.WEST);
        myFrame.add(Label, BorderLayout.CENTER);
        myFrame.add(textScroll, BorderLayout.EAST);
        
        //make sure the program exits when the frame closes
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setTitle("Mouse Events");
        myFrame.setSize(800,600);
      
        //This will center the JFrame in the middle of the screen
        myFrame.setLocationRelativeTo(null);
        
        
        myFrame.setVisible(true);
    }
    

       public static void main(String[] args) {
     
         //The event dispatch thread for Swing components
         EventQueue.invokeLater(new Runnable()
         {         
            @Override
             public void run()
             {
                 Csci230_mouseevents mouseevents = new Csci230_mouseevents();         
             }
         });              
    }
}

