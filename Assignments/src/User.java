
public class User {
	
	public	String mUsername; //variable to store user name
	public String mName;   // variable to store the name
	static int num;
    //constructor to provide values to 
	User(String username,String name){
		mUsername=username;
		mName=name;
		num++;
	}
	
	//Function to return name of person whose user name was provided
	String display() {
		return mName;
	}
}
