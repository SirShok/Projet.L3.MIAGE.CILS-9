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
		String res = null;
		int PA;
		ind.mana = ind.mana - c.cout;
		int degat;
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
			res = Narration.affiche(ind.nom, c.nom, degat, 0);
			if (m.HP <= 0){
				res = res+"\n"+Narration.affiche(ind.nom, "victoire", 0,0);
				return(res);
			}
		}
		if(c.effet == "soin"){
			ArrayList<Integer> soin = new ArrayList<Integer>();
			soin = Competence.Degat(ind,c);
			ind.pv += soin.get(0);
			if(ind.pv > ind.pvMax()){
				ind.pv = ind.pvMax();
				res = res + "\n"+Narration.affiche(ind.nom, "soin", 0,soin.get(0));
			}								//rajouter phrase soin dans natation
		}
		if(c.effet == "bouclier"){
			ArrayList<Integer> soin = new ArrayList<Integer>();
			soin = Competence.Degat(ind,c);
			ind.pv += soin.get(0); 
			res = res + "\n"+Narration.affiche(ind.nom, "bouclier", 0,soin.get(0)); //rajouter phrase bouclier dans natation
		}
		if(m.PD-ind.armure > 0){
			ind.pv = ind.pv-(m.PD-ind.armure);	//rajouter phrase attaque monstre dans natation
			
		}
		if (ind.pv <= 0){
			res = res+"\n"+Narration.affiche(ind.nom, "defaite", 0,0);	//rajouter phrase defaite dans natation
		}
		return(res);
	}
	
	public static Monstre SelectM(ArrayList<Monstre> m, int n, int nt) {
		if (n == nt/2) {
			Monstre select = m.get(5 + new Random().nextInt(7 - 5));
			return select;
		}
		if (n == nt) {
			Monstre select = m.get(10 + new Random().nextInt(12 - 10));
			return select;
		}
		if (n == 1) {
			Monstre select = m.get(new Random().nextInt(n+2));
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

