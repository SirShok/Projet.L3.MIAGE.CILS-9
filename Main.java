
public class Main {

	public static void main(String[] args) {
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
		for (Monstre E : bestiaire) {
			E.PrintMonstre(E);
		}
		lecteurFichier.close();
		}
	}

}
