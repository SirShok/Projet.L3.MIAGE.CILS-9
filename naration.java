import java.util.*;

public class Naration {

	//main pour tester la fonction afficher
	public static void main (String [] args)
	{
		/*
		String p = "Patrick";
		List<String> nomAttaque = Arrays.asList(new String[]{"charge", "estoc", "feinte", "frappe_puissante" });
		String nomAtt = nomAttaque.get(new Random().nextInt(nomAttaque.size()));
		affiche(p, nomAtt);
		*/
    }
	
	public static void affiche (String nom, String nomAttaque)  {
		if (nomAttaque == "estoc") {
			//Creation de la liste estoc contenant les phrases à afficher
			List<String> estoc = Arrays.asList(new String[]{
					nom  + " place un coup précit avec son épée !\n" + "Il lui inflige : 10 de dégats",
					"Zbla ! " +nom+  " lui plante le bout de son épée !\n" + "Il inflige 10 de dégats à son adversaire "});
			String select = estoc.get(new Random().nextInt(estoc.size()));	//selectionne aleatoirement une phrase
			System.out.println("estoc\n");
			System.out.print(select);
		}
		if (nomAttaque == "charge") {
			List<String> charge = Arrays.asList(new String[]{
					nom  + " effectue une charge !\n" + "Il lui inflige : 15 de dégats pv à son adversaire ",
					"Et bim ! " +nom+  " rentre dans son adversaire !\n" + "Il inflige 15 de dégats "});
			String select = charge.get(new Random().nextInt(charge.size()));									
			System.out.println("charge\n");
			System.out.print(select);
		}
		if (nomAttaque == "feinte") {
			List<String> feinte = Arrays.asList(new String[]{
					nom  + " fait une feinte !\n" + "Son adversaire perd 5 de dégats ",
					"Bien joue ! " +nom+  " divertit son adversaire et l'attaque en douce !\n" + "Cette feinte inflige 5 de dégats "});
			String select = feinte.get(new Random().nextInt(feinte.size()));
			System.out.println("Feinte\n");
			System.out.print(select);
		}
		if (nomAttaque == "frappe_puissante") {
			List<String> frappe_puissante = Arrays.asList(new String[]{
					nom  + " effectue une frappe puissante ! *rire diabolique*\n" + "Il lui inflige : 20 de dégats",
					"Doux jesus ! " +nom+  " place une attaque puissante avec son épée !\n" + "Il inflige 20 de dégats à son adversaire "});
			String select = frappe_puissante.get(new Random().nextInt(frappe_puissante.size()));
			System.out.println("Frappe puissante\n");
			System.out.print(select);
		}
	}
}
