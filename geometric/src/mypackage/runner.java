package mypackage;

import mypackage.Cylinder;
import mypackage.Cuboid;
import mypackage.Prism;

public class runner {

	public static void main(String[] args) {
		
		Cylinder x = new Cylinder (10,20);
		System.out.println(x);
		System.out.println(x.getVolume());
		
		Cuboid y = new Cuboid (10,10, 10);
		System.out.println(y);
		System.out.println(y.getVolume());
	}

}
