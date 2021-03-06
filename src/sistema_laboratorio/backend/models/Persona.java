package sistema_laboratorio.backend.models;

public class Persona {

    protected String dni;
    protected String email;
    protected String nombre;
    protected String domicilio;
    protected String fechaDeNacimiento;

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Persona(String dni, String email, String nombre, String domicilio, String fechaDeNacimiento) {
        this.dni = dni;
        this.email = email;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.fechaDeNacimiento = fechaDeNacimiento;

    }
}
