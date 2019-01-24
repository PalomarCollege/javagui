/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_html2;

/*
 * Demonstrates:
 * 1) Imbedding HTML in Swing Components;
 * 2) Border Layout
 * 3) Label - setForeground, setFont etc.
 * 4) BorderFactory
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Csci230_html2 extends JFrame {
    private final Toolkit toolkit;

    
    public Csci230_html2()
    {
        
        setTitle("Think Different");
        //JLabel accepts HTML markup
        String lyrics =  "<html> <p align='center'> <img src='https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Steve_Jobs_Headshot_2010-CROP2.jpg/330px-Steve_Jobs_Headshot_2010-CROP2.jpg'> </p>"
                    + "<br> <h1 ALIGN='CENTER'> <font color='#0000FF'> Think Different </font> </h1> "
                    + "<br> Here’s to the crazy ones. " 
                    + "<br> The misfits. The rebels. The troublemakers. The round pegs in the square holes. "
                    + "<br> The ones who see things differently. They’re not fond of rules. "
                    + "<br> And they have no respect for the status quo. "
                    + "<br> You can quote them, disagree with them, glorify or vilify them. "
                    + "<br> <font face='verdana' color='green'> But the only thing you can’t do is ignore them.</font> "
                    + "<br> Because they change things. <font color='red'> They push the human race forward. </font> "
                    + "<br> While some may see them as the crazy ones, we see genius. "
                    + "<br> <s>Because </s>the people who are crazy enough to think they can change the world, are the ones who do." 
                    + "<br> <br> <strong>  - Apple Inc. </strong> "
                    + "</html>";
        JPanel panel = new JPanel(); 
        panel.setLayout(new BorderLayout(10, 10));
        JLabel label = new JLabel(lyrics);
        label.setFont(new Font("Georgia", Font.PLAIN, 22));
        label.setForeground(new Color(50, 50, 25));
        panel.add(label, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panel);
        pack();
        toolkit = getToolkit();
        Dimension screensize = toolkit.getScreenSize();
        setLocation((screensize.width - getWidth())/2, 
            (screensize.height - getHeight())/2);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public static void main(String[] args) {
        Csci230_html2 mylabel = new Csci230_html2();
        mylabel.setVisible(true);
        
        
    }
}

