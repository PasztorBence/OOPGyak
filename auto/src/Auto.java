import java.io.Serializable;

class Auto implements Serializable{		//==== A Serializable interfész: az objektumok soros bájtfolyammá alakításához szüséges ún: jelölõ interfész
	private String rendszam;		//==== Az interfész metódusait nem kell implementálni, használata a soros bájtfolyammá alakítás képességével
	private String tipus;			//==== ruházza fel az osztályt. Enélkül nem lehet fájlba írni egy egyedileg létrehozott objektumot!
	private int ar;

    	public Auto (String rendszam, String tipus, int ar) {
	    this.rendszam = rendszam;
	    this.tipus = tipus;
	    this.ar = ar;
   	}

	public void setAr(int ar) {
	    this.ar = ar;
	}
	public String getRendszam() {
	    return rendszam;
	}

	@Override
	public String toString() {
	    return new StringBuffer(" Rendszám : ").append(this.rendszam)
		.append(", Típus : ").append(this.tipus)
		.append(", Ár : ").append(this.ar).toString();
	}
}