package Graficacion;
import java.awt.*;
import javax.swing.*;;

public class LineaPunteada extends JFrame {
	
	public LineaPunteada(){//constructor
		super("lineas punteadas");
		setVisible(true);
		setSize(500,500);
		setLocation(300,500);
	}
	
	
	public void paint(Graphics g){//nuevo paint
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		
		int ancholinea=3;
		float quiones1[]={10,10};
		float quiones2[]={30,30,10,30};
		float quiones3[]={10,10,10,50};
		float quiones4[]={10,20,10,50};
		float quiniones5[]={4};

		g2.setStroke(new BasicStroke(ancholinea,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_ROUND
				     ,0,quiones1,0));
		g2.setColor(Color.RED);
		g2.drawLine(50,50,150,300);
		g2.setStroke(new BasicStroke(ancholinea,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND
			     ,0,quiones2,0));
	      g2.setColor(Color.GREEN);
	      g2.drawLine(150,50,250,300);
	      g2.setStroke(new BasicStroke(ancholinea,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND
				     ,0,quiones3,0));
		      g2.setColor(Color.DARK_GRAY);
		      g2.drawLine(250,50,350,300);
		      g2.setStroke(new BasicStroke(ancholinea,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND
					     ,0,quiones4,0));
			      g2.setColor(Color.BLUE);
			      g2.drawLine(0,50,150,300);

			      g2.setStroke(new BasicStroke(ancholinea,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND
						     ,0,quiniones5,0));
				      g2.setColor(Color.magenta);
				      g2.drawLine(450,50,550,300);
		
		
		
		
		
	}
    public static void main(String []args){
    	new LineaPunteada().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
    }
}