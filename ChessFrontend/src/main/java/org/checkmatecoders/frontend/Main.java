package org.checkmatecoders.frontend;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.getContentPane().setBackground(Color.black);
        f.setLayout(new GridBagLayout());
        f.setMinimumSize(new Dimension(800, 800));
        f.setLocationRelativeTo(null);
        BoardPanel b = new BoardPanel();
        f.add(b);
        f.setVisible(true);
    }
}
