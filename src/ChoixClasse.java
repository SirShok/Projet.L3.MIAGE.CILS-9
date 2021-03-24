import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoixClasse extends JPanel{
	int cpt=0;
	JLabel nbClic;
	
	//Chevalier archer pretre magicien
	public ChoixClasse(Fenetre f){
		ImageIcon bouton=new ImageIcon("Autre/images/bouton.png");
		Dimension dimBouton=new Dimension(bouton.getIconWidth(), bouton.getIconHeight());
		
		JButton cheva=new JButton(new ImageIcon("Autre/images/chevalier.png"));
		cheva.setBorder(BorderFactory.createEmptyBorder());
		cheva.setContentAreaFilled(false);
		cheva.setSize(dimBouton);
		cheva.setBounds(398, 318, bouton.getIconWidth(), bouton.getIconHeight());
		cheva.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	Main.joueur=new Individu(0);
            	f.beginGame();
            	System.out.println(Main.joueur.nom);
            }
        });
		
		
		JButton arche=new JButton(new ImageIcon("Autre/images/archer.png"));
		arche.setBorder(BorderFactory.createEmptyBorder());
		arche.setContentAreaFilled(false);
		arche.setSize(dimBouton);
		arche.setBounds(800, 318, bouton.getIconWidth(), bouton.getIconHeight());
		arche.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	Main.joueur=new Individu(1);
            	f.beginGame();
            	System.out.println(Main.joueur.nom);
            }
        });
		
		JButton pretr=new JButton(new ImageIcon("Autre/images/pretre.png"));
		pretr.setBorder(BorderFactory.createEmptyBorder());
		pretr.setContentAreaFilled(false);
		pretr.setSize(dimBouton);
		pretr.setBounds(398, 500, bouton.getIconWidth(), bouton.getIconHeight());
		pretr.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	Main.joueur=new Individu(2);
            	f.beginGame();
            	System.out.println(Main.joueur.nom);
            }
        });
		
		JButton magic=new JButton(new ImageIcon("Autre/images/magicien.png"));
		magic.setBorder(BorderFactory.createEmptyBorder());
		magic.setContentAreaFilled(false);
		magic.setSize(dimBouton);
		magic.setBounds(800, 500, bouton.getIconWidth(), bouton.getIconHeight());
		magic.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	Main.joueur=new Individu(3);
            	f.beginGame();
            	System.out.println(Main.joueur.nom);
            }
        });
		
		

		this.setLayout(null);
		this.setBackground(Color.black);
		this.add(cheva);
		this.add(arche);
		this.add(pretr);
		this.add(magic);
	}
}
