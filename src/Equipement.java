public class Equipement {
	//caracteristiques de l'arme
	public String nom;
	//0 = pas de bonus; plus de 0: octroie du degat/soin supplementaire pour certaines capacites
	public int degatPhysique,degatMagique,armure;
	//indique le nombre d'armure ignorer par l'arme
	public int perceArmure;
	public int nbMain;
	public int rang;
	public String type;


	public Equipement(String equ) {
		String[] tab = equ.split(";");
      		nom = tab[0];
		degatPhysique = Integer.parseInt(tab[1]);
		degatMagique = Integer.parseInt(tab[2]);
		armure = Integer.parseInt(tab[3]);
		perceArmure = Integer.parseInt(tab[4]);
		nbMain = Integer.parseInt(tab[5]);
		rang = Integer.parseInt(tab[6]);
		type = tab[7];
	}
	
	public Equipement(String n, int degatP,int degatM,int ar,int perca,int nb,int r,String tp) {
		nom = n;
		degatPhysique = degatP;
		degatMagique = degatM;
		armure = ar;
		perceArmure = perca;
		nbMain = nb;
		rang = r;
		type = tp;
	}
}
