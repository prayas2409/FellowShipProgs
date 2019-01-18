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

		
	void permute(char currentchar,String array,int num,String upto,int originallength) {
		int i;
		num++;
		
	//	System.out.println("Received "+currentchar+" "+array);
		if(num==originallength-1) {
			System.out.println("String is "+upto+" "+currentchar);
			return;
		}
		else {
			for(i=0;i<originallength-num;i++) {
				
		//		System.out.print(currentchar);
		
				currentchar=array.charAt(i);
				upto=upto+currentchar;
				String temp=new StringBuffer(array).deleteCharAt(i).toString();
				//upto=Character.toString(array.charAt(i));
		//		System.out.println("sending "+currentchar+" "+ array);
				permute(currentchar,temp,num,upto,originallength);
				upto=new StringBuffer(upto).delete(originallength-num,(originallength-1)).toString();
				temp=array;
			}
			return;
		}
	}
	
	void permutations() {
		String array,temp,upto;
		char currentchar;
		System.out.println("Enter the string");
		array=s.next();
		temp=array;
		int i;
		int []j= new int[array.length()];
		for(i=0;i<array.length();i++) {
			System.out.println(i);
			temp= new StringBuilder(array).deleteCharAt(i).toString();			
			currentchar=array.charAt(i);	
			//findString(currentchar,temp,"",0,j,i,array.length()); 
			System.out.println("for "+array.charAt(i));
			permute(currentchar,temp,0,Character.toString(array.charAt(i)),array.length());
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
	
	static String [] swipeInt(String array[],int index,int till) {
		int j;
		for(j=index;j>=1;j--) {
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
					array=swipeInt(array,index,i);
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
		while(num%2==0) {
			if(num%2==0) {
				num=num/2;
				power++;
			}
			if(num/2==1 && num%2==0) {
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
	
	void wordList() {
		
		
		
	}
	
}