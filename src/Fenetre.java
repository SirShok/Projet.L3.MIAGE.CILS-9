import javax.swing.*;

public class Fenetre extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3710046988878703485L;
	private MenuPrincipal menu;
	private EcranJeu ingame;
	private ChoixClasse creation;
	
	public Fenetre(){
		//Initialisation de la fenetre
		this.setSize(1400, 900);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Projet RPG");
		this.setVisible(true);
		
		
		
		menu=new MenuPrincipal(this);
		creation=new ChoixClasse(this);
		this.getContentPane().add(menu);
		this.setVisible(true);
	}
	
	//Change la fenetre pour afficher l'ecran de jeu
	public void swicthToGame(){
		this.getContentPane().remove(menu);
		this.getContentPane().add(ingame);
		this.repaint();
		this.setVisible(true);
	}
	
	//Change la fenetre pour afficher le menu
	public void switchToMenu(){
		this.getContentPane().remove(ingame);
		this.getContentPane().add(menu);
		this.repaint();
		this.setVisible(true);
	}
	
	//Change la fenetre pour afficher le choix de classe
	public void switchToCreation(){
		this.getContentPane().remove(menu);
		this.getContentPane().add(creation);
		this.repaint();
		this.setVisible(true);
	}
	
	//Commence le jeu apres la creation du personnage
	public void beginGame(){
		this.getContentPane().remove(creation);
		this.getContentPane().add(ingame);
		this.repaint();
		this.setVisible(true);
	}
	
	//Affiche l'ecran de victoire
	public void victory(){
		this.getContentPane().remove(ingame);
		this.getContentPane().add(new EcranVictoire(this));
		this.repaint();
		this.setVisible(true);
	}
	
	//Affiche l'ecran de defaite
	public void defeat(){
		this.getContentPane().remove(ingame);
		this.getContentPane().add(new EcranDefaite(this));
		this.repaint();
		this.setVisible(true);
	}
	
	public EcranJeu getEcranJeu(){
		return ingame;
	}
	
	public void setEcranJeu(EcranJeu ej){
		ingame=ej;
	}
}
