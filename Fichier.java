import java.io.*;
import java.util.Scanner;
import java.lang.reflect.Field;


public class Fichier {
	//permet de créer un fichier si il n'existe pas
	//puis de le lire
	//voir si on laisse la méthode
	public static void LireFichier() throws	 Exception {
		String nomFichier="test.txt";
			if(!new File(nomFichier).exists()) {
				new File(nomFichier).createNewFile();
			} else {
				//System.out.println ("Ce fichier existe déjà");
			}

		FileReader f = new FileReader(nomFichier);
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
}
