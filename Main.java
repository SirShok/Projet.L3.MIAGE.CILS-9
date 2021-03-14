public class Main {
	public static void main(String[] args) {
		Equipement[] equipement  = {new Equipement("baton usé", 0, 4, 4, 0, 2, 1), new Equipement("baguette usé", 0, 2, 2, 0, 1, 1), new Equipement("épée rouillé", 4, 0, 0, 0, 1, 1),
		new Equipement("estramaçon rouillé", 8, 0, 0, 0, 2, 1), new Equipement("arc usé avec flèches rouillés", 3, 0, 0, 0, 2, 1), new Equipement("baton en érable", 0, 8, 8, 0, 2, 2),
		new Equipement("baguette en érable", 0, 4, 4, 0, 1, 2), new Equipement("épée en fer", 8, 0, 0, 0, 1, 2), new Equipement("estramaçon en fer", 16, 0, 0, 0, 2, 2),
		new Equipement("dague en fer", 6, 0, 0, 4, 1, 2), new Equipement("arc en érable avec flèches en fer", 6, 0, 0, 2, 2, 2), new Equipement("baton en chêne", 0, 12, 12, 0, 2, 3),
		new Equipement("baguette en chêne", 0, 6, 6, 0, 1, 3), new Equipement("épée en acier", 12, 0, 0, 0, 1, 3), new Equipement("estramaçon en acier", 24, 0, 0, 0, 2, 3),
		new Equipement("dague en acier", 9, 0, 0, 6, 1, 3), new Equipement("arc en chêne et flèches en acier", 9, 0, 0, 4, 2, 3)};
		ArrayList<Monstre> bestiaire = new ArrayList<Monstre>();
		ArrayList<Competence> listeCompetence = new ArrayList<Competence>();
		Fichier.RecuperationConfig(bestiaire);
		Fichier.LectureCompetence(listeCompetence);

	}
}
