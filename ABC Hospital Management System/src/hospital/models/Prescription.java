
package hospital.models;

import java.time.LocalDate;
import java.util.
public class Prescription {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private LocalDate prescriptionDate;
    
    private List<PrescriptionItem> Items = new ArrayList<>();
    
    public void removeItem(Prescription Item){
        Items.remove(Items);
    }
}
