package Consultas;

import Pacientes.Paciente;

import java.util.StringJoiner;

public class Doctor {
    private String nombre;
    private String especialidad;
    private QueueLink<Paciente> cola;

    public Doctor(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cola = new QueueLink<>();
    }

    public Doctor(String serialized) {
        String[] parts = serialized.replace("Doctor{", "").replace("}", "").split(", ");
        this.nombre = parts[0].split("=")[1];
        this.especialidad = parts[1].split("=")[1];
        this.cola = new QueueLink<>(parts[2].split("=")[1]);
    }

    @Override
    public String toString() {
        return "Doctor{nombre='" + nombre + "', especialidad='" + especialidad + "'}";
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public QueueLink<Paciente> getCola() {
        return cola;
    }


}