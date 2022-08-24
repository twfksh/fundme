package src.components;

import src.constants.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;

public class AdminDashboard extends SecondaryFrame implements ActionListener {
    // attributes
    private String username__;

    private JPanel primaryPanel;
    private JPanel secondaryPanel;

    private JLabel primaryLabel;
    private JLabel secondaryLabel_;
    private JLabel secondaryLabel__;
    private JLabel secondaryLabel___;

    private JList<String> availableCampaignsList;
    private JList<String> approvedCampaignsList;

    private JTable campaignsStatus;

    private JButton approveBtn;
    private JButton disapproveBtn;
    private JButton deleteBtn;
    private JButton showStatusBtn;

    private JButton prevBtn;

    private JButton logoutBtn;
    private JButton profileBtn;
    private JButton addCampaignBtn;

    // campaigns info
    private Vector<Campaigns> Campaigns_;
    private Vector<Campaigns> Campaigns__;

    private Vector<String> campaignList;
    private Vector<String> approvedCampaignList;

    /**
     * @param username_
     */
    public AdminDashboard(String username_) {
        // instantiating ArrayList objects
        Campaigns_ = new Vector<Campaigns>();
        Campaigns__ = new Vector<Campaigns>();
        campaignList = new Vector<String>();
        approvedCampaignList = new Vector<String>();

        // debug
        // System.out.println(campaignList.size());
        // System.out.println(availableCampaignsList.getSize());
        // for(int i = 0; i < campaignList.size(); i++) {
        //     System.out.println("Campaign name: " + campaignList.get(i));
        // }
        // debug end

        // String[] campaigns = {"Campaign 01", "Campaign 02", "Campaign 03", "Campaign 04", "Campaign 05"};

        // extractCampaignData(); // extracting campaign data from file
        // extract data
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
                    // poster = Files.readAllLines(Paths.get("src\\data\\available_campaigns.txt")).get(i+2).substring(17);
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

        // debug
            // System.out.println(Campaigns_.size());
            // for(int i = 0; i < campaignList.size(); i++) {
            //     System.out.println("Campaign Name: " + campaignList.get(i));
        // }
        // debug end


        // data extraction end
        this.username__ = username_;
        // primary panel
        primaryPanel = new JPanel();
        primaryPanel.setBounds(260, 115, 760, 423+115);
        primaryPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        primaryPanel.setBackground(Colors.secondaryColor);
        primaryPanel.setLayout(null);
        primaryPanel.setVisible(true);
        this.add(primaryPanel);

        secondaryLabel_ = new JLabel("Proposed Campaigns");
        secondaryLabel_.setBounds(15+70, 20, 357, 35);
        secondaryLabel_.setFont(Fonts.font22);
        primaryPanel.add(secondaryLabel_);

        secondaryLabel__ = new JLabel("Approved Campaigns");
        secondaryLabel__.setBounds(15+357+17+70, 20, 357, 35);
        secondaryLabel__.setFont(Fonts.font22);
        primaryPanel.add(secondaryLabel__);

        // add elements to the list
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(int i = 0; i < campaignList.size(); i++) {
            listModel.addElement(campaignList.get(i));
        }
        // for(int i = 0; i < campaigns.length; i++) {
        //     listModel.addElement(campaigns[i]);
        // }
        availableCampaignsList = new JList<>(listModel);
        availableCampaignsList.setBounds(15, 70, 357, 398);
        availableCampaignsList.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        availableCampaignsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        availableCampaignsList.setFixedCellHeight(30);
        availableCampaignsList.setAlignmentX(25);
        // availableCampaignsList.setCursor(Cursor.HAND_CURSOR);
        primaryPanel.add(availableCampaignsList);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // JScrollPane sp = new JScrollPane(availableCampaignsList);
        // sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        // sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // this.getContentPane().add(sp);

        // add elements to the list
        // adding item to list
        DefaultListModel<String> listModel_ = new DefaultListModel<>();
        for(int i = 0; i < approvedCampaignList.size(); i++) {
            listModel_.addElement(approvedCampaignList.get(i));
        }
        approvedCampaignsList = new JList<>(listModel_);
        approvedCampaignsList.setBounds(387, 70, 357, 398);
        approvedCampaignsList.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        approvedCampaignsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        approvedCampaignsList.setFixedCellHeight(30);
        approvedCampaignsList.setAlignmentX(25);
        primaryPanel.add(approvedCampaignsList);
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // JScrollPane sp_ = new JScrollPane(approvedCampaignsList);
        // sp_.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        // sp_.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        // this.getContentPane().add(sp_);

        approveBtn = new JButton("Approve");
        approveBtn.setFont(Fonts.primaryFont_);
        approveBtn.setBounds(45-8, 488, 160, 35);
        approveBtn.setForeground(Colors.secondaryColor_);
        approveBtn.setBackground(Colors.primaryColor);
        approveBtn.addActionListener(this);
        primaryPanel.add(approveBtn);

        // scroll
        // primaryPanel.add(new JScrollPane(availableCampaignsList));
        // primaryPanel.add(new JScrollPane(approvedCampaignsList));

        disapproveBtn = new JButton("Disapprove");
        disapproveBtn.setFont(Fonts.primaryFont_);
        disapproveBtn.setBounds(220-8, 488, 160, 35);
        disapproveBtn.setForeground(Colors.secondaryColor_);
        disapproveBtn.setBackground(Colors.primaryColor);
        disapproveBtn.addActionListener(this);
        primaryPanel.add(disapproveBtn);

        deleteBtn = new JButton("Delete");
        deleteBtn.setFont(Fonts.primaryFont_);
        deleteBtn.setBounds(395-8, 488, 160, 35);
        deleteBtn.setForeground(Colors.secondaryColor_);
        deleteBtn.setBackground(Colors.primaryColor);
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedItemIndex = availableCampaignsList.getSelectedIndex();
                if(selectedItemIndex != -1) {
                    listModel.remove(selectedItemIndex);
                    availableCampaignsList.setModel(listModel);
                }
            }
        });
        primaryPanel.add(deleteBtn);

        showStatusBtn = new JButton("Show Status");
        showStatusBtn.setFont(Fonts.primaryFont_);
        showStatusBtn.setBounds(570-8, 488, 160, 35);
        showStatusBtn.setForeground(Colors.secondaryColor_);
        showStatusBtn.setBackground(Colors.primaryColor);
        showStatusBtn.addActionListener(this);
        primaryPanel.add(showStatusBtn);

        availableCampaignsList = new JList<String>();

        // secondary panel
        secondaryPanel = new JPanel();
        secondaryPanel.setBounds(260, 115, 760, 423+115);
        secondaryPanel.setBackground(Colors.secondaryColor);
        secondaryPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        secondaryPanel.setLayout(null);
        secondaryPanel.setVisible(false);
        this.add(secondaryPanel);

        secondaryLabel___ = new JLabel("Running Campaigns Details");
        secondaryLabel___.setBounds(260, 25, 500, 30);
        secondaryLabel___.setFont(Fonts.primaryFont);
        secondaryPanel.add(secondaryLabel___);

        // campaign info
        // String[][] campaignsInfo = {
            // {"101", "Campaign X", "6700"},
            // {"102", "Campaign Y", "3400"},
            // {"103", "Campaign Z", "6700"},
            // {"104", "Campaign A", "5400"},
            // {"105", "Campaign D", "6500"},
            // {"106", "Campaign W", "8400"},
            // {"107", "Campaign T", "6700"},
            // {"108", "Campaign U", "2400"},
            // {"101", "Campaign C", "6600"},
            // {"102", "Campaign P", "5500"}
        // };
        // String[] column = {"Campaign ID", "Campaign Name", "Fund Raised"};

        // jtable
        // campaignStatus
        DefaultTableModel tableModel = new DefaultTableModel(0, 0);
        tableModel.addColumn("Campaign ID");
        tableModel.addColumn("Campaign Name");
        tableModel.addColumn("Fundraised");

        for(int i = 0; i < Campaigns_.size(); i++) {
            String[] rowItem = {Campaigns_.get(i).campaignID.toString(), Campaigns_.get(i).campaignName, String.valueOf(Campaigns_.get(i).targetAmount)};
            tableModel.addRow(rowItem);
        }

        campaignsStatus = new JTable(tableModel);
        campaignsStatus.setBounds(37, 65, 686, 400);
        campaignsStatus.setFont(Fonts.primaryFont_);
        campaignsStatus.setRowHeight(30);
        campaignsStatus.setRowMargin(8);
        campaignsStatus.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        secondaryPanel.add(campaignsStatus.getTableHeader());
        secondaryPanel.add(campaignsStatus);

        ListSelectionModel select = campaignsStatus.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // JScrollPane sp__ = new JScrollPane(campaignsStatus);
        // secondaryPanel.add(sp__);

        prevBtn = new JButton("Back");
        prevBtn.setFont(Fonts.primaryFont_);
        prevBtn.setBounds(570-8, 488, 160, 35);
        prevBtn.setForeground(Colors.secondaryColor_);
        prevBtn.setBackground(Colors.primaryColor);
        prevBtn.addActionListener(this);
        secondaryPanel.add(prevBtn);

        // frame
        primaryLabel = new JLabel("Admin Dashboard");
        primaryLabel.setFont(Fonts.font25);
        primaryLabel.setBounds(260, 40, 300, 40);
        this.add(primaryLabel);

        profileBtn = new JButton(username_);
        profileBtn.setFont(Fonts.primaryFont_);
        profileBtn.setBounds(1080-40-160, 40, 140, 35);
        profileBtn.setForeground(Colors.secondaryColor_);
        profileBtn.setBackground(Colors.primaryColor);
        profileBtn.addActionListener((e) -> new AdminProfile(username_));
        this.add(profileBtn);

        logoutBtn = new JButton("Logout");
        logoutBtn.setFont(Fonts.primaryFont_);
        logoutBtn.setBounds(40, 40, 140, 35);
        logoutBtn.setForeground(Colors.primaryColor);
        logoutBtn.setBackground(Colors.secondaryColor);
        logoutBtn.addActionListener((java.awt.event.ActionListener) this);
        this.add(logoutBtn);

        addCampaignBtn = new JButton("Add campaign");
        addCampaignBtn.setFont(Fonts.primaryFont_);
        addCampaignBtn.setBounds(40, 653, 140, 35);
        addCampaignBtn.setForeground(Colors.primaryColor);
        addCampaignBtn.setBackground(Colors.secondaryColor);
        addCampaignBtn.addActionListener((java.awt.event.ActionListener) this);
        this.add(addCampaignBtn);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == logoutBtn) {
            this.setVisible(false);
            new AdminPanel();
        }
        if(e.getSource() == showStatusBtn) {
            primaryPanel.setVisible(false);
            secondaryPanel.setVisible(true);
        }
        if(e.getSource() == prevBtn) {
            secondaryPanel.setVisible(false);
            primaryPanel.setVisible(true);
        }
        if(e.getSource() == addCampaignBtn) {
            this.setVisible(false);
            new RegisterCampaignPanel(username__, "Admin");
        }
        // if(e.getSource() == approveBtn) {
        //     String campaignName_ = availableCampaignsList.getSelectedValue().toString();
        //     listModel_.addElement(campaignName_);
        //     int selectedIndex = availableCampaignsList.getSelectedIndex();
        //     if(selectedIndex != -1) {
        //         availableCampaignsList.remove(selectedIndex);
        //     }
        // }
        // if(e.getSource() == disapproveBtn) {

        // }
        // if(e.getSource() == deleteBtn) {

        // }
    }
}
