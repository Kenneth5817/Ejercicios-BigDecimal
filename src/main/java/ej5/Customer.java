package ej5;

public class Customer {

    //Constructor
    public Customer(String id, String direccion, String telefono, String email) {
        this.id = id;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    //Atributos
    private String id;
    private String direccion;
    private String telefono;
    private String email;

    public String getName() {
        return id;
    }
}

