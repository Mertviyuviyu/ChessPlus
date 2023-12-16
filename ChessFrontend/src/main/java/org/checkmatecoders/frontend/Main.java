package org.checkmatecoders.frontend;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.getContentPane().setBackground(Color.black);
        f.setLayout(new BorderLayout());
        //f.setMinimumSize(new Dimension(800, 800));
        f.setLocationRelativeTo(null);
        BoardPanel b = new BoardPanel();
        //SpellPanel s = new SpellPanel();
        
        //f.add(s, BorderLayout.SOUTH);
        f.add(b, BorderLayout.CENTER);
        
        f.setVisible(true);
        f.pack();
    }
}
