import java.util.Scanner;

public class UserInput{
	public static void main(string[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your name");
		string name = input.nextLine();
		
		System.out.printf("Hello %s, you are welcome to NIIT",name);
	}
}