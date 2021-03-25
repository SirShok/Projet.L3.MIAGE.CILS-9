import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Fichier {
	
	public static boolean isEmpty(File file) throws IOException {
		Path path = Paths.get(file.getPath());
		if(Files.list(path).findAny().isPresent()){
			return true;
		}else {
			return false;
		}
	}
	//permet de recuperer le fichier de config
	public static void RecuperationConfig(ArrayList<Monstre> bestiaire) throws FileNotFoundException, IOException, ClassNotFoundException{
		try {
			File dossierSer = new File("Autre/DossierConfig/ObjetSerializer");
			if( dossierSer.exists() && dossierSer.isDirectory() && isEmpty(dossierSer)) {
				for (File f : dossierSer.listFiles()) {		//a  enlever
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
						while(((ligne = lecteurFichier.readLine()) != null)) { //tant que le fichier a une autre ligne 
							mot=ligne.split(";"); //on separe la ligne en mot 
							Monstre m = new Monstre(mot[0],Integer.parseInt(mot[1]),Integer.parseInt(mot[2]),Integer.parseInt(mot[3]),mot[4]); //on utilise les mots pour creer un objet de type monstre
							bestiaire.add(m); //ajoute l'objet cree au bestiaire
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
						System.out.println("erreur sur la serialization des monstre du fichier config");
					}
				} catch(FileNotFoundException fe) {
					System.out.println("erreur: fichier config introuvable");
				}
			}
		}catch (ClassNotFoundException Ce) {
			System.out.println("erreur class pour monstre introuvable");
		}
	}
	//permet de recuperer les differents fichier de configuration des Competences et de les introduire dans la base de donnee Java
	public static void LectureCompetence(ArrayList<Competence> ListeCompetence) throws ClassNotFoundException, IOException, FileNotFoundException {
		try {
			File dossierCompSer = new File("Autre/competence/competenceSerializer");
			if( dossierCompSer.exists() && dossierCompSer.isDirectory() && isEmpty(dossierCompSer)) {
				for (File f : dossierCompSer.listFiles()) {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
					Competence m = (Competence)ois.readObject();
					System.out.println("lecture d'une competence serializer "+m.nom+m.rang);
					ListeCompetence.add(m);
					ois.close();
				}
			} else {
				try {
					String cheminFichier = "Autre/competence/competence.txt";
					FileReader fichier = new FileReader(cheminFichier); 
					BufferedReader lecteurFichier = new BufferedReader(fichier); //on prend un stream pour lire le fichier
					String ligne;
					String[] mot;
					try {
						while(((ligne = lecteurFichier.readLine()) != null)) { //tant que le fichier a une autre ligne
							mot = ligne.split(";");
							Competence c = new Competence(mot[0],Integer.parseInt(mot[1]),mot[2],Integer.parseInt(mot[3]),Integer.parseInt(mot[4]),Integer.parseInt(mot[5]),mot[6],mot[7],Integer.parseInt(mot[8]),mot[9]); //on renvoie la ligne au constructeur de Competence
							ListeCompetence.add(c); //on ajoute la competence à la liste des competences
						}
						int i=0;
						System.out.println("Debut serialization");
						for (Competence b : ListeCompetence) {
							File fichierSer = new File("Autre/competence/competenceSerializer/competenceSerializer"+i);
							ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichierSer));
							oos.writeObject(b);
							System.out.println("Creation de l'object Serializer :" + b.nom);
							oos.close();
							i++;
						}
						lecteurFichier.close();
					} catch(IOException e) {
						System.out.println("erreur avec le fichier competence");
					}
				} catch(FileNotFoundException fe) {
					System.out.println("erreur: fichier competence introuvable");
				}
			}
		}catch (ClassNotFoundException Ce) {
			System.out.println("erreur class pour competence introuvable");
		}
	}
}
