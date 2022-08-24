package src.constants;

import javax.swing.*;
import java.awt.*;

public abstract class SecondaryFrame extends JFrame {
    // attributes
    JLabel background;
    ImageIcon appIcon;
    ImageIcon primaryBackground;
    
    public SecondaryFrame() {
        super("FundMe");
        appIcon = new ImageIcon("src\\images\\fundme.png");
        primaryBackground = new ImageIcon("src\\images\\secondary-background-two.png");

        this.setIconImage(appIcon.getImage());
        this.setSize(1080, 768);
        this.getContentPane().setBackground(Colors.primaryColor__);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);

        new Cursor(Cursor.HAND_CURSOR);

        background = new JLabel("", primaryBackground, JLabel.CENTER);
        background.setBounds(0, 0, 1080, 768);
        // this.add(background);
    }
}
