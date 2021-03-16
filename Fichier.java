import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.nio.file.Files;
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

	public static boolean isEmpty(File file) throws IOException {
		Path path = Paths.get(file.getPath());
		if(Files.list(path).findAny().isPresent()){
			return true;
		}else {
			return false;
		}
	}


	//permet de rÃ©cupÃ©rer le fichier de config
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
				String cheminFichier = "Autre/DossierConfig/Config.txt";
				FileReader fichier = new FileReader(cheminFichier);
				BufferedReader lecteurFichier = new BufferedReader(fichier); 
				String ligne;
				String[] mot;
				try {
					while(((ligne = lecteurFichier.readLine()) != null)) { //tant que le fichier Ã  une autre ligne 
						mot=ligne.split(" "); //on sÃ©pare la ligne en mot 
						Monstre m = new Monstre(mot[0],Integer.parseInt(mot[1]),Integer.parseInt(mot[1]),Integer.parseInt(mot[2])); //on utilise les mots pour crÃ©er un objet de type monstre
						bestiaire.add(m); //ajoute l'objet crÃ©Ã© au bestiaire
					}
					int i=0;
					for (Monstre b : bestiaire) {
						File fichierSer = new File("Autre/dossierConfig/ObjetSerializer/Monstre"+i);
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichierSer));
						oos.writeObject(b);
						System.out.println("Creation de l'object Serializer :" + b.Nom);
						oos.close();
						i++;
					}
					lecteurFichier.close();
				} catch(IOException e) {
					System.out.println("erreur avec le fichier config");
				}
			} catch(FileNotFoundException fe) {
				System.out.println("erreur: fichier config introuvable");
			}
		}
	}
	//permet de rÃ©cupÃ©rer les diffÃ©rents fichier de configuration des CompÃ©tences et de les introduire dans la base de donnÃ©e Java
	public static void LectureCompetence(ArrayList<Competence> ListeCompetence) throws ClassNotFoundException, IOException {
		try {
			File dossierCompSer = new File("Autre/DossierConfig/competence/competenceSerializer");
			if( dossierCompSer.exists() && dossierCompSer.isDirectory() && isEmpty(dossierCompSer)) {
				for (File f : dossierCompSer.listFiles()) {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
					Competence m = (Competence)ois.readObject();
					System.out.println("lecture d'une compétence serializer "+m.nom);
					ListeCompetence.add(m);
					ois.close();
				}
			} else {
				File initial = new File("Autre/competence/magique");
				if (initial.isDirectory()) {   //vÃ©rifie si le File est un Directory
					for (File f : initial.listFiles()) { // Pour chaque fichier dans le dossier
						FileReader fichier = new FileReader(f); 
						BufferedReader lecteurFichier = new BufferedReader(fichier); //on prend un stream pour lire le fichier
						String ligne;
						while(((ligne = lecteurFichier.readLine()) != null)) { //tant que le fichier Ã  une autre ligne
							Competence c = new Competence(ligne); //on renvoie la ligne au constructeur de Competence
							ListeCompetence.add(c); //on ajoute la competence Ã  la liste des competences
						}
						int i=0;
						for (Competence b : ListeCompetence) {
							File fichierSer = new File("Autre/dossierConfig/competence/competenceSerializerMagique"+i);
							ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichierSer));
							oos.writeObject(b);
							System.out.println("Creation d'une competence Serializer :" + b.nom);
							oos.close();
							i++;
						}
						lecteurFichier.close(); //on ferme le stream de lecture
					}
				}
			}
		} catch(IOException e) {
			System.out.println("erreur avec un des fichiers de competence magique");
		}
		// On rÃ©alise exactement la mÃªme chose pour les compÃ©tences de type physique typÃ© distance
		try {
			File initial = new File ("Autre/competence/physique/distance");
			if(initial.isDirectory()) {
				for (File f : initial.listFiles()) {
					FileReader fichier = new FileReader(f);
					BufferedReader lecteurFichier = new BufferedReader(fichier);
					String ligne;
					while(((ligne = lecteurFichier.readLine()) != null)) {
						Competence c = new Competence(ligne);
						ListeCompetence.add(c);
					}
					int i=0;
					for (Competence b : ListeCompetence) {
						File fichierSer = new File("Autre/dossierConfig/competence/competenceSerializerDistance"+i);
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichierSer));
						oos.writeObject(b);
						System.out.println("Creation d'une competence Serializer :" + b.nom);
						oos.close();
						i++;
					}
					lecteurFichier.close();
				}
			}
		} catch(IOException e) {
			System.out.println("erreur avec un des fichiers de compÃ©tence physique distance");
		}
		// On rÃ©alise exactement la mÃªme chose pour les les compÃ©tences de type physique typÃ© mÃªlÃ©e
		try {
			File initial = new File ("Autre/competence/physique/melee");
			if(initial.isDirectory()) {
				for (File f : initial.listFiles()) {
					FileReader fichier = new FileReader(f);
					BufferedReader lecteurFichier = new BufferedReader(fichier);
					String ligne;
					while(((ligne = lecteurFichier.readLine()) != null)) {
						Competence c = new Competence(ligne);
						ListeCompetence.add(c);
					}
					int i=0;
					for (Competence b : ListeCompetence) {
						File fichierSer = new File("Autre/dossierConfig/competence/competenceSerializerMelee"+i);
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichierSer));
						oos.writeObject(b);
						System.out.println("Creation d'une competence Serializer :" + b.nom);
						oos.close();
						i++;
					}
					lecteurFichier.close();
				}
			}
		} catch(IOException e) {
			System.out.println("erreur avec un des fichiers de compÃ©tence physique mÃªlÃ©e");
		}
	}

	public static void recuperationEquipement(ArrayList<Equipement> ListeEquipement) throws IOException {
		try {
			File dossierSer = new File("Autre/DossierConfig/equipementSerializer");
			if( dossierSer.exists() && dossierSer.isDirectory() && isEmpty(dossierSer)) {
				for (File f : dossierSer.listFiles()) {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
					Equipement m = (Equipement)ois.readObject();
					System.out.println("lecture d'un equipement serializer "+m.nom);
					ListeEquipement.add(m);
					ois.close();
				}
			} else {
				File initial = new File ("Autre/competence/physique/melee");
				if(initial.isDirectory()) {
					for (File f : initial.listFiles()) {
						FileReader fichier = new FileReader(f);
						BufferedReader lecteurFichier = new BufferedReader(fichier);
						String ligne;
						while(((ligne = lecteurFichier.readLine()) != null)) {
							Equipement c = new Equipement(ligne);
							ListeEquipement.add(c);
						}
						int i=0;
						for (Equipement b : ListeEquipement) {
							File fichierSer = new File("Autre/dossierConfig/equipementSerializer"+i);
							ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichierSer));
							oos.writeObject(b);
							System.out.println("Creation d'un equipement Serializer :" + b.nom);
							oos.close();
							i++;
						}
						lecteurFichier.close();
					}
				}
			}
		} catch(IOException e) {
			System.out.println("erreur avec le fichier d'equipement");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("erreur avec une classe du fichier d'equipement");
		}
	}
}
