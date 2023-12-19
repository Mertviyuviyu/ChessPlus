package org.checkmatecoders.frontend;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class StartFrame extends JFrame implements ActionListener {
    JButton but;
    BoardPanel b;
    private Font customFont;
    Color royalPurple = new Color(102, 51, 153);


    public StartFrame(){
        setLayout(null);
        but = new JButton("Play");
        but.addActionListener(this);
        but.setBackground(Color.BLACK);
        but.setForeground(royalPurple);
        but.setFont(new Font("Arial", Font.BOLD, 25));
        add(but, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        but.setBounds(150,350,200,75);
        but.setFocusPainted(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        try {
  
            customFont = Font.createFont(Font.TRUETYPE_FONT, Resources.font).deriveFont(60f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            but.setFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(Resources.startingPage, 0,0, null);
         g.setFont(customFont);
        g.setColor(Color.BLACK);
        g.drawString("Chess+", 170, 70);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("Credits:",50,120);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Mustafa Mert Gulhan", 50, 150);
        g.drawString("Anil Keskin", 50, 180);
        g.drawString("Altay Ilker Yigitel", 50, 210);
        g.drawString("Emre Algur", 50, 240);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == but){
            this.setVisible(false);
            JFrame f = new JFrame();
            f.getContentPane().setBackground(Color.black);
            f.setLayout(new BorderLayout());
            f.setSize(new Dimension(800, 900));
            f.setLocationRelativeTo(null);
            b = new BoardPanel();
            //SpellPanel s = new SpellPanel();

            //f.add(s, BorderLayout.SOUTH);
            f.add(b, BorderLayout.CENTER);

            f.setVisible(true);
            f.pack();
        }


    }
}
