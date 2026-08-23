
package hospital.models;


public class MedicalRecord {
    private int id;
    private Patient patient;
    private LocalDate createdDate;
    
    private List <Diagnosis> diagnosis = new ArrayList<>();
    private List <Treatment> treatment = new ArrayList<>();
    private List <Laboratory> laboratory = new ArrayList<>();
    private List <Diagnosis> prescription = new ArrayList<>();
    private List <Diagnosis> admission  = new  ArrayList<>();
    
    public MedicalRecord(){
        
    }
}
