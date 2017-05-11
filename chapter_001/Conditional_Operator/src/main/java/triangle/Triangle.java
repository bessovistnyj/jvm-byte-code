package triangle;	
	
public class Triangle {
	public Point a;
	public Point b;
	public Point c;

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double area() {
		double sideA = this.a.distanceTo(this.b);
		double sideB = this.a.distanceTo(this.c);
		double sideC = this.b.distanceTo(this.c);
		
		double area;	
		
		
		if ((sideA + sideB) > sideC & (sideB + sideC) > sideA & (sideC + sideA) > sideB) {
			double perimeter = (sideA+sideB+sideC)/2;
			area = Math.sqrt(perimeter*(perimeter-sideA)*(perimeter-sideB)*(perimeter-sideC));
			
		} else {
			area = -1;
		}
		return area;
	}
}