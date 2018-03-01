import java.io.Serializable;

class Auto implements Serializable{		//==== A Serializable interf�sz: az objektumok soros b�jtfolyamm� alak�t�s�hoz sz�s�ges �n: jel�l� interf�sz
	private String rendszam;		//==== Az interf�sz met�dusait nem kell implement�lni, haszn�lata a soros b�jtfolyamm� alak�t�s k�pess�g�vel
	private String tipus;			//==== ruh�zza fel az oszt�lyt. En�lk�l nem lehet f�jlba �rni egy egyedileg l�trehozott objektumot!
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
	    return new StringBuffer(" Rendsz�m : ").append(this.rendszam)
		.append(", T�pus : ").append(this.tipus)
		.append(", �r : ").append(this.ar).toString();
	}
}