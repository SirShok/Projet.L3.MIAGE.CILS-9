import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuPrincipal extends JPanel{
	
	private static final long serialVersionUID = -511007971738628908L;
	private JLabel titre;
	private JButton ngame;
	private JButton lgame;
	private JButton quit;
	private boolean premierepartie=true;
	
	public MenuPrincipal(Fenetre f){
		Font caligraphie=new Font("Nine By Five NBP", Font.PLAIN, 54);
		
		titre=new JLabel("Projet RPG");
		titre.setFont(caligraphie);
		titre.setBounds(700-(titre.getPreferredSize().width/2), 150, titre.getPreferredSize().width, titre.getPreferredSize().height);
		titre.setForeground(Color.white);
		
		//Bouton "Nouvelle partie"
		ImageIcon jou=new ImageIcon("Autre/images/new.png");
		ngame=new JButton(jou);
		ngame.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	if(premierepartie){
            		premierepartie=false;
            		f.switchToCreation();
            	}
            }
        });
		ngame.setBorder(BorderFactory.createEmptyBorder());
		ngame.setContentAreaFilled(false);
		ngame.setSize(jou.getIconWidth(), jou.getIconHeight());
		ngame.setBounds(574, 250, jou.getIconWidth(), jou.getIconHeight());
		
		//Bouton "Continuer"
		ImageIcon loa=new ImageIcon("Autre/images/continuer.png");
		lgame=new JButton(loa);
		lgame.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	if(!premierepartie){
            		f.swicthToGame();
            	}
            }
        });
		lgame.setBorder(BorderFactory.createEmptyBorder());
		lgame.setContentAreaFilled(false);
		lgame.setSize(loa.getIconWidth(), loa.getIconHeight());
		lgame.setBounds(574, 350, loa.getIconWidth(), loa.getIconHeight());
		
		//Bouton "Quitter"
		ImageIcon qui=new ImageIcon("Autre/images/quit.png");
		quit=new JButton(qui);
		quit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				f.dispose();
			}
		});
		quit.setBorder(BorderFactory.createEmptyBorder());
		quit.setContentAreaFilled(false);
		quit.setSize(jou.getIconWidth(), jou.getIconHeight());
		quit.setBounds(574, 450, jou.getIconWidth(), jou.getIconHeight());
		
		
		this.setLayout(null);
		this.setBackground(Color.black);
		this.add(titre);
		this.add(ngame);
		this.add(lgame);
		this.add(quit);
	}
}
