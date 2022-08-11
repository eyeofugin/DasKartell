package framework.graphics;

import framework.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class WindowManager extends Canvas{
    private JFrame frame;
    private BufferedImage image = new BufferedImage(Engine.X, Engine.Y, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    public WindowManager() {
        Dimension size = new Dimension(Engine.X,Engine.Y);
        setPreferredSize(size);

        this.frame = new JFrame("SwitchTeam");
        this.frame.setBounds(0, 0, 0, 0);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
    }
    public void start() {
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setTitle("rogue");
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setVisible(true);
    }

    public void render(int[] p){
        paintP(p);
        Graphics g = getGraphics();
        g.drawImage(image,0,0,getWidth(),getHeight(),null);
        g.dispose();
        paint(g);
    }

    private void paintP(int[] p) {
        for(int i = 0; i < pixels.length; i++) {
            pixels[i] = p[i];
        }
    }

    public void addMouse(MouseListener mouse) {
        addMouseListener(mouse);
    }
    public void addKey(KeyListener key) {
        addKeyListener(key);
    }
    public void dispose() {
        this.frame.dispose();
    }
}
