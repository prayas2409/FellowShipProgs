import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String username;
		//strings to get user name
		
		User U[]= {
			new User("Raj1","Raj"), new User("Prayas2","Prayas")
		};
		//Array of users
		
		System.out.println("Enter the username");
		Scanner s= new Scanner(System.in);
		username=s.nextLine();
		
		int i;
		
		//to check all the objects in array
		for(i=0;i<User.num;i++) {
					
			//to check user name is in our collection of user name
			if(username.equals(U[i].mUsername)) {
				System.out.println("Hello "+U[i].display()+", How are you?");
				break;
			}
		}
		if(i>=User.num) System.out.println("User not registered");
	
	}
}
