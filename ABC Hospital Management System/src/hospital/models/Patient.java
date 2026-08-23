
package hospital.models;

import java.time.LocalDate;

public class Patient extends Person{
    private String patientId;
    private String bloodGroup;
    private String genotype;
    private String allegies;
    private String emergencyContact;
    private String emergencyPhone; 
    
    public Patient(){
        
    }

    public Patient(String patientId, String bloodGroup, String genotype,
            String allegies, String emergencyContact, String emergencyPhone,
            String firstName, String lastName, char gender,
            LocalDate dateofBirth, String phone,String email ,String street,
            String city, String country) {
        super(firstName, lastName, gender, dateofBirth,
                phone, <error>, street, city, country);
        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.genotype = genotype;
        this.allegies = allegies;
        this.emergencyContact = emergencyContact;
        this.emergencyPhone = emergencyPhone;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getGenotype() {
        return genotype;
    }

    public void setGenotype(String genotype) {
        this.genotype = genotype;
    }

    public String getAllegies() {
        return allegies;
    }

    public void setAllegies(String allegies) {
        this.allegies = allegies;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }
    
    
}
