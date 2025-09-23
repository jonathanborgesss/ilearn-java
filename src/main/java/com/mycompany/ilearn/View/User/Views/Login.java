package com.mycompany.ilearn.View.User.Views;

import com.mycompany.ilearn.Controller.LoginController;
import com.mycompany.ilearn.Ilearn;
import com.mycompany.ilearn.Model.UserModel;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    public JLabel registerText;
    public Login() {
        setTitle("Login");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        UserModel userModel = new UserModel();
        LoginController controller = new LoginController(userModel);

        JPanel background = new JPanel(new GridBagLayout());
        background.setBackground(Color.WHITE);

        JPanel card = new JPanel(new BorderLayout());
        card.setPreferredSize(new Dimension(400, 500));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 4, 4, new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        topPanel.setBackground(Color.WHITE);

        JButton backButton = new JButton("<");
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(e -> {
            new Ilearn().setVisible(true);
            dispose();
        });

        topPanel.add(backButton);
        card.add(topPanel, BorderLayout.NORTH);

        JPanel wrapperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        wrapperPanel.setBackground(Color.WHITE);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // bloco todo mais para cima

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/logo.png"));
        Image img = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(img);
        JLabel logo = new JLabel(logoIcon, JLabel.CENTER);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("Login", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Bem-vindo de volta! Faça login para continuar", SwingConstants.CENTER);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(250, 45));
        emailField.setMaximumSize(new Dimension(250, 45));
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailField.setBorder(BorderFactory.createTitledBorder("Email"));
        emailField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(250, 45));
        passwordField.setMaximumSize(new Dimension(250, 45));
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField.setBorder(BorderFactory.createTitledBorder("Senha"));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton loginBtn = new JButton("Entrar");
        loginBtn.setBackground(new Color(0, 122, 255));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false);
        loginBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginBtn.setPreferredSize(new Dimension(250, 50));
        loginBtn.setMaximumSize(new Dimension(250, 50));
        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        registerText = new JLabel("Não tem conta? Criar uma conta", SwingConstants.CENTER);
        registerText.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        registerText.setForeground(new Color(0, 122, 255));
        registerText.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerText.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(logo);
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(title);
        centerPanel.add(Box.createVerticalStrut(3));
        centerPanel.add(subtitle);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(emailField);
        centerPanel.add(Box.createVerticalStrut(8));
        centerPanel.add(passwordField);
        centerPanel.add(Box.createVerticalStrut(12));
        centerPanel.add(loginBtn);
        centerPanel.add(Box.createVerticalStrut(8));
        centerPanel.add(registerText);

        wrapperPanel.add(centerPanel);
        card.add(wrapperPanel, BorderLayout.CENTER);

        GridBagConstraints bgc = new GridBagConstraints();
        bgc.gridx = 0;
        bgc.gridy = 0;
        background.add(card, bgc);

        loginBtn.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            controller.handleLogin(this, email, password);
        });

        add(background);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
