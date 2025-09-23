package com.mycompany.ilearn.View.Catalogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Catalogo {
    public void buildCatalogo() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Catálogo de Livros");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 500);
            frame.setLocationRelativeTo(null);

            frame.setLayout(new BorderLayout());

            JPanel painelCategorias = new JPanel();
            painelCategorias.setPreferredSize(new Dimension(150, 0));
            painelCategorias.setBackground(new Color(240, 240, 240));
            painelCategorias.setLayout(new BoxLayout(painelCategorias, BoxLayout.Y_AXIS));
            painelCategorias.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            String[] categorias = {"Ficção", "Clássicos", "Infantil", "Fantasia", "Romance"};
            for (String cat : categorias) {
                JButton btn = new JButton(cat);
                btn.setAlignmentX(Component.CENTER_ALIGNMENT);
                btn.setFocusPainted(false);
                btn.setBackground(Color.WHITE);
                btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
                painelCategorias.add(btn);
                painelCategorias.add(Box.createVerticalStrut(10));
            }

            frame.add(painelCategorias, BorderLayout.WEST);

            JPanel painelTopoDireito = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
            painelTopoDireito.setBackground(Color.WHITE);

            JTextField campoPesquisa = new JTextField(20);
            campoPesquisa.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            campoPesquisa.setBorder(BorderFactory.createTitledBorder("Pesquisar Livro"));

            JButton btnPesquisar = new JButton("\uD83D\uDD0D"); // Ícone lupa 🔍
            btnPesquisar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            btnPesquisar.setFocusPainted(false);
            btnPesquisar.setBackground(new Color(0, 122, 255));
            btnPesquisar.setForeground(Color.WHITE);
            btnPesquisar.setPreferredSize(new Dimension(45, 45));

            painelTopoDireito.add(campoPesquisa);
            painelTopoDireito.add(btnPesquisar);

            frame.add(painelTopoDireito, BorderLayout.NORTH);

            JPanel painelCatalogo = new JPanel(new GridLayout(2, 3, 15, 15));
            painelCatalogo.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            painelCatalogo.setBackground(Color.WHITE);

            Catalogo.Livro[] livros = {
                    new Catalogo.Livro("1984", "George Orwell"),
                    new Catalogo.Livro("Dom Casmurro", "Machado de Assis"),
                    new Catalogo.Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry"),
                    new Catalogo.Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis"),
                    new Catalogo.Livro("O Senhor dos Anéis", "J.R.R. Tolkien"),
                    new Catalogo.Livro("Harry Potter", "J.K. Rowling")
            };

            for (Catalogo.Livro livro : livros) {
                painelCatalogo.add(criarPainelLivro(livro));
            }

            JScrollPane scrollPane = new JScrollPane(painelCatalogo);
            scrollPane.setBorder(null);
            frame.add(scrollPane, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }

    private static JPanel criarPainelLivro(Livro livro) {
        JPanel painelLivro = new JPanel();
        painelLivro.setLayout(new BoxLayout(painelLivro, BoxLayout.Y_AXIS));
        painelLivro.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        painelLivro.setBackground(Color.WHITE);

        JPanel painelImagem = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(220, 220, 220));
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(new Color(150, 150, 150));
                int margem = 20;
                g.fillRect(margem, margem, getWidth() - 2 * margem, getHeight() - 2 * margem);
                g.setColor(new Color(200, 200, 200));
                g.fillRect(margem + 5, margem + 5, getWidth() - 2 * margem - 10, getHeight() - 2 * margem - 10);
                g.setColor(new Color(100, 100, 100));
                g.drawLine(margem + 5, margem + 5, margem + 5, getHeight() - margem - 5);
            }
        };
        painelImagem.setPreferredSize(new Dimension(150, 200));
        painelImagem.setMaximumSize(new Dimension(150, 200));
        painelImagem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        painelImagem.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton botaoSaibaMais = new JButton("Saiba Mais");
        botaoSaibaMais.setVisible(false);
        botaoSaibaMais.setFocusPainted(false);
        botaoSaibaMais.setBackground(new Color(0, 122, 255));
        botaoSaibaMais.setForeground(Color.WHITE);
        botaoSaibaMais.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botaoSaibaMais.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botaoSaibaMais.setAlignmentX(Component.CENTER_ALIGNMENT);

        botaoSaibaMais.addActionListener(e -> {
            JOptionPane.showMessageDialog(painelLivro,
                    "Título: " + livro.nome + "\nAutor: " + livro.autor,
                    "Detalhes do Livro", JOptionPane.INFORMATION_MESSAGE);
        });

        painelLivro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botaoSaibaMais.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Point mousePos = MouseInfo.getPointerInfo().getLocation();
                SwingUtilities.convertPointFromScreen(mousePos, painelLivro);
                if (!botaoSaibaMais.getBounds().contains(mousePos)) {
                    botaoSaibaMais.setVisible(false);
                }
            }
        });

        botaoSaibaMais.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                botaoSaibaMais.setVisible(false);
            }
        });

        JLabel labelNome = new JLabel(livro.nome, JLabel.CENTER);
        labelNome.setFont(new Font("Segoe UI", Font.BOLD, 14));
        labelNome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelAutor = new JLabel(livro.autor, JLabel.CENTER);
        labelAutor.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        labelAutor.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelLivro.add(painelImagem);
        painelLivro.add(Box.createVerticalStrut(8));
        painelLivro.add(labelNome);
        painelLivro.add(labelAutor);
        painelLivro.add(Box.createVerticalStrut(8));
        painelLivro.add(botaoSaibaMais);

        return painelLivro;
    }

    static class Livro {
        String nome;
        String autor;

        Livro(String nome, String autor) {
            this.nome = nome;
            this.autor = autor;
        }
    }
}
