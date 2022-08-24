package src.components;

import src.constants.Colors;
import src.constants.Fonts;
import src.constants.SecondaryFrame;

import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DonatePanel extends SecondaryFrame implements ActionListener {
    // attributes
    private JPanel primaryPanel;
    private JPanel secondaryPanel;

    private JLabel fullname;
    private JLabel email;

    private JTextField tfName;
    private JTextField CardNo;
    private JTextField ValidL;
    private JTextField CVV;
    private JRadioButton yes;
    private JRadioButton no;

    private JTextField Fullname;
    private JTextField Email;

    private JLabel primaryLabel;
    private JLabel secondaryLabel;

    private JButton prevBtn;
    private JButton makePaymentBtn;
    private String campaignName;

    public DonatePanel(String campaignName) {
        this.campaignName = campaignName;
        // primary label
        primaryLabel = new JLabel("FundMe - Make a donation for " + campaignName);
        primaryLabel.setBounds(260, 40, 720, 40);
        primaryLabel.setFont(Fonts.font30);
        this.add(primaryLabel);

        // primary panel
        primaryPanel = new JPanel();
        primaryPanel.setBounds(260, 115, 760, 423+115);
        primaryPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        primaryPanel.setBackground(Colors.secondaryColor);
        primaryPanel.setLayout(null);
        primaryPanel.setVisible(true);
        this.add(primaryPanel);

        // secondary label
        secondaryLabel = new JLabel("Donors info");
        secondaryLabel.setBounds(40, 20, 720, 35);
        secondaryLabel.setHorizontalTextPosition(JLabel.CENTER);
        secondaryLabel.setFont(Fonts.font22);
        primaryPanel.add(secondaryLabel);

        // fullname
        fullname = new JLabel("Full Name");
        fullname.setBounds(40, 80, 160, 30);
        fullname.setForeground(Color.BLACK);
        fullname.setFont(Fonts.primaryFont_);
        primaryPanel.add(fullname);

        Fullname = new JTextField();
        Fullname.setBounds(160, 80, 250, 30);
        Fullname.setFont(Fonts.primaryFont_);
        Fullname.setHorizontalAlignment(JTextField.CENTER);
        primaryPanel.add(Fullname);

        // email
        email = new JLabel("Email");
        email.setBounds(40, 80+30+10, 160, 30);
        email.setFont(Fonts.primaryFont_);
        primaryPanel.add(email);

        Email = new JTextField();
        Email.setBounds(160, 80+30+10, 250, 30);
        Email.setFont(Fonts.primaryFont_);
        Email.setHorizontalAlignment(JTextField.CENTER);
        primaryPanel.add(Email);

        // card info
        JLabel label = new JLabel();
        label.setText("Complete Your Payment");
        label.setBounds(40+120, 80+30+10+30+10, 250, 30);
        label.setFont(Fonts.primaryFont);
        primaryPanel.add(label);

        JLabel label_ = new JLabel("We Accept Only");
        label_.setBounds(40, 80+30+10+30+10+30+20, 250, 30);
        label_.setFont(Fonts.primaryFont);
        primaryPanel.add(label_);

        JLabel visacard = new JLabel(new ImageIcon("src\\images\\visacard.png"));
        visacard.setBounds(40+150, 200, 67, 45);
        primaryPanel.add(visacard);

        JLabel andL = new JLabel("and");
        andL.setBounds(40+150+67+20, 210, 50, 30);
        andL.setFont(Fonts.primaryFont);
        primaryPanel.add(andL);

        JLabel mastercard = new JLabel(new ImageIcon("src\\images\\mastercard.png"));
        mastercard.setBounds(40+150+67+15+50+15, 200, 67, 45);
        primaryPanel.add(mastercard);

        JLabel label2 = new JLabel("Card Details");
        label2.setBounds(40+170, 260, 250, 30);
        label2.setFont(Fonts.primaryFont);
        primaryPanel.add(label2);

        // Name On Card
        JLabel cname = new JLabel("Name On Card");
        cname.setBounds(40, 295, 120, 30);
        cname.setFont(Fonts.primaryFont_);
        primaryPanel.add(cname);

        tfName = new JTextField();
        tfName.setBounds(160, 295, 250, 30);
        tfName.setFont(Fonts.primaryFont_);
        tfName.setHorizontalAlignment(JTextField.CENTER);
        primaryPanel.add(tfName);

        // Card Number
        JLabel cardNo = new JLabel("Card Number");
        cardNo.setBounds(40, 335, 120, 30);
        cardNo.setFont(Fonts.primaryFont_);
        primaryPanel.add(cardNo);

        CardNo = new JTextField();
        CardNo.setBounds(160, 335, 250, 30);
        CardNo.setFont(Fonts.primaryFont_);
        CardNo.setHorizontalAlignment(JTextField.CENTER);
        primaryPanel.add(CardNo);

        // Valid On
        JLabel validL = new JLabel("Valid On");
        validL.setBounds(40, 375, 80, 30);
        validL.setFont(Fonts.primaryFont_);
        primaryPanel.add(validL);

        ValidL = new JTextField();
        ValidL.setBounds(130, 375, 110, 30);
        ValidL.setFont(Fonts.primaryFont_);
        ValidL.setHorizontalAlignment(JTextField.CENTER);
        primaryPanel.add(ValidL);

        // CVV Code
        JLabel cvv = new JLabel("CVV Code");
        cvv.setBounds(250, 375, 80, 30);
        cvv.setFont(Fonts.primaryFont_);
        primaryPanel.add(cvv);

        CVV = new JTextField();
        CVV.setBounds(330, 375, 80, 30);
        CVV.setFont(Fonts.primaryFont_);
        CVV.setHorizontalAlignment(JTextField.CENTER);
        primaryPanel.add(CVV);

        JLabel mkAnonymusDonation = new JLabel("Make anonymus donation");
        mkAnonymusDonation.setBounds(40, 420, 180, 30);
        mkAnonymusDonation.setFont(Fonts.primaryFont_);
        primaryPanel.add(mkAnonymusDonation);

        yes = new JRadioButton("Yes");
        yes.setBounds(40+180+30, 420, 50, 30);
        yes.setFont(Fonts.primaryFont_);
        primaryPanel.add(yes);

        no = new JRadioButton("N0");
        no.setBounds(40+180+30+50+20, 420, 50, 30);
        no.setFont(Fonts.primaryFont_);
        primaryPanel.add(no);

        ButtonGroup bg = new ButtonGroup();
        bg.add(yes);
        bg.add(no);

        makePaymentBtn = new JButton("Make payment");
        makePaymentBtn.setFont(Fonts.primaryFont_);
        makePaymentBtn.setBounds(40, 470, 370, 30);
        makePaymentBtn.setForeground(Colors.secondaryColor);
        makePaymentBtn.setBackground(Colors.primaryColor);
        makePaymentBtn.addActionListener(this);
        primaryPanel.add(makePaymentBtn);

        // secondary panel
        secondaryPanel = new JPanel();
        secondaryPanel.setBounds(260, 115, 760, 423+115);
        secondaryPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        secondaryPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        secondaryPanel.setLayout(null);
        secondaryPanel.setVisible(false);
        this.add(secondaryPanel);

        // previous button
        prevBtn = new JButton("Previous");
        prevBtn.setFont(Fonts.primaryFont_);
        prevBtn.setBounds(40, 40, 160, 35);
        prevBtn.setForeground(Colors.primaryColor);
        prevBtn.setBackground(Colors.secondaryColor);
        prevBtn.addActionListener(this);
        this.add(prevBtn);
    }

    private void makePayment() {
        try {
            String fullname = Fullname.getText().trim();
            String email = Email.getText().trim();
            String nameoncard = tfName.getText().trim();
            String cardno = CardNo.getText().trim();
            String anonymus = (yes.isSelected()) ? "yes" : "no";

            File file = new File("src\\data\\donors_info.txt");
            if(!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            PrintWriter pw = new PrintWriter(bw);

            LocalDateTime datentime = LocalDateTime.now();
            DateTimeFormatter datentimeformater = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");
            String timeAndDate = datentime.format(datentimeformater);

            if(anonymus.equals("no")) {
                pw.println("~~~~~~~~~~~~~~~Donors~~~~~~~~~~~~~~~");
                pw.println("Campaign name: " + campaignName);
                pw.println("Full name: " + fullname);
                pw.println("Email: " + email);
                pw.println("Name on card: " + nameoncard);
                pw.println("Card #" + cardno);
                pw.println("Time & Date: " + timeAndDate);
                pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            } else {
                pw.println("~~~~~~~~~~~~~~~Donors~~~~~~~~~~~~~~~");
                pw.println("Campaign name: " + campaignName);
                pw.println("Anonymus donation from Mr. X");
                pw.println("Time & Date: " + timeAndDate);
                pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }

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
            new AvailableCampaigns();
        }
        if(e.getSource() == makePaymentBtn) {
            if((Fullname.getText().isEmpty() || Email.getText().isEmpty() || tfName.getText().isEmpty() || ValidL.getText().isEmpty() || CVV.getText().isEmpty()) || (!yes.isSelected() && !no.isSelected())) {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
            } else if(CardNo.getText().trim().length() != 16) {
                JOptionPane.showMessageDialog(null, "Please enter a valid card number.", "Warning!", JOptionPane.WARNING_MESSAGE);
            } else if(CVV.getText().trim().length() != 3) {
                JOptionPane.showMessageDialog(null, "Please enter a valid CVV.", "Warning!", JOptionPane.WARNING_MESSAGE);
            } else if(ValidL.getText().trim().length() != 4) {
                JOptionPane.showMessageDialog(null, "Validity is incorrect. Please enter a valid year.", "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                makePayment();
                JOptionPane.showMessageDialog(null, "Payment successfull.", "Info", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                new AvailableCampaigns();
            }
        }
    }
}
