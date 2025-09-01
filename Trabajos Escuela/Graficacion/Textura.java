package Graficacion;
import java.awt.*;
import  java.awt.image.BufferedImage;
import  javax.swing.JFrame;
import javax.swing.JPanel;

public class Textura extends JFrame
{
    public Textura()
    {
        super ("Texturas java");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920,1080);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        BufferedImage b1 = new BufferedImage(89,90,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dbi = b1.createGraphics();
         g2dbi.setColor(Color.DARK_GRAY);
         g2dbi.fillRect(0,0,80,80);

         g2dbi.setColor(Color.GREEN);
         g2dbi.fillRect(20,20,20,20);
         g2dbi.fillRect(40,40,20,20);

         g2dbi.setColor(Color.BLACK);
         g2dbi.fillRect(40,20,20,20);
         g2dbi.fillRect(20,40,20,20);

         TexturePaint textureImage = new TexturePaint(b1, new Rectangle(80,80));

         Graphics2D g2d = (Graphics2D) g;
         g2d.setPaint(textureImage);
         g2d.fillOval(0,0,300,300);
    }

    public static void main(String[] args) {
        new Textura();
    }
}