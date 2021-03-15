package testInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Parchemin extends JPanel{
	
	private JTextArea texte;
	private JScrollPane scroll;
	private BarreAction ba;
	
	public Parchemin(){
		//TODO TEST DELETE LATER
		String lorem="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		
		//Ajout et configuration de la zone de texte
		texte=new JTextArea(lorem, 5, 30);
		texte.setBorder(BorderFactory.createEmptyBorder(30,20,10,30));
		texte.setWrapStyleWord(true);
		texte.setLineWrap(true);
		texte.setFocusable(false);
		texte.setEditable(false);
		////Recuperation de la police d'ecriture
		try {
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Autre/images/nine0.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		Font caligraphie=new Font("Nine By Five NBP", Font.PLAIN, 28);
		texte.setFont(caligraphie);
		texte.setBackground(Color.black);
		texte.setForeground(new Color(245, 145, 77));
		
		//Ajout et creation du scroll
		scroll=new JScrollPane(texte);
		scroll.getViewport().setBackground(Color.black);
		scroll.setBorder(null);
		scroll.setPreferredSize(new Dimension(840, 640));
		
		//Reglages et ajout des composant
		this.setBorder(null);
		this.setBackground(Color.black);
		this.add(scroll);
		this.setVisible(true);
	}
	
	public JTextArea getTextArea(){
		return texte;
	}
}
