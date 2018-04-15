package basePackage;

import java.util.PrimitiveIterator.OfDouble;

import mypackage.Cylinder;
import mypackage.Prism;

public class Database {

	Prism[] prismArray;

	public Database(int numberOfElements){
		super();
		prismArray = new Prism[numberOfElements];
	}

	public void setPrism(int index, Prism prism){
		prismArray[index] = prism;
	}

	public Prism[] getPrismArray() {
		return prismArray;
	}

	public void setPrismArray(Prism[] prismArray) {
		this.prismArray = prismArray;
	}
	
	public Prism getPrismByIndex(int index){
		return prismArray[index];
	}
	
	public int getNumberOfNulls(){
		int counter = 0;
	
		for (Prism prism:prismArray) {
			
		}
		return counter;
	}
	
	public double getAvgVolume(){
		double avg = 0;
		int counter = 0;
		for (Prism prism : prismArray) {
			if (prism!=null) {
				avg+=prism.getVolume();
			}
		}
		return avg/getNumberOfNulls();
	}
	
	public int getNumberOfCylinder(){
		int counter = 0;
		for (Prism prism : prismArray) {
			if (prism instaceof Cylinder) {
				counter++;
			}
		}
	}
	
}
