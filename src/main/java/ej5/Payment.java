package ej5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class Payment {
    //  Constructor
    public Payment(int paymentId, Date paid, BigDecimal total, String details) {
        this.paymentId = paymentId;
        this.paid = paid;
        this.total = total;
        this.details = details;
    }

    //Atributos
    private int paymentId;
    private Date paid;

    public BigDecimal getTotal() {
        return total;
    }

    private BigDecimal total;
    private String details;

        public void processPayment() {
            System.out.println("Procesando el pago de: " + total+" €");
        }
    }
