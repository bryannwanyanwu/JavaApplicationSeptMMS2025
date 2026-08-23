
package hospital.models;

import java.time.LocalDate;

public abstract class Person {
    
    private int id;
    private String firstName;
    private String lastName;
    private char gender;
    private LocalDate dateofBirth;
    private String phone;
    private String email;
    private String street;
    private String city;
    private String country;
    
    public Person(){
        
    }

    public Person(int id, String firstName, String lastName, char gender, 
            LocalDate dateofBirth, String phone, String email, 
            String street, String city, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateofBirth = dateofBirth;
        this.phone = phone;
        this.email = email;
        this.street = street;
        this.city = city;
        this.country = country;
    }
    
    

   

    public int getId() {
        return id;
    }

    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
