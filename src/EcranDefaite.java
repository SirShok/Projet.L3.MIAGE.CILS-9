import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EcranDefaite extends JPanel{
	
	public EcranDefaite(Fenetre f){
		Font caligraphie=new Font("Nine By Five NBP", Font.PLAIN, 64);
		Font caligraphieSmall=new Font("Nine By Five NBP", Font.PLAIN, 40);
		
		JLabel victoire=new JLabel("Defaite");
		victoire.setFont(caligraphie);
		victoire.setForeground(Color.white);
		victoire.setBounds(700-(victoire.getPreferredSize().width/2), 150, victoire.getPreferredSize().width, victoire.getPreferredSize().height);
		
		JLabel msg=new JLabel("Vous avez peri, mais un autre hero peut prendre la releve !");
		msg.setFont(caligraphieSmall);
		msg.setForeground(Color.white);
		msg.setBounds(700-(msg.getPreferredSize().width/2), 250, msg.getPreferredSize().width, msg.getPreferredSize().height);
		
		//Bouton "Quitter"
		ImageIcon qui=new ImageIcon("Autre/images/quit.png");
		JButton quit=new JButton(qui);
		quit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				f.dispose();
			}
		});
		quit.setBorder(BorderFactory.createEmptyBorder());
		quit.setContentAreaFilled(false);
		quit.setSize(qui.getIconWidth(), qui.getIconHeight());
		quit.setBounds(574, 450, qui.getIconWidth(), qui.getIconHeight());
		
		this.setBackground(Color.black);
		this.setLayout(null);
		this.add(victoire);
		this.add(msg);
		this.add(quit);
		
	}
}
