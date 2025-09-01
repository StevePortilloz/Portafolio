package prueba;

import javax.swing.JFrame;
import javax.swing.JPanel;

import u2.Grafica;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.*;

import javax.swing.JFrame;

public class PruebaGrafica extends JPanel {

	public static void main(String[] args) {

		JFrame window = new JFrame("Prueba");
		PruebaGrafica obj = new PruebaGrafica();
		//Definir la ventana
		window.add(obj);
		window.setSize(700, 800);
		window.setLocationRelativeTo(window);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void  paint(Graphics g){
		super.paint(g);


	}

}
