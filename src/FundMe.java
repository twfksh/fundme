package src;

import src.constants.Colors;
import src.constants.Fonts;

import javax.swing.*;
import java.awt.event.*;

public class FundMe implements ActionListener, MouseListener {
    // attributes
    private JFrame primaryFrame;
    private JLabel background;
    private JButton startFundMeBtn;
    
    private ImageIcon primaryBackground;
    private ImageIcon appIcon;

    public FundMe() {
        primaryBackground = new ImageIcon("src\\images\\primary-background.png");
        appIcon = new ImageIcon("src\\images\\fundme.png");

        primaryFrame = new JFrame("FundMe");
        primaryFrame.setSize(1080, 768);
        primaryFrame.setLocationRelativeTo(null);
        primaryFrame.setIconImage(appIcon.getImage());
        primaryFrame.setResizable(false);
        primaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        primaryFrame.setLayout(null);
        primaryFrame.setVisible(true);

        background = new JLabel("", primaryBackground, JLabel.CENTER);
        background.setBounds(0, 0, 1080, 768);
        primaryFrame.add(background);

        startFundMeBtn = new JButton("Start FundMe");
        startFundMeBtn.setFont(Fonts.primaryFont);
        startFundMeBtn.setVerticalTextPosition(JButton.CENTER);
        startFundMeBtn.setHorizontalTextPosition(JButton.CENTER);
        startFundMeBtn.setForeground(Colors.secondaryColor_);
        startFundMeBtn.setBackground(Colors.primaryColor);
        startFundMeBtn.setBounds(93, 390, 180, 40);
        startFundMeBtn.addMouseListener(this);
        startFundMeBtn.addActionListener(this);
        primaryFrame.add(startFundMeBtn);
    }

    @Override
    public void actionPerformed(ActionEvent btn) {
        if(btn.getSource() == startFundMeBtn) {
            primaryFrame.setVisible(false);
            new StartFundMe();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        startFundMeBtn.setBackground(Colors.primaryColor_);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startFundMeBtn.setBackground(Colors.primaryColor_);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        startFundMeBtn.setBackground(Colors.primaryColor);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        startFundMeBtn.setBackground(Colors.primaryColor_);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        startFundMeBtn.setBackground(Colors.primaryColor);
    }
}
