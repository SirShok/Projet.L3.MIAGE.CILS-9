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
		String lorem="Nous sommes en l'an de grace 1269 et la 9eme croisade est en route pour la Terre Sainte. Les hordes de paiens et de barbares ont realises un rituel visant a fusionner notre monde avec les enfers. De ce fait, divers monstres se sont immisces sur Terre et joignent leur force aux infideles. Les croises munis de leur foi, exorcisent les heretiques au nom de l’Eglise. \r\n"
				+ "Vous etes un(e) croise(e),  vous pouvez faire appel a votre force brute, votre intelligence ou votre foi pour manifester dans ce monde le pouvoir de Dieu. Votre objectif ultime est de parcourir les derniers kilometres qui vous separe de Jerusalem et de la liberer des hordes de l'enfer.";

		//Ajout et configuration de la zone de texte
		texte=new JTextArea(lorem, 5, 30);
		texte.setBorder(BorderFactory.createEmptyBorder(30,20,10,30));
		texte.setWrapStyleWord(true);
		texte.setLineWrap(true);
		texte.setFocusable(false);
		texte.setEditable(false);
		texte.append(Narration.apparitionMonstre(Main.joueur, Main.adversaire));
		Font caligraphie=new Font("Nine By Five NBP", Font.PLAIN, 28);
		texte.setFont(caligraphie);
		texte.setBackground(Color.black);
		texte.setForeground(new Color(245, 145, 77));
		
		//Ajout et creation du scroll
		scroll=new JScrollPane(texte);
		scroll.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
		scroll.getVerticalScrollBar().setMinimumSize(new Dimension(0, 0));
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
