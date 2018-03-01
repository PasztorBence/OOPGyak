import java.util.Scanner;

public class TVProgram {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("TV-k darabszáma: ");
		int DB = Integer.parseInt(sc.nextLine());
		
		EladoTV[] T = new EladoTV[DB];
		
		String tipus;
		int kepatlo;
		int ar;
		boolean FullHD;
		
		int szam;

		int[] arak = new int[140000/5000];
		
		for (int i = 0; i < arak.length; i++) {
			
			arak[i] = 60000+((int)(Math.random()*29)+0)*5000;
		}
		
		for (int i = 0; i < T.length; i++) {
			tipus = "TV_"+i;
			
			kepatlo = (int)(Math.random()*25)+32;
			
			
			ar = arak[(int)(Math.random()*29)+0];
			
			if (((int)(Math.random()*2)+0) == 1)
				FullHD = true;
			else
				FullHD = false;
			
			T[i] = new EladoTV(tipus, kepatlo, ar, FullHD);
		}
		
		for (int i = 0; i < T.length; i++) {
			System.out.println(T[i]+", "+T[i].Minosito());
		}
		
		int megfeleldb = 0;
		
		for (int i = 0; i < T.length; i++) {
			if(T[i].Minosito().equals("Megfelelő"))
				megfeleldb++;
		}
		
		System.out.println(megfeleldb+" darab TV megfelelő,");
		
		sc.close();
	}
}
