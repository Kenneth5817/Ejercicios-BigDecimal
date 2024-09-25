package ej5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class Account {
    //Atributos
    private int id;
    private BigDecimal balance;
    private Customer cliente;
    private boolean is_closed;
    private Date closed;

    //Constructor
    public Account(int id, BigDecimal balance, Customer cliente, boolean is_closed, Date closed) {
        this.id = id;
        this.balance = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
        this.cliente = cliente;
        this.is_closed = is_closed;
        this.closed = closed;
    }

        public void añadirDinero(BigDecimal amount) {
            balance = balance.add(amount).setScale(2, RoundingMode.HALF_UP);
        }

        public void hacerPago(BigDecimal amount) {
            balance = balance.subtract(amount).setScale(2, RoundingMode.HALF_UP);
        }

        public Customer getCustomer() {
            return cliente;
        }
    }

