import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class AutoBinProgram {
    private static Auto adat;			
    private static int db = 3;
    private static Auto[] arr = new Auto[10];			//==== Auto típusú 10 elemû tömb (helyesebb lenne rugalmas méretû tömböt használni:arraylist!)

    public static void main(String[] args) {
	arr[0] = new Auto("ABC-123", "Opel Astra", 2300000);
	arr[1] = new Auto("DDD-555", "Lada", 10000);
	arr[2] = new Auto("XYZ-294", "Skoda", 33555);		//==== A tömb elsõ 3 elemének feltöltése Auto egyedekkel

	Kiir(3);						//==== Adatok kiírása fájlba
	Beolvas();						//==== Visszaolvasás fájlból és adatok kiírása képernyõre

	arr[1].setAr(666);					//==== Adatmódosítás
        System.out.println("Adatmódosítás!");	

	arr[db] = new Auto("PAS-422", "Kia Soul", 450);		//==== Új adat felvitele a tömbbe
        System.out.println("Új adatsor létrehozása!");

	db++;							//==== A tömb méretének beállítása
	Kiir(db);						//==== Adatok kiírása fájlba
	Beolvas();						//==== Visszaolvasás fájlból és adatok kiírása képernyõre

/*	Megoldandó feladatok:
	- RendszamKeres("DDD-555");	-Adott rendszámra keresés, adatok kiírása képernyõre
	- RendszamTorol("DDD-555");	-Adott rendszámú autó törlése fájlból (Beolvasáskor a nem törlendõ autókat berakni egy tömbbe, és kiírni a tömb elemeit a fájlba!)
	- OsszAr();			-Összár kiolvasása a fájlból, kiírása képernyõre
	- Átírni a programot úgy, hogy ne fix méretû, hanem rugalmas méretû tömböt használjon (arraylist)
*/
    }
//===========
    public static void Kiir(int x) {
        try {
            FileOutputStream fstr = new FileOutputStream("k0.dat");
	    ObjectOutputStream oos = new ObjectOutputStream(fstr);
	    oos.writeInt(x);						//==== Elsõként a paraméterként kapott darabszám íródik ki Integerként
            for (int i = 0; i < x; i++) {
                oos.writeObject(arr[i]);				//==== A tömb elemeinek kiírása objektumként (ez szerializálás nélkül nem lehetséges!)
            }
            fstr.close();
            System.out.println("Adatok kiírva!");
        }
        catch (IOException ioe) {
            System.out.println("Fájl írási hiba: "+ioe.getMessage());
        }
    }
//===========
    public static void Beolvas() {
        try {
            FileInputStream fistr = new FileInputStream("k0.dat");
	    ObjectInputStream ois = new ObjectInputStream(fistr);
	    db = ois.readInt();						//==== A fájlban lévõ adatok számának beolvasása Integerként
	    Object o = null;
            for (int i = 0; i < db; i++) {				//==== A darabszámnak megfelelõ mennyiségû adat beolvasása objektumként
		o = ois.readObject();
	        adat = (Auto)o;						//==== Az objektumok átkonvertálása Auto egyedekké (deszerializálás)
		System.out.println(adat);
	    }
            fistr.close();
	} catch (Exception ie) {
            System.out.println("Fájl olvasási hiba: "+ie.getMessage());
        }
    }
}