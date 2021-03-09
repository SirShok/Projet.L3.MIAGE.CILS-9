import java.lang.Math;

public class Combat {
	//inflige les dégâts d'une attaque d'un individu
	//à un autre individu
	public static void combat (Individu p1, Individu p2, String type1, String type2, int degat, int perceArmure) {
		degat = faiblesse(type1, type2)*degat;
		degat = Math.min(1, degat - Math.min(0, (p1.armure - perceArmure));
		p1.pv = p1.pv - degat;
	}

	//prend deux types et renvoie le modificateur de dégâts correspondant
	public static int faiblesse (String type1, String type2) {
		switch(type1) {
			case "Lumiere":	if(type2.equals("Lumiere")||type2.equals("Tenebres")) return 1;
					return 1/2;
			case "Tenebres":	if(type2.equals("Lumiere")||type2.equals("Tenebres")) return 1;
						return 2;
			case "Feu":	if(type2.equals("Air")||type2.equals("Tenebres")) return 2;
					if(type2.equals("Lumiere")||type2.equals("Eau")) return 1/2;
					break;
			case "Eau":	if(type2.equals("Feu")||type2.equals("Tenebres")) return 2;
					if(type2.equals("Lumiere")||type2.equals("Terre")) return 1/2;
					break;
			case "Terre":	if(type2.equals("Eau")||type2.equals("Tenebres")) return 2;
					if(type2.equals("Lumiere")||type2.equals("Feu")) return 1/2;
					break;
			case "Air":	if(type2.equals("Terre")||type2.equals("Tenebres")) return 2;
					if(type2.equals("Lumiere")||type2.equals("Feu")) return 1/2;
					break;
		}
		return 1;
	}
}
