import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import java.awt.*;
import javax.swing.*;

public class Test {

 

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new SecondPanel());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    class SecondPanel extends JPanel {

        public SecondPanel() {
            setLayout(new GridBagLayout());
            JPanel main = new JPanel(new GridBagLayout());
            main.setBorder(new LineBorder(Color.GRAY));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(4, 4, 4, 4);

            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.LINE_START;
            main.add(new JLabel("Nome de usuario"), gbc);
            

            gbc.anchor = GridBagConstraints.CENTER;
            main.add(new JTextField("Add"), gbc);
            main.add(new JButton("Login"));

            BufferedImage img = new BufferedImage(320, 240, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            g2d.setColor(Color.RED);
            g2d.drawLine(0, 0, 320, 240);
            g2d.drawLine(320, 0, 0, 240);
            g2d.dispose();

            JLabel mainL = new JLabel();
            mainL.setIcon(new ImageIcon(img));
            mainL.setBorder(new LineBorder(Color.RED));

            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(main, gbc);
            add(mainL, gbc);
        gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
add(main, gbc);
gbc.gridx++;
add(mainL, gbc);
        }
    }
    public static void main(String[] args) {
        new Test();
    }
}