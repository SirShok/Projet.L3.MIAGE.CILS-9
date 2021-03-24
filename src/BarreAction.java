import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class BarreAction extends ImagePanel{
	
	private JButton capBouton1;
	private JButton capBouton2;
	private JButton capBouton3;
	private JButton capBouton4;
	private Competence cap1;
	private Competence cap2;
	private Competence cap3;
	private Competence cap4;
	private int pvie;
	private int parmure;
	
	public BarreAction(BufferedImage img, Fenetre f, Parchemin par, Individu i, PanneauAdv padv){
		super(img);
		ImageIcon bouton=new ImageIcon("Autre/images/bouton.png");
		Dimension dimBouton=new Dimension(bouton.getIconWidth(), bouton.getIconHeight());
		Font caligraphie=new Font("Nine By Five NBP", Font.PLAIN, 40);
		Combat c=new Combat();
		
		//Boutons de capacite
		capBouton1=new JButton("");
		capBouton1.setBorder(BorderFactory.createLineBorder(Color.white));
		capBouton1.setForeground(Color.white);
		capBouton1.setFont(caligraphie);
		capBouton1.setContentAreaFilled(false);
		capBouton1.setSize(dimBouton);
		capBouton1.setBounds(50, 27, bouton.getIconWidth(), bouton.getIconHeight());
		capBouton1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				par.getTextArea().append("\nComp Simple");
				//c.combat(i, padv.getMonster(), cap1);
				System.out.println("Coup Simple");
			}
		});
		
		capBouton2=new JButton("");
		capBouton2.setBorder(BorderFactory.createLineBorder(Color.white));
		capBouton2.setForeground(Color.white);
		capBouton2.setFont(caligraphie);
		capBouton2.setContentAreaFilled(false);
		capBouton2.setSize(dimBouton);
		capBouton2.setBounds(320, 27, bouton.getIconWidth(), bouton.getIconHeight());
		capBouton2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				par.getTextArea().append("\nEstoc");
				//c.combat(i, padv.getMonster(), cap2);
				System.out.println("Estoc");
			}
		});
		
		capBouton3=new JButton("");
		capBouton3.setBorder(BorderFactory.createLineBorder(Color.white));
		capBouton3.setForeground(Color.white);
		capBouton3.setFont(caligraphie);
		capBouton3.setContentAreaFilled(false);
		capBouton3.setSize(dimBouton);
		capBouton3.setBounds(50, 117, bouton.getIconWidth(), bouton.getIconHeight());
		capBouton3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				par.getTextArea().append("\nAttaque double");
				//c.combat(i, padv.getMonster(), cap3);
				System.out.println("Attaque double");
			}
		});
		
		capBouton4=new JButton("");
		capBouton4.setBorder(BorderFactory.createLineBorder(Color.white));
		capBouton4.setForeground(Color.white);
		capBouton4.setFont(caligraphie);
		capBouton4.setContentAreaFilled(false);
		capBouton4.setSize(dimBouton);
		capBouton4.setBounds(320, 117, bouton.getIconWidth(), bouton.getIconHeight());
		capBouton4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				par.getTextArea().append("\nAttaque triple");
				//c.combat(i, padv.getMonster(), cap4);
				System.out.println("Attaque triple");
			}
		});
		
		//Etat personnage
		JLabel vie=new JLabel(new ImageIcon("Autre/images/point_de_vie.png"));
		vie.setText("100");
		vie.setFont(caligraphie);
		vie.setBorder(BorderFactory.createEmptyBorder());
		vie.setBounds(600, 35, vie.getPreferredSize().width, vie.getPreferredSize().height);
		vie.setForeground(Color.white);
		
		JLabel armure=new JLabel(new ImageIcon("Autre/images/point_armure.png"));
		armure.setText("100");
		armure.setFont(caligraphie);
		armure.setBorder(BorderFactory.createEmptyBorder());
		armure.setBounds(600, 90, armure.getPreferredSize().width, armure.getPreferredSize().height);
		armure.setForeground(Color.white);
		
		JLabel barre=new JLabel(new ImageIcon("Autre/images/barre_orange_small.png"));
		barre.setBorder(BorderFactory.createEmptyBorder());
		barre.setBounds(730, 0, barre.getPreferredSize().width, barre.getPreferredSize().height);
		
		//Stats personnage
		JLabel stat=new JLabel("Stats :");
		stat.setFont(caligraphie);
		stat.setForeground(Color.white);
		stat.setBorder(null);
		stat.setBounds(780, 27, stat.getPreferredSize().width, stat.getPreferredSize().height);
		
		Font caligraphieSmall=new Font("Nine By Five NBP", Font.PLAIN, 32);
		
		JLabel agil=new JLabel("Agilité :");
		agil.setFont(caligraphieSmall);
		agil.setForeground(Color.white);
		agil.setBounds(800, 70, agil.getPreferredSize().width, agil.getPreferredSize().height);
		
		JLabel forc=new JLabel("Force :");
		forc.setFont(caligraphieSmall);
		forc.setForeground(Color.white);
		forc.setBounds(800, 110, forc.getPreferredSize().width, forc.getPreferredSize().height);
		
		JLabel cons=new JLabel("Constitution :");
		cons.setFont(caligraphieSmall);
		cons.setForeground(Color.white);
		cons.setBounds(800, 150, cons.getPreferredSize().width, cons.getPreferredSize().height);
		
		JLabel sage=new JLabel("Sagesse :");
		sage.setFont(caligraphieSmall);
		sage.setForeground(Color.white);
		sage.setBounds(1000, 70, sage.getPreferredSize().width, sage.getPreferredSize().height);
		
		JLabel perc=new JLabel("Perception :");
		perc.setFont(caligraphieSmall);
		perc.setForeground(Color.white);
		perc.setBounds(1000, 110, perc.getPreferredSize().width, perc.getPreferredSize().height);
		
		JLabel chari=new JLabel("Charisme :");
		chari.setFont(caligraphieSmall);
		chari.setForeground(Color.white);
		chari.setBounds(1000, 150, chari.getPreferredSize().width, chari.getPreferredSize().height);
		
		JLabel chan=new JLabel("Chance :");
		chan.setFont(caligraphieSmall);
		chan.setForeground(Color.white);
		chan.setBounds(1200, 70, chan.getPreferredSize().width, chan.getPreferredSize().height);
		
		ImageIcon retourMenu=new ImageIcon("Autre/images/menu_principal.png");
		JButton menuprinc=new JButton(retourMenu);
		menuprinc.setBorder(BorderFactory.createEmptyBorder());
		menuprinc.setContentAreaFilled(false);
		menuprinc.setSize(bouton.getIconWidth(), bouton.getIconHeight());
		menuprinc.setBounds(1190, 145, menuprinc.getPreferredSize().width, menuprinc.getPreferredSize().height);
		menuprinc.addActionListener(new ActionListener(){
			@Override
            public void actionPerformed(ActionEvent e){
            	f.switchToMenu();
            	System.out.println("Cliqué");
            }
		});
		
		//Reglages et ajout des composant
		this.setLayout(null);
		this.setBackground(Color.black);
		this.add(capBouton1);
		this.add(capBouton2);
		this.add(capBouton3);
		this.add(capBouton4);
		this.add(vie);
		this.add(armure);
		this.add(barre);
		this.add(stat);
		this.add(agil);
		this.add(forc);
		this.add(cons);
		this.add(sage);
		this.add(perc);
		this.add(chari);
		this.add(chan);
		this.add(menuprinc);
		this.setBorder(null);
	}
	
	public void setBoutonHG(Competence c){
		cap1=c;
		capBouton1.setText(c.nom);
	}
	
	public void setBoutonHD(Competence c){
		cap2=c;
		capBouton2.setText(c.nom);
	}
	
	public void setBoutonBG(Competence c){
		cap3=c;
		capBouton3.setText(c.nom);
	}
	
	public void setBoutonBD(Competence c){
		cap4=c;
		capBouton4.setText(c.nom);
	}
}
