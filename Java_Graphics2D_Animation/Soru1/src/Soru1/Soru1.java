package Soru1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class Surface extends JPanel implements ActionListener {

    private final int DELAY = 200;
    private int adim = 3;

    private Timer timer;
    int sayac = 0;

    public Surface() {

        initTimer();
         
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    public Timer getTimer() {
        
        return timer;
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        Random c = new Random();
        int w = getWidth();
        int h = getHeight();
        

        Random r = new Random();
        BasicStroke bs3 = new BasicStroke(3, BasicStroke.CAP_SQUARE,
        BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs3);
     	g2d.setColor(new Color(c.nextInt(255),c.nextInt(255),c.nextInt(255)));
        g2d.drawOval(w/2-adim/2,h/2-adim/2, adim,adim);
        g2d.setColor(new Color(c.nextInt(255),c.nextInt(255),c.nextInt(255)));
        g2d.fillOval(w/2-adim/2,h/2-adim/2, adim,adim);
        adim +=10;
        System.out.println("W:"+w/2+" H: "+h/2+" adim: "+adim);
        if(adim > h && adim > w){
            timer.stop();
            super.paintComponent(g);
        }
        
    }

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

public class Soru1 extends JFrame {

    public Soru1() {

        initUI();
    }

    private void initUI() {

        final Surface surface = new Surface();
        add(surface);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Timer timer = surface.getTimer();
                timer.stop();
            }
        });

        setTitle("1.soru");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

            	Soru1 ex = new Soru1();
                ex.setVisible(true);
            }
        });
    }
}