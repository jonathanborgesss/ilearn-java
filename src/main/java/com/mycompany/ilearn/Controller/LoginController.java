package com.mycompany.ilearn.Controller;

import com.mycompany.ilearn.Model.UserModel;
import com.mycompany.ilearn.Ilearn;
import com.mycompany.ilearn.Util.Session;
import com.mycompany.ilearn.View.User.Views.Cadastro;

import javax.swing.*;

public class LoginController {
    private UserModel userModel;

    public LoginController(UserModel userModel) {
        this.userModel = userModel;
    }

    public void handleLogin(JFrame loginFrame, String username, String password) {
        userModel = new UserModel();
        if (userModel.authenticate(username, password)) {
            Session.start(userModel);
            JOptionPane.showMessageDialog(loginFrame, "Login bem-sucedido!");
            new Ilearn().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(loginFrame, "Usuário ou senha incorretos!");
        }
    }

    public void handleSignUp(Cadastro signupFrame, String email, String username, String password){
        if (userModel.signUp(email, username,password)) {
            Session.start(userModel);
            JOptionPane.showMessageDialog(signupFrame, "Cadastro realizado com sucesso!");
            new Ilearn().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(signupFrame, "Email já está em uso. Tente outro.");
        }
    }
}
