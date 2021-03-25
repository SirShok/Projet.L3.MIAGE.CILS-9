import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static Individu joueur;
	public static ArrayList<Monstre> bestiaire = new ArrayList<Monstre>();
	public static Monstre adversaire = null;
	public static ArrayList<Competence> listeCompetence = new ArrayList<Competence>();
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, InterruptedException {
		
		Fichier.RecuperationConfig(bestiaire);
		Fichier.LectureCompetence(Main.listeCompetence);
		adversaire = Combat.SelectM(bestiaire, 1, 3);
		try {
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Autre/images/nine0.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
		Fenetre f=new Fenetre();
	}
}
