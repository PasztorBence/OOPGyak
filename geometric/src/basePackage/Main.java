package basePackage;

import mypackage.Cylinder;
import mypackage.Cuboid;
import mypackage.Prism;

public class Main {

	public static void main(String[] args) {
		
		Database data = new Database(5);
		Prism cuboid = new Cuboid(4,2,3);
		
		Prism Cylinder1 = new Cylinder(4,6);
		Cylinder Cylinder2 = new Cylinder (4,3);
		
		data.setPrism(0, cuboid);
		data.setPrism(2, Cylinder1);
		data.setPrism(4, Cylinder2);
		
		for (int i = 0; i < data.getnu; i++) {
			
		}
	}

}
