package testInterface;

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
	
	public EcranJeu(){
		//Creation de la barre d'action en bas de l'ecran
		////Récupère l'image de fond
		BufferedImage img = null;
		try{
			img=ImageIO.read(new File("images/cadre_orange.png"));
		}catch(IOException ioe){
			System.out.println("Unable to fetch image.");
			ioe.printStackTrace();
		}
		barreAction=new BarreAction(img);
		
		
		//Creation de la zone de texte scrollable
		parchemin=new Parchemin();
		
		
		//Creation du panneau monstre et menu
		misc=new JPanel();
		misc.setPreferredSize(new Dimension(560,640));
		misc.setBackground(Color.black);
		JLabel barresup=new JLabel(new ImageIcon("images/Barre_orange_transparente.png"));
		misc.add(barresup);
		
		
		this.setLayout(new BorderLayout());
		this.add(parchemin, BorderLayout.WEST);
		this.add(misc, BorderLayout.EAST);
		this.add(barreAction, BorderLayout.PAGE_END);
		this.setBackground(Color.cyan);	
	}
}
