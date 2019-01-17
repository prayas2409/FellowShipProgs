import java.io.IOException;

import java.util.Scanner;


public class Test {
	
	static Scanner s= new Scanner(System.in);
	
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
		U.windChill();
		double t=Double.parseDouble(args[0]);
		System.out.println("w= "+t);
		double v=Double.parseDouble(args[1]);
		System.out.println("v= "+v);
		
		U.anagram();
		U.anagramPrime();
		*/
		
		System.out.println("Enter the size of array");
		int j,i=s.nextInt();
		/*
		 * int [] array=new int[i];
		System.out.println("Enter the array");
		for(int j=0;j<i;j++) {
			array[j]=s.nextInt();
		}
		System.out.println("Enter the number to be searched");
		i=s.nextInt();
		*/
		String array[]=new String[i];
		System.out.println("Enter the array");
		for(j=0;j<i;j++) {
			array[j]=s.next();
		}
		System.out.println("Enter the string to be searched");
		String search=s.next();
		Utility.BinarySearch(array,search);
		
		}
}
