/**
 * 
 * @author prayas
 * Created on 15 Jan 2018 
 * Version 11.0.1
 */
import java.awt.print.Printable;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Utility {
	
	Scanner s=new Scanner(System.in);
	
	//This class is used to create a linked list of users
	class Users{
		String username,name;
		Users next;
		Users(){
			this.next=null;
		}
		Users(String u,String n){
			this.username=u;
			this.name=n;
			next=null;
		}
	}

	 //genrates random number less than 1 for heads and Tails
	float generateRandom() {
		Random r1=new Random();
	
		float d= (float)r1.nextDouble();
		return d;
	}
	int HeadsandTails(){
		/**
		 * mHead counts number of times head was the result and not counting tails as count - head will be number of tails
		 * mRandom is random number between 0-1. 
		 */
		int mHead=0,num,counter=0;
		float mRandom=0;
		
		System.out.println("Enter the number of times the coin is flipped");
		num=s.nextInt();
		float val=0.5f;
		while(counter<num){
			
			mRandom=generateRandom();
			
			if(mRandom>val){ 
				mHead++;
			}	
			counter++;
		}
		//The result of int /int will be int hence converting 1 of them to float to get answer in decimals
		counter=(int)(((float)mHead/counter)*100);
		System.out.println("The Percent of head is "+counter+"and the percent of tails is "+(100-counter));

		return counter;	
		 }
	// close of Head and Tails
	
	Users insert(Users head,String u,String n){
		/*
		String u,n;
		System.out.println("Enter the username");
		u=s.next();
		System.out.println("Enter the name");
		n=s.next();
		*/
		Users user=new Users(u,n);
		if(head==null) {
			head=user;
		}
		else {
			Users travers=head;
			while (travers.next!=null) travers=travers.next;
			travers.next=user;
		}		
		return head;
	}
	
	//this traverses the link list to search for username
	void search(Users head,String uname){
		if(head==null){
		System.out.println("List empty");
		return;
		}
		else {
			Users travers=head;
			while (travers!=null) {
				if(travers.username.equals(uname)) {
					System.out.println("Hello "+travers.name+", how are you?");
					return;
				}
				travers=travers.next;
			}
			System.out.println("There is no such user");
			}
	}
	
	/*
	 * This function is to execute the Username search function
	 */
	void Username() {
		//to create linked list of users
		System.out.println("Inserting data into linked list");
		Users head=new Users();
		head=null;
		head=insert(head,"Raj1","Raj");
		head=insert(head,"Prayas2","Prayas");
		head=insert(head,"Chemy3","Chemy");
		
		String username;
		System.out.println("Enter the username to be searched");
		username=s.next();
		search(head,username);
		
		}
	
	/*
	 * This function is for Leap year
	 */
	 int input() {
		int year=0;
		System.out.println("Enter the year having only 4 digits");
		inside:
		do {	
		try {
			s = new Scanner(System.in);
			year=s.nextInt();
			
			if(year>9999 || year<1000) {
				System.out.println("Enter the year having only 4 digits");
			}
			else return year;
		
		}catch(InputMismatchException e){
		
			System.out.println("Enter the year as interger value");
	
			continue inside;
		}
		}while(year>9999 || year<1000);
		return year;
	 	}
		
	
	void leapYear() {
		int year=0;
			
		year=input();		
		
		if(year%100==0) {
			if(year%400==0) {
					System.out.println("The year is a leap year");
			}
			else System.out.println("The year is not a leap year");
		}
		else if(year%4==0) System.out.println("The year is a leap year");
		
		else System.out.println("The year is not a leap year");
	}

	void powerOfTwo(){
		int num=1,power=1,counter=0;
		System.out.println("Enter the number to get power of 2");
		power=s.nextInt();
		if(power>31 || power<0) {
			while(power>31) {
				System.out.println("Enter the number to get power of 2 less than 32");
				power=s.nextInt();
			}
		}
		for(int i=1;i<11;i++) {
		while(counter<power) {
			num=num*2;
			if(counter<power) {
			System.out.print(num+"x"+i+"="+num*i+" ");
			}
			counter++;
		}
		System.out.println();
		counter=0;
		num=1;
		}
		//System.out.println("2^"+power+"="+num);
		
	}

	void harmonicNumber() {
		int numerator=0,denominator=1,harmonicnum,counter=1;
		System.out.println("please enter the number to get the harmonic value");
		harmonicnum=s.nextInt();
		while(counter<=harmonicnum) {
			denominator=denominator*counter;
			counter++;
		}
		counter=1;
		while(counter<=harmonicnum) {
			numerator=(denominator/counter)+numerator;
			counter++;
		}
		
		System.out.println("The harmonic value for "+harmonicnum+" is "+numerator+"/"+denominator);
	}

	void primeFactors() {
		/**
		 * counter2 is to find the factor of the number is prime
		 * counter is the prime factor, flag indicates the factor is prime, flag2 indicates the number is prime 
		 */
		int counter2=2,counter=2,flag=0,flag1=0,number;
		
		System.out.println("Please enter the value to get the prime factors");
		number=s.nextInt();
		
		for(counter=2;(counter*counter)<=number;counter++) {
			if(number%counter==0){
				for(counter2=2;counter2<=(counter/2);counter2++) {
					if(counter%counter2==0) {
						flag=1;
						break;
					}
					
				}
				if(flag==0) {
					System.out.print(counter+" ");
					flag1=1;
				}
				flag=0;
			}	
		}
		if(flag1==0) {
		System.out.println("The number itself is prime number");
		}
	}

	void Gambler(int stake,int goal,int games) {
		int counter=0,win=0,bets=0;
		float n;
		while(counter<games && (stake>0 && stake<goal) ) {
			bets++;
			n=(float) Math.random();
			if(n>0.5) {
				stake++;
				win++;
				System.out.println(n+" win ");
			}
			else {
				stake--;
				System.out.println(n+" loss ");

			}
			counter++;
		}
		System.out.println("The number of wins are: "+win+", percentage of wins: "+(win*100/(bets)+", bets: "+bets));			
	}

	void Array2d() throws IOException {
		int rows,cols;
		System.out.println("Enter the number of rows and colums");
		rows=s.nextInt();
		cols=s.nextInt();
		int [][] array = new int[rows][cols];
		int i,j;
		
		System.out.println("Enter the ,members of 2d array");
		
		for(i=0;i<rows;i++) {
			for(j=0;j<cols;j++) {
				s=new Scanner(System.in);
				array[i][j]=s.nextInt();
			}
		}
		
		PrintWriter pwriter=new PrintWriter(System.out,true);
		
		/*for (i=0;i<rows;i++) {
			for(j=0;j<cols;j++) {
				pwriter.println(array[i][j]);
			}
		}*/
		OutputStreamWriter ocw= new OutputStreamWriter(System.out);
		for (i=0;i<rows;i++) {
			for(j=0;j<cols;j++) {
				ocw.write(array[i][j]);
			}
		}
		
	}

	void zeroTriplet() throws IOException{
		int []array= new int[8];
		int i,j,k,counter=0;
		
		PrintWriter write=new PrintWriter(System.out,true);
		write.println("Please enter the values for array of 8 digits");
		
		for(i=0;i<8;i++) {
			array[i]=s.nextInt();
		}
		for(i=0;i<6;i++) {
			for(j=i+1;j<7;j++) {
				for(k=j+1;k<8;k++) {
					if((array[i]+array[j]+array[k])==0) {
						System.out.println(array[i]+","+array[j]+","+array[k]);
						counter++;
					}
				}
			}
		}
		System.out.println("The number of triplets are "+counter);
	}

	void distance() {
		int x,y;
		System.out.println("Eter the vales of x and y");
		x=s.nextInt();
		y=s.nextInt();
		
		System.out.println("The distance from 0,0 to the current point is "+ (Math.sqrt(x*x+y*y)));
	}

	void permutations() {
		String array="Prayas";
		int i,j;
		
	}
}


