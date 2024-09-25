package ej4;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

    public class ej4 {

        public static final BigDecimal Radio_Tierra_Km = new BigDecimal("6378.0");

        // Método para pasar grados a radianes
        public static BigDecimal enRadianes(BigDecimal grados) {
            //Dividimos pi entre 180 para sacar radianes
            BigDecimal piDiv180 = new BigDecimal(Math.PI).divide(new BigDecimal("180"), MathContext.DECIMAL128);
            return grados.multiply(piDiv180);
        }

        // Calculamos la distancia entre dos posiciones utilizando la fórmula de Haversine
        public static BigDecimal distanciaKm(Posicion posOrigen, Posicion posDestino) {
            MathContext mc = new MathContext(34, RoundingMode.HALF_EVEN); // Usamos Decimal128

            BigDecimal difLatitud = enRadianes(posDestino.getLatitud().subtract(posOrigen.getLatitud()));
            BigDecimal difLongitud = enRadianes(posDestino.getLongitud().subtract(posOrigen.getLongitud()));

            BigDecimal lat1EnRad = enRadianes(posOrigen.getLatitud());
            BigDecimal lat2EnRad = enRadianes(posDestino.getLatitud());

            // Fórmula de Haversine
            BigDecimal a = senoCuadrado(difLatitud.divide(new BigDecimal("2"), mc))
                    .add(coseno(lat1EnRad).multiply(coseno(lat2EnRad))
                            .multiply(senoCuadrado(difLongitud.divide(new BigDecimal("2"), mc))));

            //Atan=arcotangente
            BigDecimal c = new BigDecimal("2").multiply(atan2(sqrt(a), sqrt(BigDecimal.ONE.subtract(a))));

            // En km, vemos la distancia final
            return Radio_Tierra_Km.multiply(c, mc).setScale(2, RoundingMode.HALF_EVEN);
        }

        // Métodos auxiliares para cálculos trigonométricos y matemáticos con BigDecimal
        public static BigDecimal senoCuadrado(BigDecimal valor) {
            return seno(valor).pow(2);
        }

        public static BigDecimal seno(BigDecimal valor) {
            return new BigDecimal(Math.sin(valor.doubleValue()), MathContext.DECIMAL128);
        }

        public static BigDecimal coseno(BigDecimal valor) {
            return new BigDecimal(Math.cos(valor.doubleValue()), MathContext.DECIMAL128);
        }

        public static BigDecimal sqrt(BigDecimal valor) {
            return valor.sqrt(MathContext.DECIMAL128);
        }

        public static BigDecimal atan2(BigDecimal y, BigDecimal x) {
            return new BigDecimal(Math.atan2(y.doubleValue(), x.doubleValue()), MathContext.DECIMAL128);
        }
}
