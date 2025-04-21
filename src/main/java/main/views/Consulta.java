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
import static main.SistemaSalud.buscarPaciente;
import main.views.*;

public class Consulta extends javax.swing.JPanel {

    public Consulta() {
        initComponents();
        InitStyles();
    }

    private void ShowJPanel(JPanel p){
        p.setSize(1540, 960);
        p.setLocation(0,0);
        jPanel5.removeAll();
        jPanel5.add(p,BorderLayout.CENTER);
        jPanel5.revalidate();
        jPanel5.repaint();
    }

    private void InitStyles(){
        Color colorBase = new Color(50,119,189);
        Title_IngreseDni.putClientProperty("Flatlaf.style","font: semibold $h2.regular.font");
        Title_IngreseDni.setForeground(colorBase);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField1 = new java.awt.TextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Title_IngreseDni = new javax.swing.JLabel();
        IngresarDniBuscar = new javax.swing.JTextField();
        BuscarDNIButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();

        textField1.setText("textField1");

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1540, 960));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1540, 872));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        Title_IngreseDni.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        Title_IngreseDni.setForeground(new java.awt.Color(50, 119, 189));
        Title_IngreseDni.setText("Diagnostico:");

        IngresarDniBuscar.setCaretColor(new java.awt.Color(50, 119, 189));
        IngresarDniBuscar.setDisabledTextColor(new java.awt.Color(50, 119, 189));
        IngresarDniBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarDniBuscarActionPerformed(evt);
            }
        });

        BuscarDNIButton.setBackground(new java.awt.Color(50, 119, 189));
        BuscarDNIButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BuscarDNIButton.setForeground(new java.awt.Color(255, 255, 255));
        BuscarDNIButton.setText("Buscar DNI");
        BuscarDNIButton.setBorderPainted(false);
        BuscarDNIButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarDNIButtonActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1618, 925));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1618, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 925, Short.MAX_VALUE)
        );

        jSeparator3.setBackground(new java.awt.Color(50, 119, 189));
        jSeparator3.setForeground(new java.awt.Color(50, 119, 189));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Title_IngreseDni)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(IngresarDniBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BuscarDNIButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(692, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(Title_IngreseDni)
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(IngresarDniBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BuscarDNIButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
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
                                .addGap(890, 890, 890))
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

    private void IngresarDniBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarDniBuscarActionPerformed

    }//GEN-LAST:event_IngresarDniBuscarActionPerformed

    private void BuscarDNIButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarDNIButtonActionPerformed
        String dniBuscar = IngresarDniBuscar.getText().trim();
        if (dniBuscar.isEmpty()) {
            System.out.print("Ingrese un DNI válido");
            return;
        }
        try {
            Paciente paciente = buscarPaciente(dniBuscar);
            System.out.println(paciente.toString());
            if (paciente != null) {
                // Mostrar el historial médico del paciente encontrado
                FormularioDiagnostico formulario = new FormularioDiagnostico(paciente);
                ShowJPanel(formulario);
            } else {
                System.out.println("No se encontró ningún paciente con DNI: " + dniBuscar);
            }
        } catch (ParseException ex) {
            Logger.getLogger(Buscar_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Buscar_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BuscarDNIButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarDNIButton;
    private javax.swing.JTextField IngresarDniBuscar;
    private javax.swing.JLabel Title_IngreseDni;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator3;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
