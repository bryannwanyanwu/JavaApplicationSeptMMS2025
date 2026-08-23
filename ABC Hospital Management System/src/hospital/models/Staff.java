
package hospital.models;

import java.time.LocalDate;

public abstract class Staff extends Person{
     private String staffid;
     private LocalDate employmentDate;
     private double salary;
     private Department department;
     
     public Staff(){
         
     }

    public Staff(String staffid, LocalDate employmentDate, double salary) {
        this.staffid = staffid;
        this.employmentDate = employmentDate;
        this.salary = salary;
    }

    public Staff(String staffid, LocalDate employmentDate, double salary,
            String firstName, String lastName, char gender, 
            LocalDate dateofBirth, String phone, String email,
            String street, String city, String country,String department) {
        
        super(firstName, lastName, gender, dateofBirth, 
                phone, email, street, city, country);
        this.staffid = staffid;
        this.employmentDate = employmentDate;
        this.salary = salary;
        this.Department = department;
    }

    public String getStaffid() {
        return staffid;
    }

    

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    
     
     
}
