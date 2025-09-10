package com.mycompany.ilearn.Controller;

import com.mycompany.ilearn.Model.UserModel;
import com.mycompany.ilearn.Ilearn;

import javax.swing.*;

public class LoginController {
    private final UserModel userModel;

    public LoginController(UserModel userModel) {
        this.userModel = userModel;
    }

    public void handleLogin(JFrame loginFrame, String username, String password) {
        if (userModel.authenticate(username, password)) {
            JOptionPane.showMessageDialog(loginFrame, "Login bem-sucedido!");
            loginFrame.dispose();
            new Ilearn().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(loginFrame, "Usuário ou senha incorretos!");
        }
    }
}
