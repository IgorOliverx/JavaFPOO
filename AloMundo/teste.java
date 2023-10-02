package AloMundo;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class teste extends JFrame {
    public teste() {
        JFrame frame = new JFrame(); //JFrame Creation       
        frame.setTitle("Add Imathrgdfge"); //Add the title to frame
        frame.setLayout(null); //Terminates default flow layout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminate program on close button
        frame.setBounds(100, 200, 350, 300); //Sets the position of the frame
        
        Container c = frame.getContentPane(); //Gets the content layer
        JLabel label = new JLabel(); //JLabel Creation
        ImageIcon icon = new ImageIcon("AloMundo/java.png");
        if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            label.setIcon(icon);
        } else {
            System.err.println("A imagem não pôde ser carregada.");
        }
        
        Dimension size = label.getPreferredSize(); //Gets the size of the image
        label.setBounds(50, 30, size.width, size.height); //Sets the location of the image
 
    c.add(label); //Adds objects to the container
        frame.setVisible(true); // Exhibit the frame
    }

    public static void main(String[] args) {
        new teste();
    }
}
