package com.mycompany.ilearn.View.User;

import com.mycompany.ilearn.View.User.Views.Cadastro;
import com.mycompany.ilearn.View.User.Views.Login;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserView {
    public UserView(){
        Login loginView = new Login();
        Cadastro cadastroView = new Cadastro();
        loginView.registerText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cadastroView.setVisible(true);
                loginView.setVisible(false);
            }
        });
        cadastroView.registerText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginView.setVisible(true);
                cadastroView.setVisible(false);
            }
        });
        loginView.setVisible(true);
    }
    public static void main(String[] args) {
        new UserView();
    }
}
