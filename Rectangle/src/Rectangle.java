
public class Rectangle {

	private int sideA;
	private int sideB;
	
	public Rectangle(int sideA,int sideB) {
		this.sideA = sideA;
		this.sideB = sideB;
	}
	
	public Rectangle(int sides){
		this.sideA = sides;
		this.sideB = sides;
	}
	
	public int getArea (){
		return sideA*sideB;
	}
	
	public String toString(){
		return sideA + ", " + sideB + ": " + getArea();
	}
	
	public int getSideA() {
		return sideA;
	}
	
	public int getSideB() {
		return sideB;
	}
	
	public void setSides(int sideA,int sideB) {
		this.sideA = sideA;
		this.sideB = sideB;
	}

	public void setBothSides(int sides) {
		this.sideB = sides;
		this.sideA = sides;
		
	}
	
	public boolean biggerAreaThan(Rectangle rectangle){
		if (this.getArea() > rectangle.getArea()) {
			return true;
		}
		else return false;
	}
	
	public boolean hasSameSides(Rectangle rectangle){
		if (this.getSideA() ==rectangle.getSideA() && this.getSideB() == rectangle.getSideB()) {
			return true;
		}
		else return false;
	}
}
