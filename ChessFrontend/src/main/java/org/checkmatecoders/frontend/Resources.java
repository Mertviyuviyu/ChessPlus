package org.checkmatecoders.frontend;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class Resources {
    public static Image whiteRook;
    public static Image blackRook;
    public static Image whiteBishop;
    public static Image blackBishop;
    public static Image whiteKnight;
    public static Image blackKnight;
    public static Image whiteQueen;
    public static Image blackQueen;
    public static Image whitePawn;
    public static Image blackPawn;
    public static Image whiteKing;
    public static Image blackKing;
    public static Image startingPage;

    public static Image freeze;
    public static Image swap;
    public static Image shield;
    public static Image time;
    public static Image play;
    public static File font;
    public static final int SQUARE_SIZE = 70;
    public static final int SPELL_SIZE = 50;

    private static ClassLoader loader =  ClassLoader.getSystemClassLoader();
    static {
        try {
            whiteRook = ImageIO.read(loader.getResource("wrook.png")).getScaledInstance(SQUARE_SIZE, SQUARE_SIZE, BufferedImage.SCALE_SMOOTH);
            blackRook = ImageIO.read(loader.getResource("brook.png")).getScaledInstance(SQUARE_SIZE, SQUARE_SIZE, BufferedImage.SCALE_SMOOTH);;
            whiteKnight = ImageIO.read(loader.getResource("wknight.png")).getScaledInstance(SQUARE_SIZE, SQUARE_SIZE, BufferedImage.SCALE_SMOOTH);;
            blackKnight = ImageIO.read(loader.getResource("bknight.png")).getScaledInstance(SQUARE_SIZE, SQUARE_SIZE, BufferedImage.SCALE_SMOOTH);;
            whiteBishop = ImageIO.read(loader.getResource("wbishop.png")).getScaledInstance(SQUARE_SIZE, SQUARE_SIZE, BufferedImage.SCALE_SMOOTH);;
            blackBishop = ImageIO.read(loader.getResource("bbishop.png")).getScaledInstance(SQUARE_SIZE, SQUARE_SIZE, BufferedImage.SCALE_SMOOTH);;
            whiteQueen= ImageIO.read(loader.getResource("wqueen.png")).getScaledInstance(SQUARE_SIZE, SQUARE_SIZE, BufferedImage.SCALE_SMOOTH);;
            blackQueen = ImageIO.read(loader.getResource("bqueen.png")).getScaledInstance(SQUARE_SIZE, SQUARE_SIZE, BufferedImage.SCALE_SMOOTH);;
            whitePawn = ImageIO.read(loader.getResource("wpawn.png")).getScaledInstance(SQUARE_SIZE, SQUARE_SIZE, BufferedImage.SCALE_SMOOTH);;
            blackPawn = ImageIO.read(loader.getResource("bpawn.png")).getScaledInstance(SQUARE_SIZE, SQUARE_SIZE, BufferedImage.SCALE_SMOOTH);;
            whiteKing = ImageIO.read(loader.getResource("wking.png")).getScaledInstance(SQUARE_SIZE, SQUARE_SIZE, BufferedImage.SCALE_SMOOTH);;
            blackKing = ImageIO.read(loader.getResource("bking.png")).getScaledInstance(SQUARE_SIZE, SQUARE_SIZE, BufferedImage.SCALE_SMOOTH);;
            startingPage = ImageIO.read(loader.getResource("start.png")).getScaledInstance(500,500, BufferedImage.SCALE_SMOOTH);
            freeze = ImageIO.read(loader.getResource("freeze.png")).getScaledInstance(SPELL_SIZE, SPELL_SIZE, BufferedImage.SCALE_SMOOTH);;
            swap = ImageIO.read(loader.getResource("swap.png")).getScaledInstance(SPELL_SIZE, SPELL_SIZE, BufferedImage.SCALE_SMOOTH);;
            shield = ImageIO.read(loader.getResource("shield.png")).getScaledInstance(SPELL_SIZE, SPELL_SIZE, BufferedImage.SCALE_SMOOTH);;
            time = ImageIO.read(loader.getResource("time.png")).getScaledInstance(SPELL_SIZE, SPELL_SIZE, BufferedImage.SCALE_SMOOTH);;
            play = ImageIO.read(loader.getResource("play.png")).getScaledInstance(500,500, BufferedImage.SCALE_SMOOTH);;
            //font = new File(String.valueOf(loader.getResource("Fraktur.tff")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
