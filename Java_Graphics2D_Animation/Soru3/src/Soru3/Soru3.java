package Soru3;
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

    public Surface() {    
    }
    private void doDrawing(Graphics g) {
	     Graphics2D g2d = (Graphics2D) g;
	     BasicStroke bs3 = new BasicStroke(2, BasicStroke.CAP_ROUND,
	     BasicStroke.JOIN_BEVEL);
	     g2d.drawOval(-15,-15, 30,30);
	     g2d.setStroke(bs3);
	     Random rnd = new Random();
	     int adim =20;
	     for(int i=1;i<=10;i++){
	        BasicStroke bs4 = new BasicStroke(2, BasicStroke.CAP_ROUND,
	        BasicStroke.JOIN_BEVEL);
	        g2d.setStroke(bs4);
	        int yariCap = rnd.nextInt(100);
	        g2d.drawOval(200,adim,yariCap,yariCap);
	        g2d.drawLine(0, 0, 200+yariCap/2,adim+yariCap/2 );
	        adim +=20;
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

public class Soru3 extends JFrame {

    public Soru3() {

        initUI();
    }

    private void initUI() {

        final Surface surface = new Surface();
        add(surface);
        setTitle("3.soru");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

            	Soru3 ex = new Soru3();
                ex.setVisible(true);
            }
        });
    }
}
