package com.mycompany.ilearn.View;

import com.mycompany.ilearn.Controller.LoginController;
import com.mycompany.ilearn.Model.UserModel;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    public Login() {
        setTitle("iLearn - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        UserModel userModel = new UserModel();
        LoginController controller = new LoginController(userModel);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Login no iLearn");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        panel.add(new JLabel("Usuário:"), gbc);

        JTextField userField = new JTextField(15);
        gbc.gridx = 1;
        panel.add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Senha:"), gbc);

        JPasswordField passField = new JPasswordField(15);
        gbc.gridx = 1;
        panel.add(passField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton loginButton = new JButton("Entrar");
        loginButton.setBackground(new Color(0, 102, 255));
        loginButton.setForeground(Color.WHITE);
        panel.add(loginButton, gbc);

        // 🔗 Hook up Controller
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            controller.handleLogin(this, username, password);
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
