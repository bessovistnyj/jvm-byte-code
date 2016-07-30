package triangle;
	
	public class MaxLength{
		
		double sideA;
		double sideB;
		double sideC;
		
		public MaxLength(double sideA,double sideB,double sideC){

			this.sideA = sideA;
			this.sideB = sideB;
			this.sideC = sideC;
		}
		
		public double maxLength(){
		
			double maxLengthSide = this.sideA;
			
			maxLengthSide = Math.max(this.sideA,Math.max(this.sideB,this.sideC));
			return maxLengthSide;
		}
	
	}