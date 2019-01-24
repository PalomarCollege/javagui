/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_mapanddata;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


class Map_data {
    private static USstate[]  states = new USstate[50];    
    
    Map_data() throws FileNotFoundException, IOException  {
        String filename = "state.txt";
        readMapFile(filename);
        
        for (USstate state : states) {
            System.out.println(state);
            state.printCoordinates();
            System.out.println();
        }
       
    }
    
    public USstate[] getStates()
    {
        return states;
    }
    
    public static void readMapFile(String filename) throws FileNotFoundException, IOException
    {
        FileInputStream fstream = new FileInputStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        
        String line;
        int counter = 0;
        while ((line = br.readLine()) != null)
        {
                String[] content= line.split("#");
                System.out.println(content[0] +"=>"+content[1] + "=>" + (content.length));
                USstate s = new USstate();
                s.setIndex(Integer.parseInt(content[0]));
                s.setName(content[1]);
                double[][] c = new double[content.length-2][2];
         
                for (int i=0; i < content.length-2; i++)
                {
                  String[] latlong = content[i+2].split(",");  
                  c[i][0] =  Double.parseDouble(latlong[0]);
                  c[i][1] =  Double.parseDouble(latlong[1]);
                  
                }
                s.setCoordinate(c);
                states[counter++] = s;
        }
        br.close();
    }
    
}

class USstate{
    private int index;
    private String name;
    private double[][] coordinate;
    /*
    x = R * cos(lat) * cos(lon)
    y = R * cos(lat) * sin(lon)
    z = R *sin(lat)
    */
    public USstate(int i, String n, double[][] c)
    {
        index = i;
        name = n;
        coordinate = c; 
    }
    
    public USstate()
    {
        index = 0;
        name = null;
        coordinate = null;
    }
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[][] getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(double[][] coordinate) {
        this.coordinate = coordinate;
    }
    
    @Override
    public String toString()
    {
        String result = String.format("%2d %s %d", index, name, coordinate.length);
        return result;         
    }
    public void printCoordinates()
    {
        for (int i=0; i < coordinate.length; i++)
            System.out.print(coordinate[i][0] + "," + coordinate[i][1] + "#");
    }
}


class Canvas extends JPanel implements ActionListener{
    private Timer timer;
    private int x, y;
    private double angle=0;
    private static Map_data mymap; 
    private static USstate[] mystate = new USstate[50];
    private static double[][] mycoordinate; 
    Polygon[] polygons  = new Polygon[50];
    Color[] regularcolors = new Color[] {  
            Color.orange, Color.gray, Color.red, Color.magenta  }; 
    Color[] colors = new Color[50];  
    
    public Canvas() throws IOException 
    {
        for(int i= 0; i <colors.length; i++)
            colors[i] = regularcolors[0];
        mymap = new Map_data();
        mystate = mymap.getStates();
        //mycoordinate = mystate[13].getCoordinate();
        timer = new Timer(500, this);
        timer.start();
        
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.black);
        
        g2d.setStroke(new BasicStroke(2));
        
        for (int j =0; j < mystate.length; j++)
        {
        mycoordinate = mystate[j].getCoordinate(); 
        //g2d.setColor(Color.BLUE);
        g2d.setColor(colors[j]);
        Polygon onestate = new Polygon();
            for (double[] mycoordinate1 : mycoordinate) {
                onestate.addPoint((int) Math.abs(mycoordinate1[0]), (int) Math.abs(mycoordinate1[1]));
            }
        polygons[j] = onestate;
        g2d.fillPolygon(onestate);
        g2d.setColor(Color.WHITE);
        g2d.drawPolygon(onestate);
        g2d.setColor(regularcolors[1]);
        g2d.drawString(mystate[j].getName(), (int)mycoordinate[0][0], (int)mycoordinate[0][1]+20);
        }  
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        x = x + 1;
        y = y + 1;
        angle = angle + 0.25;
        repaint();
    }
    
}


public class Csci230_mapanddata extends JFrame{   
    
    public Csci230_mapanddata() throws IOException{
        Canvas mydraw = new Canvas();
        PolygonSelector selector;  
        selector = new PolygonSelector(mydraw);
        mydraw.addMouseListener(selector);
        add(mydraw);
        setSize(900, 900);
        setTitle("United States");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
               
            Csci230_mapanddata frame = null;
                try {
                    frame = new Csci230_mapanddata();
                } catch (IOException ex) {
                    Logger.getLogger(Csci230_mapanddata.class.getName()).log(Level.SEVERE, null, ex);
                }
            frame.setVisible(true);
        }
        });
    }
}


class PolygonSelector extends MouseAdapter  
{  
    Canvas usmap;  
    Random seed;  
   
    public PolygonSelector(Canvas pp)  
    {  
        usmap = pp;  
        seed = new Random();  
    }  
   
    @Override
    public void mousePressed(MouseEvent e)  
    {  
        Point p = e.getPoint();  
        Polygon[] polys = usmap.polygons; 
        for(int j = 0; j < polys.length; j++)  
            if(polys[j].contains(p))  
            {   
                usmap.colors[j] = getColor();  
                usmap.repaint();  
                break;           
            }  
    }  
   
    private Color getColor()  
    {  
        return new Color(seed.nextInt(0xffffff));  
    }  
}  

