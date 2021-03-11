import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Fichier {
	//écrit dans un fichier dit "de sauvegarde" les caractétisques (juste les stats) de l'individu
	public static void EcrireFichier(Individu i) {
		Class cl = i.getClass();
		Field[] fd = cl.getFields();
		try {
			FileWriter fw = new FileWriter(fd[0].get(i).toString());
			for(int j = 0; j < fd.length; j++) {
				fw.write(fd[j].get(i) + "\t");
			}
			fw.close();
		} catch(Exception e) {
			System.out.println("erreur avec le fichier de sauvegarde");
		}
	}
	
	//permet de récupérer le fichier de config
	public static void RecuperationConfig(){
		try {
			String cheminFichier = "Autre/DossierConfig/Config.txt";
			Path chemin = Paths.get(cheminFichier);
			FileReader fichier = new FileReader(cheminFichier);
			BufferedReader lecteurFichier = new BufferedReader(fichier);
			String ligne;
			String[] mot;
			ArrayList<Monstre> bestiaire = new ArrayList<Monstre>();
			try {
				while(((ligne = lecteurFichier.readLine()) != null)) {
					mot=ligne.split(" ");
					Monstre m = new Monstre(mot[0],Integer.parseInt(mot[1]),Integer.parseInt(mot[1]));
					bestiaire.add(m);
				}
				lecteurFichier.close();
			} catch(IOException e) {
				System.out.println("erreur avec le fichier config");
			}
		} catch(FileNotFoundException fe) {
				System.out.println("erreur: fichier config introuvable");
		}
	}
//permet de récupérer les différents fichier de configuration des Compétences et de les introduire dans la base de donnée Java
	public static void LectureCompetence() {
		ArrayList<Competence> ListeCompetence = new ArrayList<Competence>();
		try {
			File initial = new File ("compétence/magique","magique");
			for (File f : initial.listFiles()) {
				FileReader fichier = new FileReader(f);
				BufferedReader lecteurFichier = new BufferedReader(fichier);
				String ligne;
				while(((ligne = lecteurFichier.readLine()) != null)) {
					Competence c = new Competence(ligne);
					ListeCompetence.add(c);
				}
			}		
		} catch(IOException e) {
			System.out.println("erreur avec un des fichiers de compétence magique");
		}
		try {
			File initial = new File ("compétence/physique","physique");
			for (File f : initial.listFiles()) {
				FileReader fichier = new FileReader(f);
				BufferedReader lecteurFichier = new BufferedReader(fichier);
				String ligne;
				while(((ligne = lecteurFichier.readLine()) != null)) {
					Competence c = new Competence(ligne);
					ListeCompetence.add(c);
				}
			}		
		} catch(IOException e) {
			System.out.println("erreur avec un des fichiers de compétence physique");
		}
	}
}
