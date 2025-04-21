package Consultas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Consulta {
    private Date fechaConsulta;
    private Doctor doctor;
    private int idPaciente;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Consulta(Date fechaConsulta, Doctor doctor, int idPaciente) {
        this.fechaConsulta = fechaConsulta;
        this.doctor = doctor;
        this.idPaciente = idPaciente;
    }

    @Override
    public String toString() {
        return "Consulta{fechaConsulta='" + dateFormat.format(fechaConsulta) + "', doctor=" + doctor + ", idPaciente=" + idPaciente + "}";
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getIdPaciente() {
        return idPaciente;
    }
}
