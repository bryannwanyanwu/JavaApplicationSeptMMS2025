
package school;

import java.time.LocalDate;

public class Graduate extends student{
    
    private String finalYearProject;
    
    public Graduate(int studentID,String firstName,String lastName, char gender,
            LocalDate dOB,String PhoneNumber, String finalYearProject){
        super(studentID, firstName, lastName, gender, dOB, PhoneNumber);
        
        this.finalYearProject = finalYearProject;
    }
    
    @Override
    public void displayStudentInfo(){
        super.displayStudentInfo();
        System.out.println("Final Year Project" + finalYearProject);
    }


}
