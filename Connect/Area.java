package Connect;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;

public class Area extends JPanel implements MouseListener{

    private Color pieceColor;
    private int column;

    private int spaceWIDTH, spaceHEIGHT;
    private int boardX, boardY;

    private Game game;

    public Area(int c, int sW, int sH, int bX, int bY, Game g)
    {
        column = c;
        spaceWIDTH = sW;
        spaceHEIGHT = sH;
        boardX = bX;
        boardY = bY;
        game = g;
        pieceColor = Color.CYAN;

        setBackground(Color.CYAN);
        setLayout(null);
        this.addMouseListener(this);        
        setBounds(new Rectangle(spaceWIDTH * column + boardX, boardY - spaceHEIGHT * 2, spaceWIDTH, spaceHEIGHT * 2));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawPiece(g2d);
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        game.drop(column); 
        pieceColor = game.getPlayerColor();
        validate();
        repaint();
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) 
    {
        pieceColor = game.getPlayerColor();
        this.validate();
        this.repaint();
    }
    @Override   
    public void mouseExited(MouseEvent e) 
    {
        pieceColor = Color.CYAN;
        this.validate();
        this.repaint();
    }

    private void drawPiece(Graphics2D g)
    {
        g.setColor(pieceColor);
        g.fillOval(2, spaceHEIGHT, spaceWIDTH - 5, spaceHEIGHT - 5);
    }
}