import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Fichier {
	//Ã©crit dans un fichier dit "de sauvegarde" les caractÃ©tisques (juste les stats) de l'individu
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

	//permet de rÃ©cupÃ©rer le fichier de config
	public static void RecuperationConfig(){
		try {
			String cheminFichier = "Projet.L3.MIAGE.CILS-9-main/Autre/DossierConfig/Config.txt";
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
	//permet de rÃ©cupÃ©rer les diffÃ©rents fichier de configuration des CompÃ©tences et de les introduire dans la base de donnÃ©e Java
	public static void LectureCompetence() {
		ArrayList<Competence> ListeCompetence = new ArrayList<Competence>();
		try {
			File initial = new File("Projet.L3.MIAGE.CILS-9-main/compétence/magique");
			if (initial.isDirectory()) {
				for (File f : initial.listFiles()) {
					FileReader fichier = new FileReader(f);
					BufferedReader lecteurFichier = new BufferedReader(fichier);
					String ligne;
					int i =0;
					while(((ligne = lecteurFichier.readLine()) != null)) {
						Competence c = new Competence(ligne); 
						System.out.println("Impression de compétence magique "+ i +"  "+ c.nom);
						ListeCompetence.add(c);
						i++;
					}
					lecteurFichier.close();
				}
			}
		} catch(IOException e) {
			System.out.println("erreur avec un des fichiers de compÃ©tence magique");
		}
		try {
			File initial = new File ("Projet.L3.MIAGE.CILS-9-main/compétence/physique/distance");
			if(initial.isDirectory()) {
				for (File f : initial.listFiles()) {
					FileReader fichier = new FileReader(f);
					BufferedReader lecteurFichier = new BufferedReader(fichier);
					String ligne;
					while(((ligne = lecteurFichier.readLine()) != null)) {
						Competence c = new Competence(ligne);
						int i=0;
						System.out.println("Impression de compétence physique distance "+ i + "  " + c.nom);
						ListeCompetence.add(c);
						i++;
					}
					lecteurFichier.close();
				}
			}
		} catch(IOException e) {
			System.out.println("erreur avec un des fichiers de compÃ©tence physique distance");
		}
		try {
			File initial = new File ("Projet.L3.MIAGE.CILS-9-main/compétence/physique/mêlée");
			if(initial.isDirectory()) {
				for (File f : initial.listFiles()) {
					FileReader fichier = new FileReader(f);
					BufferedReader lecteurFichier = new BufferedReader(fichier);
					String ligne;
					while(((ligne = lecteurFichier.readLine()) != null)) {
						Competence c = new Competence(ligne);
						System.out.println("Impression de compétence physique mêlée");
						ListeCompetence.add(c);
					}
					lecteurFichier.close();
				}
			}
		} catch(IOException e) {
			System.out.println("erreur avec un des fichiers de compÃ©tence physique mêlée");
		}
	}
}
