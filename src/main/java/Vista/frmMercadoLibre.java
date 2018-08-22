package Vista;

import Modelo.SingletonProperties;
import com.mercadolibre.sdk.AuthorizationFailure;
import com.mercadolibre.sdk.Meli;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;
import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class frmMercadoLibre extends javax.swing.JInternalFrame {

    Meli m = new Meli(982713222446237L, "cZeJIR4hlVNlgRQ6eOjuj4dCXq8s5fWD"); 
    FluentStringsMap params = new FluentStringsMap();

    
    
    public frmMercadoLibre() {
        initComponents();
        String redirectUrl = m.getAuthUrl("https://labranzas.com.ar/index.php",Meli.AuthUrls.MLA);
        System.out.println(redirectUrl);

        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnComando1 = new javax.swing.JButton();
        btnAccess = new javax.swing.JButton();
        txtAccessToken = new javax.swing.JTextField();
        btnAutorizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mercado Libre");

        btnComando1.setText("comando 1");
        btnComando1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComando1ActionPerformed(evt);
            }
        });

        btnAccess.setText("Obtener Access Token");
        btnAccess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAccessMouseClicked(evt);
            }
        });

        btnAutorizar.setText("Autorizar token ML");
        btnAutorizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAutorizarMouseClicked(evt);
            }
        });

        jButton1.setText("comadno 2");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAutorizar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnComando1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(btnAccess, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addComponent(txtAccessToken, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAccess)
                    .addComponent(txtAccessToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btnAutorizar)
                .addGap(107, 107, 107)
                .addComponent(btnComando1)
                .addGap(52, 52, 52)
                .addComponent(jButton1)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComando1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComando1ActionPerformed

        try {
            Response response = m.get("/users/me", params);
            String s = response.getResponseBody();
            System.out.println("Response"+s);
        } catch (MeliException ex) {
            Logger.getLogger(frmMercadoLibre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmMercadoLibre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnComando1ActionPerformed

    private void btnAccessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAccessMouseClicked

        URL url=null;
            try {
                url = new URL("https://auth.mercadolibre.com.ar/authorization?response_type=code&client_id=982713222446237");
                try {
                    Desktop.getDesktop().browse(url.toURI());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }        
    }//GEN-LAST:event_btnAccessMouseClicked

    private void btnAutorizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAutorizarMouseClicked

        try {
            String code = txtAccessToken.getText();
//            m.authorize("TG-5b7996bee4b0e28ca3bf44cb-51568530", "https://labranzas.com.ar/index.php");
            m.authorize(code, "https://labranzas.com.ar/index.php");
        } catch (AuthorizationFailure ex) {
            Logger.getLogger(frmMercadoLibre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        params.add("access_token", m.getAccessToken());
    }//GEN-LAST:event_btnAutorizarMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        try {
            Response response1 = m.get("/sites/MLA/search?seller_id=51568530", params);
            String s1 = response1.getResponseBody();
            System.out.println("Response"+s1);
        } catch (MeliException ex) {
            Logger.getLogger(frmMercadoLibre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmMercadoLibre.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAccess;
    public javax.swing.JButton btnAutorizar;
    private javax.swing.JButton btnComando1;
    private javax.swing.JButton jButton1;
    public javax.swing.JTextField txtAccessToken;
    // End of variables declaration//GEN-END:variables
}
