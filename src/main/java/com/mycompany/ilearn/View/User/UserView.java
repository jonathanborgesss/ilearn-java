package com.mycompany.ilearn.View.User;

import com.mycompany.ilearn.Ilearn;
import com.mycompany.ilearn.View.User.Views.Cadastro;
import com.mycompany.ilearn.View.User.Views.Login;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserView {
    private Login loginView;
    private Cadastro cadastroView;

    public UserView(Ilearn mainFrame) {
        loginView = new Login(mainFrame);
        cadastroView = new Cadastro(mainFrame);

        loginView.registerText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.showView("Cadastro");
            }
        });

        cadastroView.registerText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.showView("Login");
            }
        });
    }

    public Login getLoginPanel() {
        return loginView;
    }

    public Cadastro getCadastroPanel() {
        return cadastroView;
    }
}
