public class Equipement {
	//caractéristiques de l'arme
	public String nom;
	//0 = pas de bonus; plus de 0: octroie du degat/soin supplémentaire pour certaines capacites
	public int degatPhysique,degatMagique;
	//indique le nombre d'armure ignorer par l'arme
	public int perceArmure;
	public int nbMain;
	public int rang;
	public String type;


	public Equipement(String equ) {
		String perc = "";
		int bonusP,bonusM
		int i = 0;
		while(i != 7){
			if(equ.charAt(i) != ';'){
				switch{
					case 0:
						nom = nom+equ.charAt(i);
						breaks;
					case 1:
						bonusP = bonusP+equ.charAt(i);
						breaks;
					case 2:
						bonusM = bonusP+equ.charAt(i);
					case 3:
						perc = perc+equ.charAt(i);
						breaks;
					case 4:
						nbMain = Integer.parseInt(equ.charAt(i));
						breaks;
					case 5:
						rang = Integer.parseInt(equ.charAt(i));
						breaks;
					case 6:
						type = type+equ.charAt(i);
						breaks;
				}
			}else{
				i++;
			}
		}
		degatPhysique = Integer.parseInt(bonusP);
		degatMagique = Integer.parseInt(bonusM);
		perceArmure = Integer.parseInt(perc);
	}
}
