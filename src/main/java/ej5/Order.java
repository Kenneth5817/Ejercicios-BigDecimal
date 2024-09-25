package ej5;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    @Override
    public String toString() {
        return "Order{" +
                "nombre='" + nombre + '\'' +
                ", ordered=" + ordered +
                ", shipped=" + shipped +
                ", ship_to='" + ship_to + '\'' +
                ", status=" + status +
                ", total=" + total +
                '}';
    }

    private String nombre;
    private Date ordered;
    private Date shipped;
    private String ship_to;
    private Order status;
    private BigDecimal total;

    //Constructor
    public Order(String nombre, Date ordered, Date shipped, String ship_to, Order status, BigDecimal total) {
        this.nombre = nombre;
        this.ordered = ordered;
        this.shipped = shipped;
        this.ship_to = ship_to;
        this.status = status;
        this.total = total;
    }

}
