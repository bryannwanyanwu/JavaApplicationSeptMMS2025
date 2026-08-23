package runtime;


public class ArrayOutOfBoundException {
    public static void main(String[] args){
        int[] age = {16, 21, 19, 20 14};
    try{
        System.out.println("element at index 5 is "+ age[5]);
        }
    catch (ArrayIndexOutOfBoundException e){
       system.out.println("Invalid array index");
       

    }
    
 }
}

