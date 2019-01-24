/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_layeredpane2;


/* Demonstrates: Layered Pane
 * Original Source:http://docs.oracle.com/javase/tutorial
*/
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 

public class Csci230_layeredpane2 extends JPanel
                             implements ActionListener,
                                        MouseMotionListener {
    private String[] layerStrings = { "Yellow (0)", "Magenta (1)",
                                      "Cyan (2)",   "Red (3)",
                                      "Green (4)" };
    private Color[] layerColors = { Color.yellow, Color.magenta,
                                    Color.cyan,   Color.red,
                                    Color.green };
 
    private JLayeredPane layeredPane;
    private JLabel cursorLabel;
    private JCheckBox onTop;
    private JComboBox layerList;
 
    //Action commands
    private static String ON_TOP_COMMAND = "ontop";
    private static String LAYER_COMMAND = "layer";
 
    //Adjustments to put mouse cursor at the cursor's tip.
    private static final int XFUDGE = 42;
    private static final int YFUDGE = 22;
 
    public Csci230_layeredpane2()    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
 
        //Create and load the cursor icon.
        final ImageIcon icon = createImageIcon("/Users/abla/Desktop/duke.png");
 
        //Create and set up the layered pane.
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(300, 310));
        layeredPane.setBorder(BorderFactory.createTitledBorder(
                                    "Move the Mouse to move the Big Cursor"));
        layeredPane.addMouseMotionListener(this);
 
        //This is the origin of the first label added.
        Point origin = new Point(10, 20);
 
        //This is the offset for computing the origin for the next label.
        int offset = 35;
 
        //Add several overlapping, colored labels to the layered pane
        //using absolute positioning/sizing.
        for (int i = 0; i < layerStrings.length; i++) {
            JLabel label = createColoredLabel(layerStrings[i],
                                              layerColors[i], origin);
            layeredPane.add(label, new Integer(i));
            origin.x += offset;
            origin.y += offset;
        }
 
        //Create and add the Duke label to the layered pane.
        cursorLabel = new JLabel(icon);
        if (icon != null) {
            cursorLabel.setBounds(15, 225,
                                icon.getIconWidth(),
                                icon.getIconHeight());
        } else {
            System.err.println("Duke icon not found; using black square instead.");
            cursorLabel.setBounds(15, 225, 30, 30);
            cursorLabel.setOpaque(true);
            cursorLabel.setBackground(Color.BLACK);
        }
        layeredPane.add(cursorLabel, new Integer(2), 0);
 
        //Add control pane and layered pane to this JPanel.
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(createControlPanel());
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(layeredPane);
    }
 
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        String imgURL = path;
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
 
    //Create and set up a colored label.
    private JLabel createColoredLabel(String text,
                                      Color color,
                                      Point origin) {
        JLabel label = new JLabel(text);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(color);
        label.setForeground(Color.black);
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setBounds(origin.x, origin.y, 140, 140);
        return label;
    }
 
    //Create the control pane for the top of the frame.
    private JPanel createControlPanel() {
        onTop = new JCheckBox("Top Position in Layer");
        onTop.setSelected(true);
        onTop.setActionCommand(ON_TOP_COMMAND);
        onTop.addActionListener(this);
 
        layerList = new JComboBox(layerStrings);
        layerList.setSelectedIndex(2);    //cyan layer
        layerList.setActionCommand(LAYER_COMMAND);
        layerList.addActionListener(this);
 
        JPanel controls = new JPanel();
        controls.add(layerList);
        controls.add(onTop);
        controls.setBorder(BorderFactory.createTitledBorder(
                                 "Choose Duke's Layer and Position"));
        return controls;
    }
 
    //Make Duke follow the cursor.
    @Override
    public void mouseMoved(MouseEvent e) {
        cursorLabel.setLocation(e.getX()-XFUDGE, e.getY()-YFUDGE);
    }
    @Override
    public void mouseDragged(MouseEvent e) {} //do nothing
 
    //Handle user interaction with the check box and combo box.
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
 
        if (ON_TOP_COMMAND.equals(cmd)) {
            if (onTop.isSelected()) {
                layeredPane.moveToFront(cursorLabel);
            }
            else {
                layeredPane.moveToBack(cursorLabel);
            }
 
        } else if (LAYER_COMMAND.equals(cmd)) {
            int position = onTop.isSelected() ? 0 : 1;
            layeredPane.setLayer(cursorLabel,
                                 layerList.getSelectedIndex(),
                                 position);
        }
    }
 
  
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("LayeredPaneDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new Csci230_layeredpane2();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}




