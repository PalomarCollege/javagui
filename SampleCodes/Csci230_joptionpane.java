/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_joptionpane;

/**
 * Purpose: Demonstrate JOptionPane, HTML Swing components
 * @author abla
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Csci230_joptionpane {

    private List<String> proverbs;
    int lineCounter=0;
    
    public Csci230_joptionpane(String filename) throws FileNotFoundException
    {
        this.proverbs = new ArrayList<String>();
        File proverbsFile = new File(filename);
        Scanner in= new Scanner(proverbsFile);
        
        while(in.hasNextLine())
        {
            String line = in.nextLine();
            proverbs.add(lineCounter, line);
            lineCounter++;
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        URL imageLocation;
        Csci230_joptionpane fortune = new Csci230_joptionpane("proverbs.txt");
        
        String name = JOptionPane.showInputDialog("Hello, Hello! What is your name");
        int proverb_index = (int) (Math.random()*fortune.lineCounter);
        String proverb = fortune.proverbs.get(proverb_index);
        
        try {
            imageLocation = new URL("http://images.clipartpanda.com/fortune-clipart-fortune-cookie-md.png");
            JOptionPane.showMessageDialog(null, "<html> <body> <h2> <strong>"+proverb+"</strong> </h2><br> <p> -- Source: https://github.com/larryprice/fortune-cookie-api/blob/master/data/proverbs.txt <body></html>", name + "!, Be Lucky, Be Fortunate!",
                    JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
        } catch (MalformedURLException ex) {
            Logger.getLogger(Csci230_joptionpane.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
    }
    
}

