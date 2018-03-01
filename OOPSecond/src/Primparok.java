
public class Primparok {
	public static void main(String[] args) {
		
	}
 public static boolean IsPrime (int szam){
	 boolean vissza = true;
	 for (int i = 2; i < szam/2; i++) {
		if (szam%i==0) {
			vissza = false;
			break;
		}
	}
	 return vissza;
 }
}
