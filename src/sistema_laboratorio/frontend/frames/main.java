package sistema_laboratorio.frontend.frames;

import sistema_laboratorio.backend.controllers.LaboratorioController;
import sistema_laboratorio.backend.controllers.PacienteController;
import sistema_laboratorio.backend.controllers.PracticaController;
import sistema_laboratorio.backend.controllers.UsuarioController;
import sistema_laboratorio.backend.dtos.UsuarioDTO;
import sistema_laboratorio.backend.enumerates.CargoEnumerate;

import java.util.ArrayList;

public class main{

    public static void main(String[] args) {

        class Controllers {
            LaboratorioController laboratorioController;
            PacienteController pacienteController;
            PracticaController practicaController;
            UsuarioController usuarioController;
        }

        Controllers controllers = new Controllers();

        controllers.laboratorioController = LaboratorioController.getInstance();
        controllers.pacienteController = PacienteController.getInstance();
        controllers.practicaController = PracticaController.getInstance();
        controllers.usuarioController = UsuarioController.getInstance();

        ArrayList<String> nombres = new ArrayList<String>() {
            {
                add("Maria");
                add("Juan");
                add("Jose");
                add("Carlos");
                add("Luis");
                add("Miguel");
                add("Ana");
                add("Ramon");
                add("Silvia");
                add("Roberto");
                add("Daniel");
                add("Norma");
                add("Norma");
                add("Norma");
                add("Norma");
                add("Norma");
                add("Norma");
            }
        };
        UsuarioDTO usuarioDTO;

        usuarioDTO = new UsuarioDTO(
                "0",
                "admin",
                "admin@sistemalab.com",
                "admin",
                null,
                null,
                CargoEnumerate.ADMINISTRADOR);

        controllers.usuarioController.altaUsuario(usuarioDTO);

        int i = 0;
        for (String nombre : nombres) {
            i++;
            usuarioDTO = new UsuarioDTO(
                    String.valueOf(i),
                    "123456",
                    nombre + "@sistemalab.com",
                    nombre,
                    null,
                    null,
                    CargoEnumerate.RECEPCIONISTA);

            controllers.usuarioController.altaUsuario(usuarioDTO);
        }

        FrmLogIn frame = new FrmLogIn("Sistema de Laboratorio");
        frame.setVisible(true);
    }
}


