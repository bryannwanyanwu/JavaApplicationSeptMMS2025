
package hospital.models;

import java.time.LocalDate;

public class Phamacist extends Staff{
    private String qualification;
    private String licenseNumber;
    
    public Phamacist(){
       
   }

    public Phamacist(String qualification, String licenseNumber, String staffid, LocalDate employmentDate, double salary, String firstName, String lastName, char gender, LocalDate dateofBirth, String phone, String email, String street, String city, String country) {
        
        super(staffid, employmentDate, salary, id, firstName, lastName, gender, dateofBirth, phone, email, street, city, country);
        this.qualification = qualification;
        this.licenseNumber = licenseNumber;
    }
    
    
    
}
