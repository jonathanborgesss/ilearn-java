package com.mycompany.ilearn;

import com.mycompany.ilearn.Util.Session;
import com.mycompany.ilearn.View.User.Views.Login;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Ilearn extends JFrame {
    private CardLayout cardLayout;
    private JPanel cards;

    public Ilearn() {
        setTitle("iLearn");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        // Add views (cards)
        cards.add(createHomeView(), "Home");
        cards.add(new Login(this), "Login");
        // TODO: Add other views like AboutView, CatalogView, etc.
        // cards.add(new AboutView(this), "About");

        add(cards);
        showView("Home"); // default view
    }

    public void showView(String name) {
        cardLayout.show(cards, name);
    }

    private JPanel createHomeView() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // Reuse your existing navbar, header, and card UI from original Ilearn class
        // You can extract this code into a HomeView class later

        // Example: basic button to go to login
        JButton goToLogin = new JButton("Login");
        goToLogin.addActionListener(e -> showView("Login"));
        mainPanel.add(goToLogin, BorderLayout.CENTER);

        return mainPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ilearn().setVisible(true));
    }
}
