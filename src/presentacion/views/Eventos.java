/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion.views;

import ControlErrores.ControlErrores;
import java.awt.Choice;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import presentacion.logica.EventosVista;

/**
 *
 * @author Dev
 */
public class Eventos extends javax.swing.JPanel {

    private DefaultTableModel modelo;
    private double valorTotal;
    private ControlErrores e;

    public Eventos() {
        initComponents();
        llenarlistaservicios();
        intModelo();
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
        jComboBox1estado = new javax.swing.JComboBox<>();
        jButtoninsertarEvento = new javax.swing.JButton();

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

        jComboBox1estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtoninsertarEvento.setText("Crear evento");

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
                        .addComponent(jLabelestado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(176, 176, 176))
                    .addGroup(jPaneleventoLayout.createSequentialGroup()
                        .addGroup(jPaneleventoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSDateChooserfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPaneleventoLayout.createSequentialGroup()
                                .addComponent(jLabel2fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(86, 86, 86))
                            .addComponent(jTextFieldnombreevento)
                            .addComponent(jComboBox1estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(161, 161, 161))))
            .addGroup(jPaneleventoLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jButtoninsertarEvento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(155, 155, 155))
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
                .addGap(8, 8, 8)
                .addComponent(jComboBox1estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1descripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtoninsertarEvento)
                .addContainerGap(23, Short.MAX_VALUE))
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

        selectedIndex = listaServicios.getSelectedIndex();
        selectedValue = listaServicios.getItem(selectedIndex);

        if (!selectedValue.contains("0 ")) {

            double valorV;

            obj = getvista().llenartablaServicios(selectedValue);
            valorV = getvista().valorTotalServicios(selectedValue);

            if (obj != null) {
                modelo.addRow(obj);
            }

            jTable1servicios.setModel(modelo);

            if (valorTotal == 0) {
                valorTotal = valorV;
            } else {
                valorTotal = valorTotal + valorV;
            }
            jLabelvalor.setText(String.valueOf(valorTotal));

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
                        double resultado;

                        valorremovido = Double.parseDouble(valors);

                        resultado = valorTotal - valorremovido;

                        if (resultado == 0) {
                            valorTotal = 0;
                        } else {
                            valorTotal = resultado;
                        }
                    }
                    modelo.removeRow(in);

                    jLabelvalor.setText(String.valueOf(valorTotal));
                    listaServicios.select(0);

                }
            }
        }
    }//GEN-LAST:event_jTable1serviciosMousePressed
    private EventosVista vista;
    private Choice listaServicios;

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

    private void intModelo() {
        valorTotal = 0;
        modelo = new DefaultTableModel();
        modelo.addColumn("NOMBRE");
        modelo.addColumn("VALOR");
    }

    private ControlErrores getE() {
        e = new ControlErrores();
        return e;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonagregarservicio;
    private javax.swing.JButton jButtoninsertarEvento;
    private javax.swing.JComboBox<String> jComboBox1estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1descripcion;
    private javax.swing.JLabel jLabel1nombre;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel2fecha;
    private javax.swing.JLabel jLabelestado;
    private javax.swing.JLabel jLabeltitulovalor;
    private javax.swing.JLabel jLabelvalor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelback;
    private javax.swing.JPanel jPanelbackprincipal;
    private javax.swing.JPanel jPanelchoice;
    private javax.swing.JPanel jPanelevento;
    private javax.swing.JPanel jPanelform;
    private javax.swing.JPanel jPanellistaservicios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1servicios;
    private javax.swing.JTextArea jTextAreadescripcion;
    private javax.swing.JTextField jTextFieldnombreevento;
    private rojeru_san.componentes.RSDateChooser rSDateChooserfecha;
    // End of variables declaration//GEN-END:variables
}
