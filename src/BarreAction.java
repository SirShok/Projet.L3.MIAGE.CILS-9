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
	
	private JButton cap1;
	private JButton cap2;
	private JButton cap3;
	private JButton cap4;
	private int pvie;
	private int parmure;
	
	
	public BarreAction(BufferedImage img, Fenetre f, Parchemin par){
		super(img);
		ImageIcon bouton=new ImageIcon("Autre/images/bouton.png");
		Dimension dimBouton=new Dimension(bouton.getIconWidth(), bouton.getIconHeight());
		
		//Boutons de capacite
		cap1=new JButton(new ImageIcon("Autre/images/coupS.png"));
		cap1.setBorder(BorderFactory.createEmptyBorder());
		cap1.setContentAreaFilled(false);
		cap1.setSize(dimBouton);
		cap1.setBounds(50, 27, bouton.getIconWidth(), bouton.getIconHeight());
		cap1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//Ta methode
				par.getTextArea().append("\n J'ai mal");
				System.out.println("Coup Simple");
			}
		});
		
		cap2=new JButton(new ImageIcon("Autre/images/estoc.png"));
		cap2.setBorder(BorderFactory.createEmptyBorder());
		cap2.setContentAreaFilled(false);
		cap2.setSize(dimBouton);
		cap2.setBounds(320, 27, bouton.getIconWidth(), bouton.getIconHeight());
		
		cap3=new JButton(new ImageIcon("Autre/images/attaqueD.png"));
		cap3.setBorder(BorderFactory.createEmptyBorder());
		cap3.setContentAreaFilled(false);
		cap3.setSize(dimBouton);
		cap3.setBounds(50, 117, bouton.getIconWidth(), bouton.getIconHeight());
		
		cap4=new JButton(new ImageIcon("Autre/images/attaqueT.png"));
		cap4.setBorder(BorderFactory.createEmptyBorder());
		cap4.setContentAreaFilled(false);
		cap4.setSize(dimBouton);
		cap4.setBounds(320, 117, bouton.getIconWidth(), bouton.getIconHeight());
		
		//Etat personnage
		Font caligraphie=new Font("Nine By Five NBP", Font.PLAIN, 40);
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
		this.add(cap1);
		this.add(cap2);
		this.add(cap3);
		this.add(cap4);
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
}
