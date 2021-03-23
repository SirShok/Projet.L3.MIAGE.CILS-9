import java.io.Serializable;

public class Monstre implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3121614623779670706L;
	String Nom;
	int HP;
	int PA;
	int PD;
	String Affinite;
	
	Monstre(String m, int pv, int pa,int pd,String aff){
		this.Nom = m;
		this.HP = pv;
		this.PA = pa;
		this.PD = pd;
		this.Affinite = aff;
	}
	
	public void PrintMonstre(Monstre M) {
		System.out.print(M.Nom+" ");
		System.out.print(M.HP+" ");
		System.out.println(M.PA);
		System.out.println(M.PD);
		System.out.println(M.Affinite);
	}
}
