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
    
		Fenetre f=new Fenetre();
		Monstre m1 = new Monstre("test", 1, 2, 3);
		System.out.println(m1.Nom);
		int nbCombT = 4; //nombre de combat total à laisser?
		Individu ind = null;
		int nbCombat = 1; //numéro de combat
		//déroulement du jeu
		while((ind.pv >= 0)&&(nbCombat < 12)) {
			Monstre m = SelectM(bestiaire, nbCombat);
			//selection compétence
			f.getParchemin().getTextArea().append(Combat.combat(ind, m, c));
		}
	}
}
