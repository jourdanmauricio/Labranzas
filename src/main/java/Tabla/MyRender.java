package Tabla;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class MyRender extends DefaultTableCellRenderer  {
        
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel cell = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        
        if (value instanceof JLabel) {
            JLabel lbl = (JLabel)value;
            return lbl;
        }            
        
        if (isSelected) {
            this.setBackground(Color.GRAY);
            this.setForeground(Color.black);
        } else {
            this.setBackground(Color.LIGHT_GRAY);
            this.setForeground(Color.black);
        }
        // Coloes para las fechas
        String tituloColumna = table.getColumnName(column);
        if ((tituloColumna.equals("Nombre"))||(tituloColumna.equals("Usuario ML"))||(tituloColumna.equals("Domicilio"))||(tituloColumna.equals("Observación"))) {
             cell.setHorizontalAlignment(SwingConstants.LEFT); 
        } else {
            cell.setHorizontalAlignment(SwingConstants.CENTER); 
        }

        Calendar fechaAct = new GregorianCalendar();
        int año = fechaAct.get(Calendar.YEAR);
        int mes = fechaAct.get(Calendar.MONTH);
        int dia = fechaAct.get(Calendar.DAY_OF_MONTH);

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = table.getValueAt(row, 9).toString();
        Date fechaEntrega = null;
        Date fechaActual = null;
        try {
            fechaEntrega = formato.parse(fecha);
            fechaActual = formato.parse(año + "-" + (mes+1) + "-" + dia);
        } catch (ParseException ex) {
            Logger.getLogger(MyRender.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long startTime = fechaEntrega.getTime();
        long endTime = fechaActual.getTime();
        long diffTime = startTime - endTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        int days = (int)( (fechaActual.getTime() - fechaEntrega.getTime()) / (1000 * 60 * 60 * 24));
        
        if (tituloColumna.equals("F Entrega")&&(!table.getValueAt(row, 10).toString().equals("Entregado"))) {
            if (diffDays==0) {    
                cell.setForeground(Color.green);
            }
            if (diffDays<0){
                cell.setForeground(Color.red);
            }
            if (diffDays>0&&diffDays<8){
                cell.setForeground(Color.ORANGE);
            }
            if (diffDays>7&&diffDays<16){
                cell.setForeground(Color.YELLOW);
            }            
        } else {
//               cell.setForeground(table.getForeground());
               cell.setForeground(Color.BLACK);
        }
        if (tituloColumna.equals("Estado")) {
           if (table.getValueAt(row, 10).toString().equals("Activo")) {    
               cell.setForeground(Color.YELLOW);
            }
            if (table.getValueAt(row, 10).toString().equals("Terminado")) {    
               cell.setForeground(Color.ORANGE);
            }
//            if (table.getValueAt(row, 10).toString().equals("Entregado")) {    
//               cell.setForeground(Color.GREEN);
//            }

        }

        return cell;
    }
    
}

