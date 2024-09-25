package ej1;

import java.math.BigInteger;

public class ej1 {

    public static void main(String[] args) {
        BigInteger n = new BigInteger("5");
        /**Con el acumulador va uno a uno en vez de poner new BigInteger("5")**/
        BigInteger acumulador = BigInteger.ONE;

        /**Con el while repetimos las veces necesarias hasta llegar a 0**/
        while(n.compareTo(BigInteger.ZERO) > 0){
            /**Usamos n.clase**/
            acumulador=acumulador.multiply(n);
            n=n.subtract(BigInteger.ONE);
        }
        System.out.println(acumulador);
    }

}
