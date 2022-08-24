package src;

import src.components.*;
import src.constants.Colors;
import src.constants.Fonts;
import src.constants.SecondaryFrame;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class StartFundMe extends SecondaryFrame implements ActionListener, MouseListener {
    // attributes
    private JLabel primaryLabel;
    private JLabel secondaryLabel;

    private JLabel primaryIconLabel;

    private JPanel primaryPanel;

    private JButton StartCampaignBtn;
    private JButton ShowAvailableCampaignsBtn;

    // JButton AnonymusDonationBtn;
    private JButton AdminPanelBtn;
    private JButton prevBtn;

    private ImageIcon appIcon;

    public StartFundMe() {
        appIcon = new ImageIcon("src\\images\\fundme.png");
        // primaryBackground = new ImageIcon("src\\images\\secondary-background-two.png");

        primaryLabel = new JLabel("Start fundraising with FundMe");
        primaryLabel.setBounds(260, 40, 500, 40);
        primaryLabel.setFont(Fonts.font25);
        this.add(primaryLabel);

        primaryPanel = new JPanel();
        primaryPanel.setBounds(260, 115, 760, 423+115);
        primaryPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        primaryPanel.setLayout(null);
        primaryPanel.setVisible(true);
        this.add(primaryPanel);

        primaryIconLabel = new JLabel();
        primaryIconLabel.setIcon(appIcon);
        primaryIconLabel.setText("FundMe");
        primaryIconLabel.setBounds(316, 80, 128, 128+35);
        primaryIconLabel.setFont(Fonts.font30);
        primaryIconLabel.setHorizontalTextPosition(JLabel.CENTER);
        primaryIconLabel.setVerticalTextPosition(JLabel.BOTTOM);
        primaryPanel.add(primaryIconLabel);

        StartCampaignBtn = new JButton("Start a FundMe Campaign");
        StartCampaignBtn.setFont(Fonts.primaryFont_);
        StartCampaignBtn.setBounds(125, 340, 222, 35);
        StartCampaignBtn.setForeground(Colors.secondaryColor_);
        StartCampaignBtn.setBackground(Colors.primaryColor);
        StartCampaignBtn.addActionListener(this);
        primaryPanel.add(StartCampaignBtn);

        secondaryLabel = new JLabel("or");
        secondaryLabel.setBounds(125+222+21, 340, 30, 35);
        secondaryLabel.setFont(Fonts.font25);
        primaryPanel.add(secondaryLabel);

        ShowAvailableCampaignsBtn = new JButton("Show Available Campaigns");
        ShowAvailableCampaignsBtn.setFont(Fonts.primaryFont_);
        ShowAvailableCampaignsBtn.setBounds(413, 340, 222, 35);
        ShowAvailableCampaignsBtn.setForeground(Colors.secondaryColor_);
        ShowAvailableCampaignsBtn.setBackground(Colors.primaryColor);
        ShowAvailableCampaignsBtn.addActionListener(this);
        primaryPanel.add(ShowAvailableCampaignsBtn);

        AdminPanelBtn = new JButton("Admin Panel");
        AdminPanelBtn.setFont(Fonts.primaryFont_);
        AdminPanelBtn.setBounds(1080-40-160, 40, 140, 35);
        AdminPanelBtn.setForeground(Colors.secondaryColor_);
        AdminPanelBtn.setBackground(Colors.primaryColor);
        AdminPanelBtn.addActionListener(this);
        this.add(AdminPanelBtn);

        prevBtn = new JButton("Previous");
        prevBtn.setFont(Fonts.primaryFont_);
        prevBtn.setBounds(40, 40, 140, 35);
        prevBtn.setForeground(Colors.primaryColor);
        prevBtn.setBackground(Colors.secondaryColor);
        prevBtn.addActionListener(this);
        this.add(prevBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == prevBtn) {
            this.setVisible(false);
            new FundMe();
        }
        if(e.getSource() == StartCampaignBtn) {
            this.setVisible(false);
            new CampaignPanel();
        }
        if(e.getSource() == ShowAvailableCampaignsBtn) {
            this.setVisible(false);
            new AvailableCampaigns();
        }
        if(e.getSource() == AdminPanelBtn) {
            this.setVisible(false);
            new AdminPanel();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
