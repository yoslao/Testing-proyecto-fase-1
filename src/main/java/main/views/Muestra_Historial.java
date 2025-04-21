package main.views;

import Consultas.Diagnostico;
import Consultas.Enfermedad;
import java.awt.Color;
import Pacientes.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import static main.views.FormularioDiagnostico.array;


public class Muestra_Historial<E> extends javax.swing.JPanel {

    DefaultListModel Antec = new DefaultListModel();
    DefaultListModel Enfer = new DefaultListModel();
    DefaultListModel Medi = new DefaultListModel();
    DefaultListModel Oper = new DefaultListModel();
    DefaultListModel Alerg = new DefaultListModel();
    DefaultListModel Fechas = new DefaultListModel();
    DefaultListModel Diagnostico = new DefaultListModel();
    DefaultListModel RecetaMedica = new DefaultListModel();
    ArrayList<Enfermedad> Enfers = new ArrayList();
    ArrayList<String> Medics = new ArrayList();
    static ArrayList<Paciente> array;

    public Muestra_Historial(Paciente paciente) {
        initComponents();
        MostrarDatos(paciente);
        Fecha.setModel(Fechas);
        FechasMostrarLista(paciente.getConsultas(),Fechas);
        array = new ArrayList<>();
        array.add(paciente);
        InitStyles();
    }

    private void FechasMostrarLista(ArrayList<Consultas.Consulta> e, DefaultListModel modelo) {
        modelo.removeAllElements();
        for (int i = 0; i < e.size(); i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String str = sdf.format(e.get(i).getFechaConsulta());
            modelo.addElement(str);
        }
    }

    private void MostrarLista(ArrayList<E> e, DefaultListModel modelo){
        ArrayList array = new ArrayList();
        for(E c : e){
            array.add(c);
        }
        modelo.removeAllElements();
        for(int i = 0; i<array.size();i++){
            modelo.addElement(array.get(i));
        }
    }

    private void MostrarListaEnfermedad(ArrayList<Enfermedad> e, DefaultListModel modelo){
        ArrayList array = new ArrayList();
        for(Enfermedad c : e){
            array.add(c.getNombre());
        }
        modelo.removeAllElements();
        for(int i = 0; i<array.size();i++){
            modelo.addElement(array.get(i));
        }
    }

    private void MostrarListaMedicamentos(ArrayList<String> e, DefaultListModel modelo){
        ArrayList array = new ArrayList();
        for(String c : e){
            array.add(c);
        }
        modelo.removeAllElements();
        for(int i = 0; i<array.size();i++){
            modelo.addElement(array.get(i));
        }
    }



    private void MostrarDatos(Paciente paciente){
        showPaciente.setText(paciente.getNombre());
        showDNI.setText(paciente.getDNI());
        showEdad.setText(Integer.toString(paciente.getEdad()));
        MostrarLista((ArrayList<E>) paciente.getInfoPersonal().getAntecedentesFamiliares(),Antec);
        Antecedentes.setModel(Antec);
        MostrarLista((ArrayList<E>) paciente.getInfoPersonal().getMedicacion(), Medi);
        Medicamentos.setModel(Medi);
        MostrarListaEnfermedad(paciente.getInfoPersonal().getEnfermedadesPreexistentes(),Enfer);
        Enfermedades.setModel(Enfer);
        MostrarLista((ArrayList<E>) paciente.getInfoPersonal().getOperaciones(), Oper);
        Operaciones.setModel(Oper);
        MostrarLista((ArrayList<E>) paciente.getInfoPersonal().getAlergias(), Alerg);
        Alergias.setModel(Alerg);
        Fecha.setModel(Oper);
    }

    private void InitStyles(){
        Color colorBase = new Color(50,119,189);

        jLabel1.putClientProperty("Flatlaf.styleClass","default");
        jLabel1.setForeground(Color.black);
        jLabel10.putClientProperty("Flatlaf.styleClass","default");
        jLabel10.setForeground(Color.black);
        jLabel15.putClientProperty("Flatlaf.styleClass","default");
        jLabel15.setForeground(Color.black);
        jLabel11.putClientProperty("Flatlaf.styleClass","default");
        jLabel11.setForeground(Color.black);
        jLabel17.putClientProperty("Flatlaf.styleClass","default");
        jLabel17.setForeground(Color.black);
        jLabel4.putClientProperty("Flatlaf.styleClass","default");
        jLabel4.setForeground(Color.black);
        jLabel5.putClientProperty("Flatlaf.styleClass","default");
        jLabel5.setForeground(Color.black);
        jLabel7.putClientProperty("Flatlaf.styleClass","default");
        jLabel7.setForeground(Color.black);
        jLabel8.putClientProperty("Flatlaf.styleClass","default");
        jLabel8.setForeground(Color.black);
        jLabel9.putClientProperty("Flatlaf.styleClass","default");
        jLabel9.setForeground(Color.black);
        Title1.putClientProperty("Flatlaf.style","font: semibold $h2.regular.font");
        Title1.setForeground(colorBase);
        Title2.putClientProperty("Flatlaf.style","font: semibold $h2.regular.font");
        Title2.setForeground(colorBase);
        showPaciente.setForeground(Color.black);
        showDNI.setForeground(Color.black);
        showDoctorEncargad.setForeground(Color.black);
        showEdad.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField1 = new java.awt.TextField();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        showEdad = new javax.swing.JLabel();
        showDNI = new javax.swing.JLabel();
        showDoctorEncargad = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Title1 = new javax.swing.JLabel();
        Title2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        showPaciente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Antecedentes = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        Operaciones = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        Enfermedades = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        Medicamentos = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        Fecha = new javax.swing.JList<>();
        BuscarDate = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Alergias = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        ShowDiagnostico = new javax.swing.JList<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        ShowReceta = new javax.swing.JList<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        textField1.setText("textField1");

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1540, 872));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1540, 872));

        jSeparator1.setForeground(new java.awt.Color(50, 119, 189));

        showEdad.setBackground(new java.awt.Color(192, 192, 192));
        showEdad.setForeground(new java.awt.Color(192, 192, 192));
        showEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(192, 192, 192)));

        showDNI.setBackground(new java.awt.Color(192, 192, 192));
        showDNI.setForeground(new java.awt.Color(192, 192, 192));
        showDNI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(192, 192, 192)));

        showDoctorEncargad.setBackground(new java.awt.Color(192, 192, 192));
        showDoctorEncargad.setForeground(new java.awt.Color(192, 192, 192));
        showDoctorEncargad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(192, 192, 192)));

        jLabel17.setText("Doctor Encargado:");

        jLabel15.setText("Fecha Consulta:");

        Title1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Title1.setForeground(new java.awt.Color(50, 119, 189));
        Title1.setText("Historial Médico:");

        Title2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Title2.setForeground(new java.awt.Color(50, 119, 189));
        Title2.setText("Diagnóstico:");

        jLabel10.setText("Antecedentes Familiares:");

        jLabel9.setText("Operaciones Previas:");

        jLabel8.setText("Medicamentos Actuales:");

        jLabel7.setText("Enfermedades Preexistentes:");

        jLabel5.setText("Edad:");

        jLabel4.setText("DNI:");

        jLabel1.setText("Paciente:");

        showPaciente.setBackground(new java.awt.Color(192, 192, 192));
        showPaciente.setForeground(new java.awt.Color(192, 192, 192));
        showPaciente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(192, 192, 192)));

        Antecedentes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(Antecedentes);
        Antecedentes.getAccessibleContext().setAccessibleParent(Antecedentes);

        Operaciones.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(Operaciones);

        Enfermedades.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(Enfermedades);

        Medicamentos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(Medicamentos);

        Fecha.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(Fecha);

        BuscarDate.setBackground(new java.awt.Color(50, 119, 189));
        BuscarDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BuscarDate.setForeground(new java.awt.Color(255, 255, 255));
        BuscarDate.setText("Buscar");
        BuscarDate.setBorderPainted(false);
        BuscarDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarDateActionPerformed(evt);
            }
        });

        jLabel11.setText("Alergias");

        Alergias.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(Alergias);

        ShowDiagnostico.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane9.setViewportView(ShowDiagnostico);

        ShowReceta.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane10.setViewportView(ShowReceta);

        jLabel16.setText("Diagnostico:");

        jLabel18.setText("Receta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Title2)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel10)
                                                                                .addGap(227, 227, 227))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(41, 41, 41)))
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel9)
                                                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addComponent(jLabel7)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel15)
                                                        .addComponent(BuscarDate))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(showDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                                                .addComponent(showPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel5)
                                                                .addComponent(showEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel11)))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .addGap(353, 353, 353)
                                                        .addComponent(jLabel17)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(showDoctorEncargad, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel16))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel18)
                                                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(859, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel4)
                                                .addComponent(Title1))
                                        .addContainerGap(1401, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(showPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(showDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(showEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Title2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(showDoctorEncargad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BuscarDate))
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel17))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap(245, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(Title1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel4)
                                        .addContainerGap(774, Short.MAX_VALUE)))
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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarDateActionPerformed
        // TODO add your handling code here
        int index = Fecha.getSelectedIndex();
        Date date = array.get(0).getConsultas().get(index).getFechaConsulta();
        showDoctorEncargad.setText(array.get(0).getConsultas().get(index).getDoctor().getNombre());
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
        String fechaStr = formato.format(date);
        int ID = Integer.parseInt(fechaStr);

        ArrayList<Enfermedad> enfermedi = array.get(0).getHistorialMedico().search(ID).get(0).getEnfermedades();
        MostrarListaEnfermedad(enfermedi,Diagnostico);
        ShowDiagnostico.setModel(Diagnostico);

        ArrayList<String> Medicali = array.get(0).getHistorialMedico().search(ID).get(0).getMedicamentos();
        MostrarListaMedicamentos(Medicali,RecetaMedica);
        ShowReceta.setModel(RecetaMedica);




    }//GEN-LAST:event_BuscarDateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Alergias;
    private javax.swing.JList<String> Antecedentes;
    private javax.swing.JButton BuscarDate;
    private javax.swing.JList<String> Enfermedades;
    private javax.swing.JList<String> Fecha;
    private javax.swing.JList<String> Medicamentos;
    private javax.swing.JList<String> Operaciones;
    private javax.swing.JList<String> ShowDiagnostico;
    private javax.swing.JList<String> ShowReceta;
    private javax.swing.JLabel Title1;
    private javax.swing.JLabel Title2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel showDNI;
    private javax.swing.JLabel showDoctorEncargad;
    private javax.swing.JLabel showEdad;
    private javax.swing.JLabel showPaciente;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
