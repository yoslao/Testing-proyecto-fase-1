package Pacientes;

import Consultas.Consulta;
import Consultas.Diagnostico;
import HistorialMedico.BPlusTree;

import java.text.SimpleDateFormat;
import java.util.*;

public class Paciente implements Comparable<Paciente> {

    private String nombre;
    private String DNI;
    private Date fechaNacimiento;
    private InfoPaciente infoPersonal;
    private BPlusTree<Diagnostico> historialMedico;
    private ArrayList<Consulta> consultas;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Paciente(String nombre, String DNI, Date fechaNacimiento) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.fechaNacimiento = fechaNacimiento;
        this.historialMedico = new BPlusTree<>(5);
        this.infoPersonal = new InfoPaciente();
        this.consultas = new ArrayList<>();
    }

    public Paciente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public InfoPaciente getInfoPersonal() {
        return infoPersonal;
    }

    public void setInfoPersonal(InfoPaciente infoPersonal) {
        this.infoPersonal = infoPersonal;
    }

    public BPlusTree<Diagnostico> getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(BPlusTree<Diagnostico> historialMedico) {
        this.historialMedico = historialMedico;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void insertConsulta(Consulta consulta) {
        System.out.print("pene1");
        this.consultas.add(consulta);
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

    public int getEdad() {
        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.setTime(this.fechaNacimiento);
        Calendar fechaActual = Calendar.getInstance();
        int edad = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        if (fechaActual.get(Calendar.DAY_OF_YEAR) < fechaNacimiento.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }
        return edad;
    }

    public Paciente copy() {
        Paciente copy = new Paciente();
        copy.setNombre(this.nombre);
        copy.setDNI(this.DNI);
        copy.setFechaNacimiento((Date) this.getFechaNacimiento());
        copy.setInfoPersonal(this.getInfoPersonal());
        copy.setHistorialMedico(this.getHistorialMedico());

        ArrayList<Consulta> newConsultas = new ArrayList<>();
        for (Consulta consulta : this.consultas) {
            newConsultas.add(consulta);
        }
        copy.setConsultas(newConsultas);

        return copy;
    }

    @Override
    public String toString() {
        return "Paciente{nombre='" + nombre + "', DNI='" + DNI + "', fechaNacimiento='" + dateFormat.format(fechaNacimiento)
                + "', infoPersonal=" + infoPersonal + ", historialMedico=" + historialMedico + ", consultas=" + consultas + "}";
    }

    public int compareTo(Paciente otroPaciente) {
        return this.DNI.compareTo(otroPaciente.getDNI());
    }
}
