package com.company.controllers;

import com.company.dto.PacienteDTO;
import com.company.models.Paciente;
import com.company.models.Peticion;
import java.util.ArrayList;


public class PacienteController {

    ArrayList<Paciente> pacientes = new ArrayList();


    public boolean altaPaciente(PacienteDTO paciente){

        // SI OBTENEMOS NULL, NO SE ENCUENTRA EL PACIENTE CARGADO Y PROCEDEMOS A CARGARLO.
        if(obtenerPacientePorDNI(paciente.getDNI()) == null){

            this.pacientes.add(dtoToModel(paciente));
            return true;
        }
        // EL PACIENTE YA ESTA CARGADO.
        else
            return false;
    }


    public boolean modificarPaciente(PacienteDTO paciente){

        // SI OBTENEMOS NULL, NO SE ENCUENTRA EL PACIENTE CARGADO Y PROCEDEMOS A MODIFICARLO.
        Paciente pacienteAModificar = obtenerPacientePorDNI(paciente.getDNI());

        if(pacienteAModificar != null){

//            pacienteAModificar.modificarAtributos(paciente);

//            TO DELETE!!
            System.out.println("");
            return true;


        }
        // EL PACIENTE YA ESTA CARGADO.
        else
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


    private Paciente obtenerPacientePorDNI(int dni){

        Paciente pacienteBuscado = null;

        for(Paciente paciente : pacientes){

            if(paciente.getDNI() == dni){

                pacienteBuscado = paciente;
                break;
            }
        }
        return pacienteBuscado;
    }


    private static Paciente dtoToModel(PacienteDTO paciente){

        //mapear con el mismo orden
        Paciente pacienteNuevo = new Paciente(paciente.getDNI(), paciente.getEmail(), paciente.getNombre(), paciente.getDomicilio(), paciente.getFechaDeNacimiento(), paciente.getSexo());
        return pacienteNuevo;
    }
}
