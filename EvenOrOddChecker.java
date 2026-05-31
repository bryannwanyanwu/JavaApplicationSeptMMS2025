import java.util.Scanner;
public class EvenOrOddChecker{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		char option;
		
		do{
			System.out.print("Enter any number:  ");
			int num = scan.nextInt();
			
			
			if (num %2 == 0){
				System.out.printf("The number is aneven number");
			}
			else{
			System.out.printf("The number is aneven number");
			}
			System.out.print("Do you want to run the program again(Y/N):";
			option =scan.next.charArt(0);
		}while(option == 'Y' || option == 'Y');
		System.out.println("Good bye .................");
	}
}