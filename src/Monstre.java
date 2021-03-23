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
	
	public String getName(){
		return nom;
	}
	public int getHP(){
		return HP;
	}
	public int getPA(){
		return PA;
	}
	public int getPD(){
		return PD;
	}
	print String getAffinite(){
		retun Affinite;
	}
	
	
	public void PrintMonstre(){
		System.out.print(Nom+" ");
		System.out.print(HP+" ");
		System.out.println(PA);
		System.out.println(PD);
		System.out.println(Affinite);
	}
}
