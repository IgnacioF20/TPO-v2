package sistema_laboratorio.backend.models;

import sistema_laboratorio.backend.enumerates.SexoEnumerate;

import java.util.ArrayList;

public class Paciente extends Persona {

    ArrayList<Peticion> peticiones = new ArrayList();
    SexoEnumerate sexo;
    int edad;

    public Paciente(String DNI, String email, String nombre, String domicilio, String fechaDeNacimiento, SexoEnumerate sexo) {

        super(DNI, email, nombre, domicilio, fechaDeNacimiento);
        this.sexo = sexo;
        this.edad = edad;
    }
    /*
    public Paciente(PacienteDTO dto){
        super(dto.DNI, dto.email, dto.nombre, dto.domicilio, dto.fechaDeNacimiento);
        this.sexo = dto.sexo;
        this.edad = dto.edad;

    }
    */

    @Override
    public String getDni() {
        return super.getDni();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public String getDomicilio() {
        return super.getDomicilio();
    }

    @Override
    public String getFechaDeNacimiento() {
        return super.getFechaDeNacimiento();
    }

    @Override
    public void setDni(String dni) {
        super.setDni(dni);
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public void setDomicilio(String domicilio) {
        super.setDomicilio(domicilio);
    }

    @Override
    public void setFechaDeNacimiento(String fechaDeNacimiento) {

        super.setFechaDeNacimiento(fechaDeNacimiento);
        setEdad(fechaDeNacimiento);
    }

    public Paciente(String DNI, String email, String nombre, String domicilio, String fechaDeNacimiento) {
        super(DNI, email, nombre, domicilio, fechaDeNacimiento);
    }

    public SexoEnumerate getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnumerate sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(String fechaNacimientoIngresada) {
        this.edad = calcularEdad(fechaNacimientoIngresada);
    }

    public int calcularEdad(String fechaNacimientoIngresada) {

//        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        String pattern = "MM/dd/yyyy HH:mm:ss";
//        DateFormat df = new SimpleDateFormat(pattern);
//
//        LocalDate fechaNacimiento = LocalDate.parse(df.format(fechaNacimientoIngresada), fmt);
//        LocalDate fechaHoy = LocalDate.now();
//
//        Period periodoNacimientoAHoy = Period.between(fechaNacimiento, fechaHoy);
//        System.out.printf("Tu edad es: %s a??os, %s meses y %s d??as",
//                periodoNacimientoAHoy.getYears(), periodoNacimientoAHoy.getMonths(), periodoNacimientoAHoy.getDays());

        return 0;
    }

    public void altaPeticion(Peticion peticion){
        peticiones.add(peticion);
        peticion.getSucursal().enlazarPeticion(peticion);
        for(Practica practica: peticion.getPracticas()){
            practica.setPeticion(peticion);
        }

    }

    public boolean tienePeticionCompleta(){
        boolean response = false;
        for(Peticion peticion: this.peticiones){
                if(peticion.estaActiva()){
                    return true;
                }
        }
        return response;
    }

    public int mostrarResultadoPractica(int nroPractica){
        int response = 0;
        for(Peticion peticion: this.peticiones){
            if(nroPractica == Integer.parseInt(peticion.codigoPeticion())){
                response = Integer.parseInt(peticion.codigoPeticion());
            }
        }
        return response;
    }

    public Peticion getPeticion(String id){
        Peticion peticionABuscar = null;
        for(Peticion peticion: this.peticiones){
            if(peticion.getId() == id){
                peticionABuscar = peticion;
                break;
            }
        }
        return peticionABuscar;
    }



    public void modificarPeticion(Peticion peticion){

    }


//    public boolean modificarAtributos(PacienteDTO paciente){
//
//        paciente
//
//
//    }



}
