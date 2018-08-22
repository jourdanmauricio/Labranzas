package Vista;

import Modelo.Backup;
import Modelo.SingletonProperties;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class frmBackupRestore extends javax.swing.JInternalFrame {

    public frmBackupRestore() {
        initComponents();

        // Inicializo componentes
        SingletonProperties sp = SingletonProperties.getInstancia();
        String path_icon = sp.getPropiedad("path_img_iconos");
        String path_backup = sp.getPropiedad("path_backup");
        
        btnRestore.setIcon(new ImageIcon(path_icon+"restore_peque.png"));
        btnBup.setIcon(new ImageIcon(path_icon+"backup_peque.png"));
        txtPath.setText(path_backup);
        
        String sDirectorio = txtPath.getText();
        File f = new File(sDirectorio);
        DefaultListModel modelo = new DefaultListModel();
        Calendar cal=Calendar.getInstance(); 
        int mes = cal.get(cal.MONTH)+1;
        String fecha=cal.get(cal.YEAR)+"_"+ mes +"_"+cal.get(cal.DATE);
        
        txtNombreBup.setText(txtPath.getText()+"Activos3-"+fecha+".sql");
        
        if (f.exists()){ // Directorio existe 
            File[] ficheros = f.listFiles();
            for (int x=0;x<ficheros.length;x++){
                modelo.addElement(ficheros[x].getName());
                System.out.println(ficheros[x].getName());
            }
            jlArchivos.setModel(modelo);
        }
    }
    
    public void transfer(InputStream input, OutputStream output) throws Exception {
        byte[] buf = new byte[1024];
        int len;
        while ((len = input.read(buf)) > 0) {
            output.write(buf, 0, len);
        }
        input.close();
        output.close();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreBup = new javax.swing.JTextField();
        btnBup = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlArchivos = new javax.swing.JList<>();
        btnRestore = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Back-up / Restore BD");
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Back-up"));

        jLabel1.setText("Nombre:");

        btnBup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBupMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreBup, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnBup, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreBup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 70, 649, 119);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Restore"));

        jlArchivos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jlArchivos);

        btnRestore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRestoreMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
                .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 200, 649, 265);

        jLabel2.setText("Carpeta:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(12, 30, 70, 17);
        getContentPane().add(txtPath);
        txtPath.setBounds(90, 25, 570, 27);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBupMouseClicked

/*        String archivo = txtNombreBup.getText();    
//        String command = "mysqldump -hlocalhost  -uroot -pmau10ti0  -rc:\\back.sql activos3";
        String command = "mysqldump -hlocalhost  -uroot -pmau10ti0  -rc:"+archivo+" activos3";
      
        try {    
            Process child = Runtime.getRuntime().exec(command);
            InputStream input = child.getInputStream();

            FileOutputStream output = new FileOutputStream(archivo);
            transfer(input, output);
        }  catch (Exception e) {
            e.printStackTrace();
        }
*/

        new Backup().CrearBackup("localhost", "3306", "root", "mau10ti0", "activos3",txtNombreBup.getText());
    }//GEN-LAST:event_btnBupMouseClicked

    private void btnRestoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRestoreMouseClicked

            
        new Backup().restore("root", "mau10ti0", "activos3",jlArchivos.getSelectedValue(), "/home/mauricio/NetBeansProjects/labranzas_git/restore.sh");
        System.out.println(jlArchivos.getSelectedValue());
    }//GEN-LAST:event_btnRestoreMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBup;
    public javax.swing.JButton btnRestore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlArchivos;
    private javax.swing.JTextField txtNombreBup;
    private javax.swing.JTextField txtPath;
    // End of variables declaration//GEN-END:variables
}
