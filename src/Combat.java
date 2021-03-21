import java.lang.Math;

public class Combat {
	//prend un deux types et un individu, un montant de dégâts et un montant de perce-armure
	//puis applique les dégâts selon les faiblesses
	//on peut, peut-être, à la place de prendre un montant de perce-armure, prendre un individu ou autre chose pour le perce-armure
	public static void combat (Individu p1, /*Individu p2,*/ int perceArmure, String type1, String type2, int degat) {
		degat = faiblesse(type1, type2)*degat;
		degat = Math.min(0, degat - Math.min(0, p1.armure - perceArmure)); //on peut toujours appliquer armure et le perce-armure autre part
		p1.pv = p1.pv - degat;
	}

	//prend deux types et renvoie le facteur de dégâts correspondant
	public static int faiblesse (String type1, String type2) {
		switch(type1) {
			case "lumiere":	if(type2.equals("lumiere")||type2.equals("tenebres")||type2.equals("physique")) return 1;
					return 1/2;
			case "tenebres":	if(type2.equals("lumiere")||type2.equals("tenebres")||type2.equals("physique")) return 1;
						return 2;
			case "feu":	if(type2.equals("vent")||type2.equals("tenebres")) return 2;
					if(type2.equals("lumiere")||type2.equals("eau")) return 1/2;
					return 1;
			case "eau":	if(type2.equals("feu")||type2.equals("tenebres")) return 2;
					if(type2.equals("lumiere")||type2.equals("terre")) return 1/2;
					return 1;
			case "terre":	if(type2.equals("eau")||type2.equals("tenebres")) return 2;
					if(type2.equals("lumiere")||type2.equals("feu")) return 1/2;
					return 1;
			case "vent":	if(type2.equals("terre")||type2.equals("tenebres")) return 2;
					if(type2.equals("lumiere")||type2.equals("feu")) return 1/2;
					return 1;
			case "physique": return 1;
		}
		return 1;
	}
	
	// permet de d'apliquer les dégat subit en un tour (ne prend pas la res élémentaire car les monstre n'en on pas)
	public static ArrayList<String> combat(Individu ind, Monstre m, Competence c){
		ArrayList<Integer> DM = new ArrayList<Integer>();
		DM = Competence.Degat(ind,c);
		int n = DM.size()/2;
		for(Equipement e: Individu.armeEquip(ind)){
			for(int i = 0; i<n; i++){
				if(0 < DM.get(i)-(m.PA-(c.perca+(e.perceArmure)))){
					m.HP = m.HP-(DM.get(i)-(m.PA-(c.perca+(e.perceArmure))));
					DM.remove(i);
				}
			}
		}
		if(m.PD-ind.armure > 0){
			ind.pv = ind.pv-(m.PD-ind.armure);
		}
		ArrayList<String> res = new ArrayList<String>();
		return(res);
	}
}
