/**
 * 
 * @author prayas
 * Created on 15 Jan 2018 
 * Version 11.0.1
 */
import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Utility {
	
	static Scanner s=new Scanner(System.in);	
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
	void HeadsandTails(){
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
			
			mRandom=(float)Math.random();
			
			if(mRandom>val){ 
				mHead++;
			}	
			counter++;
		}
		//The result of int /int will be int hence converting 1 of them to float to get answer in decimals
		counter=(int)(((float)mHead/counter)*100);
		System.out.println("The Percent of head is "+counter+" and the percent of tails is "+(100-counter));
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
		 * counter2 is to find the factor of the number(counter) is prime
		 * counter is the prime factor, flag indicates the factor is prime, flag2 indicates the number is prime 
		 */
		int counter2=2,counter=2,flag=0,flag1=0,number;
		
		System.out.println("Please enter the value to get the prime factors");
		number=s.nextInt();
		
		for(counter=2;(counter*counter)<=number;counter++) {
			if(number%counter==0){
				for(counter2=2;counter2<=(counter/2);counter2++) {
					
					//if counter is  not prime
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

	void Coupon() {
		System.out.println("Enter the range of coupons");
		int random,countcoupons,counttotal=0,i,range=s.nextInt();
		int coupons[]= new int [range];
		int []array= new int[range];
				
		for(i=0;i<range;i++) {
			coupons[i]=i+1;
		}
		
		for(countcoupons=0;countcoupons<range;counttotal++) {
			random=(int)(Math.random()*(range+1));

				for(i=0;i<range;i++) {
					if(coupons[i]==random && array[i]==0) {
						array[i]=1;
						countcoupons++;
					}
				}
		}
		System.out.println("The number of times we tried to get all the coupons is "+counttotal);
		
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

		
	void permute(String upto, String remaining,int num) {
			num++;
			int i=0;
			String temp1=upto,temp2=remaining;
			
			if(remaining.isEmpty()) {
				System.out.print(" "+upto);
				return;
			}
			else {
				while(i<remaining.length()) {					
					upto=upto+remaining.charAt(i);
					remaining= new StringBuilder(remaining).deleteCharAt(i).toString();
					permute(upto,remaining,num);
					remaining=temp2; //getting back so that we can switch to next character
					upto=temp1;
					i++;
				}
			}
	}
	
	void permutations() {
		String array,temp,upto;
		String current;
		System.out.println("Enter the string");
		array=s.next();
		temp=array;
		int i;
		int []j= new int[array.length()];
		for(i=0;i<array.length();i++) {
					
			System.out.println("for "+array.charAt(i));
			current=""+array.charAt(i);
			temp=new StringBuilder(array).deleteCharAt(i).toString();
			permute(current,temp,1);
			System.out.println();
			temp=array;
			
		}	
	}

	void stopWatch() {
		
		/*
		 * start stores time when prog started and stop takes the time when enter key is hitted 
		 */
		double start=(System.nanoTime()/1000000000),stop=0;
		
		System.out.println("press enter key to stop ");
		s.hasNextLine();
			stop=System.nanoTime()/1000000000;
			System.out.println("Elapsed time between "+start+" and "+stop+" is "+(stop-start));
	}

	int valueAtPosition(int [][]array,int index) {
		int j,i=0,num=0;
		
		for(i=0;i<array.length;i++) {
			for(j=0;j<array.length;j++) {
				num++;
				if( num== index) { 
					return array[i][j];
				}
			}	
		}
		
	/*	switch(index){
			
		case 1: 
			return array[0][0];
		case 2: 
			return array[0][1];		
		case 3: 
			return array[0][2];
		case 4: 
			return array[1][0];
		case 5: 
			return array[1][1];
		case 6: 
			return array[1][2];
		case 7: 
			return array[2][0];
		case 8: 
			return array[2][1];
		case 9: 
			return array[2][2];	
		default:
			return 1;
		}
		*/	
		return 1;
	}
	
	int[][] enter(int [][]array,int index,int number) {
	
		int i=0;
		
		switch(index){
			
		case 1: 
			 array[0][0]=number;
			 return array;
		case 2: 
			 array[0][1]=number;
			 return array;
		case 3: 
			 array[0][2]=number;
			 return array;
		case 4: 
			 array[1][0]=number;
			 return array;
		case 5: 
			 array[1][1]=number;
			 return array;
		case 6: 
			 array[1][2]=number;
			 return array;
		case 7: 
			 array[2][0]=number;
			 return array;
		case 8: 
			 array[2][1]=number;
			 return array;
		case 9: 
			 array[2][2]=number;
			 return array;
		}
		return array;
	}
	
	int checkIfEnd(int a[][]) {
		int i,j,flag=1;
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				if(a[i][j]==0 || a[i][j]==1) continue;
				else flag=0;
			}
		}
		if(flag==1) {
			System.out.println("game over");
			return flag;
		}
		return flag;
	}
	
	int checkIfWon(int a[][],int val) {
		int flag=0;
		if(a[0][0]==val && ((a[0][1]==val && a[0][2]==val) || (a[1][0]==val && a[2][0]==val))){
			flag=1;
		}else if(a[1][1]==val && ((a[0][0]==val && a[2][2]==val)||(a[0][2]==val && a[2][0]==val))) {
			flag =1;
		}else if(a[1][0]==val && a[1][1]==val && a[1][2]==val) flag=1;
		else if(a[2][0]==val && a[2][1]==val && a[2][2]==val) flag=1;
		else if(a[0][2]==val && a[1][2]==val && a[2][2]==val) flag=1;
		else if(a[0][1]==val && a[1][1]==val && a[2][1]==val) flag=1;
		
		return flag;
	}

	void printGame(int array[][]) {
		int i,j;
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				
				if(array[i][j]==0) System.out.print("X");
				else if(array[i][j]==1) System.out.print("O");
				else System.out.print("-");
			}
			System.out.println();	
		}
	}
	
	void ticTacToe(){
		
		//0 for user 1 for comp
		
		int [][]array=new int[3][3];
		int i,j;
		
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				array[i][j]=2;
			}
			}
		
		System.out.println("Your positions are marked as X");
		int value,comp,flag=0;
		
		for(i=0;i<10;i++) {
			
			comp=(int)(Math.random()*10);
			value=valueAtPosition(array,comp);
			
			while(value==0 || value==1) {
				comp=(int)(Math.random()*10);
				value=valueAtPosition(array,comp);
			}
			
			array=enter(array,comp,1);
			flag=checkIfWon(array,1);
			if(flag==1) {
				System.out.println("You losse");
				printGame(array);
				return;
			}
			flag=checkIfEnd(array);
			if(flag==1) {
				printGame(array);
				return;
			}
			printGame(array);
			System.out.println("Enter the number from 1-9 where you'd like to place the point");
			s=new Scanner(System.in);
			comp=s.nextInt();
			value=valueAtPosition(array,comp);
			while(value==0 || value==1) {
				System.out.println("The point is already marked please enter the number");
				s=new Scanner(System.in);
				comp=s.nextInt();
				value=valueAtPosition(array,comp);
			}
			array=enter(array,comp,0);
			flag=checkIfWon(array,0);
			if(flag==1) {
				System.out.println("You Win");
				printGame(array);
				return;
			}
			flag=checkIfEnd(array);
			if(flag==1) {
				printGame(array);
				return;
			}
		}	
	

}
	
	void quadratic(int a,int b,int c) {
		double delta,srt;
		String sign;
		float rt1,rt2;
		System.out.println("The equation is "+a+"x^2+"+b+"x+"+c+"=0");
		
		delta=b*b-4*a*c;
		System.out.println("delta is "+delta);
		srt=Math.sqrt(delta);
		
		if(Double.isNaN(Math.sqrt(delta))) {
			delta=-delta;
			srt=Math.sqrt(delta);
			rt1=(float)(srt/2*a);
			rt2=(float)(-srt/2*a);
						
			if(rt2>0) sign="-";
			else sign="";
			
			System.out.printf("The roots of the equations are "+(-b/2*a)+"+"+rt1+"i and"+(-b/2*a)+sign+rt2+"i");
		}
		else {
			srt=Math.sqrt(delta);
			rt1=(float)((srt-b)/2*a);
			rt2=(float)((-srt-b)/2*a);
			System.out.printf("The roots of the equations are "+rt1+" and "+rt2);
		}
	}
	void windChill(double t,double v) {
		double w;
		//w=(0.4275*t)-35.75;
		//v=Math.pow(v,0.16);
		w=35.74+0.6215*t+((0.4275*t)-35.75)*(Math.pow(v,0.16));
		System.out.println("W= "+w+" and v= "+v);
		
	}	

	/*
		****************Algorithms******************
	*/
	
	char[] sortChar(char[] a){
		int i,j;
		char temp;
		for(i=0;i<a.length;i++) {
			for(j = i+1;j<a.length;j++) {
					if(a[i]>a[j]){
						temp=a[i];
						a[i]=a[j];
						a[j]=temp;
					}
			}
		}
		return a;
		
	}
	
	static int[] sortInt(int[] a){
		int i,j,temp;
		for(i=0;i<a.length;i++) {
			for(j = i+1;j<a.length;j++) {
					if(a[i]>a[j]){
						temp=a[i];
						a[i]=a[j];
						a[j]=temp;
					}
			}
		}
		for(i=0;i<a.length;i++) System.out.print(a[i]+" ");
		System.out.println();
		return a;
		
	}
	
	static String[] sortString(String[] a){
		int i,j,flag;
		String var1,var2,temp;
		for(i=0;i<a.length;i++) {
			for(j = i+1;j<a.length;j++) {
				//to compare by alphabets and not by cases
					var1=a[i].toLowerCase();
					var2=a[j].toLowerCase();
					flag=var1.compareTo(var2);
					if(flag>0){
						temp=a[i];
						a[i]=a[j];
						a[j]=temp;
					}
			}
		}
		for(i=0;i<a.length;i++) System.out.print(a[i]+" ");
		System.out.println();
		return a;
		
	}
	
	void anagram(String string1, String string2){
		int i,j,flag=0;
		
		if(string1.length()!=string2.length()) {
			//System.out.println("Strings are not anagrams");
			return;
		}
		
		char aS1[]=new char[string1.length()];
		char aS2[]=new char[string2.length()];
		
		for(i=0;i<string1.length();i++) {
			aS1[i]=string1.charAt(i);
		}
		for(i=0;i<string2.length();i++) {
			aS2[i]=string2.charAt(i);
		}
		aS1=sortChar(aS1);
		aS2=sortChar(aS2);
		//System.out.println(aS1);
		//System.out.println(aS2);

		for(i=0;i<string1.length();i++) {
			if(aS1[i]!=aS2[i]) {
				flag=1;
				break;
			}
		}
		if(flag==0) System.out.println("Strings "+string1+" and "+string2+" are anagrams");
		
		//else System.out.println("Strings are not anagrams");
		
	}
	
	int checkPrime(int num) {
		int j,flag=0;
		for(j=2;j<=num/2;j++) {
			if(num%j==0) {
				flag=1;
				break;
			}
		}
		
		return flag;
	}
	
	void prime() {
		
		int range,i,j,flag=0;

		System.out.println("Enter the range");
		range=s.nextInt();
		if(range>2) {
			System.out.println(" 2");
		}
		for(i=3;i<range;i++) {
			flag=checkPrime(i);
			if(flag==0) {
				System.out.println(" "+i+"");
				}
			flag=0;
		}
	}
	
	void anagramPrime() {
		
		int range,i,j,count=0,flag=0;
		System.out.println("Enter the range");
		range=s.nextInt();
		int primes[]=new int [range];
				
		for(i=3;i<range;i++) {
			flag=checkPrime(i);
			if(flag==0) {
				primes[count]=i; //storing the prime numbers in the array
				count++;
				}
			flag=0;
		}
		String prime1,prime2;
		for(i=0;i<count;i++) {
			prime1=Integer.toString(primes[i]);
			for(j=i+1;j<count;j++) {
				prime2=Integer.toString(primes[j]);
				anagram(prime1,prime2);
			}
		}
		for(i=0;i<count;i++) {
			prime1=Integer.toString(primes[i]);
			if(prime1.length()<2) continue;
			
			prime2=new StringBuffer(prime1).reverse().toString();
			
			if(prime1.equals(prime2)) {
				System.out.println(prime1+" is a palindrome");
			}
		}
	}

	
	static void binarySearch(int array[],int num){
			int i,length,low,high,mid;
		array=sortInt(array);
		length=array.length;
		
		low=0;
		high=length-1;
		
	
		for(i=0;i<length/2+1;i++) {
			mid=(low+high)/2;
			if(num==array[mid]) {
				System.out.println("Number found at position "+(mid+1));
				return;
			}
			if(num<array[mid]) {
				high=mid;				
			}
			else {
				low=mid+1;
			}
		}
		System.out.println("Number not found");
		
		}
	static void BinarySearch(String [] array,String num){
			
			array=sortString(array);
			int flag,i,length,low,high,mid;
			
			length=array.length;
			low=0;
			high=length-1;
			for(i=0;i<length;i++) {
				
				mid=(low+high)/2;
				
				//System.out.println("we are finding at "+mid+" and high = "+high);
				
				flag=num.compareTo(array[mid]);
				if(flag==0){
					System.out.println("string found at position "+(mid+1));
					return;
				}
				
			//	System.out.println(" "+flag+" when compared "+num+", "+array[mid]);
				if(flag<0) {
					high=mid;		
				}
				else {
					low=mid+1;
				}
			}
			System.out.println("String not found");
			
		}
	
	static int [] swipeInt(int array[],int index,int till) {
		int j;
		for(j=index;j>=1;j--) {
			array[j]=array[j-1];
		}
		return array;
	}
	
	static String [] swipeString(String array[],int index,int till) {
		int j;
		for(j=index;j>=till+1;j--) {
			array[j]=array[j-1];
		}
		return array;
	}
	
	
	static int[] insertionSort(int []array,int length) {
		int i,j,temp,index;
	
		for(j=0;j<length;j++) {	
		//System.out.println("In j= "+j);
			for(i=j+1;i<length;i++) {
					if(array[j]>array[i]) {
					temp=array[i];
					index=i;
					array=swipeInt(array,index,i);
					array[j]=temp;		
				//	System.out.println("Array after swipe ");
					//for(int c=0;c<length;c++)System.out.print(" "+array[c]);
				//	System.out.println();						
				}
			}
		}
		//System.out.println("The sorted array is");
		//for(i=0;i<length;i++) System.out.print(" "+array[i]);
		return array;
	}
	
	static String[] insertionSortString(String[]array,int length) {
		int i,j,index;
		String temp;	
		
		for(j=0;j<length;j++) {	
		//System.out.println("In j= "+j);
			for(i=j+1;i<length;i++) {
					if(array[j].compareTo(array[i])>1) {
					temp=array[i];
					index=i;
					array=swipeString(array,index,i);
					array[j]=temp;		
					//System.out.println("Array after swipe ");
				//	for(int c=0;c<length;c++)System.out.print(" "+array[c]);
				//	System.out.println();						
				}
			}
		}
	//	System.out.println("The sorted array is");
		//for(i=0;i<length;i++) System.out.print(" "+array[i]);
		return array;
	}
	
	static int[] bubbleSortInt(int []array,int length) {
		
		int i,j,temp;
			for(i=0;i<length;i++) {
			for(j=0;j<length-1;j++) {
				if(array[j]>array[j+1]) {
					temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		//System.out.println("The sorted array is");
	//	for(i=0;i<length;i++) System.out.print(" "+array[i]);
			return array;
	}
	
	static String[] bubbleSortString(String []array,int length) {
		
		int i,j;
		String temp;
			
		for(i=0;i<length;i++) {
			for(j=0;j<length-1;j++) {
				if(array[j].compareTo(array[j+1])>1) {
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
//		System.out.println("The sorted array is");
//		for(i=0;i<length;i++) {
//			System.out.print(" "+array[i]);
//		}
		return array;
	}

	static void callSortandSearch() {
		
		double start=0,stop=0;
		
	int intlength,stringlength,i,j;
	System.out.println("Enter the length of integer array");
	intlength=s.nextInt();
	int []array= new int[intlength]; //integer array
	System.out.println("Enter the array");
	for(i=0;i<intlength;i++) array[i]=s.nextInt();
	
	System.out.println("Enter the length of string array");
	stringlength=s.nextInt();
	String [] stringarray=new String[stringlength]; 
	System.out.println("Enter the array");
	
	for(i=0;i<stringlength;i++) stringarray[i]=s.next();
			//stopwatch
	double []times= new double[6];	
	String []S=new String[6];
	
			start=System.nanoTime();
			array=insertionSort(array,intlength);
			stop=System.nanoTime();
			times[0]=stop-start;
			S[0]="InsertionsortInt";
			
			System.out.println("After insertion sort int");
			
			start=System.nanoTime();
			stringarray=insertionSortString(stringarray,stringlength);
			stop=System.nanoTime();
			times[1]=stop-start;
			S[1]="InsertionsortString";
			
			System.out.println("After insertion sort string");
			
			start=System.nanoTime();
			array=bubbleSortInt(array,intlength);
			stop=System.nanoTime();
			times[2]=stop-start;
			S[2]="bulleSortInt";

			System.out.println("After bubble sort int");
			
			start=System.nanoTime();
			stringarray=bubbleSortString(stringarray,stringlength);
			stop=System.nanoTime();
			times[3]=stop-start;
			S[3]="bubbleSortString";
			
			System.out.println("After bubble sort string");
			
			System.out.println("Enter the number to be searched");
			int num=s.nextInt();
			
			start=System.nanoTime();
			binarySearch(array,num);
			stop=System.nanoTime();
			times[4]=stop-start;
			S[4]="binarysearchint";
			
			System.out.println("After binary search int");
			
			System.out.println("Enter the string to be searched");
			String search=s.next(); 
			start=System.nanoTime();
			BinarySearch(stringarray,search);
			stop=System.nanoTime();
			times[5]=stop-start;
			S[5]="binarysearchString";
			
			System.out.println("After binary search String");
			
			double t;
			String change;
			
			for(i=0;i<times.length;i++) {
				for(j=0;j<times.length-1;j++) {
					if(times[j]<times[j+1]) {
						t=times[i];
						change=S[i];
						times[i]=times[j];
						S[i]=S[j];
						times[j]=t;
						S[j]=change;
					}
				}
			}
			//printing the times taken 
			System.out.println("Times in descending order are");
			
			for(i=0;i<times.length;i++) System.out.println("Time for :"+S[i]+" is "+times[i]+" milliseconds");
			
		}

	//to check a number is a power of 2
	int power=1;

	int check2Power(int num) {
		int flag=0;
		while(num%2==0) {  //num divisible by 2
			if(num%2==0) { 
				num=num/2;
				power++;
			}
			if(num/2==1 && num%2==0) { //checking basically for num 2 when 2 comes at last after dividing it is a power of 2
				flag=1;
				break;
			}
		}
		return flag;
}
	
	void guessGame(int num) {
		
		System.out.println("Thank you for entering the number:"+num+" let me check");
		int t,low,high,mid;
		int flag=check2Power(num);
		 
		while(flag==0) {
			System.out.println("Please enter the number which is a power of 2 only");
			power=1; // class variable to calculate value of n in 2^n
			num=s.nextInt();
			
			flag=check2Power(num);
		}
		int []array=new int[num];
		for(t=0;t<num;t++) array[t]=t;
		low=0;
		high=num-1;
		//System.out.println(power);
		for(;power>0;power--) {
						
				mid=(low+high)/2;
				
				System.out.println("Is the number "+array[mid]+" If yes type 'true' else type 'false'");
					if(s.nextBoolean()==true) {
					System.out.println("You won");
					return;
				}
				else {
					System.out.println("Is the number more than "+array[mid]+" ? If yes type 'true' else type 'false");
										
					if(s.nextBoolean()==true) low=mid+1;	
					
					else high=mid;
				}
		}	
	System.out.println("Number not found");
	}
	
	void wordList() throws IOException {
		
		int i,j,k,count=0,t=0;
		String strings;
		/*
		FileWriter fw=new FileWriter("WordList.txt");
		
		System.out.println("Please enter the number of words you wish to add to file");
		i=s.nextInt();
		System.out.println("Please enter the words ");

		for(j=0;j<i;j++) {
			strings=s.next();
			fw.write(strings);
			if(j<i-1) fw.write(',');//add , at end of each word but not for the last word.
		}
		System.out.print("lines added sucessfully");
		fw.close();
		*/
		FileReader fr=new FileReader("WordList.txt");
		
		/*
		for(j=0;fr.read()!=-1;j++) {
			fr.read();
		}
		*/
		//fr.close();
		String ch,data[]=new String[10];		//data has complete line read from the file
		
		BufferedReader br=new BufferedReader(new FileReader("WordList.txt"));
		i=0;
		 do {
			 
			ch=br.readLine();
			
		//	if(ch==null) break;
			data[i]=ch; //enter each line to data
			i++; //counting number of lines;
		 }while(ch!=null);
		
		 
		 char c;
		 String s[]; 
		 j=0;
		 while(j<i) {  //j less than number of lines in file
			 k=0;
			 t=0;
			 count=0;
			 if(i==(j+1)) break;
			 while(k<data[j].length()) {
				 c=data[j].charAt(k);
				
				 if(c==',') count++; //count is counting number of ',' to know number of words in the jth line. 
				 k++;
			 }
			 
			 s=new String[count+1]; //string of number of words in first line
			 for(k=0;k<count+1;k++) {  //till number of words in each line are over k = number of words
				 s[k]=""; //adding each word to array of strings and default the first char of string is empty
				 
				 c=data[j].charAt(t); //each char of jth line
				 for(;t<data[j].length();t++) { 
					 
					 c=data[j].charAt(t); 
					 if(c==',') { 
						 t++;
						 break;
					 }
					 s[k]=s[k]+c;
				 }
		//		 System.out.println("word "+s[k]);
			 }
			 System.out.println("Strings in "+(j+1)+"st line are");
			 for(t=0;t<=count;t++) {
				 System.out.println(s[t]);
			 }
			 j++;
		 }
	
	}

	char[] swipeChar(char []array,int index,int till) {
		int j;
		for(j=index;j>=till+1;j--) {
			array[j]=array[j-1];
		}
		return array;
	}
		
	void insertionsortinstring() {
		
		int i,j,index;
		char temp;
		String string;
		System.out.println("Enter the string ");
		string=s.next();
		char array[]=new char[string.length()];
		for(i=0;i<string.length();i++) {
			array[i]=string.charAt(i);
		}
		
		for(j=0;j<string.length();j++) {	
			//System.out.println("In j= "+j);
				for(i=j+1;i<string.length();i++) {
						if(array[j]>array[i]) {
						temp=array[i];
						index=i;
						array=swipeChar(array,index,j);
						array[j]=temp;		
						System.out.println("Array after swipe ");
						for(int c=0;c<array.length;c++)System.out.print(" "+array[c]);
						System.out.println();						
					}
				}
			}
		System.out.println("After sort");
		for(int c=0;c<array.length;c++)System.out.print(array[c]);
	}
	
	void bubbleIntList() {
		
		int n,i,j,temp;
		ArrayList<Integer> intlist=new ArrayList<Integer>();
		System.out.println("Enter the numbers of intergers");
		n=s.nextInt();
		System.out.println("Enter the numbers for integers array");
		//Enter elements in list
		for(i=0;i<n;i++) intlist.add(i,s.nextInt());
		
		for(i=0;i<n-1;i++) {
			for(j=0;j<n-1;j++) {
				if(intlist.get(j)>intlist.get(j+1)) {
					temp=intlist.get(j);
					intlist.set(j,intlist.get(j+1));
					intlist.set(j+1,temp);
				}
			}
		}
		System.out.println("The sorted list after sorting is ");
		for(i=0;i<n;i++) System.out.print(" "+intlist.get(i));

	}	

	int count=0;
	
	String [] combine(String a[],int la,String b[],int lb) {
		
		/*
		 * j for total array combined,i for a, k is for b
		 */
		int j,i=0,k=0;
		
//		System.out.print("combining ");
//		for(i=0;i<la;i++)System.out.print(a[i]);
//		System.out.print(" and ");
//		for(i=0;i<lb;i++)System.out.print(b[i]);
//		System.out.println();
		
		String []c=new String [la+lb];
		i=0;
		for(j=0;j<c.length;j++) {
			
			if(k>=lb && i<la) {
				c[j]=""+a[i];
				i++;
			}
			else if(i>=la && k<lb) {
				c[j]=""+a[k];
				k++;
			}
			else {	
		if(b[k].compareTo(a[i])<1 && k<lb) {
			c[j]=""+b[k];
			k++;
		}else if(b[k].compareTo(a[i])>1 && i<la){
			c[j]=""+a[i];
			i++;		                           
		}
			
	}
		}
		for (i=0;i<=(la+lb-1);i++) System.out.print(" "+c[i]);
		System.out.println();
		
		return c;
	}

	String [] merge(String a[],int low,int high) {
		
		
		int i,mid=low+(high-low)/2;
		String r1[]=new String [mid-low+1],r2[]= new String[high-mid];
		String c[]=new String[high-low+1];
		if(low<high) {
//			System.out.print("Merging ");
//			for(i=low;i<=mid;i++) System.out.print(a[i]);
//			System.out.println();
			
			r1=merge(a,low,mid); //storing 1st half 
		
//			System.out.print("Merging ");
//			for(i=mid+1;i<=high;i++) System.out.print(a[i]);
//			System.out.println();
			
			r2=merge(a,mid+1,high);
			
			c=combine(r1,(mid-low+1),r2,high-mid); //storing results of both the arrays 
			
			return c;
		}	
		else {
			c[0]=""+a[low];
			return c;
		}
		}	
	
	void mergeSort() {
		
		int i,j;
		
		System.out.println("Enter the size of array");
		i=s.nextInt();
		String a[]=new String[i];
		System.out.println("Enter the elements in the array");
		for(j=0;j<i;j++) a[j]=s.next();
		
		a=merge(a,0,i-1);
		System.out.println("After sort ");	
		for(j=0;j<i;j++) System.out.println(a[j]+" ");		
	}

	
	void dayofWeek() {
		int d,y,m,y0,x,m0,d0;
		
		System.out.println("plese entger the date in dd mm yy format ");
		d=s.nextInt();
		m=s.nextInt();
		y=s.nextInt();
		
		y0=y-(14-m)/12;
		x=y0+y0/4-y0/100+y0/400;
		m0=m+12*((14-m)/12)-2;
		d0=(d+x+(31*m)/12)%7;
		
		String months[]=new String[] {
				"January","Feb","March","April","May","June","July","August","September","October","November",
						"December"
		};
		String days[]= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
				
		System.out.println("The day on this date is "+days[d0-1]);
	
	}
		
	void temprature() {
			
			System.out.println("To convert temprature from celcius to farenheit press 1");
			System.out.println("To convert the temprature from farenheit to celcius press 2");
			int i=s.nextInt();
			System.out.println("Enter the temprarture");
			float temp=s.nextFloat();
			
			if(i==1) System.out.println((temp*9/5)+32+"F");
			else System.out.println((temp-32)*5/9+"C");
		}
	
	void vendingMachine() {
		
		int count=0,num,i,noteno,atm[]={
				1000,500,100,50,10,5,2,1
		};
		
		System.out.println("Enter the amount to be withdrawn ");
		num=s.nextInt();
		for(i=0;i<atm.length && num>0;i++) {
			if(num/atm[i]>0) {
				noteno=num/atm[i];
				count=count+noteno;
				num=num-(noteno*atm[i]);
				System.out.println("number of "+atm[i]+"'s note required: "+noteno);
				noteno=0;
			}
		}
		System.out.println("Minimun number of notes required: "+count);
	}

	void monthlyPayment() {
		
		int P,Y,R;
		float n,r,payment,deno;
		System.out.println("Enter the values of Principal loan,  Years and Rate of interest");
		
		P=s.nextInt();
		Y=s.nextInt();
		R=s.nextInt();
		
		n=12*Y;
		r=R/1200f;
		System.out.println("r: "+r);
		deno=1+r;
		System.out.println("1+r: "+deno);
		
		//calculating (1+r)^n
		
		for(int i=1;i<n;i++) {
			deno=deno*(1+r);
		}
		
		deno=(float) (1.0/deno);
		
		payment=(P*r)/(1-deno);

		//System.out.println("The interest amount is "+(R*P/100));
		System.out.println("The payment to be done monthly is "+payment);
	}

	void sqrt() {
		
		System.out.println("Enter the value for which you wish to find the square root");
		
		double c=s.nextDouble(),t=c;
		
		while(Math.abs(t-c/t)>1e-15) t=(t+c/t)/2;
		
		System.out.println("The square root of "+c+" is "+t);
	}

	int [] toBinary(int num) {
		
		int count,i=0,power=1;
		
		//calculating the power of 2 just greater than number
		for(;num>=power;i++) {
			power*=2;
		}
		
		
		/*
		 * count will keep track of n in 2^n
		 * values store 1,2,4,8
		 * nums store which number will be used to calculate the number
		 */
		count=i;
		int values[]=new int [i], nums[]=new int[i];
		//storing values 16 8 4 2 in values
		for(i=0;power>1;i++) {
			power=power/2;
			values[i]=power;
		} 
		count=i;
		for(i=0;i<count;i++) System.out.print(" "+values[i]);
		System.out.println();
		i=0;
		while(num>0) {
			// printing 1 for only those numbers which will be used to calculate  number
			//also storing the value 1 for the numbers that are used
			if(num>=values[i]) {
				num=num-values[i];
				nums[i]=1;
				System.out.print("1");
			}else System.out.print("0");
			i++;
		}
		System.out.println();
		count--;
		int nums8bit[]=new int[8];
		for(i=7;count>=0;i--) {
			nums8bit[i]=nums[count];
			count--;
		}
		System.out.println("In 8 bits");
		for(i=0;i<8;i++) System.out.print(nums8bit[i]);
		System.out.println();
		
		return nums8bit;
	}
	int twoPowerN(int a) {
		
		int i,num=1;
		for(i=0;i<a;i++) {
			num*=2;
		}
		return num;
	}
	
	void nibblesSwap() {
		
		System.out.println("Enter the number ");
		int temp,i,num=s.nextInt();
		int[] binnum = new int [8];
		binnum=toBinary(num);
		
		for(i=0;i<4;i++) {
			temp=binnum[i];
			binnum[i]=binnum[4+i];
			binnum[4+i]=temp;
		}
		System.out.println("New binary array is ");
		for(i=0;i<8;i++) System.out.print(binnum[i]);
		System.out.println();
		num=0;
		for(i=0;i<8;i++) {
			if(binnum[i]==1) {
				num=num+twoPowerN(7-i);
			}
		}
		System.out.println("new number is "+num);
		
		if(check2Power(num)==1) System.out.println(num+" is a power of 2");
		else System.out.println(num+" is not power of 2");
		
		
	}

	/*
	 * 	**********************Data Structure************************
	 */

		
	
}
	