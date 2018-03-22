
public class Main {

	public static void main(String[] args) {
		
		Rectangle a = new Rectangle(6,4);
		Rectangle b = new Rectangle(3);
		Rectangle c = a;
		
		System.out.println(a + "\n" + b + "\n" + c);
		
		a.setSides(5,6);

		System.out.println();
		System.out.println(a + "\n" + b + "\n" + c);
		
		a.setBothSides(3);
		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(a.hasSameSides(b));
	}

}
