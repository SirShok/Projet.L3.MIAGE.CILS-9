import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

//Classe permettant de creer des JPanel avec une image de fond
public class ImagePanel extends JPanel {
	
	private BufferedImage img;
	
	//Constructeur
	public ImagePanel(BufferedImage i){
		img=i;
	}
	
	//Renvoie la taille du panel
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(img.getWidth(null), img.getHeight(null));
	}
	
	//Dessine l'image de fond du panel
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}
}
