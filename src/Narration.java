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
	
	public static  String affiche (String nom, String nomE, int DM, int SOIN)  {
		if (nomE == "estoc") {
			//Creation de la liste estoc contenant les phrases Ã  afficher
			List<String> estoc = Arrays.asList(new String[]{
					nom  + " place un coup précit avec son épée !\n" + "Il lui inflige : " + DM + " de dégats \n",
					"Zbla ! " +nom+  " lui plante le bout de son épée !\n" + "Il inflige " + DM + " de dégats Ã  son adversaire \n"});
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
					nom  + " effectue une double attaque !\n" + "Il lui inflige : " + DM + " de dégats pv Ã  son adversaire \n",
					"Et bim ! " +nom+  " fait une attaque double Ã  son adversaire !\n" + "Il inflige " + DM + " de dégats \n"});
			String select = attaque_double.get(new Random().nextInt(attaque_double.size()));
			System.out.println("attaque double\n");
			return select;
		}
		if (nomE == "boule_de_feu") {
			List<String> boule_de_feu = Arrays.asList(new String[]{
					nom  + " envoit une boule de feu ! *rire diabolique*\n" + "Il lui inflige : " + DM + " de dégats \n",
					"Doux jesus ! " +nom+  " fait jaillir une boule de feu et l'envoie sur son adversaire !\n" + "Il inflige " + DM + " de dégats Ã  son adversaire \n"});
			String select = boule_de_feu.get(new Random().nextInt(boule_de_feu.size()));
			System.out.println("boule de feu\n");
			return select;
		}
		if (nomE == "victoire") {
			List<String> victoire = Arrays.asList(new String[]{
					"Bravo, " +nom+ " ! \n" + "Vous avez gagné \n",
					"Damn ! " +nom+  " a pulvérisé son adversaire !\n" + "Vous etes l'heureux gagnant de ce combat \n"});
			String select = victoire.get(new Random().nextInt(victoire.size()));
			System.out.println("victoire\n");
			return select;
			
		}
		if (nomE == "defaite") {
			List<String> defaite = Arrays.asList(new String[]{
					"Mince " +nom+ " ! \n" + "Vous avez perdu... \n",
					"Zut ! " + " Vous avez été vaincu...\n" + "Devenez plus fort !\n"});
			String select = defaite.get(new Random().nextInt(defaite.size()));
			System.out.println("defaite\n");
			return select;
			
		}
		if (nomE == "soin") {
			List<String> soin = Arrays.asList(new String[]{
					"Abracadabra ! \n" +nom+ " recupere " + SOIN + " de pv !\n",
					"Parfait ! \n" + "Vous recuperez " + SOIN + " de pv !\n"});
			String select = soin.get(new Random().nextInt(soin.size()));
			System.out.println("soin\n");
			return select;
			
		}
		if (nomE == "bouclier") {
			List<String> bouclier = Arrays.asList(new String[]{
					"Bien joué, \n" +nom+ " gagne un bouclier et ses pv augmentent de  " + SOIN + " !\n",
					"Incroyable ! \n" + "Vous obtenez un bouclier qui vous donne " + SOIN + " de pv !\n"});
			String select = bouclier.get(new Random().nextInt(bouclier.size()));
			System.out.println("bouclier\n");
			return select;
			
		}
		return null;
	}
	
	public static String afficheCompetence(String Ind, String c,int degat) {
		String res = null;
		res = (" Avec son courage, notre h�ros utilise : "+c+"  et ainsi inflige : "+degat+" � son terrible adversaire.");
		return res;
	}
	public static String apparitionMonstre(Individu joueur, Monstre m) {
		String res =null;
		res = ("\n Malheur !! Un terrible danger se dresse sur votre route vers la Terre Sainte ! Un "+m.Nom+" souhaite en d�coudre avec vous. \nAux armes, triomphez de cet adversaire sans attendre !!!");
		return res;
	}
	public static String afficheCompetenceMonstre(String Ind, String c,int degat) {
		String res = null;
		res = ("Mince ! Le monstre attaque et inflige "+degat+" de d�gats à notre h�ro !");
		return res;
	}
}
