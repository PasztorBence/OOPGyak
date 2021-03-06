import java.util.Random;
import java.util.Scanner;


public class Array {

	public static void main(String[] args) {
		Rectangle[] rectangleArray = new Rectangle[10];
		
		Random random = new Random();
		
		//feltöltés
		for (int i = 0; i < rectangleArray.length; i++) {
			rectangleArray[i] = new Rectangle(random.nextInt(8)+2,random.nextInt(8)+2);
			//kiiratás
			System.out.println(rectangleArray[i]);
		}
		
		//legkissebb téglalap
		int smallestID = 0;
		for (int i = 1; i < rectangleArray.length; i++) {
			if (rectangleArray[i].getArea()<rectangleArray[smallestID].getArea()) {
				smallestID = i;
			}
		}
		System.out.println();
		System.out.println("the smallest rectangle: " + rectangleArray[smallestID]);

		//beolvasott téglalap
		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter A and B side: ");
		int sideA = scanner.nextInt();
		int sideB = scanner.nextInt();
		Rectangle scanned = new Rectangle(sideA,sideB);
		System.out.println(scanned);
		
		//kissebb téglalapok
		int smallerCount = 0;
		for (int i = 0; i < rectangleArray.length; i++) {
			if (scanned.biggerAreaThan(rectangleArray[i])) {
				smallerCount++;
			}
		}
		System.out.println("the count of smaller rectangles than the scanned: " + smallerCount);
	}

}
