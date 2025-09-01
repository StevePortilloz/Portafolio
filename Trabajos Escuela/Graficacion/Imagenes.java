package Graficacion;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Imagenes extends JFrame{
	public Imagenes(){
        super("Imagenes");
	}
public void paint(Graphics g){
	super.paint(g);
	
	ImageIcon imagen = new ImageIcon(getClass().getResource("paisaje.png"));
	g.drawImage(imagen.getImage(),0,0,800,500,this);
	
	ImageIcon imagen2 = new ImageIcon(getClass().getResource("Goku-PNG-Transparent-Image.png"));
	g.drawImage(imagen2.getImage(),250,100,200,300,this);
}
public static void main(String[] args) {
	Imagenes ventana= new Imagenes();
    JPanel objeto = new JPanel();
    ventana.add(objeto);
    ventana.setSize(700,700);
    ventana.setVisible(true);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}

        
