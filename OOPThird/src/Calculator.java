import java.util.Scanner;


public class Calculator {
	public static void main(String[] args) {
		System.out.println("Kérem az első számot:");
		Scanner scannera = new Scanner (System.in);
		double a = scannera.nextDouble();
		System.out.println("Kérem a műveletet:");
		scannera = new Scanner (System.in);
		String muvelet = scannera.next();
		System.out.println("Kérem a második számot:");
		scannera = new Scanner (System.in);
		double b = scannera.nextDouble();
		switch (muvelet) {
		case "+":
			System.out.println("megoldás:"+(a+b));
			break;
		case "-":
			System.out.println("megoldás:"+(a-b));
			break;
		case "/":
			while (b==0) {
				if (b==0) {
					System.out.println("Nem oszthatunk 0-val, adj meg új számot");
					scannera = new Scanner (System.in);
					b = scannera.nextDouble();
				}
			}
			System.out.println("megoldás:"+(a/b));
			break;
		case "*":
			System.out.println("megoldás:"+(a*b));
			break;
		}
	}

}
