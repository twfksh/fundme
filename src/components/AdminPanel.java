package src.components;

import src.StartFundMe;
import src.constants.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AdminPanel extends SecondaryFrame implements ActionListener {
    // attributes
    private JPanel primaryPanel;

    private JLabel primaryLabel;
    private JLabel primaryLabel_;
    private JLabel username;
    private JLabel password;

    private JTextField Username;
    private JPasswordField Password;

    private JButton prevBtn;
    private JButton regBtn;
    private JButton loginBtn;

    public AdminPanel() {
        primaryLabel = new JLabel("FundMe - Admin Panel");
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
        primaryLabel_.setText("Admin Login");
        primaryLabel_.setIcon(new ImageIcon("src\\images\\login_.png"));
        primaryLabel_.setBounds(305, 45, 250, 128+35);
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
        loginBtn.setBounds(230, 290+25, 140, 35);
        loginBtn.setForeground(Colors.secondaryColor);
        loginBtn.setBackground(Colors.primaryColor);
        loginBtn.addActionListener((java.awt.event.ActionListener) this);
        primaryPanel.add(loginBtn);

        regBtn = new JButton("Register");
        regBtn.setFont(Fonts.primaryFont_);
        regBtn.setBounds(230+140+20, 290+25, 140, 35);
        regBtn.setForeground(Colors.secondaryColor);
        regBtn.setBackground(Colors.primaryColor);
        regBtn.addActionListener((java.awt.event.ActionListener) this);
        primaryPanel.add(regBtn);

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
                BufferedReader reader = new BufferedReader(new FileReader("src\\data\\admin_info.txt"));

                int totalLines = 0;
                while(reader.readLine() != null) 
                    totalLines++;
                reader.close();

                boolean authorized = false;
                String fullname_ = "";

                for(int i = 0; i < totalLines; i++) {
                    String username_ = Files.readAllLines(Paths.get("src\\data\\admin_info.txt")).get(i).substring(10);
                    if(username_.equals(username)) {
                        String password_ = Files.readAllLines(Paths.get("src\\data\\admin_info.txt")).get(i+1).substring(10);
                        if(password_.equals(password)) {
                            authorized = true;
                            fullname_ = Files.readAllLines(Paths.get("src\\data\\admin_info.txt")).get(i-1).substring(11);
                        }
                    }
                }

                if(authorized) {
                    this.setVisible(false);
                    new AdminDashboard(fullname_);
                }
                
            } catch(Exception e) {
                e.printStackTrace();
            }
        
        // if(username.equals("admin") && password.equals("admin")) {
        //     // JOptionPane.showMessageDialog(null, "Username n Password matched!", "Validation", JOptionPane.WARNING_MESSAGE);
        //     new AdminDashboard();
        // } else {
        //     JOptionPane.showMessageDialog(null, "Username n Password didn't matched!", "Warning", JOptionPane.WARNING_MESSAGE);
        // }
    }

    @Override
    public void actionPerformed(ActionEvent btn) {
        if(btn.getSource() == prevBtn) {
            this.setVisible(false);
            new StartFundMe();
        }
        if(btn.getSource() == loginBtn) {
            if(Username.getText().trim().isEmpty() || Password.getPassword().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                login();
            }
        }
        if(btn.getSource() == regBtn) {
            this.setVisible(false);
            new Registration();
        }
    }
}
