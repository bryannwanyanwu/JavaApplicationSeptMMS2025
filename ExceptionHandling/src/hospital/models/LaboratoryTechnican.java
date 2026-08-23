
package hospital.models;

import java.time.LocalDate;

public class LaboratoryTechnican extends Staff {
   private String qualification;
   private String licenseNumber;
   
   public LaboratoryTechnican(){
       
   }

    public LaboratoryTechnican( 
            String staffid, LocalDate employmentDate, double salary, 
            int id, String firstName, String lastName, char gender, 
            LocalDate dateofBirth, String phone, String email, 
            String street, String city, String country,
            String qualification, String licenseNumber,) {
        
        super(staffid, employmentDate, salary, id, firstName, 
                lastName, gender, dateofBirth, phone, email,
                street, city, country);
        this.qualification = qualification;
        this.licenseNumber = licenseNumber;
    }
   
   
}
