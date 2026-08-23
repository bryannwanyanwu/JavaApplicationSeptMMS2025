
package hospital.models;

import java.time.LocalDateTime;

public class MedicationDispensing {
    private int id;
    private Prescription prescription;
    private PrescriptionItem prescriptionItems;
    private Pharmacist pharmacist;
    private Patient patient;
    private LocalDateTime DispensingDate;
    private int quantity;
    private String status;
    private String notes;
    
    public MedicationDispensing() {
    }
    
}
