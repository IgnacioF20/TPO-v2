package sistema_laboratorio.frontend.utils;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TablaSucursales extends AbstractTableModel{

    class Sucursal {
        private int nroSucursal;
        private String direccion;

        public Sucursal(int nroSucursal, String direccion){
            this.nroSucursal = nroSucursal;
            this.direccion = direccion;
        }

        public int getNumero() {
            return this.nroSucursal;
        }
        public String getDireccion() {
            return this.direccion;
        }
    }

    private List<TablaSucursales.Sucursal> sucursales = new ArrayList<TablaSucursales.Sucursal>();

    protected String[] columnNames = new String[] {"Numero", "Direccion"};
    protected Class[] columnClasses = new Class[] {int.class, String.class};

    public String getColumnName(int col) {
        return columnNames[col];
    }
    public Class getColumnClass(int col){
        return columnClasses[col];
    }

    public int getRowCount() {
        return sucursales.size();
    }

    public int getColumnCount() {
        return this.columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return sucursales.get(rowIndex).getNumero();
            case 1: return sucursales.get(rowIndex).getDireccion();
            default: return null;
        }
    }
    public int add(int nroSucursal, String direccion){
        sucursales.add(new TablaSucursales.Sucursal(nroSucursal, direccion));
        return sucursales.size() -1;
    }
}
