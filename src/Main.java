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

	}
	
	//methode qui selectionne le monstre pour un combat en fonction de
	//la liste de montres, et le nombres de combats effectué
	public static Monstre SelectM(ArrayList<Monstre> m, int n) {
		if (n >= (m.size())-2) {
			Monstre select = m.get(new Random().nextInt(m.size()));
			System.out.println("Monstre selectionne\n");
			return select;
		} else {
			Monstre select = m.get(new Random().nextInt(n+2));
			System.out.println("Monstre selectionne\n");
			return select;
		}
		
	}
}
