
package abstraction;

public class student  extends person {
    
    int studentID;
    
     public student(){
     }
     public student(String FirstName, String LastName,
             String phone, String address, int studentID){
               super(firstName, lastName, phone, address)
     }
     
    @Override
    void study() {
        System.out.println("student is studying");
    }
    void read(){
        @Override
        System.out.println(firstName + " " + lastName +
                " is reading");
    }
}
