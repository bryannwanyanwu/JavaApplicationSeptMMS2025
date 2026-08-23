
package runtime;
import java.util.scanner;

public class ArithmeticExceptionHandling {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
      
        
        try{
        
            
        System.out.println("Dividing the first number by second number");
        System.out.print("Enter first number");
        int num1 = scan.nextInt();
        
        System.out.print("Enter second number");
        int num2 = scan.nextInt();
        
        int division = num1 / num2;
        System.out.printf("The result is %d%n", division);
        }
        catch(ArithmeticException e){
            System.out.println("Number can not be divided by zero");
        }
        finally{
            
        }
        }
        
        int
        
        int
    }
}
