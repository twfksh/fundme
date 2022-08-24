package src.components;

import src.StartFundMe;
import src.constants.Campaigns;
import src.constants.Colors;
import src.constants.Fonts;
import src.constants.SecondaryFrame;
import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AvailableCampaigns extends SecondaryFrame implements ActionListener {
    // attributes
    JPanel primaryPanel;
    // JPanel secondaryPanel;
    // JPanel secondaryPanel_;

    JLabel primaryLabel;
    JLabel primaryLabel_;

    JList<String> campaignsList;
    JScrollPane scrollPane;

    private JButton donateBtn;
    // private JButton showDetailsBtn;
    private JButton prevBtn;

    // campaigns info
    ArrayList<Campaigns> Campaigns_;
    ArrayList<Campaigns> Campaigns__;

    ArrayList<String> campaignList;
    ArrayList<String> approvedCampaignList;

    /**
     * 
     */
    public AvailableCampaigns() {
        // instantiating ArrayList objects
        Campaigns_ = new ArrayList<Campaigns>();
        Campaigns__ = new ArrayList<Campaigns>();
        campaignList = new ArrayList<String>();
        approvedCampaignList = new ArrayList<String>();

        // data extraction
        try {
            String campaignID;
            String campaignName;
            String campaigner;
            String name;
            String application;
            double targetAmount;
            // String reqDocs;
            // String poster;
            // boolean approved_;

            BufferedReader reader = new BufferedReader(new FileReader("src\\data\\available_campaigns.txt"));

            int totalLines = 0;
            while(reader.readLine() != null) 
                totalLines++;
            reader.close();

            for(int i = 0; i < totalLines-9; i++) {
                String line = Files.readAllLines(Paths.get("src\\data\\available_campaigns.txt")).get(i);
                String chk = line.substring(0, 11);
                if(chk.equals("Campaign ID")) {
                    campaignID = line.substring(13);

                    campaignName = Files.readAllLines(Paths.get("src\\data\\available_campaigns.txt")).get(i+1).substring(15);
                    campaignList.add(campaignName);

                    campaigner = Files.readAllLines(Paths.get("src\\data\\available_campaigns.txt")).get(i+2).substring(12);

                    name = Files.readAllLines(Paths.get("src\\data\\available_campaigns.txt")).get(i+3).substring(6);

                    String target = Files.readAllLines(Paths.get("src\\data\\available_campaigns.txt")).get(i+4).substring(15);

                    targetAmount = Double.parseDouble(target);

                    // reqDocs = Files.readAllLines(Paths.get("src\\data\\available_campaigns.txt")).get(i+5).substring(20);
                    // poster = Files.readAllLines(Paths.get("src\\data\\available_campaigns.txt")).get(i+2).substring(17);\

                    application = Files.readAllLines(Paths.get("src\\data\\available_campaigns.txt")).get(i+9).substring(13);

                    // debug
                    // System.out.println(campaignID);
                    // System.out.println(campaignName);
                    // System.out.println(campaigner);
                    // System.out.println(targetAmount);
                    // end debug

                    Campaigns campaign = new Campaigns(campaignID, campaignName, campaigner, name, application, targetAmount);
                    Campaigns_.add(campaign);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        // data extraction complete

        // String[] campaigns_ = {"Campaigns 01", "Campaigns 02", "Campaigns 03", "Campaigns 04", "Campaigns 05", "Campaigns 06", "Campaigns 07", "Campaigns 08", "Campaigns 09", "Campaigns 10"};

        // String[] campaigns_ = new String[campaignList.size()];
        // for(int i = 0; i < campaignList.size(); i++) {
        //     campaigns_[i] = campaignList.get(i);
        // }

        // primary label
        primaryLabel = new JLabel("EVERY GOOD DONOR IS A HERO");
        primaryLabel.setBounds(260+200, 40, 500, 40);
        primaryLabel.setFont(Fonts.primaryFont25);
        this.add(primaryLabel);

        // primary panel
        primaryPanel = new JPanel();
        primaryPanel.setBounds(260, 115, 760, 423+115);
        primaryPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        primaryPanel.setBackground(Colors.secondaryColor);
        primaryPanel.setLayout(null);
        primaryPanel.setVisible(true);
        this.add(primaryPanel);

        primaryLabel_ = new JLabel("Campaigns available for donation");
        primaryLabel_.setBounds(20, 10, 450, 35);
        primaryLabel_.setFont(Fonts.primaryFont__);
        primaryPanel.add(primaryLabel_);

        DefaultListModel<String> campaignsModel = new DefaultListModel<>();
        for(int i = 0; i < campaignList.size(); i++) {
            campaignsModel.addElement(campaignList.get(i));
        }
        
        campaignsList = new JList<>(campaignsModel);
        campaignsList = new JList<>(campaignsModel);
        campaignsList.setBounds(20, 60, 720-160-20, 398);
        campaignsList.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        campaignsList.setFixedCellHeight(35);
        campaignsList.setFont(Fonts.primaryFont);
        primaryPanel.add(campaignsList);

        // scrollPane = new JScrollPane(campaignsList);
        // primaryPanel.add(scrollPane);
        // JScrollPane sp = new JScrollPane(campaignsList);
        // sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        // sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // primaryPanel.add(sp);
        
        donateBtn = new JButton("Donate");
        donateBtn.setFont(Fonts.primaryFont_);
        donateBtn.setBounds(580, 60, 160, 35);
        donateBtn.setForeground(Colors.secondaryColor_);
        donateBtn.setBackground(Colors.primaryColor);
        donateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String listItem = campaignsList.getSelectedValue().trim();
                setVisibleThisFrame(false);
                new DonatePanel(listItem);
            }
        });
        primaryPanel.add(donateBtn);
        
        // secondary panel
        // secondaryPanel = new JPanel();
        // secondaryPanel.setBounds(260, 115, 760, 423+115);
        // secondaryPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        // secondaryPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        // secondaryPanel.setLayout(null);
        // secondaryPanel.setVisible(false);
        // this.add(secondaryPanel);

        // secondary panel dash
        // secondaryPanel_ = new JPanel();
        // secondaryPanel_.setBounds(260, 115, 760, 423+115);
        // secondaryPanel_.setBorder(BorderFactory.createLineBorder(Color.black));
        // secondaryPanel_.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        // secondaryPanel_.setLayout(null);
        // secondaryPanel_.setVisible(false);
        // this.add(secondaryPanel_);

        prevBtn = new JButton("Previous");
        prevBtn.setFont(Fonts.primaryFont_);
        prevBtn.setBounds(20, 40, 140, 35);
        prevBtn.setForeground(Colors.primaryColor);
        prevBtn.setBackground(Colors.secondaryColor);
        prevBtn.addActionListener((java.awt.event.ActionListener) this);
        this.add(prevBtn);
    }

    private void setVisibleThisFrame(boolean flag) {
        this.setVisible(flag);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == prevBtn) {
            this.setVisible(false);
            new StartFundMe();
        }
    }
}
