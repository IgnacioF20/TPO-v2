package sistema_laboratorio.frontend.frames;

import sistema_laboratorio.backend.controllers.LaboratorioController;
import sistema_laboratorio.backend.models.Sucursal;
import sistema_laboratorio.frontend.utils.TablaSucursales;
import sistema_laboratorio.frontend.utils.TablaUsuarios;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FrmSucursalesLista extends JDialog {


    private JPanel pnlSucursales;

    private JPanel JPTitle;

    private JPanel JPBody;
    private JPanel JPTable;
    private JScrollPane JSP_Sucursales;
    private JTable tablaSucursales;

    private JPanel JPNew;
    private JButton btnCrearSucursal;


    private TablaSucursales modeloTablaSucursales = new TablaSucursales();

    public FrmSucursalesLista(String titulo){

        this.setContentPane(pnlSucursales);
        this.setSize(400,400);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        tablaSucursales.setModel(modeloTablaSucursales);
        ArrayList<Sucursal> sucursales = LaboratorioController.getInstance().getSucursales();

        int nroSucursal;
        String direccion;

        for (Sucursal sucursal:sucursales) {

            nroSucursal = sucursal.getNumero();
            direccion = sucursal.getDirección();
            modeloTablaSucursales.add(nroSucursal, direccion);
        }


        tablaSucursales.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                JTable row = (JTable) e.getSource();
                String nroSucursal = tablaSucursales.getValueAt(row.getSelectedRow(),0).toString();

                FrmUsuarioVista frame = new FrmUsuarioVista("Crear Sucursal", nroSucursal);
                frame.setVisible(true);
            }
        });

        btnCrearSucursal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                FrmSucursalCrear frame = new FrmSucursalCrear("Crear Sucursal");
                frame.setVisible(true);
            }
        });
        tablaSucursales.addComponentListener(new ComponentAdapter() {
        });
    }
}

