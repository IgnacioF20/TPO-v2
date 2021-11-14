package sistema_laboratorio.frontend.frames;

import sistema_laboratorio.backend.controllers.UsuarioController;
import sistema_laboratorio.backend.dtos.UsuarioDTO;
import sistema_laboratorio.backend.enumerates.CargoEnumerate;
import sistema_laboratorio.backend.models.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmUsuarioVista extends JDialog {

    private JPanel pnlUsuarioVista;
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
    private JButton btnGuardarUsuario;
    private JButton btnEliminarUsuario;

    public FrmUsuarioVista(String titulo, String usuarioDNI) {

        this.setContentPane(pnlUsuarioVista);
        this.setSize(500, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
//        this.setResizable(false);

        Usuario usuario = UsuarioController.getInstance().obtenerUsuarioPorDNI(usuarioDNI);

        JTF_dni.setText(usuario.getDni());
        JTF_contrasenia.setText(usuario.getPassword());
        JTF_nombre.setText(usuario.getNombre());
        JTF_email.setText(usuario.getEmail());
        JTF_domicilio.setText(usuario.getDomicilio());
        JTF_nacimiento.setText(usuario.getFechaDeNacimiento());
        JCBx_cargo.setSelectedIndex(UsuarioController.getInstance().cargoAIndice(usuario.getCargo()));



        btnGuardarUsuario.addActionListener(new ActionListener() {

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

                    usuario.setPassword(contrasenia);
                    usuario.setNombre(nombre);
                    usuario.setEmail(email);
                    usuario.setDomicilio(domicilio);
                    usuario.setFechaDeNacimiento(fechaDeNacimiento);
                    usuario.setCargo(cargo);

                    mensaje = "Usuario modificado correctamente";
                    titulo = "Usuario modificado";

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

        btnEliminarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String dni = JTF_dni.getText();
                UsuarioController.getInstance().bajaUsuario(dni);

                JTF_dni.setText("");
                JTF_contrasenia.setText("");
                JTF_nombre.setText("");
                JTF_email.setText("");
                JTF_domicilio.setText("");
                JTF_nacimiento.setText("");
                JCBx_cargo.setSelectedIndex(0);

                String mensaje = "Usuario eliminado correctamente";
                String titulo = "Usuario eliminado";
                JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
