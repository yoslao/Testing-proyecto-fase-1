package Pacientes;

import Consultas.Enfermedad;

import java.util.ArrayList;
import java.util.Arrays;

public class InfoPaciente {
    private ArrayList<Enfermedad> enfermedadesPreexistentes;
    private ArrayList<String> medicacion;
    private ArrayList<String> operaciones;
    private ArrayList<String> antecedentesFamiliares;
    private ArrayList<String> alergias;

    public InfoPaciente() {
        this.enfermedadesPreexistentes = new ArrayList<>();
        this.medicacion = new ArrayList<>();
        this.alergias = new ArrayList<>();
        this.antecedentesFamiliares = new ArrayList<>();
        this.operaciones = new ArrayList<>();
    }

    public InfoPaciente(String serialized) {
        this.enfermedadesPreexistentes = new ArrayList<>();
        this.medicacion = new ArrayList<>();
        this.alergias = new ArrayList<>();
        this.antecedentesFamiliares = new ArrayList<>();
        this.operaciones = new ArrayList<>();

        String[] parts = serialized.replace("InfoPaciente{", "").replace("}", "").split(", ");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            String key = keyValue[0];
            String value = keyValue[1];

            switch (key) {
                case "enfermedadesPreexistentes":
                    value = value.substring(1, value.length() - 1);  // Remove brackets
                    for (String enfermedad : value.split(", ")) {
                        this.enfermedadesPreexistentes.add(new Enfermedad(enfermedad));
                    }
                    break;
                case "medicacion":
                    value = value.substring(1, value.length() - 1);  // Remove brackets
                    this.medicacion = (ArrayList<String>) Arrays.asList(value.split(", "));
                    break;
                case "operaciones":
                    this.operaciones = (ArrayList<String>) Arrays.asList(value.substring(1, value.length() - 1).split(", "));
                    break;
                case "antecedentesFamiliares":
                    this.antecedentesFamiliares = (ArrayList<String>) Arrays.asList(value.substring(1, value.length() - 1).split(", "));
                    break;
                case "alergias":
                    this.alergias = (ArrayList<String>) Arrays.asList(value.substring(1, value.length() - 1).split(", "));
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "InfoPaciente{" +
                "enfermedadesPreexistentes=" + enfermedadesPreexistentes +
                ", medicacion=" + medicacion +
                ", operaciones=" + operaciones +
                ", antecedentesFamiliares=" + antecedentesFamiliares +
                ", alergias=" + alergias +
                '}';
    }

    public void agregarEnfermedadPreexistente(Enfermedad enfermedad) {
        enfermedadesPreexistentes.add(enfermedad);
    }

    public void agregarMedicacion(String medicamento) {
        medicacion.add(medicamento);
    }

    public void agregarOperaciones(String operaciones) {
        this.operaciones.add(operaciones);
    }

    public void agregarAntecedentesFamiliares(String antecedentesFamiliares) {
        this.antecedentesFamiliares.add(antecedentesFamiliares);
    }

    public void agregarAlergias(String alergias) {
        this.alergias.add(alergias);
    }

    public void setEnfermedadesPreexistentes(ArrayList<Enfermedad> enfermedadesPreexistentes) {
        this.enfermedadesPreexistentes = enfermedadesPreexistentes;
    }

    public void setMedicacion(ArrayList<String> medicacion) {
        this.medicacion = medicacion;
    }

    public void setOperaciones(ArrayList<String> operaciones) {
        this.operaciones = operaciones;
    }

    public void setAntecedentesFamiliares(ArrayList<String> antecedentesFamiliares) {
        this.antecedentesFamiliares = antecedentesFamiliares;
    }

    public void setAlergias(ArrayList<String> alergias) {
        this.alergias = alergias;
    }

    public ArrayList<Enfermedad> getEnfermedadesPreexistentes() {
        return enfermedadesPreexistentes;
    }

    public ArrayList<String> getMedicacion() {
        return medicacion;
    }

    public ArrayList<String> getOperaciones() {
        return operaciones;
    }

    public ArrayList<String> getAntecedentesFamiliares() {
        return antecedentesFamiliares;
    }

    public ArrayList<String> getAlergias() {
        return alergias;
    }


}
