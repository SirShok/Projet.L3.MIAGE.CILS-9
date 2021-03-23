import java.lang.Math;

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
		System.out.println("erreur avec les types");
		return ;
	}
	
	// permet de d'appliquer les dégâts subit en un tour (ne prend pas la res élémentaire car les monstre n'en ont pas)
	public static String combat(Individu ind, Monstre m, Competence c){
		ArrayList<Integer> DM = new ArrayList<Integer>();
		DM = Competence.Degat(ind,c);
		int n = DM.size()/2;
		String res;
		ind.mana = ind.mana - c.cout;
		if(c.type == "degat"){
			for(Equipement e: Individu.armeEquip(ind)){
				for(int i = 0; i<n; i++){
					if(0 < DM.get(i)-(m.PA-(c.perca+(e.perceArmure)))){
						int degat = DM.get(i)-(m.PA-(c.perca+(e.perceArmure)));
					}
					DM.remove(i);
				}
			}
			m.HP = m.HP-degat;
			res = Naration.affiche(ind.nom, c.nom, degat);
			if (m.HP <= 0){
				res = res+"\n"+Naration.affiche(ind.nom, victoire, degat);
				return(res);
			}
		}
		if(c.type == "soin"){
			ArrayList<Integer> soin = new ArrayList<Integer>();
			soin = Competence.Degat(ind,c);
			ind.pv += soin.get(0);
			if(ind.pv > ind.pvMax()){
				ind.pv = ind.pvMax();
			}								//rajouter phrase soin dans natation
		}
		if(c.type == "bouclier"){
			ArrayList<Integer> soin = new ArrayList<Integer>();
			soin = Competence.Degat(ind,c);
			ind.pv += soin.get(0);			//rajouter phrase bouclier dans natation
		}
		if(m.PD-ind.armure > 0){
			ind.pv = ind.pv-(m.PD-ind.armure);	//rajouter phrase attaque monstre dans natation
		}
		if (ind.pv <= 0){
			res = res+"\n"+Naration.affiche(ind.nom, defaite, degat);	//rajouter phrase defaite dans natation
		}
		return(res);
	}
}

}
