package mypackage;

public class Cuboid extends Prism {
	
	private double aSide,bSide;

	public Cuboid(int height , double aSide ,double bSide) {
		super(height);
		this.aSide = aSide;
		this.bSide = bSide;
	}

	public double getBaseArea() {
		return aSide*bSide;
	}
	
	public String toString(){
		return "Cuboid [a=" + aSide +" ,b=" + bSide + "getHeight()=" + super.getHeight();
	}
	
}
