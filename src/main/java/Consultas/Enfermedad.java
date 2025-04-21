package Consultas;

public class Enfermedad {
    private String nombre;
    private boolean cronico;

    public Enfermedad(String nombre, boolean cronico) {
        this.nombre = nombre;
        this.cronico = cronico;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isCronico() {
        return cronico;
    }

    public String serialized() {
        return "Enfermedad{" +
                "nombre='" + nombre + '\'' +
                ", cronico=" + cronico +
                '}';
    }

    public Enfermedad(String serialized) {
        String[] parts = serialized.replace("Enfermedad{", "").replace("}", "").split(", ");
        this.nombre = parts[0].split("=")[1];
        this.cronico = Boolean.parseBoolean(parts[1].split("=")[1]);
    }

    @Override
    public String toString() {
        return "Enfermedad{nombre='" + nombre + "', cronico=" + cronico + "}";
    }
}
