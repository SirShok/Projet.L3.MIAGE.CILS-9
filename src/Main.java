import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException{
		
		ArrayList<Monstre> bestiaire = new ArrayList<Monstre>();
		ArrayList<Competence> listeCompetence = new ArrayList<Competence>();
		Fichier.RecuperationConfig(bestiaire);
		Fichier.LectureCompetence(listeCompetence);
		
		
		Fenetre f=new Fenetre();

	}
}