
package Graficacion;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Degradado extends JFrame{
    public Degradado(){
        super("Degradado");
}
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;
        
        GradientPaint degradado1 = new GradientPaint(0,0,Color.RED,50,50,Color.BLUE,true);
        g2d.setPaint(degradado1);
        
        g2d.fillRect(100,100,300, 200);
        g2d.fillOval(500, 100, 200, 200);
        
        GradientPaint degradado2 = new GradientPaint(0,0,Color.YELLOW,50,50,Color.BLACK,true);
        g2d.setPaint(degradado2);
        g2d.fillRect(00,100,300, 200);
        g2d.fillOval(500, 100, 200, 200);
        }

	public static void main(String[] args) {
		Degradado ventana= new Degradado();
        JPanel objeto = new JPanel();
        ventana.add(objeto);
        ventana.setSize(700,700);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
