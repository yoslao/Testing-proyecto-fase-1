/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main.views;

import Consultas.Doctor;
import Pacientes.Paciente;
import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import main.FileManager;
import static main.SistemaSalud.buscarPaciente;
import static main.SistemaSalud.validarNombre;
import static main.SistemaSalud.validarTextoAlfabetico;
import main.views.*;

public class Crear_Consulta extends javax.swing.JPanel {

    public Crear_Consulta() {
        initComponents();
        InitStyles();
    }

    private void InitStyles() {
        Color colorBase = new Color(50, 119, 189);
        Title_IngreseDni.putClientProperty("Flatlaf.style", "font: semibold $h2.regular.font");
        Title_IngreseDni.setForeground(colorBase);
        Display_FechaConsulta.putClientProperty("Flatlaf.styleClass", "default");
        Display_FechaConsulta.setForeground(Color.black);
        Display_FechaNacimiento1.putClientProperty("Flatlaf.styleClass", "default");
        Display_FechaNacimiento1.setForeground(Color.black);
        Display_FechaNacimiento2.putClientProperty("Flatlaf.styleClass", "default");
        Display_FechaNacimiento2.setForeground(Color.black);
        jLabel15.putClientProperty("Flatlaf.styleClass", "default");
        jLabel15.setForeground(Color.black);
        jLabel14.putClientProperty("Flatlaf.styleClass", "default");
        jLabel14.setForeground(Color.black);
        Display_FechaNacimiento3.putClientProperty("Flatlaf.styleClass", "default");
        Display_FechaNacimiento3.setForeground(Color.black);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField1 = new java.awt.TextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        CrearConsultaButton = new javax.swing.JButton();
        IngresarAnio = new javax.swing.JTextField();
        IngresarMes = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        IngresarDia = new javax.swing.JTextField();
        Especialidad = new javax.swing.JTextField();
        NombreDoctor = new javax.swing.JTextField();
        Display_FechaNacimiento3 = new javax.swing.JLabel();
        Display_FechaNacimiento1 = new javax.swing.JLabel();
        IngresarDniBuscar = new javax.swing.JTextField();
        Title_IngreseDni = new javax.swing.JLabel();
        BuscarDNIButton = new javax.swing.JButton();
        Display_FechaNacimiento2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Display_FechaConsulta = new javax.swing.JLabel();

        textField1.setText("textField1");

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1540, 960));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1540, 872));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 793, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 492, Short.MAX_VALUE)
        );

        CrearConsultaButton.setBackground(new java.awt.Color(50, 119, 189));
        CrearConsultaButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CrearConsultaButton.setForeground(new java.awt.Color(255, 255, 255));
        CrearConsultaButton.setText("Generar Consulta");
        CrearConsultaButton.setBorderPainted(false);
        CrearConsultaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearConsultaButtonActionPerformed(evt);
            }
        });

        IngresarAnio.setText("YYYY");
        IngresarAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarAnioActionPerformed(evt);
            }
        });

        IngresarMes.setText("MM");
        IngresarMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarMesActionPerformed(evt);
            }
        });

        jLabel15.setText("/");

        jLabel14.setText("/");

        IngresarDia.setText("DD");
        IngresarDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarDiaActionPerformed(evt);
            }
        });

        Especialidad.setCaretColor(new java.awt.Color(50, 119, 189));
        Especialidad.setDisabledTextColor(new java.awt.Color(50, 119, 189));
        Especialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EspecialidadActionPerformed(evt);
            }
        });

        NombreDoctor.setCaretColor(new java.awt.Color(50, 119, 189));
        NombreDoctor.setDisabledTextColor(new java.awt.Color(50, 119, 189));
        NombreDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreDoctorActionPerformed(evt);
            }
        });

        Display_FechaNacimiento3.setText("Ingresar Doctor");

        Display_FechaNacimiento1.setText("Especialidad");

        IngresarDniBuscar.setCaretColor(new java.awt.Color(50, 119, 189));
        IngresarDniBuscar.setDisabledTextColor(new java.awt.Color(50, 119, 189));
        IngresarDniBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarDniBuscarActionPerformed(evt);
            }
        });

        Title_IngreseDni.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        Title_IngreseDni.setForeground(new java.awt.Color(50, 119, 189));
        Title_IngreseDni.setText("Crear Consulta:");

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

        Display_FechaNacimiento2.setText("Paciente:");

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Display_FechaConsulta.setText("Fecha de Consulta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Title_IngreseDni)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(353, 353, 353)
                                                .addComponent(CrearConsultaButton))
                                        .addComponent(NombreDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(Especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(4, 4, 4)
                                                                .addComponent(Display_FechaNacimiento3)))
                                                .addGap(145, 145, 145)
                                                .addComponent(IngresarDia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel14)
                                                .addGap(6, 6, 6)
                                                .addComponent(IngresarMes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel15)
                                                .addGap(6, 6, 6)
                                                .addComponent(IngresarAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(IngresarDniBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(6, 6, 6)
                                                                .addComponent(BuscarDNIButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(Display_FechaNacimiento1))
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(Display_FechaConsulta)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(Display_FechaNacimiento2)
                                                                .addGap(12, 12, 12)
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(Title_IngreseDni)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(IngresarDniBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(2, 2, 2)
                                                                .addComponent(BuscarDNIButton))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(8, 8, 8)
                                                                .addComponent(Display_FechaNacimiento2))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(9, 9, 9)
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(24, 24, 24)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Display_FechaNacimiento1)
                                                        .addComponent(Display_FechaConsulta))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(Display_FechaNacimiento3)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(Especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(51, 51, 51)))
                                                        .addComponent(IngresarDia, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(IngresarMes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(IngresarAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(8, 8, 8)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel14)
                                                                        .addComponent(jLabel15))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(NombreDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(144, 144, 144)
                                                .addComponent(CrearConsultaButton)))
                                .addContainerGap(355, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
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
                jLabel1.setText(paciente.getNombre());
                jLabel1.putClientProperty("Flatlaf.styleClass", "default");
                jLabel1.setForeground(Color.black);
            } else {
                System.out.println("No se encontró ningún paciente con DNI: " + dniBuscar);
            }
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Buscar_Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Buscar_Paciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BuscarDNIButtonActionPerformed

    private void IngresarDniBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarDniBuscarActionPerformed

    }//GEN-LAST:event_IngresarDniBuscarActionPerformed

    private void IngresarAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarAnioActionPerformed

    }//GEN-LAST:event_IngresarAnioActionPerformed

    private void IngresarMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarMesActionPerformed

    }//GEN-LAST:event_IngresarMesActionPerformed

    private void IngresarDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarDiaActionPerformed

    }//GEN-LAST:event_IngresarDiaActionPerformed

    private void CrearConsultaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearConsultaButtonActionPerformed
        try {
            Paciente paciente = buscarPaciente(IngresarDniBuscar.getText().trim());
            String t = paciente.toString();

            Paciente temp = FileManager.deserialized(t);
            System.out.println(temp.toString()+ "Hola");
            int DNI = Integer.parseInt(IngresarDniBuscar.getText().trim());

            String dia = IngresarDia.getText().trim();
            String mes = IngresarMes.getText().trim();
            String anio = IngresarAnio.getText().trim();
            String fechaConsulta = anio + "-" + mes + "-" + dia;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaConsulta1 = sdf.parse(fechaConsulta);
            System.out.println(fechaConsulta1);

            if (dia.isEmpty() || mes.isEmpty() || anio.isEmpty()) {
                System.out.println("Ingrese una fecha válida (día, mes, año)");
                return;
            }



            System.out.print("Ingrese el nombre del doctor: ");
            String nombreDoctor = NombreDoctor.getText();
            validarNombre(nombreDoctor);

            System.out.print("Ingrese la especialidad del doctor: ");
            String especialidadDoctor = Especialidad.getText();
            validarTextoAlfabetico(especialidadDoctor);
            Consultas.Consulta consulta = new Consultas.Consulta(fechaConsulta1, new Doctor(nombreDoctor, especialidadDoctor), DNI);
            System.out.println(consulta);
            temp.insertConsulta(consulta);

            FileManager.actualizarPaciente("paciente.txt", paciente.toString(), temp.toString());

            System.out.println();
        } catch (NumberFormatException e) {
            System.out.println("Error: El DNI debe ser un número entero.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_CrearConsultaButtonActionPerformed

    private void NombreDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreDoctorActionPerformed

    private void EspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EspecialidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarDNIButton;
    private javax.swing.JButton CrearConsultaButton;
    private javax.swing.JLabel Display_FechaConsulta;
    private javax.swing.JLabel Display_FechaNacimiento1;
    private javax.swing.JLabel Display_FechaNacimiento2;
    private javax.swing.JLabel Display_FechaNacimiento3;
    private javax.swing.JTextField Especialidad;
    private javax.swing.JTextField IngresarAnio;
    private javax.swing.JTextField IngresarDia;
    private javax.swing.JTextField IngresarDniBuscar;
    private javax.swing.JTextField IngresarMes;
    private javax.swing.JTextField NombreDoctor;
    private javax.swing.JLabel Title_IngreseDni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables

    private void ShowJPanel(Muestra_Historial muestraHistorial) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
