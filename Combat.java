import java.lang.Math;

public class Combat {
	public static void combat (Individu p1, Individu p2, String type1, String type2, int degat) {
		degat = faiblesse(type1, type2)*degat;
		degat = Math.min(0, degat /*- p1.armure*/);
		p1.pv = p1.pv - degat;
	}

	public static int faiblesse (String type1, String type2) {
		switch(type1) {
			case "lumiere":	if(type2.equals("lumiere")||type2.equals("tenebres")||type2.equals("physique")) return 1;
					return 1/2;
			case "tenebres":	if(type2.equals("lumiere")||type2.equals("tenebres")||type2.equals("physique")) return 1;
						return 2;
			case "feu":	if(type2.equals("air")||type2.equals("tenebres")) return 2;
					if(type2.equals("lumiere")||type2.equals("eau")) return 1/2;
					return 1;
					break;
			case "eau":	if(type2.equals("feu")||type2.equals("tenebres")) return 2;
					if(type2.equals("lumiere")||type2.equals("terre")) return 1/2;
					return 1;
					break;
			case "terre":	if(type2.equals("eau")||type2.equals("tenebres")) return 2;
					if(type2.equals("lumiere")||type2.equals("feu")) return 1/2;
					return 1;
					break;
			case "air":	if(type2.equals("terre")||type2.equals("tenebres")) return 2;
					if(type2.equals("lumiere")||type2.equals("feu")) return 1/2;
					return 1;
					break;
			case "physique"; return 1; break;
		}
		return 1;
	}
}
