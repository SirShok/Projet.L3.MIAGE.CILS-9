import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JButton;

public class BarreAction extends ImagePanel{
	
	private JButton cap1;
	private JButton cap2;
	private JButton cap3;
	private JButton cap4;
	
	public BarreAction(BufferedImage img){
		super(img);
		this.setBackground(Color.black);
		this.setVisible(true);
		
	}
}
