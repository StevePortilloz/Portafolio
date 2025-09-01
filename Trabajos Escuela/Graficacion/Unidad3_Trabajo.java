package Graficacion;
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Unidad3_Trabajo extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JButton boton = new JButton("Salir");
	JButton boton1 = new JButton("Repaint");
	JLabel coX = new JLabel("Coordenada x : ");	
	JLabel coY = new JLabel("Coordenada y : ");
	JLabel ins = new JLabel("");
	JTextField valorX = new JTextField("");
	JTextField valorY = new JTextField("");
	int x = 80;
	int y = 100;
	
	public Unidad3_Trabajo(){
		super("Unidad3_Trabajo");
		setSize(700,700);
		setVisible(true);
		
		boton.setBounds(450,550,100,30);
		boton.addActionListener(this);
		add(boton);
		
		boton1.setBounds(150,600,100,30);
		boton1.addActionListener(this);
		add(boton1);
		
		coX.setBounds(50,500,200,40);
		add(coX);
		
		coY.setBounds(50,550,200,40);
		add(coY);
		
		valorX.setBounds(150,510,50,20);
		add(valorX);
		
		valorY.setBounds(150,560,50,20);
		add(valorY);
		
		ins.setBounds(0,0,0,0);
		add(ins);
		
		
	}
	public static void main(String[] args){
		Unidad3_Trabajo t = new Unidad3_Trabajo();
	}
	
	public void paint (Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
	ImageIcon imagen = new ImageIcon(getClass().getResource("ETk9v-_XsAAUYOr.png"));
      g.drawImage(imagen.getImage(),0,0,700,700,this);
       ImageIcon imagen2 = new ImageIcon(getClass().getResource("Goku-PNG-Transparent-Image.png"));
       g.drawImage(imagen2.getImage(),380,180,200,300,this);
		g2d.translate(x, y);
        ImageIcon imagen3 = new ImageIcon(getClass().getResource("gohan_ssj2__png_by_lumus115_d6brify-fullview.png"));
        g.drawImage(imagen3.getImage(),x,y,300,300,this);
      //ancho de los pixeles
        int ancholinea = 5;
		float guiones1[]={10,10};
		float guiones2[]={10,10,10,20};
		g2d.setStroke(new BasicStroke(ancholinea,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_ROUND,0,guiones1,0));
		g2d.setColor(Color.black);
		g2d.drawLine(50, 50, 50, 400);
		g2d.setStroke(new BasicStroke(ancholinea,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,0,guiones2,0));
		g2d.setColor(Color.black);
		g2d.drawLine(550, 50, 550,400);
	    g2d.setColor(Color.yellow);
	    g2d.setStroke(new BasicStroke(6.0f));
		g2d.fill(new Arc2D.Double(10,10,150,150,10,280,Arc2D.PIE));
		
       }
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource()== boton){
			setTitle("Salir...");
			try{
				Thread.sleep(1000);
				System.exit(0);
			}
			catch(Exception excep)
			{
				System.exit(0);
			}
		}
		if (e.getSource()==boton1){
			x = Integer.parseInt(valorX.getText());
			y = Integer.parseInt(valorY.getText());
			repaint();
		}
	}
}
