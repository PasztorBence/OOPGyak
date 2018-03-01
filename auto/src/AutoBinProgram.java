import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class AutoBinProgram {
    private static Auto adat;			
    private static int db = 3;
    private static Auto[] arr = new Auto[10];			//==== Auto t�pus� 10 elem� t�mb (helyesebb lenne rugalmas m�ret� t�mb�t haszn�lni:arraylist!)

    public static void main(String[] args) {
	arr[0] = new Auto("ABC-123", "Opel Astra", 2300000);
	arr[1] = new Auto("DDD-555", "Lada", 10000);
	arr[2] = new Auto("XYZ-294", "Skoda", 33555);		//==== A t�mb els� 3 elem�nek felt�lt�se Auto egyedekkel

	Kiir(3);						//==== Adatok ki�r�sa f�jlba
	Beolvas();						//==== Visszaolvas�s f�jlb�l �s adatok ki�r�sa k�perny�re

	arr[1].setAr(666);					//==== Adatm�dos�t�s
        System.out.println("Adatm�dos�t�s!");	

	arr[db] = new Auto("PAS-422", "Kia Soul", 450);		//==== �j adat felvitele a t�mbbe
        System.out.println("�j adatsor l�trehoz�sa!");

	db++;							//==== A t�mb m�ret�nek be�ll�t�sa
	Kiir(db);						//==== Adatok ki�r�sa f�jlba
	Beolvas();						//==== Visszaolvas�s f�jlb�l �s adatok ki�r�sa k�perny�re

/*	Megoldand� feladatok:
	- RendszamKeres("DDD-555");	-Adott rendsz�mra keres�s, adatok ki�r�sa k�perny�re
	- RendszamTorol("DDD-555");	-Adott rendsz�m� aut� t�rl�se f�jlb�l (Beolvas�skor a nem t�rlend� aut�kat berakni egy t�mbbe, �s ki�rni a t�mb elemeit a f�jlba!)
	- OsszAr();			-�ssz�r kiolvas�sa a f�jlb�l, ki�r�sa k�perny�re
	- �t�rni a programot �gy, hogy ne fix m�ret�, hanem rugalmas m�ret� t�mb�t haszn�ljon (arraylist)
*/
    }
//===========
    public static void Kiir(int x) {
        try {
            FileOutputStream fstr = new FileOutputStream("k0.dat");
	    ObjectOutputStream oos = new ObjectOutputStream(fstr);
	    oos.writeInt(x);						//==== Els�k�nt a param�terk�nt kapott darabsz�m �r�dik ki Integerk�nt
            for (int i = 0; i < x; i++) {
                oos.writeObject(arr[i]);				//==== A t�mb elemeinek ki�r�sa objektumk�nt (ez szerializ�l�s n�lk�l nem lehets�ges!)
            }
            fstr.close();
            System.out.println("Adatok ki�rva!");
        }
        catch (IOException ioe) {
            System.out.println("F�jl �r�si hiba: "+ioe.getMessage());
        }
    }
//===========
    public static void Beolvas() {
        try {
            FileInputStream fistr = new FileInputStream("k0.dat");
	    ObjectInputStream ois = new ObjectInputStream(fistr);
	    db = ois.readInt();						//==== A f�jlban l�v� adatok sz�m�nak beolvas�sa Integerk�nt
	    Object o = null;
            for (int i = 0; i < db; i++) {				//==== A darabsz�mnak megfelel� mennyis�g� adat beolvas�sa objektumk�nt
		o = ois.readObject();
	        adat = (Auto)o;						//==== Az objektumok �tkonvert�l�sa Auto egyedekk� (deszerializ�l�s)
		System.out.println(adat);
	    }
            fistr.close();
	} catch (Exception ie) {
            System.out.println("F�jl olvas�si hiba: "+ie.getMessage());
        }
    }
}