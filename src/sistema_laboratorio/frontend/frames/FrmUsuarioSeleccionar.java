package sistema_laboratorio.frontend.frames;

import sistema_laboratorio.backend.controllers.UsuarioController;
import sistema_laboratorio.backend.models.Usuario;
import sistema_laboratorio.frontend.utils.TablaUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FrmUsuarioSeleccionar extends JDialog{

    private JPanel pnlUsuarioSeleccion;
    private JPanel JPTitle;
    private JPanel JPBody;
    private JPanel JPTable;
    private JScrollPane JSP_Usuarios;
    private JTable tablaUsuarios;

    private TablaUsuarios modeloTablaUsuarios = new TablaUsuarios();

    public FrmUsuarioSeleccionar(Window owner, String titulo, FrmSucursalCrear.ResponsableTecnico responsableTecnico){

        this.setTitle("Seleccionar Responsable Tecnico");
        this.setContentPane(pnlUsuarioSeleccion);
        this.setSize(400,400);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        tablaUsuarios.setModel(modeloTablaUsuarios);
        ArrayList<Usuario> usuarios = UsuarioController.getInstance().getUsuarios();

        String dni, nombre;
        for (Usuario usuario:usuarios) {

            dni = usuario.getDni();
            nombre = usuario.getNombre();
            modeloTablaUsuarios.add(dni, nombre);
        }


        tablaUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                JTable row = (JTable) e.getSource();
                String dni = tablaUsuarios.getValueAt(row.getSelectedRow(),0).toString();

                responsableTecnico.setResponsableTecnico(UsuarioController.getInstance().obtenerUsuarioPorDNI(dni));
                dispose();
            }
        });
    }
}
