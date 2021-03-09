
public class Monstre {
	String Nom;
	int HP;
	int PA;
	
	Monstre(String m, int pv, int pa){
		this.Nom = m;
		this.HP = pv;
		this.PA = pa;
	}
	
	public void PrintMonstre(Monstre M) {
		System.out.print(M.Nom+" ");
		System.out.print(M.HP+" ");
		System.out.println(M.PA);
	}
}