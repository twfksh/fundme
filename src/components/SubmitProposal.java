package src.components;

import src.StartFundMe;
import src.constants.Colors;
import src.constants.Fonts;
import src.constants.SecondaryFrame;

import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SubmitProposal extends SecondaryFrame implements ActionListener {
    // attributes
    private JLabel primaryLabel;
    private JLabel secondaryLabel;

    private JButton homeBtn;

    public SubmitProposal() {
        primaryLabel = new JLabel(new ImageIcon("src\\images\\checked.png"));
        primaryLabel.setBounds(540-64, 384-64-120, 128, 128);
        this.add(primaryLabel);

        secondaryLabel = new JLabel("Proposal successfully submitted.");
        secondaryLabel.setBounds(280, 350, 520, 35);
        secondaryLabel.setFont(Fonts.font30);
        secondaryLabel.setHorizontalAlignment(JLabel.CENTER);
        secondaryLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(secondaryLabel);

        homeBtn = new JButton("Go back to Home");
        homeBtn.setBounds(280, 510, 520, 35);
        homeBtn.setFont(Fonts.primaryFont);
        homeBtn.setForeground(Colors.secondaryColor);
        homeBtn.setBackground(Colors.primaryColor);
        homeBtn.addActionListener((java.awt.event.ActionListener) this);
        this.add(homeBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == homeBtn) {
            this.setVisible(false);
            new StartFundMe();
        }
    }
    
}
