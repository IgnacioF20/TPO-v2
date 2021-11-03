package com.company.models;

import com.company.enumerate.CargoEnumerate;

import java.util.Date;

public class Usuario extends Persona{

    private String password;
    private CargoEnumerate rol;

    public Usuario(int DNI, String email, String nombre, String domicilio, Date fechaDeNacimiento, String password, CargoEnumerate cargo) {

        super(DNI, email, nombre, domicilio, fechaDeNacimiento);

        this.password = password;
        this.rol = rol;
    }


    @Override
    public int getDNI() {
        return super.getDNI();
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
    public Date getFechaDeNacimiento() {
        return super.getFechaDeNacimiento();
    }

    @Override
    public void setDNI(int DNI) {
        super.setDNI(DNI);
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
    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        super.setFechaDeNacimiento(fechaDeNacimiento);
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CargoEnumerate getRol() {
        return rol;
    }

    public void setRol(CargoEnumerate rol) {
        this.rol = rol;
    }
}
