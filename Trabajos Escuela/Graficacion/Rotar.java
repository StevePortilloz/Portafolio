package Graficacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;

	public class Rotar extends JFrame{
		int x=200;
		int y=200;
		int ancho=100;
		int alto=100;
		int giro=0;
	
	public Rotar(){
		super("Rotacion");
		setSize(600,600);
		setVisible(true);

}
	public void setGiro(int g){
		giro=g;
}
		
	public static void main(String[] args) {
		Scanner dato=new Scanner (System.in);
		Rotar t=new Rotar();
		
		int g=0;
		int xx=0;
		
		while (xx>=1){
			System.out.print("\n Grados a girar: ");
			xx=dato.nextInt();
			g=xx;
			
			if(xx>1){
				t.setGiro(g);
				t.repaint();
			}else{
				System.out.print("Programa Terminado\n ");
				System.exit(0);
			}
		}
	}
	
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d= (Graphics2D) g;
		Font fuente1= new Font("Arial", Font.PLAIN,10);
		
		g2d.translate(x, y);
		g2d.rotate(Math.toRadians(giro));
		g2d.setColor(Color.RED);
		g2d.fillRect(x, y, ancho, alto);
		
		g2d.setColor(Color.BLACK);
		g2d.fillOval(0, 0, 0, 0);
		
		g2d.setColor(Color.GREEN);
		g2d.setFont(fuente1);
		g2d.drawString("ITCUL", 5, 50);
	}
	
	
}

