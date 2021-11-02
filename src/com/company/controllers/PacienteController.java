package com.company.controllers;

import com.company.dto.PacienteDTO;
import com.company.enumerate.SexoEnum;
import com.company.models.Paciente;
import com.company.models.Peticion;

import java.util.ArrayList;
import java.util.Date;


public class PacienteController {

    ArrayList<Paciente> pacientes = new ArrayList();


    public boolean altaPaciente(PacienteDTO paciente){

        boolean flag;

        if(ObtenerPacientePorDNI(paciente.getDNI()) != null){
            this.pacientes.add(dtoToModel(paciente));
            return true;
        }
        else
            return false;
    }


    public boolean modificarPaciente(){

        return false;
    }


    public boolean bajaPaciente(int dni){

        return false;
    }


    public boolean altaPeticion(int dni){


        return false;
    }


    public boolean modificarPeticion(){

        return false;
    }


    public Peticion consultarPeticion(){


        return null;
    }


    private Paciente ObtenerPacientePorDNI(int dni){

        Paciente retorno = null;

        for(Paciente paciente : pacientes){

            if(paciente.GetDNI() == dni){
                retorno = paciente;
                break;
            }
        }
        return retorno;
    }


    private static Paciente dtoToModel(PacienteDTO paciente){

        //mapear con el mismo orden
        Paciente nuevoPaciente = new Paciente(paciente.getDNI(), paciente.getEmail(), paciente.getNombre(), paciente.getDomicilio(), paciente.getFechaDeNacimiento(), paciente.getSexo());
        return nuevoPaciente;
    }
}
