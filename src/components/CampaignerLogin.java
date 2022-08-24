package src.components;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import src.constants.Colors;
import src.constants.Fonts;
import src.constants.SecondaryFrame;

public class CampaignerLogin extends SecondaryFrame implements ActionListener {
    // attributes
    private JPanel primaryPanel;

    private JLabel username;
    private JLabel password;
    private JLabel primaryLabel;
    private JLabel primaryLabel_;

    private JTextField Username;
    private JPasswordField Password;

    private JButton loginBtn;
    // private JButton forgetPassBtn;
    private JButton prevBtn;

    public CampaignerLogin() {
        primaryLabel = new JLabel("FundMe - Campaigner Login");
        primaryLabel.setBounds(260, 40, 500, 40);
        primaryLabel.setFont(Fonts.font30);
        this.add(primaryLabel);

        primaryPanel = new JPanel();
        primaryPanel.setBounds(260, 115, 760, 423+115);
        primaryPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        primaryPanel.setBackground(Colors.secondaryColor);
        primaryPanel.setLayout(null);
        primaryPanel.setVisible(true);
        this.add(primaryPanel);

        primaryLabel_ = new JLabel();
        primaryLabel_.setText("Login");
        primaryLabel_.setIcon(new ImageIcon("src\\images\\login.png"));
        primaryLabel_.setBounds(340, 65, 250, 128+35);
        primaryLabel_.setFont(Fonts.font30);
        primaryLabel_.setHorizontalTextPosition(JLabel.CENTER);
        primaryLabel_.setVerticalTextPosition(JLabel.BOTTOM);
        primaryPanel.add(primaryLabel_);

        username = new JLabel("Username");
        username.setBounds(230, 200+25, 100, 35);
        username.setFont(Fonts.primaryFont_);
        primaryPanel.add(username);

        Username = new JTextField();
        Username.setBounds(230+100, 200+25, 200, 35);
        Username.setFont(Fonts.primaryFont_);
        primaryPanel.add(Username);

        password = new JLabel("Password");
        password.setBounds(230, 245+25, 100, 35);
        password.setFont(Fonts.primaryFont_);
        primaryPanel.add(password);

        Password = new JPasswordField();
        Password.setBounds(230+100, 245+25, 200, 35);
        Password.setFont(Fonts.primaryFont_);
        primaryPanel.add(Password);

        loginBtn = new JButton("Login");
        loginBtn.setFont(Fonts.primaryFont_);
        loginBtn.setBounds(230, 290+25, 300, 35);
        loginBtn.setForeground(Colors.secondaryColor);
        loginBtn.setBackground(Colors.primaryColor);
        loginBtn.addActionListener((java.awt.event.ActionListener) this);
        primaryPanel.add(loginBtn);

        prevBtn = new JButton("Previous");
        prevBtn.setFont(Fonts.primaryFont_);
        prevBtn.setBounds(40, 40, 140, 35);
        prevBtn.setForeground(Colors.primaryColor);
        prevBtn.setBackground(Colors.secondaryColor);
        prevBtn.addActionListener((java.awt.event.ActionListener) this);
        this.add(prevBtn);
    }

    private void login() {
        String username = Username.getText().trim();
        String password = String.valueOf(Password.getPassword()).trim();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\data\\campaigners_info.txt"));

            int totalLines = 0;
            while(reader.readLine() != null)
                totalLines++;
            reader.close();

            boolean authorized = false;
            String fullname_ = "";

            for(int i = 0; i < totalLines; i++) {
                String username__ = Files.readAllLines(Paths.get("src\\data\\campaigners_info.txt")).get(i).substring(10);
                if(username__.equals(username)) {
                    String password__ = Files.readAllLines(Paths.get("src\\data\\campaigners_info.txt")).get(i+1).substring(10);
                    if(password__.equals(password)) {
                        authorized = true;
                        fullname_ = Files.readAllLines(Paths.get("src\\data\\campaigners_info.txt")).get(i-1).substring(11);
                    }
                }
            }

            if(authorized) {
                this.setVisible(false);
                new RegisterCampaignPanel(fullname_, Username.getText().trim());
            }
                
        } catch(Exception e) {
            e.printStackTrace();
        }

        // if(Username.getText().trim() == "admin" && String.valueOf(Password.getPassword()).trim().equals("admin")) {
        //     this.setVisible(false);
        //     new RegisterCampaignPanel("Admin", "Admin");
        // } else {
        //     JOptionPane.showMessageDialog(null, "Username or Password is incorrect.", "Warning!", JOptionPane.WARNING_MESSAGE);
        // }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginBtn) {
            if(Username.getText().trim().isEmpty() || Password.getPassword().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!", JOptionPane.WARNING_MESSAGE);
            } else {
                login();
            }
        }
        if(e.getSource() == prevBtn) {
            this.setVisible(false);
            new CampaignPanel();
        }
    }
    
}
