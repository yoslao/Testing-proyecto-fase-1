package Consultas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Diagnostico {
    private int id;
    private Date fechaConsulta;
    private ArrayList<Enfermedad> enfermedades;
    private ArrayList<String> medicamentos;
    private Doctor doctor;

    public Diagnostico(Date fechaConsulta, Doctor doctor) {
        this.fechaConsulta = fechaConsulta;
        this.enfermedades = new ArrayList<>();
        this.medicamentos = new ArrayList<>();
        this.doctor = doctor;
        this.id = convertirFechaAEntero(fechaConsulta);
    }


    public Diagnostico(int id, Date fechaConsulta, ArrayList<Enfermedad> enfermedades, ArrayList<String> medicamentos, Doctor doctor) {
        this.id = id;
        this.fechaConsulta = fechaConsulta;
        this.enfermedades = enfermedades;
        this.medicamentos = medicamentos;
        this.doctor = doctor;
    }

    private int convertirFechaAEntero(Date fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
        String fechaStr = formato.format(fecha);
        return Integer.parseInt(fechaStr);
    }

    public void agregarEnfermedad(Enfermedad enfermedad) {
        enfermedades.add(enfermedad);
    }

    public void agregarMedicamento(String medicamento) {
        medicamentos.add(medicamento);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public ArrayList<Enfermedad> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(ArrayList<Enfermedad> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public ArrayList<String> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(ArrayList<String> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder enfermedadesStr = new StringBuilder("[");
        for (Enfermedad enfermedad : enfermedades) {
            enfermedadesStr.append(enfermedad.serialized()).append(", ");
        }
        if (enfermedadesStr.length() > 1) {
            enfermedadesStr.setLength(enfermedadesStr.length() - 2); // Remove last ", "
        }
        enfermedadesStr.append("]");

        return "Diagnostico{" +
                "id=" + id +
                ", fechaConsulta=" + formato.format(fechaConsulta) +
                ", enfermedades=" + enfermedadesStr +
                ", medicamentos=" + medicamentos +
                ", doctor=" + doctor +
                "}";
    }
}
