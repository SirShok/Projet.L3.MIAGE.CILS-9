import java.util.ArrayList;
import java.util.Random;

public class Combat {
	//prend deux types et renvoie le facteur de dégâts correspondant
	//typeO désigne le type de l'attaquant (type offensif)
	//typeD désigne le type du défenseur (type défensif)
	public static int faiblesse (String typeO, String typeD) {
		switch(typeO) {
		case "lumiere":	if(typeD.equals("lumiere")||typeD.equals("tenebres")||typeD.equals("physique")) return 1;
		return 1/2;
		case "tenebres":	if(typeD.equals("lumiere")||typeD.equals("tenebres")||typeD.equals("physique")) return 1;
		return 2;
		case "feu":	if(typeD.equals("vent")||typeD.equals("tenebres")) return 2;
		if(typeD.equals("lumiere")||typeD.equals("eau")) return 1/2;
		return 1;
		case "eau":	if(typeD.equals("feu")||typeD.equals("tenebres")) return 2;
		if(typeD.equals("lumiere")||typeD.equals("terre")) return 1/2;
		return 1;
		case "terre":	if(typeD.equals("eau")||typeD.equals("tenebres")) return 2;
		if(typeD.equals("lumiere")||typeD.equals("feu")) return 1/2;
		return 1;
		case "vent":	if(typeD.equals("terre")||typeD.equals("tenebres")) return 2;
		if(typeD.equals("lumiere")||typeD.equals("feu")) return 1/2;
		return 1;
		case "physique": return 1;
		}
		System.out.println("erreur avec les types");
		return 0;
	}

	// permet de d'appliquer les dégâts subit en un tour (ne prend pas la res élémentaire car les monstre n'en ont pas)
	public static String combat(Individu ind, Monstre m, Competence c){
		ArrayList<Integer> DM = new ArrayList<Integer>();
		DM = Competence.Degat(ind,c);
		int n = DM.size()/2;
		String res;
		int PA;
		int degat;
		ind.mana = ind.mana - c.cout;
		if(c.effet == "degat"){
			for(Equipement e: ind.armeEquip()){
				if(e != null){
					PA = m.PA-(c.perca+(e.perceArmure));
					if(PA < 0) PA = 0;
					for(int i = 0; i<n; i++){
						if(0 < DM.get(i)-PA){
							degat = DM.get(i)-PA;
						}
						DM.remove(i);
					}
				}
			}
			degat = degat*faiblesse(c.type,m.Affinite);
			m.HP = m.HP-degat;
			res = Narration.affiche(ind.nom, c.nom, degat);
			if (m.HP <= 0){
				res = res+"\n"+Narration.affiche(ind.nom, "victoire", degat);
				return(res);
			}
		}
		if(c.effet == "soin"){
			ArrayList<Integer> soin = new ArrayList<Integer>();
			soin = Competence.Degat(ind,c);
			ind.pv += soin.get(0);
			if(ind.pv > ind.pvMax()){
				ind.pv = ind.pvMax();
			}								//rajouter phrase soin dans natation
		}
		if(c.effet == "bouclier"){
			ArrayList<Integer> soin = new ArrayList<Integer>();
			soin = Competence.Degat(ind,c);
			ind.pv += soin.get(0);			//rajouter phrase bouclier dans natation
		}
		if(m.PD-ind.armure > 0){
			ind.pv = ind.pv-(m.PD-ind.armure);	//rajouter phrase attaque monstre dans natation
		}
		if (ind.pv <= 0){
			res = res+"\n"+Narration.affiche(ind.nom, "defaite", degat);	//rajouter phrase defaite dans natation
		}
		return(res);
	}
	
	public static  String affiche (String nom, String nomE, int DM, int SOIN)  {
		if (nomE == "estoc") {
			//Creation de la liste estoc contenant les phrases à afficher
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
					"Damn ! " +nom+  " a éclaté son adversaire !\n" + "Vous etes l'heureux gagnant de ce combat \n"});
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
}

