package sistema_laboratorio.frontend.frames;

import sistema_laboratorio.backend.controllers.LaboratorioController;
import sistema_laboratorio.backend.controllers.UsuarioController;
import sistema_laboratorio.backend.dtos.SucursalDTO;
import sistema_laboratorio.backend.dtos.UsuarioDTO;
import sistema_laboratorio.backend.enumerates.CargoEnumerate;
import sistema_laboratorio.backend.models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmSucursalCrear extends JDialog {

    private JPanel pnlSucursalCrear;

    private JPanel JPBody;
    private JPanel JP_nroSucursal;
    private JTextField JTF_nroSucursal;

    private JPanel JP_direccion;
    private JTextField JTF_direccion;

    private JPanel JP_responsableTecnico;
    private JTextField JTF_responsableTecnico;

    private JButton btnResponsableTecnicoSeleccionar;

    private JPanel JPFooter;
    private JButton btnSucursalCrear;

    private FrmSucursalCrear self;
    private Usuario usuarioResponsableTecnico;

    class ResponsableTecnico{

        Usuario responsableTecnico;

        public void setResponsableTecnico(Usuario responsableTecnico) {
            this.responsableTecnico = responsableTecnico;
        }

        public Usuario getResponsableTecnico() {
            return responsableTecnico;
        }
    }

    ResponsableTecnico responsableTecnico = new ResponsableTecnico();

    public FrmSucursalCrear(String titulo) {

        this.setContentPane(pnlSucursalCrear);
        this.setSize(500, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        btnSucursalCrear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                boolean formularioCompleto = true;
                String mensaje, titulo;

                UsuarioController usuarioController = UsuarioController.getInstance();

                String direccion, responsableTecnico;
                int nroSucursal = -1;

                try{
                    nroSucursal = Integer.parseInt(JTF_nroSucursal.getText());
                }catch (Exception error){
                    System.out.println("NroSucursal No es un número");
                }
                direccion = JTF_direccion.getText();
                responsableTecnico = JTF_responsableTecnico.getText();


                String camposIncompletosMensaje = "";

                if (nroSucursal==-1) {
                    camposIncompletosMensaje = camposIncompletosMensaje + " - " + "Numero Sucursal\n";
                    formularioCompleto = false;
                }
                if (direccion.equals("")) {
                    camposIncompletosMensaje = camposIncompletosMensaje + " - " + "Direccion\n";
                    formularioCompleto = false;
                }
                if (responsableTecnico.equals("")) {
                    camposIncompletosMensaje = camposIncompletosMensaje + " - " + "Responsable Tecnico\n";
                    formularioCompleto = false;
                }
                if (formularioCompleto) {
                    SucursalDTO sucursalDTO = new SucursalDTO(
                            nroSucursal,
                            direccion,
                            usuarioResponsableTecnico);
                    LaboratorioController.getInstance().altaSucursal(sucursalDTO);
                    mensaje = "Sucursal creada correctamente";
                    titulo = "Sucursal creada";

                    JTF_nroSucursal.setText("");
                    JTF_direccion.setText("");
                    JTF_responsableTecnico.setText("");
                } else {
                    mensaje = "Por favor complete los siguientes campos:\n";
                    mensaje = mensaje + camposIncompletosMensaje;
                    titulo = "Falta completar campos";
                }
                JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
            }
        });


        JTF_nroSucursal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e);
            }
        });


        btnResponsableTecnicoSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmUsuarioSeleccionar frame = new FrmUsuarioSeleccionar(self, "Seleccionar Usuario", responsableTecnico);
                frame.setVisible(true);

                usuarioResponsableTecnico = responsableTecnico.getResponsableTecnico();

                if(responsableTecnico!=null){
                    JTF_responsableTecnico.setText(usuarioResponsableTecnico.getNombre()+" (DNI: "+usuarioResponsableTecnico.getDni()+")");
                }
            }
        });
    }
}
