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
		String lorem="Nous sommes en l'an de grâce 1269 et la 9ème croisade est en route pour la Terre Sainte. Les hordes de païens et de barbares ont réalisés un rituel visant à fusionner notre monde avec les enfers. De ce fait, divers monstres se sont immiscés sur Terre et joignent leur force aux infidèles. Les croisés munis de leur foi, exorcisent les hérétiques au nom de l’Église. \r\n"
				+ "  Vous êtes un(e) croisé(e),  vous pouvez faire appel à votre force brute, votre intelligence ou votre foi pour manifester dans ce monde le pouvoir de Dieu. Votre objectif ultime est de parcourir les derniers kilomètres qui vous sépare de Jérusalem et de la libérer des hordes de l'enfer.";
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
