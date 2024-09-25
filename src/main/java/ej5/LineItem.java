package ej5;
import java.math.BigDecimal;

public class LineItem {
    // Atributos
    private Integer quantify; // Cantidad
    private BigDecimal price;  // Precio

    // Constructor
    public LineItem(Integer quantify, BigDecimal price) {
        this.quantify = quantify;
        this.price = price; // Inicialización del precio
    }

    // Métodos para obtener los atributos
    public Integer getQuantify() {
        return quantify; // Devuelve la cantidad
    }

    public BigDecimal getPrice() {
        return price; // Devuelve el precio
    }
}

