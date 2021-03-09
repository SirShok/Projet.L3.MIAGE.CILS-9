import java.io.*;
import java.util.Scanner;
import java.lang.reflect.Field;
import java.io.BufferedReader;
import java.util.*;


public class Fichier {
	//permet de créer un fichier si il n'existe pas
	//puis de le lire
	//voir si on laisse la méthode
	public static void LireFichier() throws	 Exception {
		String nomFichier="test.txt";
			if(!new File(NomFichier).exists()) {
				new File(NomFichier).createNewFile();
			} else {
				//System.out.println ("Ce fichier existe déjà");
			}

		FileReader f = new FileReader(NomFichier);
		//FileInputStream = new FileInputStream("test.txt");
//		System.out.println(f.exists());
/*		try {
//			PrintWriter writer = new PrintWriter(f);
			Scanner scan = new Scanner(f);
		} catch (FileNotFoundException e) {}*/
		try {
			char [] a = new char[2048];
			f.read(a);   

			for(char c : a) {
				System.out.print(c);   
			}
		} finally {
				f.close();
		}
	}

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
	public static void RecuperationConfig(){
		Path chemin = Paths.get("DossierConfig\\Config.txt");
		FileReader fichier = new FileReader("DossierConfig\\Config.txt");
		BufferedReader lecteurFichier = new BufferedReader(fichier);
		String ligne;
		String[] mot;
		ArrayList<Monstre> bestiaire = new ArrayList<Monstre>();
		while(((ligne = lecteurFichier.readLine()) != null)) {
			System.out.println(ligne);
			mot=ligne.split(" ");
			Monstre m = new Monstre(mot[0],Integer.parseInt(mot[1]),Integer.parseInt(mot[1]));
			bestiaire.add(m);
		}
		lecteurFichier.close();
		}
}
