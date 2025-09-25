package com.mycompany.ilearn.View.NavBar.Views;

import javax.swing.*;
import java.awt.*;

public class NavBar {
    public static void About(){
        JFrame frame = new JFrame("Sobre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
    }
    public static void Contact(){
        JFrame frame = new JFrame("Contato");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
    }
    public static void Faq(){
        JFrame frame = new JFrame("FAQ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
    }
    public static void Resources(){
        JFrame frame = new JFrame("Recursos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
    }
    public static void Solutions(){
        JFrame frame = new JFrame("Soluções");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
    }
    public static void main(String[] args){

    }
}
