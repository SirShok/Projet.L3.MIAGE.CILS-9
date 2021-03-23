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
	public String getAffinite(){
		return Affinite;
	}
	
	public void appliquerDegat(int degat){
		this.HP = this.HP - degat;
	}
	
	public void PrintMonstre(){
		System.out.print(this.Nom+" ");
		System.out.print(this.HP+" ");
		System.out.println(this.PA);
		System.out.println(this.PD);
		System.out.println(this.Affinite);
	}
}
