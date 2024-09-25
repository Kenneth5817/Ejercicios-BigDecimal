package ej5;

import java.math.BigDecimal;
import java.util.function.Supplier;

public class Product {
    // Atributos
    private int id;
    private String name;
    private BigDecimal price; // Atributo de precio
    private Supplier supplier;

    // Constructor
    public Product(int id, String name, BigDecimal price, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.price = price; // Inicialización del precio
        this.supplier = supplier;
    }

    // Método para obtener el precio
    public BigDecimal getPrice() {
        return price; // Asegúrate de que devuelva el precio
    }
}
