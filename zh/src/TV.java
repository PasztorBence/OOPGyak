
public class TV {
	private String tipus;
	protected int kepatlo;
	
	public TV(String tipus, int kepatlo) {
		this.tipus = tipus;
		this.kepatlo = kepatlo;
	}
	
	public void setParameter(int kepatlo){
		this.kepatlo = kepatlo;
	}
	
	public String toString(){
		return "Típus: "+tipus+", Méret: "+kepatlo;
	}
}
