
package hospital.models;

import java.time.LocalDateTime;

public class Appointment {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime appointmentDate;
    private String status;
    private String notes;
}
