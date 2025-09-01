package Graficacion;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grosor extends JFrame{
	public Grosor(){
        super("Linea punteada");
        
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;
       
        g2d.setStroke(new BasicStroke(6.0f));
        g2d.setColor(Color.RED);
        g2d.draw(new Arc2D.Double(50,50,150,150,0,270,Arc2D.CHORD));
        
        g2d.setColor(Color.GREEN);
        g2d.draw(new Arc2D.Double(250,50,150,150,0,270,Arc2D.OPEN));
        
        g2d.setColor(Color.YELLOW);
        g2d.fill(new Arc2D.Double(450,50,150,150,30,290,Arc2D.PIE));
        
        g2d.setColor(Color.BLACK);
        g2d.fillOval(520,80,8,8);
    }
       

	public static void main(String[] args) {
		Grosor ventana= new Grosor();
        JPanel objeto = new JPanel();
        ventana.add(objeto);
        ventana.setSize(700,700);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}