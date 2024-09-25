package ej2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ej2 {
    public static void main(String[] args) {
        /**INFO ÚTIL**/
        /**n = años, p=monto principal, r=tasa de interés anual, c= cantidad final depositada**/
        BigDecimal p= new BigDecimal("10");
        BigDecimal r= new BigDecimal("0.05");
        int n= 2;

        /** Fórmula c=p(1+r);**/
        BigDecimal suma= BigDecimal.ONE.add(r);
        BigDecimal c=p.multiply(suma.pow(n));
        /**Redondeamos y cogeremos 10 decimales**/
        c.setScale(10, RoundingMode.HALF_EVEN);

        /**Mostramos por pantalla el resultado**/
        System.out.println("RESULTADO: "+c.setScale(2,RoundingMode.HALF_UP));
    }
}
