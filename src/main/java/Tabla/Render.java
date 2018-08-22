package Tabla;

//import Controlador.*;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class Render extends DefaultTableCellRenderer  {
        
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
        
        setHorizontalAlignment(SwingConstants.CENTER); 
        
        return cell;
    }
}

