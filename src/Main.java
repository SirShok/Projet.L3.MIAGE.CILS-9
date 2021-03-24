import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		ArrayList<Monstre> bestiaire = new ArrayList<Monstre>();
		ArrayList<Competence> listeCompetence = new ArrayList<Competence>();
		Fichier.RecuperationConfig(bestiaire);
		Fichier.LectureCompetence(listeCompetence);
		System.out.print(Narration.afficheCompetence("Le joueur ", listeCompetence.get(120).nom, 15));
		//Fenetre f=new Fenetre(bestiaire, listeCompetence);
		//Fenetre f=new Fenetre();
		/*int nbCombT = 4; //nombre de combat total
		Individu ind = null;
		int nbCombat = 1; //numéro de combat
		//déroulement du jeu
		while(nbCombat < 12) {
			Monstre m = SelectM(bestiaire, nbCombat, nbComT);
			while(ind.pv > 0) {
				//selection compétence
				f.getParchemin().getTextArea().append(Combat.combat(ind, m, c));
			}
		}*/
	}
}
