package vistas;

import com.company.controllers.UsuarioController;

import javax.swing.*;
import java.awt.*;

public class FrmUsuarios extends JDialog{

    private JTabbedPane tabbedPane1;
    private JPanel pnlPrincipal;
    private JTextField textField1;
    private JButton buscarButton;
    private JTextField txtDNI;
    private JTextField txtEmail;
    private JTextField txtNombre;
    private JTextField txtDomicilio;
    private JTextField txtFecha;
    private JButton guardarButton;
    private JButton eliminarButton;
    private JTextField txt1;
    private JTextField txt2;
    private JTextField txt3;
    private JTextField txt4;
    private JTextField txt5;
    private JButton guardarButton1;
    private JButton cancelarButton1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;

    public FrmUsuarios(Window owner, String titulo){
        super(owner,"Usuarios");

        this.setContentPane(pnlPrincipal);
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //establezco comportamiento al cerrarse
        this.setLocationRelativeTo(null); //que la pantalla inicie centrada
        //this.asociarEventos();
        this.setResizable(false);
        this.setModal(true);

    }

}
