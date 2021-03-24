import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static Individu joueur;
	public static ArrayList<Monstre> bestiaire = new ArrayList<Monstre>();
	public static ArrayList<Competence> listeCompetence = new ArrayList<Competence>();
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
		
		Fichier.RecuperationConfig(bestiaire);
		Fichier.LectureCompetence(Main.listeCompetence);
		
		Fenetre f=new Fenetre();
		
		
		/*
		f.getEcranJeu().getParchemin().getTextArea().append("\ntest");
		int nbCombT = 4; //nombre de combat total
		Individu ind = null;
		int nbCombat = 1; //numéro de combat
		//déroulement du jeu
		while(nbCombat < 12) {
			Monstre m = Combat.SelectM(bestiaire, nbCombat, nbCombT);
			while(ind.pv > 0) {
				//selection compétence
				f.getParchemin().getTextArea().append(Combat.combat(ind, m, c));
			}
		}*/
	}
}
