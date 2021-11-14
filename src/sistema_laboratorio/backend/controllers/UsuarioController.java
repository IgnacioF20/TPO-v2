package sistema_laboratorio.backend.controllers;

import java.util.ArrayList;

import sistema_laboratorio.backend.dtos.UsuarioDTO;
import sistema_laboratorio.backend.enumerates.CargoEnumerate;
import sistema_laboratorio.backend.models.Usuario;

public class UsuarioController {
    static UsuarioController instance = null;
    ArrayList<Usuario> usuarios;

    private UsuarioController(){
        usuarios = new ArrayList();
    }

    public static synchronized UsuarioController getInstance(){
        if(instance == null){
            instance = new UsuarioController();
        }
        return instance;
    }

    public boolean altaUsuario(UsuarioDTO usuario){
        if(obtenerUsuarioPorDNI(usuario.getDNI()) == null){
            this.usuarios.add(dtoToModel(usuario));
            return true;
        }
        else
            return false;
    }

    public void bajaUsuario(String dni){
        int indice = 0;
        for(Usuario usuario : usuarios){
            if(usuario.getDni().equals(dni)){
                usuarios.remove(indice);
                break;
            }
            indice ++;
        }
    }

    public Usuario obtenerUsuarioPorDNI(String DNI){
        Usuario usuarioBuscado = null;
        for(Usuario usuario : usuarios){
            if(usuario.getDni().equals(DNI)){
                usuarioBuscado = usuario;
                break;
            }
        }
        return usuarioBuscado;
    }
    public boolean validarCredenciales(String DNI, String password){
        Usuario usuarioBuscado = obtenerUsuarioPorDNI(DNI);
        return usuarioBuscado != null && usuarioBuscado.getPassword().equals(password);
    }
    private static Usuario dtoToModel(UsuarioDTO usuario){
        Usuario usuarioNuevo = new Usuario(usuario.getDNI(), usuario.getEmail(), usuario.getNombre(), usuario.getDomicilio(), usuario.getFechaDeNacimiento(),usuario.getPassword(), usuario.getCargo());
        return usuarioNuevo;
    }

    public ArrayList<Usuario> getUsuarios(){
        return this.usuarios;
    }

    public CargoEnumerate textoACargo(String cargoTxt) {

        CargoEnumerate cargo = null;

        switch (cargoTxt) {

            case "Recepcionista":
                cargo = CargoEnumerate.RECEPCIONISTA;
            case "Laboratorista":
                cargo = CargoEnumerate.LABORATISTA;
            case "Administrador":
                cargo = CargoEnumerate.ADMINISTRADOR;
        }
        return cargo;
    }

    public int cargoAIndice(CargoEnumerate cargoEnumerate){

        int indice = 0;

        if(cargoEnumerate.equals(CargoEnumerate.RECEPCIONISTA))
            indice = 0;
        else if (cargoEnumerate.equals(CargoEnumerate.LABORATISTA))
            indice = 1;
        else
            indice = 2;

        return indice;
    }
}
