import java.util.Scanner;

public class TestHeadandTails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//gets the number of times coin will be flipped
		int coinflip=0;
		
		System.out.println("Enter the number of times the coin is flipped");
		Scanner s=new Scanner(System.in);
		coinflip=s.nextInt();
		
		HeadsandTails h=new HeadsandTails();
		coinflip=h.random(coinflip);
		
	}

}
