package src.components;

import src.StartFundMe;
import src.constants.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Registration extends SecondaryFrame implements ActionListener {
    // attributes
    private JPanel primaryPanel;

    private JLabel primaryLabel;
    // private JLabel secondaryLabel;

    private JLabel fullname;
    private JLabel username;
    private JLabel email;
    private JLabel password;
    private JLabel verificationQues;
    private JLabel answer;
    private JLabel captcha;
    private JLabel clabel;
    private JLabel registerLabel;

    private JTextField Fullname;
    private JTextField Username;
    private JTextField Email;
    private JPasswordField Password;
    private JComboBox<String> VerificationQues;
    private JTextField Answer;
    JTextField cAns;

    private JButton regBtn;
    private JButton prevBtn;

    // To get a random number for captcha
    private Random rand = new Random();
    private int ra = rand.nextInt(10);
    private int rb = rand.nextInt(10);
    private int res = ra + rb;

    public Registration() {
        primaryLabel = new JLabel("FundMe - Register as admin");
        primaryLabel.setBounds(260, 40, 750, 40);
        primaryLabel.setFont(Fonts.font25);
        this.add(primaryLabel);

        primaryPanel = new JPanel();
        primaryPanel.setBounds(260, 115, 760, 423+115);
        primaryPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        primaryPanel.setLayout(null);
        primaryPanel.setVisible(true);
        this.add(primaryPanel);

        registerLabel = new JLabel(new ImageIcon("src\\images\\register.png"));
        registerLabel.setBounds(80, 224, 128,90);
        primaryPanel.add(registerLabel);

        
        fullname = new JLabel("Full Name");
        fullname.setBounds(168+128, 80+20, 160, 35);
        fullname.setForeground(Color.BLACK);
        fullname.setFont(Fonts.primaryFont_);
        primaryPanel.add(fullname);

        Fullname = new JTextField();
        Fullname.setBounds(168+160+128, 80+20, 250, 35);
        Fullname.setFont(Fonts.primaryFont_);
        primaryPanel.add(Fullname);

        username = new JLabel("Username");
        username.setBounds(168+128, 80+43+20, 160, 35);
        username.setFont(Fonts.primaryFont_);
        primaryPanel.add(username);

        Username = new JTextField();
        Username.setBounds(168+160+128, 80+43+20, 250, 35);
        Username.setFont(Fonts.primaryFont_);
        primaryPanel.add(Username);

        email = new JLabel("Email");
        email.setBounds(168+128, 80+43+43+20, 160, 35);
        email.setFont(Fonts.primaryFont_);
        primaryPanel.add(email);

        Email = new JTextField();
        Email.setBounds(168+160+128, 80+43+43+20, 250, 35);
        Email.setFont(Fonts.primaryFont_);
        primaryPanel.add(Email);

        password = new JLabel("Password");
        password.setBounds(168+128, 80+43+43+43+20, 160, 35);
        password.setFont(Fonts.primaryFont_);
        primaryPanel.add(password);

        Password = new JPasswordField();
        Password.setBounds(168+160+128, 80+43+43+43+20, 250, 35);
        Password.setFont(Fonts.primaryFont_);
        primaryPanel.add(Password);

        verificationQues = new JLabel("Security question");
        verificationQues.setBounds(168+128, 80+43+43+43+43+20, 160, 35);
        verificationQues.setFont(Fonts.primaryFont_);
        primaryPanel.add(verificationQues);

        String[] secQsn = { "Choose a Security Question...", "Your dream job?", "Your favorite song?",
                "First pet's name?", "Your favorite hobby?" };

        VerificationQues = new JComboBox<>(secQsn);
        VerificationQues.setBounds(168+160+128, 80+43+43+43+43+20, 250, 35);
        VerificationQues.setSelectedIndex(0);
        VerificationQues.setFont(Fonts.primaryFont_);
        VerificationQues.setBackground(Color.white);
        primaryPanel.add(VerificationQues);

        answer = new JLabel("Answer");
        answer.setBounds(168+128, 80+43+43+43+43+43+20, 160, 35);
        answer.setFont(Fonts.primaryFont_);
        primaryPanel.add(answer);

        Answer = new JTextField();
        Answer.setBounds(168+160+128, 80+43+43+43+43+43+20, 250, 35);
        Answer.setFont(Fonts.primaryFont_);
        primaryPanel.add(Answer);

        captcha = new JLabel("Captcha");
        captcha.setBounds(168+128, 80+43+43+43+43+43+43+20, 160, 35);
        captcha.setFont(Fonts.primaryFont_);
        primaryPanel.add(captcha);

        // Captcha
        clabel = new JLabel();
        clabel.setText(" " + ra + " + " + rb + " ");
        clabel.setBounds(70+168+128, 80+43+43+43+43+43+43+20, 50, 35);
        clabel.setFont(Fonts.primaryFont_);
        clabel.setForeground(Color.red);
        clabel.setBackground(Color.decode("#FFD3D3"));
        clabel.setOpaque(true);
        primaryPanel.add(clabel);

        cAns = new JTextField();
        cAns.setBounds(168+160+128, 80+43+43+43+43+43+43+20, 250, 35);
        cAns.setFont(Fonts.primaryFont_);
        primaryPanel.add(cAns);

        regBtn = new JButton("Register");
        regBtn.setFont(Fonts.primaryFont_);
        regBtn.setBounds(168+128, 405, 160+250, 35);
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

    private void register() {
        String fullname = Fullname.getText().trim();
        String username = Username.getText().trim().toLowerCase();
        String email = Email.getText().trim().toLowerCase();
        String password = String.valueOf(Password.getPassword()).trim();
        String sQues = String.valueOf(VerificationQues.getSelectedItem());
        String sQuesAns = Answer.getText().trim();
        String capAns = cAns.getText().trim();

        try {
            File file = new File("src\\data\\user_info.txt");
            if(!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            PrintWriter pw = new PrintWriter(bw);

            LocalDateTime datentime = LocalDateTime.now();
            DateTimeFormatter datentimeformater = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");
            String timeAndDate = datentime.format(datentimeformater);

            pw.println("Full name: " + fullname);
            pw.println("Username: " + username);
            pw.println("Password: " + password);
            pw.println("Email: " + email);
            pw.println("Security Question: " + sQues);
            pw.println("Answer: " + sQuesAns);
            pw.println("Time & Date: " + timeAndDate);
            pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            pw.close();
            bw.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Registration Successfull.", "Registration Complete", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
        new AdminPanel();
    }

    @Override
    public void actionPerformed(ActionEvent btn) {
        if(btn.getSource() == prevBtn) {
            this.setVisible(false);
            new StartFundMe();
        }
        if(btn.getSource() == regBtn) {
            if(!Checked.usernameExists("src\\data\\admin_info.txt", Username.getText().trim())) {
                if(Fullname.getText().isEmpty() && Username.getText().isEmpty() && Email.getText().isEmpty() && Password.getPassword().toString().isEmpty() && VerificationQues.getSelectedItem().toString().isEmpty() && Answer.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill out all the information correctly.", "Warning!", JOptionPane.WARNING_MESSAGE);
                } else if(cAns.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please answer the captcha.", "Warning!", JOptionPane.WARNING_MESSAGE);
                } else if(res != Integer.parseInt(cAns.getText().trim())) {
                    JOptionPane.showMessageDialog(null, "Please recheck your captcha.", "Warning!", JOptionPane.WARNING_MESSAGE);
                } else if(Password.getPassword().toString().trim().length() < 8) {
                    JOptionPane.showMessageDialog(null, "Weak password. Please enter a strong password.", "Warning!", JOptionPane.WARNING_MESSAGE);
                } else {
                    register();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username already exists.", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
