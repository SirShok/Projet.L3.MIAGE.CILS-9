import java.util.*;

public class Narration {

	//main pour tester la fonction afficher
	public static void main (String [] args)
	{
		/*
		String p = "Patrick";
		List<String> evenements = Arrays.asList(new String[]{"estoc", "attaque_simple", "attaque_double", "boule_de_feu", "victoire" });
		String nomAtt = evenements.get(new Random().nextInt(evenements.size()));
		System.out.println(affiche(p, nomAtt, 10));
		*/
		
    }
	
	public static  String affiche (String nom, String nomE, int DM)  {
		if (nomE == "estoc") {
			//Creation de la liste estoc contenant les phrases à  afficher
			List<String> estoc = Arrays.asList(new String[]{
					nom  + " place un coup précit avec son épée !\n" + "Il lui inflige : " + DM + " de dégats \n",
					"Zbla ! " +nom+  " lui plante le bout de son épée !\n" + "Il inflige " + DM + " de dégats à son adversaire \n"});
			String select = estoc.get(new Random().nextInt(estoc.size()));	//selectionne aleatoirement une phrase
			System.out.println("estoc\n");
			return select;
		}
		if (nomE == "attaque_simple") {
			List<String> attaque_simple = Arrays.asList(new String[]{
					nom  + " met un coup d'épée !\n" + "Son adversaire perd " + DM + " de pv \n",
					"Bien joue ! " +nom+  " place une attaque simple !\n" + "Ce coup inflige " + DM + " de dégats \n"});
			String select = attaque_simple.get(new Random().nextInt(attaque_simple.size()));									
			System.out.println("attaque simple\n");
			return select;
		}
		if (nomE == "attaque_double") {
			List<String> attaque_double = Arrays.asList(new String[]{
					nom  + " effectue une double attaque !\n" + "Il lui inflige : " + DM + " de dégats pv à son adversaire \n",
					"Et bim ! " +nom+  " fait une attaque double à son adversaire !\n" + "Il inflige " + DM + " de dégats \n"});
			String select = attaque_double.get(new Random().nextInt(attaque_double.size()));
			System.out.println("attaque double\n");
			return select;
		}
		if (nomE == "boule_de_feu") {
			List<String> boule_de_feu = Arrays.asList(new String[]{
					nom  + " envoit une boule de feu ! *rire diabolique*\n" + "Il lui inflige : " + DM + " de dégats \n",
					"Doux jesus ! " +nom+  " fait jaillir une boule de feu et l'envoie sur son adversaire !\n" + "Il inflige " + DM + " de dégats à son adversaire \n"});
			String select = boule_de_feu.get(new Random().nextInt(boule_de_feu.size()));
			System.out.println("boule de feu\n");
			return select;
		}
		if (nomE == "victoire") {
			List<String> victoire = Arrays.asList(new String[]{
					"Bravo, " +nom+ " ! \n" + "Vous avez gagné \n",
					"Damn ! " +nom+  " a d�fait son adversaire !\n" + "Vous etes l'heureux gagnant de ce combat \n"});
			String select = victoire.get(new Random().nextInt(victoire.size()));
			System.out.println("victoire\n");
			return select;
		}
		return null;
	}
}
