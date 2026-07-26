
package school;

import java.time.LocalDate;

public class UnderGraduateStudent extends student{ 
    
    private int level;
    
    public UnderGraduateStudent(int studentID,String firstName,String lastName, 
            char gender, LocalDate dOB,String PhoneNumber, int level){
        super(studentID, firstName, lastName, gender, dOB, PhoneNumber);
    
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
        

    @Override
    public void displayStudentInfo(){
        super.displayStudentInfo();
        System.out.println("Level" + level);
    }


    
}
