public class Equipement {
	//caractéristiques de l'arme
	public String nom;
	//0 = pas de bonus; plus de 0: octroie du degat/soin supplémentaire pour certaines capacites
	public int bonus;
	//indique le nombre d'armure ignorer par l'arme
	public int perceArmure;
	public int nbMain;
	public int rang;
	public String type;


	public Equipement(String equ) {
		String perc = "";
		int i = 0;
		while(i != 6){
			if(equ.charAt(i) != ';'){
				switch{
					case 0:
						nom = nom+equ.charAt(i);
						breaks;
					case 1:
						bonus = bonus+equ.charAt(i);
						breaks;
					case 2:
						perc = perc+equ.charAt(i);
						breaks;
					case 3:
						nbMain = Integer.parseInt(equ.charAt(i));
						breaks;
					case 4:
						rang = Integer.parseInt(equ.charAt(i));
						breaks;
					case 5:
						type = type+equ.charAt(i);
						breaks;
				}
			}else{
				i++;
			}
		}
		perceArmure = Integer.parseInt(perc);
	}
}
