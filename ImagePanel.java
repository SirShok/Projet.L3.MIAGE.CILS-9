import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	
	private BufferedImage img;
	
	public ImagePanel(){
		
	}
	
	public ImagePanel(BufferedImage i){
		img=i;
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(img.getWidth(null), img.getHeight(null));
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}
}
