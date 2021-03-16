

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class StatAdv extends ImagePanel{
	private int pvie=100;
	private int armure=100;
	
	public StatAdv(BufferedImage img){
		super(img);
		Font caligraphie=new Font("Nine By Five NBP", Font.PLAIN, 36);
		
		//Titre du panneau
		JLabel nom=new JLabel("Stat ennemi :");
		nom.setForeground(Color.white);
		nom.setFont(caligraphie);
		nom.setBounds(15, 10, nom.getPreferredSize().width, nom.getPreferredSize().height);
		
		//Jauge de vie
		JLabel jaugevie=new JLabel(new ImageIcon("Autre/images/point_de_vie.png"));
		jaugevie.setForeground(Color.white);
		jaugevie.setFont(caligraphie);
		jaugevie.setText(""+pvie);
		jaugevie.setBounds(50, 70, jaugevie.getPreferredSize().width, jaugevie.getPreferredSize().height);
		
		//Slash pour separe les deux stats
		JLabel sep=new JLabel("/");
		sep.setForeground(Color.white);
		sep.setFont(caligraphie);
		sep.setBounds(170, 75, sep.getPreferredSize().width, sep.getPreferredSize().height);
		
		//Jauge d'armure
		JLabel jaugearmure=new JLabel(new ImageIcon("Autre/images/point_armure.png"));
		jaugearmure.setForeground(Color.white);
		jaugearmure.setFont(caligraphie);
		jaugearmure.setText(""+armure);
		jaugearmure.setBounds(210, 70, jaugearmure.getPreferredSize().width, jaugearmure.getPreferredSize().height);
		
		//Reglages et ajout des composant
		this.setLayout(null);
		this.add(nom);
		this.add(jaugevie);
		this.add(sep);
		this.add(jaugearmure);
		this.setBackground(Color.black);
		this.setBorder(null);
		
	}
}