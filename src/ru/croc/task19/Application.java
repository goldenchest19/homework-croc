package ru.croc.task19;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    private Image image;

    public Application() {
        setSize(400, 320);
        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        JLabel label = new JLabel("Hello, world!");
        getContentPane().add(label, BorderLayout.NORTH);
        setVisible(true);
    }
}
