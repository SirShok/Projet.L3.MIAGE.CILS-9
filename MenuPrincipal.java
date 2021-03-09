package testInterface;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuPrincipal extends JPanel{
	
	private JLabel titre;
	private JButton ngame;
	private JButton lgame;
	private JButton options;
	private JButton quit;
	int etat=0;
	
	//TODO TEST DELETE LATER
	int cpt=0;
	JLabel nbClic;
	
	public MenuPrincipal(Fenetre f){
		titre=new JLabel("Projet RPG");
		titre.setBounds(700-(titre.getPreferredSize().width/2), 150, titre.getPreferredSize().width, titre.getPreferredSize().height);
		titre.setForeground(Color.white);
		
		//Bouton "Nouvelle partie"
		ImageIcon jou=new ImageIcon("images/new.png");
		ngame=new JButton(jou);
		ngame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	etat=1;
            	cpt++;
            	nbClic.setText("Nb de boutons cliqué : "+cpt);
            	System.out.println(etat);
            }
        });
		ngame.setBorder(BorderFactory.createEmptyBorder());
		ngame.setContentAreaFilled(false);
		ngame.setSize(jou.getIconWidth(), jou.getIconHeight());
		ngame.setBounds(574, 250, jou.getIconWidth(), jou.getIconHeight());
		
		//Bouton "Charger partie"
		ImageIcon loa=new ImageIcon("images/charger.png");
		lgame=new JButton(loa);
		lgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	etat=2;
            	cpt++;
            	nbClic.setText("Nb de boutons cliqué : "+cpt);
            	System.out.println(etat);
            }
        });
		lgame.setBorder(BorderFactory.createEmptyBorder());
		lgame.setContentAreaFilled(false);
		lgame.setSize(loa.getIconWidth(), loa.getIconHeight());
		lgame.setBounds(574, 350, loa.getIconWidth(), loa.getIconHeight());
		
		//Bouton "Options"
		ImageIcon opt=new ImageIcon("images/options.png");
		options=new JButton(opt);
		options.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				etat=3;
				cpt++;
				nbClic.setText("Nb de boutons cliqué : "+cpt);
				System.out.println(etat);
			}
		});
		options.setBorder(BorderFactory.createEmptyBorder());
		options.setContentAreaFilled(false);
		options.setSize(jou.getIconWidth(), jou.getIconHeight());
		options.setBounds(574, 450, opt.getIconWidth(), opt.getIconHeight());
		
		//Bouton "Quitter"
		ImageIcon qui=new ImageIcon("images/quit.png");
		quit=new JButton(qui);
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				etat=4;
				cpt++;
				f.dispose();
				nbClic.setText("Nb de boutons cliqué : "+cpt);
			}
		});
		quit.setBorder(BorderFactory.createEmptyBorder());
		quit.setContentAreaFilled(false);
		quit.setSize(jou.getIconWidth(), jou.getIconHeight());
		quit.setBounds(574, 550, jou.getIconWidth(), jou.getIconHeight());
		
		//TEST
		nbClic=new JLabel("Nb de boutons cliqué :");
		nbClic.setBounds(574, 800, 200, nbClic.getPreferredSize().height);
		nbClic.setForeground(Color.white);
		
		this.setLayout(null);
		this.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.setBackground(Color.black);
		this.add(titre);
		this.add(ngame);
		this.add(lgame);
		this.add(options);
		this.add(quit);
		this.add(nbClic);
	}
}
