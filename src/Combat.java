import java.lang.Math;
import java.util.ArrayList;

public class Combat {
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
		return 0;
	}
	
	// permet de d'appliquer les dégâts subit en un tour (ne prend pas la res élémentaire car les monstre n'en ont pas)
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
