package com.mycompany.ilearn;

import com.mycompany.ilearn.Model.UserModel;
import com.mycompany.ilearn.Util.Session;
import com.mycompany.ilearn.View.User.UserView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ilearn extends JFrame {
    public Ilearn() {
        /*
        jonathan -
        a navbar fica flickando, conserte.
         */
        UserModel currentUser = Session.getCurrentUser();

        setTitle("iLearn - Home");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
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
        logo.setFont(new Font("SansSerif", Font.BOLD, 22));
        logo.setForeground(new Color(0, 102, 255));
        logo.setIconTextGap(10);

        topBar.add(logo, BorderLayout.WEST);

        // Itens Navbar
        JPanel centerNav = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        centerNav.setBackground(Color.WHITE);

        String[] navItems = {"Home", "Sobre", "Recursos", "Soluções", "FAQ", "Catálogo", "Contato"};
        for (String item : navItems) {
            JButton btn = new JButton(item);
            btn.setBackground(Color.WHITE);
            btn.setForeground(new Color(0, 102, 255));
            btn.setFont(new Font("Arial", Font.PLAIN, 14));
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    btn.setBackground(new Color(0, 120, 255));
                    btn.setForeground(Color.WHITE);
                    btn.setBorder(BorderFactory.createLineBorder(new Color(0, 120, 255), 2));
                }

                @Override
                public void mouseExited(MouseEvent evt) {
                    btn.setBackground(Color.WHITE);
                    btn.setForeground(new Color(0, 102, 255));
                    btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
                }
            });

            centerNav.add(btn);
        }

        topBar.add(centerNav, BorderLayout.CENTER);

        // Botão Iniciar / Logout
        JButton startButton;
        if (currentUser == null) {
            startButton = new JButton("Iniciar");
            startButton.setBackground(new Color(0, 102, 255));
            startButton.setForeground(Color.WHITE);
            startButton.setFocusPainted(false);
            startButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));

            startButton.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    startButton.setBackground(new Color(0, 150, 255));
                }

                public void mouseExited(MouseEvent evt) {
                    startButton.setBackground(new Color(0, 102, 255));
                }
            });

            startButton.addActionListener(e -> {
                new UserView();
                dispose();
            });
        } else {
            startButton = new JButton("Logout");
            startButton.setBackground(new Color(255, 69, 58));
            startButton.setForeground(Color.WHITE);
            startButton.setFocusPainted(false);
            startButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));

            startButton.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    startButton.setBackground(new Color(255, 99, 71));
                }

                public void mouseExited(MouseEvent evt) {
                    startButton.setBackground(new Color(255, 69, 58));
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
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        // Painel de texto (esquerda)
        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.WHITE);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBorder(BorderFactory.createEmptyBorder(80, 0, 0, 40)); // 60px no topo


        JLabel subtitle = new JLabel("Conectando leitores, transformando a educação.");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 18)); // Aumentado
        subtitle.setForeground(new Color(0, 102, 255));
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel title = new JLabel("Sua biblioteca digital e colaborativa");
        title.setFont(new Font("SansSerif", Font.BOLD, 32)); // Aumentado
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea description = new JTextArea(
                "Acreditamos que cada livro compartilhado abre uma porta para o futuro.\n"
                        + "Por isso, criamos uma plataforma vibrante que conecta leitores curiosos e autores talentosos,\n"
                        + "unindo todos pela paixão de democratizar o conhecimento e celebrar o poder da leitura.\n"
                        + "Seja bem-vindo ao iLearn."
        );
        description.setFont(new Font("SansSerif", Font.PLAIN, 16)); // Aumentado
        description.setEditable(false);
        description.setFocusable(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setOpaque(false);
        description.setAlignmentX(Component.LEFT_ALIGNMENT);

        textPanel.add(subtitle);
        textPanel.add(Box.createVerticalStrut(20));
        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(20));
        textPanel.add(description);

        // Painel de imagem (direita)
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);

        ImageIcon rightImageIcon = new ImageIcon(getClass().getResource("/hero.png"));
        Image scaledImage = rightImageIcon.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH); // Aumentado
        rightImageIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(rightImageIcon);
        imagePanel.add(imageLabel);

        centerPanel.add(textPanel, BorderLayout.WEST);
        centerPanel.add(imagePanel, BorderLayout.EAST);

        // Painel inferior com cards
        JPanel bottomPanel = new JPanel(new GridLayout(1, 4, 20, 10));
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        bottomPanel.add(createInfoCard("Comunidade", "Troca de experiências."));
        bottomPanel.add(createInfoCard("Acervo Diverso", "Leitura para todos."));
        bottomPanel.add(createInfoCard("Autores", "Novos talentos."));
        bottomPanel.add(createInfoCard("Verificado", "Conteúdo confiável."));

        // Adiciona tudo ao painel principal
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

    // Painel "Sobre"
    private JPanel createAboutSection() {
        JPanel aboutPanel = new JPanel(new BorderLayout());
        aboutPanel.setBackground(Color.WHITE);
        aboutPanel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        // Painel de texto (esquerda)
        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.WHITE);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel sobreTitle = new JLabel("Quem somos?");
        sobreTitle.setFont(new Font("SansSerif", Font.BOLD, 28));
        sobreTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea sobreDesc = new JTextArea(
                "Somos uma plataforma digital movida por um propósito: conectar pessoas através das histórias. "
                        + "Nascemos como uma comunidade colaborativa, guiada pela ODS 4 (Educação de Qualidade), onde sua "
                        + "experiência de leitura importa.\n\n"
                        + "Aqui, leitores, estudantes e autores se encontram para compartilhar, avaliar e democratizar o acesso "
                        + "a um universo de conhecimento, fortalecendo juntos a educação."
        );
        sobreDesc.setFont(new Font("SansSerif", Font.PLAIN, 15));
        sobreDesc.setEditable(false);
        sobreDesc.setFocusable(false);
        sobreDesc.setLineWrap(true);
        sobreDesc.setWrapStyleWord(true);
        sobreDesc.setOpaque(false);
        sobreDesc.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Lista de tópicos
        JPanel bulletPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        bulletPanel.setBackground(Color.WHITE);
        String[] bullets = {
                "✔ Promoção da Leitura",
                "✔ Inovação e Tecnologia",
                "✔ Democratização da Leitura",
                "✔ Ambiente Seguro",
                "✔ Conectividade e Inclusão",
                "✔ Vitrine para Autores"
        };
        for (String b : bullets) {
            JLabel lbl = new JLabel(b);
            lbl.setFont(new Font("SansSerif", Font.PLAIN, 14));
            lbl.setForeground(new Color(0, 102, 255));
            bulletPanel.add(lbl);
        }

        textPanel.add(sobreTitle);
        textPanel.add(Box.createVerticalStrut(15));
        textPanel.add(sobreDesc);
        textPanel.add(Box.createVerticalStrut(20));
        textPanel.add(bulletPanel);

        // Painel de imagem (direita)
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);

        ImageIcon aboutIcon = new ImageIcon(getClass().getResource("/about.png")); // coloque sua imagem aqui
        Image scaledImage = aboutIcon.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        aboutIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(aboutIcon);
        imagePanel.add(imageLabel);

        aboutPanel.add(textPanel, BorderLayout.WEST);
        aboutPanel.add(imagePanel, BorderLayout.EAST);

        return aboutPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Ilearn().setVisible(true);
        });
    }
}