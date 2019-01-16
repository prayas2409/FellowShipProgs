import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Utility U=new Utility();
		/*
		U.HeadsandTails();
		U.Username();
		U.leapYear();
		U.powerOfTwo();
		U.harmonicNumber();
		U.primeFactors();
		U.Gambler(20, 25, 1000);
		U.Coupon();
		U.Array2d();
		U.zeroTriplet();
		U.distance();
		U.permutations();
		U.stopWatch();
		U.ticTacToe();
		U.quadratic(10, 20, 20);
		*/
		double w=Double.parseDouble(args[0]);
		double v=Double.parseDouble(args[1]);
		U.windChill(w, v);
		
		
	}
}
