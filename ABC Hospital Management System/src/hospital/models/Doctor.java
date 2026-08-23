
package hospital.models;

import java.time.LocalDate;

public class Doctor extends Staff{
    private String Specialization;
    private String licenseName;
    
    
    public Doctor(){
        
    }

    

    public Doctor(String Specialization, String licenseName, String staffid,
            LocalDate employmentDate, double salary, String firstName, 
            String lastName, char gender, LocalDate dateofBirth, 
            String phone, String email, String street, String city,
            String country, String department) {
        super(
                firstName, lastName,
                gender, dateofBirth, phone, email, street, 
                city, country, department);
        this.Specialization = Specialization;
        this.licenseName = licenseName;
    }
    
    

   
    

   
    }

    
    
    
            
}
