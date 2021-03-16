import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Fichier {
	//Ã©crit dans un fichier dit "de sauvegarde" les caracé©tisques (juste les stats) de l'individu
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

	public static boolean isEmpty(File file) throws IOException {
		Path path = Paths.get(file.getPath());
		if(Files.list(path).findAny().isPresent()){
			return true;
		}else {
			return false;
		}
	}
	
	
	//permet de récupérer le fichier de config
	public static void RecuperationConfig(ArrayList<Monstre> bestiaire) throws FileNotFoundException, IOException, ClassNotFoundException{
		File dossierSer = new File("Autre/DossierConfig/ObjetSerializer");
		if( dossierSer.exists() && dossierSer.isDirectory() && isEmpty(dossierSer)) {
			for (File f : dossierSer.listFiles()) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				Monstre m = (Monstre)ois.readObject();
				System.out.println("lecture d'un objet serializer "+m.Nom);
				bestiaire.add(m);
				ois.close();
			}
		} else {

			try {
			String cheminFichier = "Projet.L3.MIAGE.CILS-9-main/Autre/DossierConfig/Config.txt";
			FileReader fichier = new FileReader(cheminFichier);
			BufferedReader lecteurFichier = new BufferedReader(fichier); 
			String ligne;
			String[] mot;
			try {
				while(((ligne = lecteurFichier.readLine()) != null)) { //tant que le fichier a une autre ligne 
					mot=ligne.split(" "); //on sépare la ligne en mot 
					Monstre m = new Monstre(mot[0],Integer.parseInt(mot[1]),Integer.parseInt(mot[1])); //on utilise les mots pour créer un objet de type monstre
					bestiaire.add(m); //ajoute l'objet crÃ©Ã© au bestiaire
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
	public static void LectureCompetence(ArrayList<Competence> ListeCompetence) {
		try {
			File initial = new File("Projet.L3.MIAGE.CILS-9-main/competence/magique");
			if (initial.isDirectory()) {   //vérifie si le File est un Directory
				for (File f : initial.listFiles()) { // Pour chaque fichier dans le dossier
					FileReader fichier = new FileReader(f); 
					BufferedReader lecteurFichier = new BufferedReader(fichier); //on prend un stream pour lire le fichier
					String ligne;
					while(((ligne = lecteurFichier.readLine()) != null)) { //tant que le fichier à une autre ligne
						Competence c = new Competence(ligne); //on renvoie la ligne au constructeur de Competence
						ListeCompetence.add(c); //on ajoute la competence Ã  la liste des competences
					}
					lecteurFichier.close(); //on ferme le stream de lecture
				}
			}
		} catch(IOException e) {
			System.out.println("erreur avec un des fichiers de compétence magique");
		}
		// On réalise exactement la même chose pour les compétences de type physique typé distance
		try {
			File initial = new File ("Projet.L3.MIAGE.CILS-9-main/competence/physique/distance");
			if(initial.isDirectory()) {
				for (File f : initial.listFiles()) {
					FileReader fichier = new FileReader(f);
					BufferedReader lecteurFichier = new BufferedReader(fichier);
					String ligne;
					while(((ligne = lecteurFichier.readLine()) != null)) {
						Competence c = new Competence(ligne);
						ListeCompetence.add(c);
					}
					lecteurFichier.close();
				}
			}
		} catch(IOException e) {
			System.out.println("erreur avec un des fichiers de compÃ©tence physique distance");
		}
		// On réalise exactement la même chose pour les compétences de type physique type mêlée
		try {
			File initial = new File ("Projet.L3.MIAGE.CILS-9-main/competence/physique/mÃªlÃ©e");
			if(initial.isDirectory()) {
				for (File f : initial.listFiles()) {
					FileReader fichier = new FileReader(f);
					BufferedReader lecteurFichier = new BufferedReader(fichier);
					String ligne;
					while(((ligne = lecteurFichier.readLine()) != null)) {
						Competence c = new Competence(ligne);
						ListeCompetence.add(c);
					}
					lecteurFichier.close();
				}
			}
		} catch(IOException e) {
			System.out.println("erreur avec un des fichiers de compÃ©tence physique mÃªlÃ©e");
		}
	}
}
