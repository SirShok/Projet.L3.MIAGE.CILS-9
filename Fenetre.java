import javax.swing.*;

public class Fenetre extends JFrame{
	
	private MenuPrincipal menu;
	private EcranJeu ingame;
	
	public Fenetre(){
		this.setSize(1400, 900);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Projet RPG");
		this.setVisible(true);
		
		menu=new MenuPrincipal(this);
		ingame=new EcranJeu();
		this.getContentPane().add(ingame);
		this.setVisible(true);
	}
}
