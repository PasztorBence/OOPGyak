import java.util.Scanner;


public class CalculatorB {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter you calculation:");
		String calc = scanner.nextLine();
		
		double a = Double.parseDouble(calc.split(" ")[0]);
		double b = Double.parseDouble(calc.split(" ")[2]);
		
		String operator = calc.split(" ")[1];
		double end = Calculate(a,b,operator);
		System.out.println(end);
	}
	public static double Calculate(double a,double b , String operator ){
		double megoldas = 0;
		switch (operator) {
		case "+":
			megoldas = a+b;
			break;
		case "-":
			megoldas = a-b;
			break;
		case "/":
			if (b!=0) {
				megoldas = a/b;	
			}else {System.out.println("dont divide with 0");}
			break;
		case "*":
			megoldas = a*b;
			break;
		}
	return megoldas;	
	}
}