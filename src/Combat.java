import java.util.ArrayList;
import java.util.Random;

public class Combat {
	//prend deux types et renvoie le facteur de dégâts correspondant
	//typeO désigne le type de l'attaquant (type offensif)
	//typeD désigne le type du défenseur (type défensif)
	public static double faiblesse (String typeO, String typeD) {
		switch(typeO) {
		case "lumiere":	if(typeD.equals("lumiere")||typeD.equals("tenebres")||typeD.equals("physique")) return 1;
		return 1.0/2;
		case "tenebres":	if(typeD.equals("lumiere")||typeD.equals("tenebres")||typeD.equals("physique")) return 1;
		return 2;
		case "feu":	if(typeD.equals("vent")||typeD.equals("tenebres")) return 2;
		if(typeD.equals("lumiere")||typeD.equals("eau")) return 1.0/2;
		return 1;
		case "eau":	if(typeD.equals("feu")||typeD.equals("tenebres")) return 2;
		if(typeD.equals("lumiere")||typeD.equals("terre")) return 1.0/2;
		return 1;
		case "terre":	if(typeD.equals("eau")||typeD.equals("tenebres")) return 2;
		if(typeD.equals("lumiere")||typeD.equals("feu")) return 1.0/2;
		return 1;
		case "vent":	if(typeD.equals("terre")||typeD.equals("tenebres")) return 2;
		if(typeD.equals("lumiere")||typeD.equals("feu")) return 1.0/2;
		return 1;
		case "physique": return 1;
		}
		System.out.println("erreur avec les types");
		return 0;
	}

	// permet de d'appliquer les dégâts subit en un tour (ne prend pas la res élémentaire car les monstre n'en ont pas)
	public static String combat(Individu ind, Monstre m, Competence c, BarreAction ba){
		ArrayList<Integer> DM = new ArrayList<Integer>();
		DM = Competence.Degat(ind,c);
		String res = null;
		int PA;
		ind.mana = ind.mana - c.cout;
		int degat = 0;
		int j = 0, n = DM.size();
		if(c.effet.equals("degat")){	//gere l'aplication des degat si la competence untiliser doit en infliger
			Equipement[] e = ind.armeEquip();
			PA = m.PA-(c.perca+(e[j].perceArmure));
			if(PA < 0) PA = 0;	// si le perce armure total depasse l'armure de la cible l'armure passe a 0
			while(DM.size() > 0){	// aplique tous les degats si l'attaque est a coup multiple
				if(0 < DM.get(0)-PA){	//si les degat son inferieur a l'armure la variable degat n'est pas incréménter
					degat = degat + DM.get(0)-PA;
				}
				if((n/2 == DM.size())&&(e[j + 1] != null)){
					j = j + 1;
				}
				DM.remove(0);
			}
			degat =(int) (((double) degat)*faiblesse(c.type,m.Affinite));	//recalcul des dégat selont la resistance elementaire
			m.HP = m.HP-degat;
			res = "\n" + Narration.afficheCompetence(ind.nom, c.nom, degat);
			if (m.HP <= 0){							// si les PV de l'ennemi passe a 0 renvoi le message de victoire
				res = res+"\n"+Narration.affiche(ind.nom, "victoire", 0,0);
				return(res);
			}
		}
		if(c.effet.equals("soin")){	// rend les pv si la competence est un soin
			ArrayList<Integer> soin = new ArrayList<Integer>();
			soin = Competence.Degat(ind,c);
			int pvA = ind.pv;
			ind.pv += soin.get(0);
			if(ind.pv > ind.pvMax()){	// fais en sorte que le soint ne depasse pas les pv max
				ind.pv = ind.pvMax();

			}
			if(ind.pv > pvA) {
				res = res + "\n"+Narration.affiche(ind.nom, "soin", 0,ind.pv - pvA);
			}
			ba.actualiseVie(ind.pv);
		}
		if(c.effet.equals("bouclier")){	// aplique un bouclier
			ArrayList<Integer> bouclier = new ArrayList<Integer>();
			bouclier = Competence.Degat(ind,c);
			ind.pv += bouclier.get(0); 
			res = res + "\n"+Narration.affiche(ind.nom, "bouclier", 0,bouclier.get(0));
			ba.actualiseVie(ind.pv);
		}
		if(m.PD-ind.armure > 0){	// calcul et apliction des degat du monstre
			System.out.println("pv =" + ind.pv);
			ind.pv = ind.pv-(m.PD-ind.armure);	//rajouter phrase attaque monstre dans natation
			System.out.println("pv =" + ind.pv);
			ba.actualiseVie(ind.pv);
		}
		if (ind.pv <= 0){
			res = res+"\n"+Narration.affiche(ind.nom, "defaite", 0,0);	
		}
		return(res);
	}
	
	//Methode qui selectionne puis retourne un monstre en
	//fonction du nombres de combats gagne et nbr de combat total
	public static Monstre SelectM(ArrayList<Monstre> m, int n, int nt) {
		if (n == nt/2) {
			Monstre select = m.get(5 + new Random().nextInt(7 - 5));
			System.out.println("Monstre selectionne\n");
			return select;
		}
		if (n == nt) {
			Monstre select = m.get(10 + new Random().nextInt(12 - 10));
			System.out.println("Monstre selectionne\n");
			return select;
		}
		if (n == 1) {
			Monstre select = m.get(new Random().nextInt(n+2));
			System.out.println("Monstre selectionne\n");
			return select;
		}
		if (n >= (m.size())-2) {
			Monstre select = m.get(new Random().nextInt(m.size()));
			System.out.println("Monstre selectionne\n");
			return select;
		} else {
			Monstre select = m.get(new Random().nextInt(n));
			System.out.println("Monstre selectionne\n");
			return select;
		}
		
	}
	
}

