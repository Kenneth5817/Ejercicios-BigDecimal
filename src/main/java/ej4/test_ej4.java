package ej4;

import java.math.BigDecimal;

public class test_ej4 {
    public static void main(String[] args) {
        // Creamos posiciones: Igualada y Granada
        Posicion Igualada = new Posicion(new BigDecimal("41.57879"), new BigDecimal("1.617221"));
        Posicion Granada = new Posicion(new BigDecimal("37.176487"), new BigDecimal("-3.597929"));

        // Calculamos la distancia en km
        BigDecimal distancia = ej4.distanciaKm(Igualada, Granada);

        // Mostramos la distancia calculada
        System.out.println("Distancia calculada: " + distancia + " km");

        // Comprobamos si la distancia está cerca de 664 km
        BigDecimal distanciaEsperada = new BigDecimal("664.0");
        if (distancia.compareTo(distanciaEsperada) == 0) {
            System.out.println("La distancia es correcta.");
        } else {
            System.out.println("La distancia NO es la esperada.");
        }
    }
}
