package com.mycompany.ilearn;

import com.mycompany.ilearn.Model.UserModel;
import com.mycompany.ilearn.Util.Session;
import com.mycompany.ilearn.View.Login;

import javax.swing.*;
import java.awt.*;

public class Ilearn extends JFrame {

    public Ilearn() {
        UserModel currentUser = Session.getCurrentUser();

        setTitle("iLearn - Home");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // Navbar
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(Color.WHITE);
        topBar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Logo
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/logo.png"));
        Image img = logoIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(img);

        JLabel logo = new JLabel("iLearn", logoIcon, JLabel.LEFT);
        logo.setFont(new Font("SansSerif", Font.BOLD, 20));
        logo.setForeground(new Color(0, 102, 255));
        logo.setIconTextGap(10);

        topBar.add(logo, BorderLayout.WEST);

        // Itens Navbar
        JPanel centerNav = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        centerNav.setBackground(Color.WHITE);

        String[] navItems = {"Home", "Sobre", "Recursos", "Soluções", "FAQ", "Catálogo", "Contato"};
        for (String item : navItems) {
            JButton btn = new JButton(item);
            btn.setBackground(new Color(220, 220, 220));
            btn.setForeground(Color.DARK_GRAY);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));

            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btn.setBackground(new Color(0, 120, 255));
                    btn.setForeground(Color.WHITE);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btn.setBackground(new Color(220, 220, 220));
                    btn.setForeground(Color.DARK_GRAY);
                }
            });

            centerNav.add(btn);
        }

        topBar.add(centerNav, BorderLayout.CENTER);
        JButton startButton;
        if(currentUser == null){
            startButton = new JButton("Iniciar");
            startButton.setBackground(new Color(0, 102, 255));
            startButton.setForeground(Color.WHITE);
            startButton.setFocusPainted(false);
            startButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
            startButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    startButton.setBackground(new Color(0, 150, 255));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    startButton.setBackground(new Color(0, 102, 255));
                }
            });

            startButton.addActionListener(e -> {
                new Login().setVisible(true);
                dispose();
            });
        } else{
            startButton = new JButton("Logout");
            startButton.setBackground(new Color(0, 102, 255));
            startButton.setForeground(Color.WHITE);
            startButton.setFocusPainted(false);
            startButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
            startButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    startButton.setBackground(new Color(0, 150, 255));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    startButton.setBackground(new Color(0, 102, 255));
                }
            });

            startButton.addActionListener(e -> {
                Session.end();
                new Ilearn().setVisible(true);
                dispose();
            });
        }


        topBar.add(startButton, BorderLayout.EAST);

        // Home
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 100, 40, 100));

        JLabel subtitle = new JLabel("Conectando leitores, transformando a educação.");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subtitle.setForeground(new Color(0, 102, 255));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("Sua biblioteca digital e colaborativa");
        title.setFont(new Font("SansSerif", Font.BOLD, 26));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea description = new JTextArea(
                "Acreditamos que cada livro compartilhado abre uma porta para o futuro.\n"
                        + "Por isso, criamos uma plataforma vibrante que conecta leitores curiosos e autores talentosos,\n"
                        + "unindo todos pela paixão de democratizar o conhecimento e celebrar o poder da leitura.\n"
                        + "Seja bem-vindo ao iLearn."
        );
        description.setFont(new Font("SansSerif", Font.PLAIN, 14));
        description.setEditable(false);
        description.setFocusable(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setOpaque(false);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(subtitle);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(title);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(description);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 4, 20, 10));
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        bottomPanel.add(createInfoCard("Comunidade", "Troca de experiências."));
        bottomPanel.add(createInfoCard("Acervo Diverso", "Leitura para todos."));
        bottomPanel.add(createInfoCard("Autores", "Novos talentos."));
        bottomPanel.add(createInfoCard("Verificado", "Conteúdo confiável."));

        mainPanel.add(topBar, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JPanel createInfoCard(String title, String description) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(new Color(245, 247, 250));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(20, 15, 20, 15)
        ));

        JLabel icon = new JLabel("📘", SwingConstants.CENTER);
        icon.setFont(new Font("SansSerif", Font.PLAIN, 32));
        icon.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel descLabel = new JLabel(description);
        descLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(icon);
        card.add(Box.createVerticalStrut(10));
        card.add(titleLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(descLabel);

        return card;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ilearn().setVisible(true);
        });
    }
}