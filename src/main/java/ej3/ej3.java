package ej3;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ej3 {

        public static void main(String[] args) {
            // Datos del préstamo
            // Monto(PRINCIPAL)
            BigDecimal principal = new BigDecimal("200000");
            // Tasa de interés anual (5%)
            BigDecimal tasaInteresAnual = new BigDecimal("0.05");
            int plazoAños = 30;  // Plazo del préstamo en años
            int totalPagos = plazoAños * 12;  // Número total de pagos (n)

            // Pasamos la tasa de interés, de anual a mensual. Lo hacemos dividiendo po 12
            BigDecimal tasaInteresXMes = tasaInteresAnual.divide(new BigDecimal("12"), 10, RoundingMode.HALF_EVEN);

            // Calculamos el pmt
            BigDecimal uno = BigDecimal.ONE;
            BigDecimal factorInteres = (uno.add(tasaInteresXMes)).pow(totalPagos, new MathContext(10, RoundingMode.HALF_EVEN));
            BigDecimal pmt = principal.multiply(tasaInteresXMes).multiply(factorInteres)
                    .divide(factorInteres.subtract(uno), 10, RoundingMode.HALF_EVEN);

            // Damos inicio a el saldo pendiente con la cantidad del original
            BigDecimal saldoPendiente = principal;

            //Mostramos info
            System.out.println("Préstamo:"+principal+" €");
            System.out.println("Tasa de interés anual: 5%");
            System.out.println("Pago mensual: "+pmt.setScale(2,RoundingMode.HALF_EVEN)+" €");
            System.out.println("Mes  Pago           Principal          Interés              Balance");
            System.out.println("--------------------------------------------------------------------------");

            // Calculamos los pagos por cada mes
            for (int mes = 1; mes <= totalPagos; mes++) {
                BigDecimal interesMes = saldoPendiente.multiply(tasaInteresXMes).setScale(10, RoundingMode.HALF_EVEN);
                // Pago principal
                BigDecimal pagoPrincipal = pmt.subtract(interesMes).setScale(10, RoundingMode.HALF_EVEN);

                // Saldo pendiente
                saldoPendiente = saldoPendiente.subtract(pagoPrincipal).setScale(10, RoundingMode.HALF_EVEN);

                // Mostramos los resultados
                System.out.println(mes + "    " + pmt.setScale(2, RoundingMode.HALF_EVEN) + "         " +
                        pagoPrincipal.setScale(2, RoundingMode.HALF_EVEN) + "             " +
                        interesMes.setScale(2, RoundingMode.HALF_EVEN) + "              " +
                        saldoPendiente.setScale(2, RoundingMode.HALF_EVEN));
            }
        }
    }