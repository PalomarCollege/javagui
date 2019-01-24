/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_tree;

/**
 * Demonstrates: 1) JTree; 2) JScrollPane;
*/
 
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

 
public class Csci230_tree extends JFrame
{
    private JTree tree;
    private JLabel selectedLabel;
     
    public Csci230_tree()
    {
        //create the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Apple");
        
        //create the child nodes and their children
        DefaultMutableTreeNode iphoneNode = new DefaultMutableTreeNode("iPhones");
        iphoneNode.add(new DefaultMutableTreeNode("iPhone5"));
        iphoneNode.add(new DefaultMutableTreeNode("iPhone5C"));
        iphoneNode.add(new DefaultMutableTreeNode("iPhone5S"));
        iphoneNode.add(new DefaultMutableTreeNode("iPhone6"));
        iphoneNode.add(new DefaultMutableTreeNode("iPhone6+"));
         
        DefaultMutableTreeNode watchNode = new DefaultMutableTreeNode("Watches");
        watchNode.add(new DefaultMutableTreeNode("Apple Watch"));
        watchNode.add(new DefaultMutableTreeNode("Apple Watch Sport"));
        watchNode.add(new DefaultMutableTreeNode("Apple Watch Limited"));
        
        DefaultMutableTreeNode ipadNode = new DefaultMutableTreeNode("iPads");
        ipadNode.add(new DefaultMutableTreeNode("iPad Mini with Retina Display"));
        ipadNode.add(new DefaultMutableTreeNode("iPad Air"));
        
        //add the child nodes to the root node
        root.add(iphoneNode);
        root.add(watchNode);
        root.add(ipadNode);
         
        //create the tree by passing in the root node
        tree = new JTree(root);
 
        ImageIcon imageIcon = new ImageIcon(Csci230_tree.class.getResource("/images/apple_03.png"));
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();       
        renderer.setLeafIcon(imageIcon);   
        tree.setCellRenderer(renderer);
        tree.setShowsRootHandles(true);
        tree.setRootVisible(true);
        
        JScrollPane scroll = new JScrollPane(tree);
        add(scroll);
         
        selectedLabel = new JLabel();
        add(selectedLabel, BorderLayout.SOUTH);
 
        tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                selectedLabel.setText(selectedNode.getUserObject().toString());
            }
        });
         
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("csci230_tree");       
        this.setSize(200, 500);
        this.setVisible(true);
    }
     
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Csci230_tree();
            }
        });
    }       
}
