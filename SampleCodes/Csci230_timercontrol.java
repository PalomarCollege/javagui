/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_timercontrol;

/*
 * Demonstrates:
 *1)  Swing Timer
 *2)  Timer Control
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Csci230_timercontrol extends JFrame{  
    public static final DateFormat format = new SimpleDateFormat("hh:mm:ss");
    public static final JLabel label =new JLabel();
    final Timer timer = new Timer(1000, null);
   
    public Csci230_timercontrol(){
        super("CS230 - Code23");
        add(label, BorderLayout.CENTER);
        final JButton button = new JButton("Stop");
        
        button.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e) {
            if (timer.isRunning() )
            {
                timer.stop();
                button.setText("Start");
            }
            else 
            {
                timer.start();
                button.setText("Stop");
            }
        }
        });             
        add(button, BorderLayout.SOUTH);
        setSize(160, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        timer.addActionListener( new ActionListener() { 
            @Override   
            public void actionPerformed(ActionEvent e) {
                Calendar now = Calendar.getInstance();
                String timeText = "<html><font size='7' color='red'>" + format.format(now.getTime()) + "</font></html>";
                label.setText(timeText);
            }
        });
        timer.start();
    }
        
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
            Csci230_timercontrol frame = new Csci230_timercontrol();
            frame.setVisible(true);
        }
        });
    }
}

