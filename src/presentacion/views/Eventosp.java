/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion.views;

import ControlErrores.ControlErrores;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import presentacion.logica.EventosVista;

/**
 *
 * @author Dev
 */
public class Eventosp extends javax.swing.JPanel {

    private DefaultTableModel modelo;
    private double valorTotal;
    private ControlErrores e;
    private EventosVista vista;
    private Choice listaServicios;
    private JComboBox<String> listaEstados;
    private String objtabla;

    public Eventosp() {
        initComponents();
        llenarTodo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelbackprincipal = new javax.swing.JPanel();
        jPanelback = new javax.swing.JPanel();
        jPanelform = new javax.swing.JPanel();
        jPanellistaservicios = new javax.swing.JPanel();
        jButtonagregarservicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1servicios = new javax.swing.JTable();
        jPanelchoice = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelvalor = new javax.swing.JLabel();
        jLabeltitulovalor = new javax.swing.JLabel();
        jPanelevento = new javax.swing.JPanel();
        jLabel1nombre = new javax.swing.JLabel();
        jTextFieldnombreevento = new javax.swing.JTextField();
        jLabel2fecha = new javax.swing.JLabel();
        rSDateChooserfecha = new rojeru_san.componentes.RSDateChooser();
        jLabel1descripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreadescripcion = new javax.swing.JTextArea();
        jLabelestado = new javax.swing.JLabel();
        jButtoninsertarEvento = new javax.swing.JButton();
        jPanelcombo = new javax.swing.JPanel();
        jLabelsubtotalñtitulo = new javax.swing.JLabel();
        jTextFieldsubtotal = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(910, 430));

        jPanelbackprincipal.setBackground(new java.awt.Color(255, 255, 255));

        jPanelback.setBackground(new java.awt.Color(255, 255, 255));
        jPanelback.setPreferredSize(new java.awt.Dimension(910, 430));

        jPanellistaservicios.setBackground(new java.awt.Color(255, 255, 255));

        jButtonagregarservicio.setText("Agregar");
        jButtonagregarservicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonagregarservicioActionPerformed(evt);
            }
        });

        jLabel1.setText("Servicios agregados");

        jLabel2.setText("Agregar servicios");

        jTable1servicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1servicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1serviciosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1servicios);

        jPanelchoice.setBackground(new java.awt.Color(255, 255, 255));
        jPanelchoice.setMaximumSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout jPanelchoiceLayout = new javax.swing.GroupLayout(jPanelchoice);
        jPanelchoice.setLayout(jPanelchoiceLayout);
        jPanelchoiceLayout.setHorizontalGroup(
            jPanelchoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelchoiceLayout.setVerticalGroup(
            jPanelchoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelvalor.setBackground(new java.awt.Color(255, 255, 255));
        jLabelvalor.setFont(new java.awt.Font("Lucida Fax", 1, 36)); // NOI18N
        jLabelvalor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelvalor.setEnabled(false);

        jLabeltitulovalor.setText("Valor total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabeltitulovalor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelvalor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelvalor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabeltitulovalor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanellistaserviciosLayout = new javax.swing.GroupLayout(jPanellistaservicios);
        jPanellistaservicios.setLayout(jPanellistaserviciosLayout);
        jPanellistaserviciosLayout.setHorizontalGroup(
            jPanellistaserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanellistaserviciosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanellistaserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanellistaserviciosLayout.createSequentialGroup()
                        .addComponent(jPanelchoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonagregarservicio))
                    .addGroup(jPanellistaserviciosLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                        .addGap(104, 104, 104))
                    .addGroup(jPanellistaserviciosLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(117, 117, 117))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanellistaserviciosLayout.setVerticalGroup(
            jPanellistaserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanellistaserviciosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addGroup(jPanellistaserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonagregarservicio, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jPanelchoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        jPanelevento.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1nombre.setText("Nombre evento");

        jLabel2fecha.setText("Fecha Evento");

        jLabel1descripcion.setText("Descripción evento");

        jTextAreadescripcion.setColumns(20);
        jTextAreadescripcion.setRows(5);
        jScrollPane1.setViewportView(jTextAreadescripcion);

        jLabelestado.setText("Estado factura");

        jButtoninsertarEvento.setText("Crear evento");
        jButtoninsertarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoninsertarEventoActionPerformed(evt);
            }
        });

        jPanelcombo.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelcomboLayout = new javax.swing.GroupLayout(jPanelcombo);
        jPanelcombo.setLayout(jPanelcomboLayout);
        jPanelcomboLayout.setHorizontalGroup(
            jPanelcomboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelcomboLayout.setVerticalGroup(
            jPanelcomboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLabelsubtotalñtitulo.setText("Subtotal");

        javax.swing.GroupLayout jPaneleventoLayout = new javax.swing.GroupLayout(jPanelevento);
        jPanelevento.setLayout(jPaneleventoLayout);
        jPaneleventoLayout.setHorizontalGroup(
            jPaneleventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneleventoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneleventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPaneleventoLayout.createSequentialGroup()
                        .addComponent(jLabel1nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(251, 251, 251))
                    .addGroup(jPaneleventoLayout.createSequentialGroup()
                        .addComponent(jLabel1descripcion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPaneleventoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPaneleventoLayout.createSequentialGroup()
                        .addGroup(jPaneleventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSDateChooserfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPaneleventoLayout.createSequentialGroup()
                                .addComponent(jLabel2fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(86, 86, 86))
                            .addComponent(jTextFieldnombreevento))
                        .addGap(161, 161, 161))
                    .addGroup(jPaneleventoLayout.createSequentialGroup()
                        .addComponent(jLabelestado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(273, 273, 273))))
            .addGroup(jPaneleventoLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jButtoninsertarEvento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(155, 155, 155))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaneleventoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneleventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPaneleventoLayout.createSequentialGroup()
                        .addComponent(jLabelsubtotalñtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTextFieldsubtotal, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelcombo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(161, 161, 161))
        );
        jPaneleventoLayout.setVerticalGroup(
            jPaneleventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneleventoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldnombreevento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2fecha)
                .addGap(7, 7, 7)
                .addComponent(rSDateChooserfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabelestado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelsubtotalñtitulo)
                .addGap(4, 4, 4)
                .addComponent(jTextFieldsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1descripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtoninsertarEvento)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelformLayout = new javax.swing.GroupLayout(jPanelform);
        jPanelform.setLayout(jPanelformLayout);
        jPanelformLayout.setHorizontalGroup(
            jPanelformLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelformLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelevento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanellistaservicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelformLayout.setVerticalGroup(
            jPanelformLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelformLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelformLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanellistaservicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelevento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelbackLayout = new javax.swing.GroupLayout(jPanelback);
        jPanelback.setLayout(jPanelbackLayout);
        jPanelbackLayout.setHorizontalGroup(
            jPanelbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelbackLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelform, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelbackLayout.setVerticalGroup(
            jPanelbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelbackLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelform, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelbackprincipalLayout = new javax.swing.GroupLayout(jPanelbackprincipal);
        jPanelbackprincipal.setLayout(jPanelbackprincipalLayout);
        jPanelbackprincipalLayout.setHorizontalGroup(
            jPanelbackprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelback, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
        );
        jPanelbackprincipalLayout.setVerticalGroup(
            jPanelbackprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelback, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelbackprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelbackprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonagregarservicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonagregarservicioActionPerformed

        int selectedIndex;
        String selectedValue;
        Object[] obj;
        boolean isExiste;

        selectedIndex = listaServicios.getSelectedIndex();

        if (selectedIndex > -1) {
            selectedValue = listaServicios.getItem(selectedIndex);
            isExiste = false;

            if (getE().isValidString(objtabla)) {
                if (objtabla.contains(selectedValue)) {
                    isExiste = true;
                }
            }

            if (!isExiste) {
                if (!selectedValue.contains("0 ")) {

                    double valorV;

                    obj = getvista().llenartablaServicios(selectedValue);
                    valorV = getvista().valorTotalServicios(selectedValue);

                    if (obj != null) {
                        modelo.addRow(obj);
                        if (!getE().isValidString(objtabla)) {
                            objtabla = selectedValue;
                        } else {
                            objtabla += ", " + selectedValue;
                        }
                    }

                    sumarValores(valorV);
                    jTable1servicios.setModel(modelo);

                } else {
                    JOptionPane.showMessageDialog(null, "Debe ser una opcion valida");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe agregar un unico servicio para el evento");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe ser una opcion valida");
        }
    }//GEN-LAST:event_jButtonagregarservicioActionPerformed

    private void jTable1serviciosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1serviciosMousePressed
        if (evt.getClickCount() == 1) {
            if (jTable1servicios.getSelectedRowCount() > 0) {

                int in;
                int op;

                String[] opc = {"SI", "NO"};
                in = 0;

                op = JOptionPane.showOptionDialog(
                        null,
                        "Que desea eliminar servicio de la lista",
                        "Operacion",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        opc,
                        null
                );

                if (opc[op].equalsIgnoreCase("SI")) {

                    double valorremovido;
                    int columnCount;
                    Object[] rowData;
                    String valors;

                    in = jTable1servicios.getSelectedRow();
                    columnCount = jTable1servicios.getColumnCount();
                    rowData = new Object[columnCount];
                    valorremovido = 0;

                    for (int i = 0; i < columnCount; i++) {
                        rowData[i] = jTable1servicios.getValueAt(in, i);
                    }

                    valors = rowData[1].toString();

                    if (getE().isValidString(valors)) {
                        valorremovido = Double.valueOf(valors);
                        restarValores(valorremovido);
                    }
                    modelo.removeRow(in);
                    eliminarServicioLista(rowData[0].toString());

                    listaServicios.select(0);

                }
            }
        }
    }//GEN-LAST:event_jTable1serviciosMousePressed

    private void jButtoninsertarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoninsertarEventoActionPerformed
        boolean error;
        int selectindex;
        Date fechaCaptura;
        String nombreEvento;
        String estadoEvento;
        String descripcion;
        String servicios;
        String subtotal;
        String mensajeError;
        String documento;
        String tDoc;

        error = false;
        mensajeError = "";

        selectindex = listaEstados.getSelectedIndex();

        fechaCaptura = rSDateChooserfecha.getDatoFecha();
        nombreEvento = jTextFieldnombreevento.getText();
        estadoEvento = listaEstados.getItemAt(selectindex);
        descripcion = jTextAreadescripcion.getText();
        servicios = objtabla;
        subtotal = jTextFieldsubtotal.getText();
        documento = "0987654321";
        tDoc = "CC";

        if (!getE().isValidString(nombreEvento)) {
            error = true;
            mensajeError = "El nombre del evento no puede ser vacio o null";
        }
        if (!getE().isValidString(estadoEvento)) {
            error = true;
            mensajeError = "se debe seleccionar estado evento";
        }
        if (!getE().isValidString(descripcion)) {
            error = true;
            mensajeError = "se ingresar descripcion de evento";
        }
        if (!getE().isValidString(servicios)) {
            error = true;
            mensajeError = "Se debe seleccionar al menos un servicio";
        }

        if (fechaCaptura == null) {
            error = true;
            mensajeError = "Se ingresar fecha";
        } else {
            if (fechaCaptura.before(new Date())) {
                error = true;
                mensajeError = "la fecha no puede ser anterior a la fecha actual";
            }

            if (fechaCaptura.equals(new Date())) {
                error = true;
                mensajeError = "la fecha tiene que ser superior a la fecha actual";
            }
        }

        if (estadoEvento.equalsIgnoreCase("pendiente")) {
            if (!getE().isValidString(subtotal)) {
                error = true;
                mensajeError = "Se debe ingresar subtotal cuando se indica pendiente el estado";
            }
        }

        if (error) {
            JOptionPane.showMessageDialog(null, mensajeError);
        } else {
            
            getvista().insertarEvento(documento, tDoc, fechaCaptura, nombreEvento, estadoEvento, descripcion, servicios, subtotal, valorTotal);
            limpiarCampos();
        }
    }//GEN-LAST:event_jButtoninsertarEventoActionPerformed

    private EventosVista getvista() {
        vista = new EventosVista();
        return vista;
    }

    private void llenarlistaservicios() {
        listaServicios = new Choice();
        listaServicios = getvista().llenarListaServicios();
        listaServicios.select(0);
        jPanelchoice.add(listaServicios);
    }

    private void llenarEstados() {
        listaEstados = new JComboBox<>();
        listaEstados = getvista().llenarListaEstados();
        listaEstados.setSelectedItem(0);
        jPanelcombo.add(listaEstados);
    }

    private void intModelo() {
        valorTotal = 0;
        modelo = new DefaultTableModel();
        modelo.addColumn("NOMBRE");
        modelo.addColumn("VALOR");
        jTable1servicios.repaint();
    }

    private ControlErrores getE() {
        e = new ControlErrores();
        return e;
    }

    private void eliminarServicioLista(String nombreServicio) {
        if (getE().isValidString(objtabla)) {
            String cadena;
            cadena = objtabla;

            cadena = cadena.replaceAll("\\d+ - " + nombreServicio + "(, |$)", "");
            cadena = cadena.replaceAll(",\\s*(?=,|$)", "");
            objtabla = cadena;
        }
    }

    private void sumarValores(double a) {
        if (a > 0) {
            String valorCadena;
            double valort;
            double val;

            valorCadena = "";
            valort = 0;
            val = 0;

            if (valorTotal == 0) {
                valorTotal = a;
                valorCadena = String.valueOf(valorTotal);
            } else {

                valort = valorTotal;
                val = valort + a;
                valorTotal = val;
                valorCadena = String.valueOf(val);
            }

            jLabelvalor.setText(valorCadena);

        }
    }

    private void restarValores(double a) {
        if (a > 0) {
            double valor;
            double valorE;
            double total;
            String valorCadena;

            valor = 0;
            valorE = 0;
            total = 0;
            valorCadena = "";

            if (valorTotal > 0) {

                valor = valorTotal;
                valorE = a;

                total = valor - valorE;
                valorTotal = total;
                valorCadena = String.valueOf(total);

            }
            jLabelvalor.setText(valorCadena);
        }
    }

    private void limpiarCampos() {
        
        showJpanel(jPanellistaservicios);
    }
    
    private void showJpanel(JPanel p)
    {
        jPanelbackprincipal.removeAll();
        jPanelbackprincipal.add(p);
        jPanelbackprincipal.revalidate();
        jPanelbackprincipal.repaint();
    }

    private void llenarTodo() {
        llenarlistaservicios();
        llenarEstados();
        intModelo();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonagregarservicio;
    private javax.swing.JButton jButtoninsertarEvento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1descripcion;
    private javax.swing.JLabel jLabel1nombre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel2fecha;
    private javax.swing.JLabel jLabelestado;
    private javax.swing.JLabel jLabelsubtotalñtitulo;
    private javax.swing.JLabel jLabeltitulovalor;
    private javax.swing.JLabel jLabelvalor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelback;
    private javax.swing.JPanel jPanelbackprincipal;
    private javax.swing.JPanel jPanelchoice;
    private javax.swing.JPanel jPanelcombo;
    private javax.swing.JPanel jPanelevento;
    private javax.swing.JPanel jPanelform;
    private javax.swing.JPanel jPanellistaservicios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1servicios;
    private javax.swing.JTextArea jTextAreadescripcion;
    private javax.swing.JTextField jTextFieldnombreevento;
    private javax.swing.JTextField jTextFieldsubtotal;
    private rojeru_san.componentes.RSDateChooser rSDateChooserfecha;
    // End of variables declaration//GEN-END:variables
}
