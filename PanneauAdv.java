package testInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauAdv extends JPanel{
	private int test;
	private StatAdv statAdv;
	
	public PanneauAdv(){
		//Barre orange verticale cosmetique sur le cote
		JLabel barresup=new JLabel(new ImageIcon("Autre/images/Barre_orange_transparente.png"));
		barresup.setBorder(BorderFactory.createEmptyBorder());
		barresup.setBounds(20, 60, barresup.getPreferredSize().width, barresup.getPreferredSize().height);
		
		//Recuperation de l'image de fond pour le panneau stat de l'adversaire
		BufferedImage img = null;
		try{
			img=ImageIO.read(new File("Autre/images/cadre_orange_small.png"));
		}catch(IOException ioe){
			System.out.println("Unable to fetch image.");
			ioe.printStackTrace();
		}
		statAdv=new StatAdv(img);
		statAdv.setBounds(115, 20, statAdv.getPreferredSize().width, statAdv.getPreferredSize().height);
		
		//Reglages et ajout des composant
		this.setLayout(null);
		this.setPreferredSize(new Dimension(560,640));
		this.setBackground(Color.black);
		this.add(statAdv);
		this.add(barresup);
		this.setBorder(null);
	}
}
