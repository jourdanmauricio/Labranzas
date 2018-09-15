package Vista;

import Modelo.*;
import Tabla.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class frmListaPedidos extends javax.swing.JInternalFrame {

    Tabla.TablaListaPedidos tlistaped = new TablaListaPedidos();
    Tabla.TablaCliente tcli = new TablaCliente();
    Tabla.TablaSpd tspd = new TablaSpd();
    
    ListaPedidoDAO pedidos;
    TransporteDAO transportes = new TransporteDAO();
    ClienteDAO clienteDao = new ClienteDAO();
    PedidoDAO pedido = new PedidoDAO();
    PedidoEnvioDAO pedidoEnvio = new PedidoEnvioDAO();
    SpdDAO spd;

    JTextField clipboard;    
    int clic_tabla = 0;

    public frmListaPedidos() {
    
        initComponents();
    
        // Inicializo componentes
        SingletonProperties sp=SingletonProperties.getInstancia();
        String path_icon= sp.getPropiedad("path_img_iconos");

        btnListar.setIcon(new ImageIcon(path_icon+"busqueda_peque.png"));
        btnNuevo.setIcon(new ImageIcon(path_icon+"nuevo_peque.png"));
        btnModificar.setIcon(new ImageIcon(path_icon+"editar_peque.png"));
        btnEliminar.setIcon(new ImageIcon(path_icon+"eliminar_peque.png"));
        btnBuscarProd.setIcon(new ImageIcon(path_icon+"busqueda_peque.png"));
        btnRegistrar.setIcon(new ImageIcon(path_icon+"guardar_peque.png"));
        btnEnvio.setIcon(new ImageIcon(path_icon+"envio_peque.png"));        
        btnBuscaGeografia.setIcon(new ImageIcon(path_icon+"busqueda_peque.png"));
        btnBusTransporte.setIcon(new ImageIcon(path_icon+"busqueda_peque.png"));
        btnBuscarCli.setIcon(new ImageIcon(path_icon+"busqueda_peque.png"));
        btnRegistrarEnvio.setIcon(new ImageIcon(path_icon+"guardar_peque.png"));
        btnLimpiarEnvio.setIcon(new ImageIcon(path_icon+"limpiar_peque.png"));
        btnLimpiar.setIcon(new ImageIcon(path_icon+"limpiar_peque.png"));
        btnRemove.setIcon(new ImageIcon(path_icon+"remove_peque.png"));
        btnRemito.setIcon(new ImageIcon(path_icon+"remito_peque.png"));
        
        pedidos = new ListaPedidoDAO();
        // Cargo los combo de búsqueda
        cmbBusEstado.removeAllItems();
        cmbEstado.removeAllItems();
        ArrayList<String> estado = new ArrayList();
        estado = pedidos.Llenar_cmbEstado();
        for (int i=0; i<estado.size();i++){
            cmbBusEstado.addItem(estado.get(i));
            cmbEstado.addItem(estado.get(i));
        }
        cmbBusEstado.addItem("*"); 

        cmbTransporte.removeAllItems();
        ArrayList<String> transporte = new ArrayList();
        transporte = transportes.Llenar_cmbTransporte();
        for (int i=0; i<transporte.size();i++){
            cmbTransporte.addItem(transporte.get(i));
        }
        
        Calendar hoy = new GregorianCalendar();
        dtFventa.setCalendar(hoy);
        Calendar entrega = new GregorianCalendar();
        entrega.add(Calendar.DAY_OF_YEAR, 15);
        dtFentrega.setCalendar(entrega);
        dtCita.setCalendar(entrega);
        
        tlistaped.visualizarListaPedido(jtListaPedidos, "Activo", "*","*");
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(2, false);
        
        String pedidoId = String.valueOf(jtListaPedidos.getValueAt(jtListaPedidos.getSelectedRow(), 0));                
        
        // Agrego change al jtable
        ListSelectionModel rowSM = jtSpd.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //Ignore extra messages.
                if (e.getValueIsAdjusting()) return;
                ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                if (lsm.isSelectionEmpty()) {
                    //no rows are selected
                } else {
                    int row = lsm.getMinSelectionIndex();
                    //selectedRow is selected
                    LlenarSpd();
                } 
            }
        });

        // change para envio
        cmbEnvioADom.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                String envio = (String)cmbEnvioADom.getSelectedItem();
                if (envio=="N") {
                    txtObsEnvio.setText("Retira en sucursal");
                    txtDomicilioEntrega.setText("Retira en sucursal");
                } else {
                    txtObsEnvio.setText("Envío a domicilio");
                }
            }
        });
                
        cmbBusEstado.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                listar();
            }
        });
                
        txtCant.addFocusListener(new FocusListener() {
            public void focusLost(FocusEvent e) {
                if (txtCant.getText().length()==0) {
                    txtCant.setText("0");
                }
                calculaSubTotalSpd ();
//              System.out.println(((JTextField)e.getSource()).getText());
            }
            public void focusGained(FocusEvent e) {
                txtCant.selectAll();
            }
        });        

        txtPrecio.addFocusListener(new FocusListener() {
            public void focusLost(FocusEvent e) {
                if (txtPrecio.getText().length()==0) {
                    txtPrecio.setText("0");
                }
                calculaSubTotalSpd ();
            }
            public void focusGained(FocusEvent e) {
                txtPrecio.selectAll();
            }
        });        

        txtObsSpd.addFocusListener(new FocusListener() {
            public void focusLost(FocusEvent e) {
            }
            public void focusGained(FocusEvent e) {
                txtObsSpd.selectAll();
            }
        });        

        txtTotalSpd.addFocusListener(new FocusListener() {
            public void focusLost(FocusEvent e) {
            }
            public void focusGained(FocusEvent e) {
                txtTotalSpd.selectAll();
            }
        });        

        txtPDesc.addFocusListener(new FocusListener() {
            public void focusLost(FocusEvent e) {
                CalculaPedido();
            }
            public void focusGained(FocusEvent e) {
                txtPDesc.selectAll();
            }
        });        
    }
    
    public void calculaSubTotalSpd () {
        
        double total = 0;
        double cantidad=Double.parseDouble(txtCant.getText());
        double precio=Double.parseDouble(txtPrecio.getText());
        total = cantidad*precio;
        txtTotalSpd.setText(""+total); 
    }
    
    public void CalculaPedido() {

        double cpmontoPedido = 0;
        double cpdesc = 0;
        double cptotal = 0;
        double cpsaldo = 0;
        for (int i = 0; i < jtSpd.getRowCount(); i++) {
            cpmontoPedido = cpmontoPedido + Double.parseDouble(String.valueOf(jtSpd.getValueAt(i, 10)));
        }
        txtSubTotal.setText(""+cpmontoPedido); 
        cpdesc =  Double.parseDouble(txtPDesc.getText());
        cptotal = cpmontoPedido-(cpmontoPedido*cpdesc/100);
        txtTotal.setText(""+cptotal); 
        // Calculo el saldo si la forma de pago es <> a MP
        if (!cmbFPago.getSelectedItem().equals("MP")) {
            cpsaldo = cptotal - Double.parseDouble(txtSenia.getText());
            txtSaldo.setText(""+cpsaldo);
        } else {
            txtSaldo.setText("0");
        }
        
        // Preparo pedido
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaVenta = formatoFecha.format(dtFventa.getDate());
        String fechaEntrega = formatoFecha.format(dtFentrega.getDate());
        String cita = formatoFecha.format(dtCita.getDate());
        String pedidoId = txtPedidoId.getText();
        String clienteId = txtClienteId.getText();
        String estado = (String)cmbEstado.getSelectedItem();
        String senia = txtSenia.getText();
        String subTotal = txtSubTotal.getText();
        String pdesc = txtPDesc.getText();
        String total = txtTotal.getText();
        String saldo = txtSaldo.getText();
        String formaPago = (String)cmbFPago.getSelectedItem();
        String fact = (String)cmbFact.getSelectedItem();
        String envio = (String)cmbEnvio.getSelectedItem();
        String domEntrega = txtDomEntrega.getText();
        String observacion = txtObservacion.getText();
        String usuario_creacion = "admin";
        String usuario_ult_mod = "admin";

        if (pedidoId.length()==0) {
        // Inserta pedido
            String rptaRegistro = pedido.insertarPedido(clienteId, fechaVenta, fechaEntrega, estado, senia, subTotal, pdesc, total, saldo, formaPago, fact, cita, envio, domEntrega, observacion, usuario_creacion, usuario_ult_mod);
            if (rptaRegistro != null) {
                pedidoId = pedido.listPedidoMax();
                txtPedidoId.setText(pedidoId);
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar en pedido.");                
            }
        // Prepara pedido_envio
            
            ArrayList<String> cli = new ArrayList();
            cli = clienteDao.listClientexid(clienteId);

            String referente = cli.get(1);
            String dniE = cli.get(2);
            String telefonoE = cli.get(5);
            String obsEnvio = cli.get(7);
        // Inserta pedido_envio
            String rptaRegistro2 = pedidoEnvio.insertarPedidoEnvio(pedidoId, referente, dniE, telefonoE, "", "", "", "", "", "", "0", obsEnvio, usuario_creacion, usuario_ult_mod);
            if (rptaRegistro2 == null) {
                JOptionPane.showMessageDialog(null, "Error al insertar en pedido_envio.");                
            }
          
        } else {
        // Modifica pedido
            int rptaEdit = pedido.editarPedido(pedidoId, clienteId, fechaVenta, fechaEntrega, estado, senia, subTotal, pdesc, total, saldo, formaPago, fact, cita, envio, domEntrega, observacion, usuario_ult_mod);

            if (rptaEdit <= 0) {
                JOptionPane.showMessageDialog(null, "No se pudo realizar la edición.");
            }
        }
        tlistaped.visualizarListaPedido(jtListaPedidos, "Activo", "*","*");        
    }
    
    public void LimpiarElementosPedido() {
        txtPedidoId.setText("");
        txtCliente.setText("");
        txtClienteId.setText("");
        cmbEstado.setSelectedItem("Activo");        
        Calendar hoy = new GregorianCalendar();
        dtFventa.setCalendar(hoy);
        Calendar entrega = new GregorianCalendar();
        entrega.add(Calendar.DAY_OF_YEAR, 15);
        dtFentrega.setCalendar(entrega);
        dtCita.setCalendar(entrega);
        cmbFact.setSelectedItem("S");
        cmbFPago.setSelectedItem("MP");
        cmbEnvio.setSelectedItem("N");
        txtDomEntrega.setText("");
        txtObservacion.setText("");
        txtSubTotal.setText("0");
        txtPDesc.setText("0");
        txtTotal.setText("0");
        txtSenia.setText("0");        
        txtSaldo.setText("0");        
    }

    public void LimpiarElementosSpd() {
        txtSpd.setText("");
        txtProd.setText("");
        cmbEstadoSpd.setSelectedItem("Activo");
        cmbCemento.setSelectedItem("-");
        cmbVidrio.setSelectedItem("-");
        cmbParafina.setSelectedItem("-");        
        txtCant.setText("1");
        txtPrecio.setText("0");
        txtTotalSpd.setText("0");
        txtObsSpd.setText("");
    }
    
    public void LlenarSpd () {

//  LLAMAR A SPD PARA LLENAR TABLA

        int rowSpd = jtSpd.getSelectedRow();    
        txtSpd.setText(String.valueOf(jtSpd.getValueAt(rowSpd, 1)));
        txtProd.setText(String.valueOf(jtSpd.getValueAt(rowSpd, 6)));        

/*        String path_prod="";
        try {
            FileReader reader = new FileReader("src/Modelo/conf.properties");
            prop.load(reader);
            path_prod = prop.getProperty("path_fotos_prod"); 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TablaListaPedidos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TablaListaPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
  */      

        SingletonProperties sp=SingletonProperties.getInstancia();
        String path_prod= sp.getPropiedad("path_fotos_prod");

        String url = path_prod+txtProd.getText()+".jpg";
        String notFoundUrl = path_prod+"noEncontrada.png";

        File fotoAp = new File(url);
        if(fotoAp.isFile()){
            ImageIcon icon = new ImageIcon(url);  
            frmListaPedidos.lblProdFoto.setIcon(icon);  
        } else {
            ImageIcon icon = new ImageIcon(notFoundUrl);  
            frmListaPedidos.lblProdFoto.setIcon(icon);  
        }  

        txtCant.setText(String.valueOf(jtSpd.getValueAt(rowSpd, 8)));
        cmbEstadoSpd.setSelectedItem(String.valueOf(jtSpd.getValueAt(rowSpd, 2)));
        cmbCemento.setSelectedItem(String.valueOf(jtSpd.getValueAt(rowSpd, 3)));
        cmbVidrio.setSelectedItem(String.valueOf(jtSpd.getValueAt(rowSpd, 4)));        
        cmbParafina.setSelectedItem(String.valueOf(jtSpd.getValueAt(rowSpd, 5)));
        txtPrecio.setText(String.valueOf(jtSpd.getValueAt(rowSpd, 9)));
        txtTotalSpd.setText(String.valueOf(jtSpd.getValueAt(rowSpd, 10)));        
        txtObsSpd.setText(String.valueOf(jtSpd.getValueAt(rowSpd, 11)));        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu = new javax.swing.JPopupMenu();
        Copy = new javax.swing.JMenuItem();
        Paste = new javax.swing.JMenuItem();
        Cut = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbBusEstado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUserML = new javax.swing.JTextField();
        btnListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaPedidos = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtSpd = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnBuscarCli = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtClienteId = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dtFentrega = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        dtCita = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmbFPago = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtDomEntrega = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtObservacion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cmbEnvio = new javax.swing.JComboBox<>();
        dtFventa = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        cmbFact = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnEnvio = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtProd = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtObsSpd = new javax.swing.JTextField();
        btnRemove = new javax.swing.JButton();
        btnBuscarProd = new javax.swing.JButton();
        txtTotalSpd = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cmbEstadoSpd = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cmbParafina = new javax.swing.JComboBox<>();
        cmbVidrio = new javax.swing.JComboBox<>();
        cmbCemento = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtSpd = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        lblProdFoto = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtPDesc = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtSenia = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        txtPedidoId = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtPedidoIdE = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtClienteE = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txtReferente = new javax.swing.JTextField();
        txtDniE = new javax.swing.JTextField();
        txtTelefonoE = new javax.swing.JTextField();
        cmbEnvioADom = new javax.swing.JComboBox<>();
        txtDomicilioEntrega = new javax.swing.JTextField();
        cmbTransporte = new javax.swing.JComboBox<>();
        cmbCantCajas = new javax.swing.JComboBox<>();
        txtObsEnvio = new javax.swing.JTextField();
        txtProvincia = new javax.swing.JTextField();
        txtLocalidad = new javax.swing.JTextField();
        txtCodigoPostal = new javax.swing.JTextField();
        btnBuscaGeografia = new javax.swing.JButton();
        btnBusTransporte = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        btnRegistrarEnvio = new javax.swing.JButton();
        btnLimpiarEnvio = new javax.swing.JButton();
        btnRemito = new javax.swing.JButton();

        Copy.setText("Copy");
        Copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyActionPerformed(evt);
            }
        });
        jPopupMenu.add(Copy);

        Paste.setText("Paste");
        Paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasteActionPerformed(evt);
            }
        });
        jPopupMenu.add(Paste);

        Cut.setText("Cut");
        Cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CutActionPerformed(evt);
            }
        });
        jPopupMenu.add(Cut);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pedidos");
        getContentPane().setLayout(null);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));
        jPanel3.setLayout(null);

        jLabel1.setText("Estado:");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(18, 34, 64, 17);

        cmbBusEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cmbBusEstado);
        cmbBusEstado.setBounds(94, 29, 142, 27);

        jLabel2.setText("Cliente:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(361, 34, 80, 17);

        txtNombre.setComponentPopupMenu(jPopupMenu);
        jPanel3.add(txtNombre);
        txtNombre.setBounds(441, 29, 251, 27);

        jLabel3.setText("User ML:");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(768, 34, 80, 17);

        txtUserML.setComponentPopupMenu(jPopupMenu);
        jPanel3.add(txtUserML);
        txtUserML.setBounds(846, 29, 120, 27);

        btnListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListarMouseClicked(evt);
            }
        });
        jPanel3.add(btnListar);
        btnListar.setBounds(1035, 17, 60, 45);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(12, 12, 1130, 80);

        jtListaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtListaPedidos);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 1140, 530);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoMouseClicked(evt);
            }
        });
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(1160, 20, 110, 320);

        jTabbedPane1.addTab("Pedidos", jPanel1);

        jPanel2.setLayout(null);

        jLabel4.setText("Pedido Id:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 20, 80, 30);

        jtSpd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jtSpd);

        jPanel2.add(jScrollPane6);
        jScrollPane6.setBounds(0, 390, 1140, 122);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        jPanel8.setLayout(null);

        jLabel5.setText("Cliente:");
        jPanel8.add(jLabel5);
        jLabel5.setBounds(220, 27, 70, 30);

        btnBuscarCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarCliMouseClicked(evt);
            }
        });
        jPanel8.add(btnBuscarCli);
        btnBuscarCli.setBounds(550, 20, 50, 50);

        txtCliente.setEditable(false);
        jPanel8.add(txtCliente);
        txtCliente.setBounds(300, 30, 232, 27);

        jLabel6.setText("Id:");
        jPanel8.add(jLabel6);
        jLabel6.setBounds(40, 27, 40, 30);

        txtClienteId.setEditable(false);
        jPanel8.add(txtClienteId);
        txtClienteId.setBounds(90, 30, 77, 27);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(190, 10, 950, 90);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedido"));

        jLabel7.setText("FVenta:");

        jLabel8.setText("FEntrega:");

        jLabel9.setText("Cita:");

        jLabel10.setText("Estado:");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Fact:");

        cmbFPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MP", "EF", "TR", "MP-EF" }));

        jLabel12.setText("Dom Entrega:");

        txtDomEntrega.setComponentPopupMenu(jPopupMenu);
        txtDomEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDomEntregaActionPerformed(evt);
            }
        });

        jLabel13.setText("Observación:");

        txtObservacion.setComponentPopupMenu(jPopupMenu);

        jLabel14.setText("Envio:");

        cmbEnvio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N", "S" }));
        cmbEnvio.setToolTipText("");

        jLabel23.setText("FP:");

        cmbFact.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "N" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(cmbEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDomEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtFventa, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtFentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(dtCita, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(4, 4, 4)
                        .addComponent(cmbFact, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbFPago, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbFPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel23)
                        .addComponent(cmbFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dtFentrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(dtFventa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDomEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel9);
        jPanel9.setBounds(0, 100, 1140, 130);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnRegistrar.setPreferredSize(new java.awt.Dimension(65, 65));
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
        });
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEnvio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnvioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7);
        jPanel7.setBounds(1151, 121, 110, 180);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Sub_pedido"));
        jPanel10.setLayout(null);

        jLabel15.setText("Prod:");
        jPanel10.add(jLabel15);
        jLabel15.setBounds(10, 70, 50, 17);

        txtProd.setEditable(false);
        jPanel10.add(txtProd);
        txtProd.setBounds(80, 60, 112, 27);

        jLabel19.setText("Obs:");
        jPanel10.add(jLabel19);
        jLabel19.setBounds(522, 110, 60, 17);

        txtObsSpd.setComponentPopupMenu(jPopupMenu);
        jPanel10.add(txtObsSpd);
        txtObsSpd.setBounds(590, 100, 370, 27);

        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
        });
        jPanel10.add(btnRemove);
        btnRemove.setBounds(1070, 50, 53, 50);

        btnBuscarProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarProdMouseClicked(evt);
            }
        });
        jPanel10.add(btnBuscarProd);
        btnBuscarProd.setBounds(200, 50, 40, 50);

        txtTotalSpd.setText("0");
        txtTotalSpd.setComponentPopupMenu(jPopupMenu);
        jPanel10.add(txtTotalSpd);
        txtTotalSpd.setBounds(890, 60, 73, 27);

        jLabel17.setText("Spd:");
        jPanel10.add(jLabel17);
        jLabel17.setBounds(10, 30, 50, 17);

        cmbEstadoSpd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Terminado", "Cancelado" }));
        jPanel10.add(cmbEstadoSpd);
        cmbEstadoSpd.setBounds(80, 100, 112, 27);

        jLabel18.setText("Cemento:");
        jPanel10.add(jLabel18);
        jLabel18.setBounds(340, 20, 80, 17);

        jLabel26.setText("Vidrio:");
        jPanel10.add(jLabel26);
        jLabel26.setBounds(340, 70, 70, 17);

        jLabel27.setText("Parafina:");
        jPanel10.add(jLabel27);
        jLabel27.setBounds(340, 110, 80, 17);

        cmbParafina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "N", "-" }));
        jPanel10.add(cmbParafina);
        cmbParafina.setBounds(435, 100, 48, 27);

        cmbVidrio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "N", "-" }));
        jPanel10.add(cmbVidrio);
        cmbVidrio.setBounds(435, 62, 48, 27);

        cmbCemento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "N", "-" }));
        jPanel10.add(cmbCemento);
        cmbCemento.setBounds(435, 17, 48, 27);

        jLabel28.setText("Precio:");
        jPanel10.add(jLabel28);
        jLabel28.setBounds(650, 70, 60, 17);

        jLabel29.setText("SubTotal:");
        jPanel10.add(jLabel29);
        jLabel29.setBounds(820, 70, 80, 17);

        txtPrecio.setText("0");
        txtPrecio.setComponentPopupMenu(jPopupMenu);
        jPanel10.add(txtPrecio);
        txtPrecio.setBounds(720, 60, 73, 27);

        jLabel30.setText("Cant:");
        jPanel10.add(jLabel30);
        jLabel30.setBounds(520, 70, 50, 17);

        txtCant.setText("0");
        txtCant.setComponentPopupMenu(jPopupMenu);
        jPanel10.add(txtCant);
        txtCant.setBounds(584, 62, 52, 27);

        jLabel31.setText("Estado:");
        jPanel10.add(jLabel31);
        jLabel31.setBounds(10, 110, 60, 17);

        txtSpd.setEditable(false);
        jPanel10.add(txtSpd);
        txtSpd.setBounds(80, 20, 50, 27);

        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });
        jPanel10.add(btnLimpiar);
        btnLimpiar.setBounds(1010, 50, 50, 50);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(lblProdFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProdFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel14);
        jPanel14.setBounds(250, 40, 60, 70);

        jPanel2.add(jPanel10);
        jPanel10.setBounds(-1, 238, 1140, 140);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel20.setText("Sub Total:");

        txtSubTotal.setText("0");
        txtSubTotal.setComponentPopupMenu(jPopupMenu);

        jLabel21.setText("% Desc:");

        txtPDesc.setText("0");
        txtPDesc.setComponentPopupMenu(jPopupMenu);

        jLabel22.setText("Total:");

        txtTotal.setText("0");
        txtTotal.setComponentPopupMenu(jPopupMenu);

        jLabel24.setText("Senia:");

        txtSenia.setText("0");
        txtSenia.setComponentPopupMenu(jPopupMenu);

        jLabel25.setText("Saldo:");

        txtSaldo.setComponentPopupMenu(jPopupMenu);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel24)
                .addGap(4, 4, 4)
                .addComponent(txtSenia, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(txtPDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24)
                        .addComponent(txtSenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(0, 540, 1144, 50);

        txtPedidoId.setEnabled(false);
        txtPedidoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPedidoIdActionPerformed(evt);
            }
        });
        jPanel2.add(txtPedidoId);
        txtPedidoId.setBounds(90, 20, 80, 27);

        jTabbedPane1.addTab("Nuevo / Modificar", jPanel2);

        jPanel5.setLayout(null);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedido"));

        jLabel16.setText("Pedido:");

        txtPedidoIdE.setEditable(false);
        txtPedidoIdE.setComponentPopupMenu(jPopupMenu);

        jLabel32.setText("Cliente:");

        txtClienteE.setEditable(false);
        txtClienteE.setComponentPopupMenu(jPopupMenu);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPedidoIdE, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClienteE, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtPedidoIdE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(txtClienteE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel11);
        jPanel11.setBounds(0, 12, 550, 64);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de envío"));
        jPanel12.setLayout(null);

        jLabel34.setText("Referente:");
        jPanel12.add(jLabel34);
        jLabel34.setBounds(18, 34, 110, 17);

        jLabel35.setText("DNI:");
        jPanel12.add(jLabel35);
        jLabel35.setBounds(474, 34, 29, 17);

        jLabel36.setText("Teléfono:");
        jPanel12.add(jLabel36);
        jLabel36.setBounds(711, 34, 68, 17);

        jLabel40.setText("Provincia:");
        jPanel12.add(jLabel40);
        jLabel40.setBounds(18, 85, 90, 17);

        jLabel39.setText("Localidad:");
        jPanel12.add(jLabel39);
        jLabel39.setBounds(433, 85, 100, 17);

        jLabel38.setText("CP:");
        jPanel12.add(jLabel38);
        jLabel38.setBounds(784, 85, 50, 17);

        jLabel41.setText("Envío a domicilio:");
        jPanel12.add(jLabel41);
        jLabel41.setBounds(18, 137, 130, 17);

        jLabel37.setText("Domicilio entrega:");
        jPanel12.add(jLabel37);
        jLabel37.setBounds(295, 137, 150, 17);

        jLabel42.setText("Transporte:");
        jPanel12.add(jLabel42);
        jLabel42.setBounds(20, 190, 120, 30);

        jLabel43.setText("Cantidad cajas:");
        jPanel12.add(jLabel43);
        jLabel43.setBounds(789, 184, 130, 20);

        jLabel44.setText("Observación:");
        jPanel12.add(jLabel44);
        jLabel44.setBounds(18, 249, 120, 17);

        txtReferente.setComponentPopupMenu(jPopupMenu);
        jPanel12.add(txtReferente);
        txtReferente.setBounds(96, 29, 325, 27);

        txtDniE.setComponentPopupMenu(jPopupMenu);
        jPanel12.add(txtDniE);
        txtDniE.setBounds(515, 29, 120, 27);

        txtTelefonoE.setComponentPopupMenu(jPopupMenu);
        jPanel12.add(txtTelefonoE);
        txtTelefonoE.setBounds(797, 29, 231, 27);

        cmbEnvioADom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N", "S" }));
        jPanel12.add(cmbEnvioADom);
        cmbEnvioADom.setBounds(146, 132, 60, 27);

        txtDomicilioEntrega.setComponentPopupMenu(jPopupMenu);
        jPanel12.add(txtDomicilioEntrega);
        txtDomicilioEntrega.setBounds(433, 132, 595, 27);

        cmbTransporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel12.add(cmbTransporte);
        cmbTransporte.setBounds(120, 190, 309, 27);

        cmbCantCajas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        jPanel12.add(cmbCantCajas);
        cmbCantCajas.setBounds(910, 179, 118, 27);

        txtObsEnvio.setComponentPopupMenu(jPopupMenu);
        jPanel12.add(txtObsEnvio);
        txtObsEnvio.setBounds(112, 244, 916, 27);

        txtProvincia.setComponentPopupMenu(jPopupMenu);
        jPanel12.add(txtProvincia);
        txtProvincia.setBounds(96, 80, 325, 27);

        txtLocalidad.setComponentPopupMenu(jPopupMenu);
        jPanel12.add(txtLocalidad);
        txtLocalidad.setBounds(515, 80, 248, 27);

        txtCodigoPostal.setComponentPopupMenu(jPopupMenu);
        jPanel12.add(txtCodigoPostal);
        txtCodigoPostal.setBounds(820, 80, 142, 27);

        btnBuscaGeografia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscaGeografiaMouseClicked(evt);
            }
        });
        jPanel12.add(btnBuscaGeografia);
        btnBuscaGeografia.setBounds(980, 70, 40, 40);

        btnBusTransporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBusTransporteMouseClicked(evt);
            }
        });
        jPanel12.add(btnBusTransporte);
        btnBusTransporte.setBounds(440, 180, 50, 50);

        jPanel5.add(jPanel12);
        jPanel12.setBounds(0, 82, 1080, 290);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnRegistrarEnvio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarEnvioMouseClicked(evt);
            }
        });

        btnRemito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemitoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrarEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(btnLimpiarEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnRegistrarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnLimpiarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel5.add(jPanel13);
        jPanel13.setBounds(1120, 80, 130, 300);

        jTabbedPane1.addTab("Envío", jPanel5);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 1290, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListarMouseClicked

        if (evt.getSource() == btnListar) {
            listar();
        }
    }//GEN-LAST:event_btnListarMouseClicked

    private void txtCantActionPerformed(java.awt.event.ActionEvent evt) {
    }  
    private void btnBuscarCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarCliMouseClicked
        frmClientes clientes = new frmClientes("ListaPedido");

        frmPrincipal.Escritorio.add(clientes);
        try {
            clientes.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        clientes.toFront();
        clientes.setVisible(true);
    }//GEN-LAST:event_btnBuscarCliMouseClicked

    private void txtDomEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDomEntregaActionPerformed
    }//GEN-LAST:event_txtDomEntregaActionPerformed

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        CalculaPedido();

        // Preparo sub_pedido    
        spd = new SpdDAO();

        String subPedido = txtSpd.getText();
        String estadoSpd = (String)cmbEstadoSpd.getSelectedItem();
        String cemento = (String)cmbCemento.getSelectedItem();
        String vidrio = (String)cmbVidrio.getSelectedItem();
        String parafina = (String)cmbParafina.getSelectedItem();
        String prod = txtProd.getText();
        String cantidad = txtCant.getText();
        String precio = txtPrecio.getText();
        String totalSpd = txtTotalSpd.getText();
        String observacionSpd = txtObsSpd.getText();
        String pedidoId = txtPedidoId.getText();
        String usuario_creacion = "admin";
        String usuario_ult_mod = "admin";
        
        if (txtSpd.getText().length()==0) {
        // Insertar
            //Calcular sub_pedido Select max
            String maxSpd = spd.listSpdMax(pedidoId);
            int subpedido = Integer.parseInt(maxSpd) + 1;
            
            String rptaRegistro = spd.insertSpd(pedidoId, String.valueOf(subpedido), estadoSpd, cemento, vidrio, parafina, prod, cantidad, precio, totalSpd, observacionSpd, usuario_creacion, usuario_ult_mod);

            if (rptaRegistro != null) {
                tspd.visualizarSpd(jtSpd, pedidoId);
            } else {
                JOptionPane.showMessageDialog(null, "Registro erroneo.");                
            }
        } else {
            // Modificar
            int rptaEdita = JOptionPane.showConfirmDialog(null, "Desea modificar el Pedido: " + txtSpd.getText() + " - SubPedido: " + txtSpd.getText() + " ?");
            if (rptaEdita==0) {

                int rptaEdit = spd.editarSpd(pedidoId, subPedido, estadoSpd, cemento, vidrio, parafina, prod, cantidad, precio, totalSpd, observacionSpd, usuario_ult_mod);

                if (rptaEdit <= 0) {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la edición.");
                } else {
                    tspd.visualizarSpd(jtSpd, pedidoId);      
                }
            }
        }   
        CalculaPedido();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        LimpiarElementosSpd();
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseClicked
        LimpiarElementosSpd();
        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setSelectedIndex(1);  
    }//GEN-LAST:event_btnNuevoMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked

        int rowPedido = jtListaPedidos.getSelectedRow();    
        txtPedidoId.setText(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 1)));
        txtClienteId.setText(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 6)));
        txtCliente.setText(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 7)));
        try {
            Date fechaParseada= new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 8)));            
            dtFventa.setDate(fechaParseada);
            Date fechaParseada2= new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 9)));
            dtFentrega.setDate(fechaParseada2);
            Date fechaParseada3= new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 21)));
            dtCita.setDate(fechaParseada3);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        cmbFact.setSelectedItem(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 14)));
        cmbEnvio.setSelectedItem(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 18)));
        cmbFPago.setSelectedItem(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 15)));        
        txtDomEntrega.setText(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 19)));
        txtObservacion.setText(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 22)));
        cmbEstado.setSelectedItem(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 10)));
        txtSubTotal.setText(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 12)));
        txtTotal.setText(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 14)));
        txtPDesc.setText(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 13)));
        txtSenia.setText(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 11)));
        txtSaldo.setText(String.valueOf(jtListaPedidos.getValueAt(rowPedido, 15)));
        tspd.visualizarSpd(jtSpd, String.valueOf(jtListaPedidos.getValueAt(rowPedido, 1)));

        LlenarSpd();
        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setSelectedIndex(1);          
        
    }//GEN-LAST:event_btnModificarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked

        String estado = (String)cmbBusEstado.getSelectedItem();
        String nombre = "*";
        String userML = "*";            

        int row = jtListaPedidos.getSelectedRow();
        int rptaElimina = JOptionPane.showConfirmDialog(null, "Desea eliminar el pedido: " + String.valueOf(jtListaPedidos.getValueAt(row, 0) + "?"));
        if (rptaElimina==0) {
            pedido.eliminarPedido(String.valueOf(jtListaPedidos.getValueAt(row, 1)));
            tlistaped.visualizarListaPedido(jtListaPedidos, estado, nombre, userML);
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtPedidoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPedidoIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPedidoIdActionPerformed

    private void btnBuscarProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarProdMouseClicked
        frmProductos producto = new frmProductos("ListaPedido");

        frmPrincipal.Escritorio.add(producto);
        try {
            producto.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        producto.toFront();
        producto.setVisible(true);
    }//GEN-LAST:event_btnBuscarProdMouseClicked

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        // Elimina sub_pedido
        spd = new SpdDAO();    
        String pedidoId = txtPedidoId.getText();
        String subPedido = txtSpd.getText();
        int rptaEdita = JOptionPane.showConfirmDialog(null, "Desea Eliminar el Spd: " + txtSpd.getText() + " ?");
        if (rptaEdita==0) {

            int rptaEdit = spd.eliminarSpd(pedidoId, subPedido);

            if (rptaEdit <= 0) {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar.");
            } else {
                tspd.visualizarSpd(jtSpd, pedidoId);      
            }
        }
        CalculaPedido();
        
    }//GEN-LAST:event_btnRemoveMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

        // jTabbedPane1.getSelectedIndex() esto te entrega el indice del tab que seleccionaste
        if (jTabbedPane1.getSelectedIndex()==0) {
            jTabbedPane1.setEnabledAt(1, false);
            jTabbedPane1.setEnabledAt(2, false);
            LimpiarElementosSpd();
            LimpiarElementosPedido();
            tspd.limparTspd(jtSpd);
            // Limpiar pedido envio
            listar();
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void CopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyActionPerformed
        clipboard = (JTextField) jPopupMenu.getInvoker();
        clipboard.copy();
    }//GEN-LAST:event_CopyActionPerformed

    private void PasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasteActionPerformed
        clipboard = (JTextField) jPopupMenu.getInvoker();
        clipboard.paste();
    }//GEN-LAST:event_PasteActionPerformed

    private void CutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutActionPerformed
        clipboard = (JTextField) jPopupMenu.getInvoker();
        clipboard.cut();
    }//GEN-LAST:event_CutActionPerformed

    private void btnEnvioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnvioMouseClicked
        txtPedidoIdE.setText(txtPedidoId.getText());
        jTabbedPane1.setEnabledAt(2, true);
        jTabbedPane1.setSelectedIndex(2);  
        ArrayList<String> envio = new ArrayList();
        envio = pedidoEnvio.listPedidoEnvio(txtPedidoIdE.getText());
        
        txtClienteE.setText(txtCliente.getText()); 
        txtReferente.setText(envio.get(1)); 
        txtDniE.setText(envio.get(2));
        txtTelefonoE.setText(envio.get(3));
        txtProvincia.setText(envio.get(7));
        txtLocalidad.setText(envio.get(5));
        txtCodigoPostal.setText(envio.get(6));
        cmbEnvioADom.setSelectedItem(envio.get(8));
        txtDomicilioEntrega.setText(envio.get(4));
        cmbTransporte.setSelectedItem(envio.get(9));
        cmbCantCajas.setSelectedItem(envio.get(10));
        txtObsEnvio.setText(envio.get(11));
    }//GEN-LAST:event_btnEnvioMouseClicked

    private void btnBuscaGeografiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscaGeografiaMouseClicked
        frmGeografia geografias = new frmGeografia("ListaPedido");

        frmPrincipal.Escritorio.add(geografias);
        try {
            geografias.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        geografias.toFront();
        geografias.setVisible(true);
    }//GEN-LAST:event_btnBuscaGeografiaMouseClicked

    private void btnBusTransporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusTransporteMouseClicked
        frmTransportes transportes = new frmTransportes("ListaPedido");

        frmPrincipal.Escritorio.add(transportes);
        try {
            transportes.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        transportes.toFront();
        transportes.setVisible(true);
    }//GEN-LAST:event_btnBusTransporteMouseClicked

    private void btnRegistrarEnvioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarEnvioMouseClicked
        // Editar Envio

        String pedido = txtPedidoIdE.getText();
        String referente = txtReferente.getText();
        String dni = txtDniE.getText();
        String telefono = txtTelefonoE.getText();
        String domEntrega = txtDomicilioEntrega.getText();
        String localidad = txtLocalidad.getText();                
        String codigoPostal = txtCodigoPostal.getText();        
        String provincia = txtProvincia.getText();        
        String envioADom = (String)cmbEnvioADom.getSelectedItem();
        String transporte = (String)cmbTransporte.getSelectedItem();
        String cantCajas = (String)cmbCantCajas.getSelectedItem();        
        String obsEnvio = txtObsEnvio.getText();        
        String usuario_creacion = "admin";
        String usuario_ult_mod = "admin";
        // Modificar

        int rptaEdita = JOptionPane.showConfirmDialog(null, "Desea modificar el envio?");
        if (rptaEdita==0) {

            int rptaEdit = pedidoEnvio.editarPedidoEnvio(pedido, referente, dni, telefono, domEntrega, localidad, codigoPostal, provincia, envioADom, transporte, cantCajas, obsEnvio, usuario_ult_mod);

            if (rptaEdit <= 0) {
                JOptionPane.showMessageDialog(null, "No se pudo realizar la edición.");
            } else {
//                tspd.visualizarSpd(jtSpd, pedidoId);      
            }
        }
        
    }//GEN-LAST:event_btnRegistrarEnvioMouseClicked

    private void btnRemitoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemitoMouseClicked

        SingletonProperties sp=SingletonProperties.getInstancia();
        String path_remito = sp.getPropiedad("path_remito");
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String arch = "envio_"+txtReferente.getText().replace(" ","_")+"_"+formateador.format(ahora);

        // Se crea el documento
        Document documento = new Document();
        FileOutputStream ficheroPdf;
        try {
            // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
            ficheroPdf = new FileOutputStream(path_remito+arch);
            // Se asocia el documento al OutputStream y se indica que el espaciado entre
            // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
            PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
            // Se abre el documento.
            documento.open();
            String cantBultos;
            if (cmbCantCajas.getSelectedItem().equals("1")) {
                cantBultos = "bulto";
            } else {
                cantBultos = "bultos";
            }
            
            for (int i=1; i<=Integer.parseInt((String)cmbCantCajas.getSelectedItem());i++) {
                Paragraph p1 = new Paragraph("Nombre: "+txtReferente.getText()+". DNI: "+txtDniE.getText());
                Paragraph p2 = new Paragraph("Domicilio: "+txtDomicilioEntrega.getText());
                Paragraph p3 = new Paragraph("Localidad: "+txtLocalidad.getText()+" - "+txtProvincia.getText()+". CP: "+txtCodigoPostal.getText());
                Paragraph p4 = new Paragraph("Observación: "+txtObsEnvio.getText()+". "+(String)cmbCantCajas.getSelectedItem()+ " " + cantBultos);            
                Paragraph p5 = new Paragraph("Teléfono: "+txtTelefonoE.getText());            
                Paragraph p6 = new Paragraph("Caja: " + i + " de " + (String)cmbCantCajas.getSelectedItem());
                Paragraph p7 = new Paragraph("----------------------------------");
                Paragraph p8 = new Paragraph("Remitente: Isabel Peña. Cuit: 27-23869777-3");
                Paragraph p9 = new Paragraph("Domicilio: Av Segurola 1523. CP: 1407");
                Paragraph p10 = new Paragraph("Ciudad: Floresta, Capital Federal");
                Paragraph p11 = new Paragraph("Teléfono: 0111563379203/01145665219");
                Paragraph p12 = new Paragraph("www.labranzas.com.ar - decolabranzas@hotmail.com");
                Paragraph p13 = new Paragraph(" ");

                p1.setAlignment(Element.ALIGN_CENTER);
                p2.setAlignment(Element.ALIGN_CENTER);
                p3.setAlignment(Element.ALIGN_CENTER);
                p4.setAlignment(Element.ALIGN_CENTER);
                p5.setAlignment(Element.ALIGN_CENTER);
                p6.setAlignment(Element.ALIGN_CENTER);
                p7.setAlignment(Element.ALIGN_CENTER);
                p8.setAlignment(Element.ALIGN_CENTER);
                p9.setAlignment(Element.ALIGN_CENTER);
                p10.setAlignment(Element.ALIGN_CENTER);
                p11.setAlignment(Element.ALIGN_CENTER);
                p12.setAlignment(Element.ALIGN_CENTER);            
                p13.setAlignment(Element.ALIGN_CENTER);            

                documento.add(p1);
                documento.add(p2);
                documento.add(p3);
                documento.add(p4);
                documento.add(p5);
                documento.add(p6);
                documento.add(p7);
                documento.add(p8);
                documento.add(p9);
                documento.add(p10);
                documento.add(p11);
                documento.add(p12);            
                documento.add(p13);
                
                if (i==3) {
                    documento.newPage();
                }
            }

/* documento.add(new Paragraph("Este es el segundo y tiene una fuente rara",
				FontFactory.getFont("arial",   // fuente
				22,                            // tamaño
				Font.ITALIC,                   // estilo
				BaseColor.CYAN)));             // color
*/

            documento.close();
            JOptionPane.showMessageDialog(null, "pdf generado: "+path_remito+arch);
            
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(frmListaPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRemitoMouseClicked

    public void listar() {    
        String estado = (String)cmbBusEstado.getSelectedItem();
        String nombre = "*";
        String userML = "*";            
        if (!txtNombre.getText().equals("")) {
            nombre = txtNombre.getText();
        }
        if (!txtUserML.getText().equals("")) {
            userML = txtUserML.getText();
        }            
        tlistaped.visualizarListaPedido(jtListaPedidos, estado, nombre, userML);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Copy;
    private javax.swing.JMenuItem Cut;
    private javax.swing.JMenuItem Paste;
    public javax.swing.JButton btnBusTransporte;
    public javax.swing.JButton btnBuscaGeografia;
    public javax.swing.JButton btnBuscarCli;
    public javax.swing.JButton btnBuscarProd;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnEnvio;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnLimpiarEnvio;
    public javax.swing.JButton btnListar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JButton btnRegistrarEnvio;
    public javax.swing.JButton btnRemito;
    public javax.swing.JButton btnRemove;
    public javax.swing.JComboBox<String> cmbBusEstado;
    public javax.swing.JComboBox<String> cmbCantCajas;
    public static javax.swing.JComboBox<String> cmbCemento;
    public static javax.swing.JComboBox<String> cmbEnvio;
    public javax.swing.JComboBox<String> cmbEnvioADom;
    public javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbEstadoSpd;
    public javax.swing.JComboBox<String> cmbFPago;
    public javax.swing.JComboBox<String> cmbFact;
    public static javax.swing.JComboBox<String> cmbParafina;
    public static javax.swing.JComboBox<String> cmbTransporte;
    public static javax.swing.JComboBox<String> cmbVidrio;
    public com.toedter.calendar.JDateChooser dtCita;
    public com.toedter.calendar.JDateChooser dtFentrega;
    public com.toedter.calendar.JDateChooser dtFventa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jtListaPedidos;
    public javax.swing.JTable jtSpd;
    public static javax.swing.JLabel lblProdFoto;
    public static javax.swing.JTextField txtCant;
    public static javax.swing.JTextField txtCliente;
    public static javax.swing.JTextField txtClienteE;
    public static javax.swing.JTextField txtClienteId;
    public static javax.swing.JTextField txtCodigoPostal;
    public javax.swing.JTextField txtDniE;
    public static javax.swing.JTextField txtDomEntrega;
    public javax.swing.JTextField txtDomicilioEntrega;
    public static javax.swing.JTextField txtLocalidad;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtObsEnvio;
    public javax.swing.JTextField txtObsSpd;
    public javax.swing.JTextField txtObservacion;
    private javax.swing.JTextField txtPDesc;
    public javax.swing.JTextField txtPedidoId;
    public static javax.swing.JTextField txtPedidoIdE;
    public static javax.swing.JTextField txtPrecio;
    public static javax.swing.JTextField txtProd;
    public static javax.swing.JTextField txtProvincia;
    public javax.swing.JTextField txtReferente;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtSenia;
    public javax.swing.JTextField txtSpd;
    private javax.swing.JTextField txtSubTotal;
    public javax.swing.JTextField txtTelefonoE;
    private javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txtTotalSpd;
    public javax.swing.JTextField txtUserML;
    // End of variables declaration//GEN-END:variables
}
