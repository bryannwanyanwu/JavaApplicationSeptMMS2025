
package hospital.models;

import java.time.LocalDate;

public class Nurse extends Staff {
    private String nursingLicense;
    private String qualification;
    private Department department;
    
    public Nurse(){
        
    }

   


    public Nurse(String nursingLicense, String qualification, 
            Department department, String staffid, LocalDate employmentDate,
            double salary, int id, String firstName, String lastName,
            char gender, LocalDate dateofBirth, String phone, 
            String email, String street, String city, String country) {
        
        super(
                firstName, lastName, gender, dateofBirth,
        phone, email, street, city, country.);
        this.nursingLicense = nursingLicense;
        this.qualification = qualification;
        this.department = department;
    }

    public String getNursingLicense() {
        return nursingLicense;
    }

    public void setNursingLicense(String nursingLicense) {
        this.nursingLicense = nursingLicense;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    
    
}
