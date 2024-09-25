package ej5;
public class UserState {
    public enum State {
        NEW("new"),
        ACTIVE("active"),
        BLOCKED("blocked"),
        BANNED("banned");

        private final String state;

        // Constructor del enum
        State(String state) {
            this.state = state;
        }

        // Obtenemos el valor del estado
        public String getState() {
            return state;
        }
    }
}