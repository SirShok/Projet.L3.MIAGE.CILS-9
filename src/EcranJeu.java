import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class EcranJeu extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2813799278796918896L;
	private Parchemin parchemin;
	private BarreAction barreAction;
	private PanneauAdv misc=new PanneauAdv(new Monstre("Slime", 150, 50, 20, "eau"));
	
	public EcranJeu(Fenetre f, Individu i){
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
		barreAction=new BarreAction(img, f, parchemin, i, misc);
		
		
		//Reglages et ajout des composant
		this.setLayout(new BorderLayout());
		this.add(parchemin, BorderLayout.WEST);
		this.add(barreAction, BorderLayout.SOUTH);
		this.add(misc, BorderLayout.EAST);
		this.setBackground(Color.black);
	}
	
	//creation et affichage d'un panneau monstre
	public void monsterEncounter(Monstre m){
		this.remove(misc);
		misc=new PanneauAdv(m);
		this.add(misc);
		this.revalidate();
		this.setVisible(true);
	}
	
	//retourne le parchemin (la où est affiche le texte)
	public Parchemin getParchemin(){
		return parchemin;
	}
	public BarreAction getBarreAction() {
		return barreAction;
	}
	public PanneauAdv getPanneauAdv() {
		return misc;
	}
}
