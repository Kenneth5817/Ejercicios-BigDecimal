package ej5;

public class OrderStatus {
    public enum Status {
        NEW("new"),
        HOLD("hold"),
        SHIPPED("shipped"),
        DELIVERED("delivered"),
        CLOSED("closed");

        private final String status;

        // Constructor del enum
        Status(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }
}
