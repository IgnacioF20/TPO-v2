package sistema_laboratorio.frontend.frames;

import sistema_laboratorio.backend.controllers.UsuarioController;
import sistema_laboratorio.backend.dtos.UsuarioDTO;
import sistema_laboratorio.backend.enumerates.CargoEnumerate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmUsuarioCrear extends JDialog{

    private JPanel pnlUsuarioCrear;
    private JPanel JPBody;

    private JPanel JP_dni;
    private JTextField JTF_dni;

    private JPanel JP_contrasenia;
    private JTextField JTF_contrasenia;

    private JPanel JP_nombre;
    private JTextField JTF_nombre;

    private JPanel JP_email;
    private JTextField JTF_email;

    private JPanel JP_domicilio;
    private JTextField JTF_domicilio;

    private JPanel JP_nacimiento;
    private JTextField JTF_nacimiento;

    private JPanel JP_cargo;
    private JComboBox JCBx_cargo;

    private JPanel JPFooter;
    private JButton guardarButton1;

    public FrmUsuarioCrear(String titulo) {

        this.setContentPane(pnlUsuarioCrear);
        this.setSize(500, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        guardarButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                boolean formularioCompleto = true;

                UsuarioController usuarioController = UsuarioController.getInstance();

                String dni, contrasenia, nombre, email, domicilio, fechaDeNacimiento;
                CargoEnumerate cargo;

                dni = JTF_dni.getText();
                contrasenia = JTF_contrasenia.getText();
                nombre = JTF_nombre.getText();
                email = JTF_email.getText();
                domicilio = JTF_domicilio.getText();
                fechaDeNacimiento = JTF_nacimiento.getText();
                cargo = usuarioController.textoACargo(JCBx_cargo.getSelectedItem().toString());

                String camposIncompletosMensaje = "";

                if (dni.equals("")) {
                    camposIncompletosMensaje = camposIncompletosMensaje + " - " + "DNI\n";
                    formularioCompleto = false;
                }
                if (contrasenia.equals("")) {
                    camposIncompletosMensaje = camposIncompletosMensaje + " - " + "Contraseña\n";
                    formularioCompleto = false;
                }
                if (nombre.equals("")) {
                    camposIncompletosMensaje = camposIncompletosMensaje + " - " + "Nombre\n";
                    formularioCompleto = false;
                }
                if (email.equals("")) {
                    camposIncompletosMensaje = camposIncompletosMensaje + " - " + "eMail\n";
                    formularioCompleto = false;
                }
                if (domicilio.equals("")) {
                    camposIncompletosMensaje = camposIncompletosMensaje + " - " + "Domicilio\n";
                    formularioCompleto = false;
                }
                if (fechaDeNacimiento.equals("")) {
                    camposIncompletosMensaje = camposIncompletosMensaje + " - " + "Fecha de nacimiento\n";
                    formularioCompleto = false;
                }
                String mensaje, titulo;
                if (formularioCompleto) {
                    UsuarioDTO usuarioDTO = new UsuarioDTO(
                            dni,
                            contrasenia,
                            email,
                            nombre,
                            domicilio,
                            fechaDeNacimiento,
                            cargo);
                    usuarioController.altaUsuario(usuarioDTO);
                    mensaje = "Usuario creado correctamente";
                    titulo = "Usuario creado";

                    JTF_dni.setText("");
                    JTF_contrasenia.setText("");
                    JTF_nombre.setText("");
                    JTF_email.setText("");
                    JTF_domicilio.setText("");
                    JTF_nacimiento.setText("");
                    JCBx_cargo.setSelectedIndex(0);
                } else {
                    mensaje = "Por favor complete los siguientes campos:\n";
                    mensaje = mensaje + camposIncompletosMensaje;
                    titulo = "Falta completar campos";
                }
                JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
