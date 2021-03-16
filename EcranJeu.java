import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class EcranJeu extends JPanel{
	
	private Parchemin parchemin;
	private BarreAction barreAction;
	private JPanel misc;
	
	public EcranJeu(Fenetre f){
		//Creation de la zone de texte scrollable
		parchemin=new Parchemin();
		
				
		//Creation de la barre d'action en bas de l'ecran
		////Recupere l'image de fond
		BufferedImage img = null;
		try{
			img=ImageIO.read(new File("Autre/images/cadre_orange.png"));
		}catch(IOException ioe){
			System.out.println("Unable to fetch image.");
			ioe.printStackTrace();
		}
		barreAction=new BarreAction(img, f, parchemin);
		
		
		//Creation du panneau monstre et menu
		misc=new PanneauAdv();
		
		
		//Reglages et ajout des composant
		this.setLayout(new BorderLayout());
		this.add(parchemin, BorderLayout.WEST);
		this.add(misc, BorderLayout.EAST);
		this.add(barreAction, BorderLayout.PAGE_END);
		this.setBackground(Color.black);	
	}
}
