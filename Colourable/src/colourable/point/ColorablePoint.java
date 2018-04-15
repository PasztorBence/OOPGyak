package colourable.point;

import java.awt.Color;

public class ColorablePoint extends Point {
	
	private Color color;
	
	public ColorablePoint(int x,int y, Color color){
		super(x, y);
		this.color = color;
	}

}
