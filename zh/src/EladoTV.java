
public class EladoTV extends TV {
	private int ar;
	private boolean FullHD;
	
	public EladoTV(String tipus, int kepatlo, int ar, boolean FullHD) {
		super(tipus, kepatlo);
		this.ar = ar;
		this.FullHD = FullHD;
	}
	
	public void setParameter(int kepatlo, int ar, boolean FullHD){
		this.kepatlo = kepatlo;
		this.ar = ar;
		this.FullHD = FullHD;
	}
	
	public String Minosito(){
		if(FullHD)
			return "Megfelelő";
		return "Nem megfelelő";
	}
	
	public String FullHDkiir(){
		if(FullHD)
			return "Igen";
		return "Nem";
	}
	
	public String toString(){
		return super.toString()+", Ár: "+ar+", FullHD: "+FullHDkiir();
	}	
}
