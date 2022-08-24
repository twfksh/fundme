package src.components;

import src.constants.Colors;
import src.constants.Fonts;
import src.constants.SecondaryFrame;

import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegisterCampaignPanel extends SecondaryFrame implements ActionListener {
    // attributes
    private String username__;
    private String fullname__;

    private JPanel primaryPanel;

    private JLabel primaryLabel;
    private JLabel campaignName;
    private JLabel applicationLabel;
    private JLabel targetAmount;

    private JTextField CampaignName;
    private JTextArea Application;
    private JTextField TargetAmount;

    private JButton procedeBtn;
    private JButton uploadDocs;
    private JButton uploadPoster;
    private JButton prevBtn;
    private JButton profileBtn;

    private String requiredDocs;
    private String camgaignPoster;

    public RegisterCampaignPanel(String fullname_, String username_) {
        this.username__ = username_;
        this.fullname__ = fullname_;

        primaryPanel = new JPanel();
        primaryPanel.setBounds(260, 115, 760, 423+115);
        primaryPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        primaryPanel.setBackground(Colors.secondaryColor);
        primaryPanel.setLayout(null);
        primaryPanel.setVisible(true);
        this.add(primaryPanel);

        profileBtn = new JButton(fullname_);
        profileBtn.setFont(Fonts.primaryFont_);
        profileBtn.setBounds(1080-40-160, 40, 140, 35);
        profileBtn.setForeground(Colors.secondaryColor_);
        profileBtn.setBackground(Colors.primaryColor);
        profileBtn.addActionListener((e) -> new CampaignerProfile(username_));
        this.add(profileBtn);

        primaryLabel = new JLabel("FundMe - Apply for a campaign");
        primaryLabel.setBounds(260, 40, 350, 40);
        primaryLabel.setFont(Fonts.font22);
        this.add(primaryLabel);

        campaignName = new JLabel("Campaign name");
        campaignName.setBounds(20, 50, 180, 35);
        campaignName.setFont(Fonts.primaryFont);
        primaryPanel.add(campaignName);

        CampaignName = new JTextField();
        CampaignName.setBounds(20+180, 50, 520, 35);
        CampaignName.setFont(Fonts.primaryFont_);
        CampaignName.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        primaryPanel.add(CampaignName);

        applicationLabel = new JLabel("Write your proposal");
        applicationLabel.setBounds(20, 95, 200, 35);
        applicationLabel.setFont(Fonts.primaryFont);
        primaryPanel.add(applicationLabel);

        Application = new JTextArea();
        Application.setBounds(20+180, 95, 520, 260);
        Application.setFont(Fonts.primaryFont_);
        Application.setLineWrap(true);
        Application.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        primaryPanel.add(Application);

        targetAmount = new JLabel("Target amount");
        targetAmount.setBounds(20, 365, 180, 35);
        targetAmount.setFont(Fonts.primaryFont);
        primaryPanel.add(targetAmount);
        
        TargetAmount = new JTextField();
        TargetAmount.setBounds(20+180, 365, 520, 35);
        TargetAmount.setFont(Fonts.primaryFont);
        TargetAmount.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        primaryPanel.add(TargetAmount);

        uploadDocs = new JButton("Upload required documents");
        uploadDocs.setBounds(20+180, 410, 255, 35);
        uploadDocs.setFont(Fonts.primaryFont);
        uploadDocs.setForeground(Colors.secondaryColor);
        uploadDocs.setBackground(Colors.primaryColor);
        uploadDocs.addActionListener((java.awt.event.ActionListener) this);
        primaryPanel.add(uploadDocs);

        uploadPoster = new JButton("Upload campaign poster");
        uploadPoster.setBounds(20+180+250+15, 410, 255, 35);
        uploadPoster.setFont(Fonts.primaryFont);
        uploadPoster.setForeground(Colors.secondaryColor);
        uploadPoster.setBackground(Colors.primaryColor);
        uploadPoster.addActionListener((java.awt.event.ActionListener) this);
        primaryPanel.add(uploadPoster);

        procedeBtn = new JButton("Submit proposal");
        procedeBtn.setBounds(20+180, 455, 520, 35);
        procedeBtn.setFont(Fonts.primaryFont);
        procedeBtn.setForeground(Colors.secondaryColor);
        procedeBtn.setBackground(Colors.primaryColor);
        procedeBtn.addActionListener((java.awt.event.ActionListener) this);
        primaryPanel.add(procedeBtn);

        prevBtn = new JButton("Previous");
        prevBtn.setFont(Fonts.primaryFont_);
        prevBtn.setBounds(40, 40, 140, 35);
        prevBtn.setForeground(Colors.primaryColor);
        prevBtn.setBackground(Colors.secondaryColor);
        prevBtn.addActionListener((java.awt.event.ActionListener) this);
        this.add(prevBtn);
    }

    private void uploadDocsFn() {
        JFileChooser upload_file = new JFileChooser();
        int res = upload_file.showOpenDialog(null);

        if(res == JFileChooser.APPROVE_OPTION) {
            File file_path = new File(upload_file.getSelectedFile().getAbsolutePath());
            requiredDocs = String.valueOf(file_path);
        }
    }

    private void uploadPosterFn() {
        JFileChooser upload_file = new JFileChooser();
        int res = upload_file.showOpenDialog(null);

        if(res == JFileChooser.APPROVE_OPTION) {
            File file_path = new File(upload_file.getSelectedFile().getAbsolutePath());
            camgaignPoster = String.valueOf(file_path);
        }
    }

    private void registerCampaign() {
        String campName = CampaignName.getText().trim();
        String application = Application.getText().trim();
        String targetAmount = TargetAmount.getText().trim();

            try {
                File file = new File("src\\data\\available_campaigns.txt");
                if(!file.exists()) {
                    file.createNewFile();
                }

                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                PrintWriter pw = new PrintWriter(bw);

                LocalDateTime datentime = LocalDateTime.now();
                DateTimeFormatter datentimeformater = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");
                String timeAndDate = datentime.format(datentimeformater);

                pw.println("~~~~~~~~~~~~~~~Campaign~~~~~~~~~~~~~~~");
                pw.println("Campaign ID: " + UUID.randomUUID().toString().substring(0,8));
                pw.println("Campaign name: " + campName);
                pw.println("Campaigner: " + username__);
                pw.println("Name: " + fullname__);
                pw.println("Target amount: " + targetAmount);
                pw.println("Required documents: " + requiredDocs);
                pw.println("Campaign poster: " + camgaignPoster);
                pw.println("Time & Date: " + timeAndDate);
                pw.println("Approved: false");
                pw.println("Application: " + application);
                pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                pw.close();
                bw.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == prevBtn) {
            this.setVisible(false);
            new CampaignerLogin();
        }
        if(e.getSource() == uploadDocs) {
            uploadDocsFn();
        }
        if(e.getSource() == uploadPoster) {
            uploadPosterFn();
        }
        if(e.getSource() == procedeBtn) {
                if(CampaignName.getText().isEmpty() || Application.getText().isEmpty() || 
            TargetAmount.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                registerCampaign();
                this.setVisible(false);
                new SubmitProposal();
            }
        }
    }
}
