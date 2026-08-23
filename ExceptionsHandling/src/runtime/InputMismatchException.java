
package runtime;

import java.util.Scanner;
public class InputMismatchException {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        try{
          System.out.print("Enter your age");
          int age = input.nextInt();
        
          System.out.printf("Your are %d years old", age);
        }
        catch(InputMismatchException e){
            System.out.println("Age is a number");
        }
    }
}
