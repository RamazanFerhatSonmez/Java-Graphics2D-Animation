package Soru2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
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

    private final int DELAY = 2;
    private boolean yukari1 = false;
    private boolean durum = false;
    private boolean yukari2 = true;
    public int w;
    public int h;
    Random rnd = new Random();
    Random rnd2 = new Random();
    public int kare1_x = rnd.nextInt(480);
    public int kare2_x = rnd2.nextInt(480); 
    public int kare1_y = rnd.nextInt(10)-40; 
    public int kare2_y = rnd2.nextInt(30)+500;  
    private Timer timer;
    public Surface() {
        initTimer();
    }
    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();
    }
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        w = getWidth();
        h = getHeight();       
        g2d.setColor(Color.RED);
        g2d.fillRect(kare1_x, kare1_y, 20, 20);
        g2d.setColor(Color.RED);
        g2d.fillRect(kare2_x, kare2_y, 20, 20);    
        if(durum){
            timer.stop();
            super.paintComponent(g);
        }
        if(kare1_y > (h + 60)){
            Random r1 = new Random();
            kare1_x = r1.nextInt(w-20);
            yukari1 = true;
        }
        
        if(kare2_y > (h + 60)){
            Random r = new Random();
            kare2_x = r.nextInt(w-20);
            yukari2 = true;
        }
        if(yukari1){
            kare1_y -= 1;
            if(kare1_y < 0){
                kare1_y += 1;
                yukari1 = false;
            }
        }else{
            kare1_y += 1;
        }

        if(yukari2){
            kare2_y -= 1;
            if(kare2_y < 0){
                kare2_y += 1;
                yukari2 = false;
            }
        }else{
            kare2_y += 1;
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        doDrawing(g);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        checkCollisions();
        repaint();
    }
    public void checkCollisions() {

        Rectangle kare1 = new Rectangle(kare1_x , kare1_y, 20, 20);  
        Rectangle kare2 = new Rectangle(kare2_x , kare2_y, 20, 20);  
        if(kare1.intersects(kare2)){
            durum =true;
        }else{
            durum =false;
        }
    }
}
public class Soru2 extends JFrame {
    public Soru2() {
        initUI();
    }
    private void initUI() {
        final Surface surface = new Surface();
        add(surface);
        setTitle("2.soru");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Soru2 soru2 = new Soru2();
                soru2.setVisible(true);
            }
        });
    }
}