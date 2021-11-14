package sistema_laboratorio.frontend.frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPrincipal extends JFrame{

    private JPanel PnlPrincipal;
    private JButton sucursalesButton;
    private JButton practicasButton;
    private JButton usuariosButton;
    private JPanel JPBody;
    private JPanel JPHeader;
    private FrmPrincipal self;
    private JButton btnCerrarPrincipal;
    private JPanel JPFooter;
    private JButton btnConfigurarParametros;
    private JButton ingresarEnSucursalButton;

    public FrmPrincipal(String titulo) {

//        this.setModal(true); // BLOQUEA PANTALLA ANTERIOR
        JPBody.setVisible(false);
        this.setTitle("Menu principal");
        this.setContentPane(PnlPrincipal);
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //COMPORAMIENTO AL CERRARsE
        this.setLocationRelativeTo(null); //CENTRAR PANTALLA
        this.setResizable(false); //NO PERMITIR EL REAJUSTE

        this.asociarEventos();

    }

    private void asociarEventos(){
        sucursalesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmSucursalesLista frame = new FrmSucursalesLista("Sucursales");
                frame.setVisible(true);

            }
        });

        practicasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        usuariosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                FrmPrincipal.super.dispose();
                FrmUsuariosLista frame = new FrmUsuariosLista("Usuarios");
                frame.setVisible(true);

            }
        });

        btnCerrarPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmPrincipal.super.dispose();
                FrmLogIn frame = new FrmLogIn("Sistema de Laboratorio");
                frame.setVisible(true);
            }
        });

    }

}
