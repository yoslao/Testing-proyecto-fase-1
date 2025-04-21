/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main.views;

import Pacientes.Paciente;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import java.awt.BorderLayout;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.UIManager;
import main.SistemaSalud;
import main.views.*;
import static main.SistemaSalud.buscarPaciente;
/**
 *
 * @author PC
 */
public class Buscar_Paciente extends javax.swing.JPanel {

    /**
     * Creates new form Ingresar_paciente
     */
    public Buscar_Paciente() {
        initComponents();
        InitStyles();
    }



    private void InitStyles(){
        Color colorBase = new Color(50,119,189);
        Title_IngreseDni.putClientProperty("Flatlaf.style","font: semibold $h2.regular.font");
        Title_IngreseDni.setForeground(colorBase);
    }

    private void ShowJPanel(JPanel p){
        p.setSize(1540, 960);
        p.setLocation(0,0);
        Mostrar_Historial.removeAll();
        Mostrar_Historial.add(p,BorderLayout.CENTER);
        Mostrar_Historial.revalidate();
        Mostrar_Historial.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField1 = new java.awt.TextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BuscarDNIButton = new javax.swing.JButton();
        IngresarDniBuscar = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        Title_IngreseDni = new javax.swing.JLabel();
        Mostrar_Historial = new javax.swing.JPanel();

        textField1.setText("textField1");

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1540, 960));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1540, 872));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        BuscarDNIButton.setBackground(new java.awt.Color(50, 119, 189));
        BuscarDNIButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BuscarDNIButton.setForeground(new java.awt.Color(255, 255, 255));
        BuscarDNIButton.setText("Buscar");
        BuscarDNIButton.setBorderPainted(false);
        BuscarDNIButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarDNIButtonActionPerformed(evt);
            }
        });

        IngresarDniBuscar.setCaretColor(new java.awt.Color(50, 119, 189));
        IngresarDniBuscar.setDisabledTextColor(new java.awt.Color(50, 119, 189));
        IngresarDniBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarDniBuscarActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(50, 119, 189));
        jSeparator3.setForeground(new java.awt.Color(50, 119, 189));

        Title_IngreseDni.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        Title_IngreseDni.setForeground(new java.awt.Color(50, 119, 189));
        Title_IngreseDni.setText("Ingrese el DNI:");

        Mostrar_Historial.setBackground(new java.awt.Color(255, 255, 255));
        Mostrar_Historial.setForeground(new java.awt.Color(255, 255, 255));
        Mostrar_Historial.setPreferredSize(new java.awt.Dimension(1540, 872));

        javax.swing.GroupLayout Mostrar_HistorialLayout = new javax.swing.GroupLayout(Mostrar_Historial);
        Mostrar_Historial.setLayout(Mostrar_HistorialLayout);
        Mostrar_HistorialLayout.setHorizontalGroup(
                Mostrar_HistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1540, Short.MAX_VALUE)
        );
        Mostrar_HistorialLayout.setVerticalGroup(
                Mostrar_HistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 872, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addComponent(Mostrar_Historial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(IngresarDniBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(BuscarDNIButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(239, 239, 239))
                                                .addComponent(Title_IngreseDni))
                                        .addGap(877, 877, 877)))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(91, Short.MAX_VALUE)
                                .addComponent(Mostrar_Historial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(Title_IngreseDni)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(IngresarDniBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(BuscarDNIButton))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(880, 880, 880)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 206, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarDNIButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarDNIButtonActionPerformed
        String dniBuscar = IngresarDniBuscar.getText().trim();
        if (dniBuscar.isEmpty()) {
            System.out.print("Ingrese un DNI válido");
            return;
        }
        try {
            Paciente paciente = buscarPaciente(dniBuscar);
            if (paciente != null) {
                // Mostrar el historial médico del paciente encontrado
                Muestra_Historial muestraHistorial = new Muestra_Historial(paciente);
                ShowJPanel(muestraHistorial);
            } else {
                System.out.println("No se encontró ningún paciente con DNI: " + dniBuscar);
            }
        } catch (ParseException ex) {
            Logger.getLogger(Buscar_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Buscar_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BuscarDNIButtonActionPerformed

    private void IngresarDniBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarDniBuscarActionPerformed

    }//GEN-LAST:event_IngresarDniBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarDNIButton;
    private javax.swing.JTextField IngresarDniBuscar;
    private javax.swing.JPanel Mostrar_Historial;
    private javax.swing.JLabel Title_IngreseDni;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator3;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
