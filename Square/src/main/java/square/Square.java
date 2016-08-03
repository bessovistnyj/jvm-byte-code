package square;

public class Square {
	double a;
	double b;
	double c;
	
	public Square(double a,double b,double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public float calculate(int x) {
		float result;

			result = (float) (this.a * Math.pow(x,2)+ this.b * x + this.c);
			return result;
		}
	
	public void main(String[] args){
		int x1   = 	Integer.valueOf(args[3]);
		int x2   = 	Integer.valueOf(args[4]);
		int step = 	Integer.valueOf(args[5]);
		
		Square square = new Square(Double.valueOf(args[0]),Double.valueOf(args[1]),Double.valueOf(args[2]));
				
		for(int count = x1; count < x2; count = count+step){
			float result = square.calculate(count);
			System.out.println(result);
			
		}
		
	}
}

