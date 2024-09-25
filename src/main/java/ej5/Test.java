package ej5;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        // Creamos clientes
        Customer cliente1 = new Customer("Juan", "Calle Vega de Mijas 123", "123456789", "juan@gmail.com");
        Customer cliente2 = new Customer("Pepe", "Calle Fuengirola 82, 3ºE", "987654321", "pepe@gmail.com");

        // Creamos cuentas
        Account cuenta1 = new Account(1, BigDecimal.ZERO, cliente1, true, null);
        Account cuenta2 = new Account(2, BigDecimal.ZERO, cliente2, false, null);

        // Creamos productos con precio no nulo
        Product producto1 = new Product(1, "Ordenador", new BigDecimal("858.99"), null);
        Product producto2 = new Product(2, "Libro", new BigDecimal("24.58"), null);

        // Creamos carrito de compras
        ShoppingCart carrito = new ShoppingCart(new Date());

        // Agregamos productos al carrito
        List<LineItem> lineItems = new ArrayList<>();
        lineItems.add(new LineItem(2, producto1.getPrice())); // 2 Ordenadores
        lineItems.add(new LineItem(1, producto2.getPrice())); // 1 Libro

        // Creamos una orden
        BigDecimal totalOrderAmount = calculateTotal(lineItems);
        Order order = new Order("Juan", new Date(), new Date(), "Calle Vega de Mijas 123", null, totalOrderAmount);

        // Creamos un pago
        Payment payment = new Payment(1, new Date(), totalOrderAmount, "Pago para el pedido 1");
        payment.processPayment();

        // Imprimimos los detalles
        System.out.println("Resumen del pedido: " + order+" €");
        System.out.println("Pago procesado: " + payment.getTotal()+" €");
        System.out.println("Genial, gracias por su compra");
        System.out.println("El pedido llegará en 3 días!!!");
    }

    //Calculamos el total
    private static BigDecimal calculateTotal(List<LineItem> lineItems) {
        BigDecimal total = BigDecimal.ZERO;

        //Vamos producto por producto
        for (int i = 0; i < lineItems.size(); i++) {
            LineItem item = lineItems.get(i);
            // Comprobamos que el precio no sea nulo
            if (item.getPrice() != null) {
                BigDecimal itemTotal = item.getPrice().multiply(new BigDecimal(item.getQuantify()));
                total = total.add(itemTotal);
            } else {
                System.out.println("El precio de un artículo no vale, no se puede calcular el total.");
            }
        }
        //Como viene en el ej. se devuelve redondeado a 2 decimales
        return total.setScale(2, RoundingMode.HALF_UP);

    }
}
