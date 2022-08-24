package src.components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JLabel;

import src.constants.*;
import java.awt.event.*;

public class CampaignerProfile extends SecondaryFrame implements ActionListener {
    // attrubutes
    private String fullname;
    private String password;
    private String email;
    private String sques;
    private String sans;
    private String regDate;

    private JLabel fullnameL;
    private JLabel usernameL;
    private JLabel passwordL;
    private JLabel emailL;
    private JLabel squesL;
    private JLabel sansL;
    private JLabel regDateL;

    private JButton prevBtn;

    public CampaignerProfile(String username) {
        extractInfo(username);

        fullnameL = new JLabel(fullname);
        fullnameL.setBounds(240, 80, 250, 35);
        fullnameL.setFont(Fonts.font22);
        this.add(fullnameL);

        usernameL = new JLabel("Username: " + username);
        usernameL.setBounds(240, 80+45, 250, 35);
        usernameL.setFont(Fonts.font22);
        this.add(usernameL);

        passwordL = new JLabel(password);
        passwordL.setBounds(240, 80+45+45, 250, 35);
        passwordL.setFont(Fonts.font22);
        this.add(passwordL);

        emailL = new JLabel(email);
        emailL.setBounds(240, 80+45+45+45, 250, 35);
        emailL.setFont(Fonts.font22);
        this.add(emailL);

        squesL = new JLabel(sques);
        squesL.setBounds(240, 80+45+45+45+45, 250, 35);
        squesL.setFont(Fonts.font22);
        this.add(squesL);

        sansL = new JLabel(sans);
        sansL.setBounds(240, 80+45+45+45+45+45, 250, 35);
        sansL.setFont(Fonts.font22);
        this.add(sansL);

        regDateL = new JLabel(regDate + " (registration verified)");
        regDateL.setBounds(240, 80+45+45+45+45+45+45, 250, 35);
        regDateL.setFont(Fonts.font22);
        this.add(regDateL);

        prevBtn = new JButton("Previous");
        prevBtn.setFont(Fonts.primaryFont_);
        prevBtn.setBounds(40, 40, 140, 35);
        prevBtn.setForeground(Colors.primaryColor);
        prevBtn.setBackground(Colors.secondaryColor);
        prevBtn.addActionListener((java.awt.event.ActionListener) this);
        this.add(prevBtn);
    }

    public void extractInfo(String username) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src\\data\\campaigners_info.txt"));

            int totalLines = 0;
            while(reader.readLine() != null) 
                totalLines++;
            reader.close();
            
            for(int i = 0; i <= totalLines; i++) {
                String username_ = Files.readAllLines(Paths.get("src\\data\\campaigners_info.txt")).get(i).substring(10);

                if(username.equals(username_)) {
                    this.fullname = Files.readAllLines(Paths.get("src\\data\\campaigners_info.txt")).get(i-1);
                    this.password = Files.readAllLines(Paths.get("src\\data\\campaigners_info.txt")).get(i+1);
                    this.email = Files.readAllLines(Paths.get("src\\data\\campaigners_info.txt")).get(i+2);
                    this.sques = Files.readAllLines(Paths.get("src\\data\\campaigners_info.txt")).get(i+3);
                    this.sans = Files.readAllLines(Paths.get("src\\data\\campaigners_info.txt")).get(i+4);
                    this.regDate = Files.readAllLines(Paths.get("src\\data\\campaigners_info.txt")).get(i+5);
                    break;
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == prevBtn) {
            this.setVisible(false);
        }
    }
}
