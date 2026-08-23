
package hospital.models;

import java.time.LocalDate;

public class Payment {
    private int id;
    private Invoice invoice;
    private double amount;
    private LocalDate paymentDate;
    private String paymentMethod;
   
}
