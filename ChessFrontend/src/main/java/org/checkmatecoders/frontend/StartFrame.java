package org.checkmatecoders.frontend;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame implements ActionListener {
    JButton but;

    public StartFrame(){
        setLayout(new BorderLayout());
        but = new JButton("Play");
        but.setPreferredSize(new Dimension(200,80));
        but.addActionListener(this);
        add(but, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(Resources.startingPage, 0,0, null);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.setColor(Color.BLACK);
        g.drawString("Chess+",170,70);
        g.setColor(new Color(10, 10, 10));
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("Credits:",50,120);
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
            BoardPanel b = new BoardPanel();
            //SpellPanel s = new SpellPanel();

            //f.add(s, BorderLayout.SOUTH);
            f.add(b, BorderLayout.CENTER);

            f.setVisible(true);
            f.pack();
        }
    }
}
