package main;

import Consultas.Consulta;
import Consultas.Diagnostico;
import Consultas.Doctor;
import Consultas.Enfermedad;
import HistorialMedico.BPlusTree;
import Pacientes.InfoPaciente;
import Pacientes.Paciente;
import Pacientes.HashA;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FileManager {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // Método para guardar un objeto Paciente en un archivo de texto
    public static void guardarPacienteEnArchivo(Paciente paciente, BufferedWriter writer) throws IOException {
        writer.write(paciente.toString());
        writer.newLine();
    }

    // Método para guardar el tamaño de la tabla y todos los pacientes en un archivo de texto
    public static void guardarTablaPacientesEnArchivo(HashA<Paciente> tabla, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Guardar el tamaño de la tabla en la primera línea
            writer.write(String.valueOf(tabla.getM()));
            writer.newLine();

            // Obtener todos los pacientes y guardarlos en el archivo
            List<Paciente> pacientes = tabla.getAllElements();
            for (Paciente paciente : pacientes) {
                guardarPacienteEnArchivo(paciente, writer);
            }
        }
    }

    // Método para leer un objeto Paciente desde un archivo de texto
    public static Paciente leerPacienteDesdeArchivo(String filePath, BufferedReader reader) throws IOException, ParseException {
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        sb.append(line);
        return deserialized(sb.toString());
    }

    // Método para leer la tabla de pacientes desde un archivo de texto
    public static HashA<Paciente> leerTablaPacientesDesdeArchivo(String filePath) throws IOException, ParseException, ClassNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Leer el tamaño de la tabla desde la primera línea
            int size = Integer.parseInt(reader.readLine());
            HashA<Paciente> tabla = new HashA<>(size);

            // Leer y añadir cada paciente en la tabla
            String line;
            while ((line = reader.readLine()) != null) {
                Paciente paciente = deserialized(line);
                tabla.insert(Integer.parseInt(paciente.getDNI()), paciente);
            }
            return tabla;
        }
    }

    public static Paciente deserialized(String data) throws ParseException {
        System.out.println(data);
        List<String> result = extractSubstrings(data);
        System.out.println(result);
        String dateString = extractValue(result.get(2));
        Date date = dateFormat.parse(dateString);
        Paciente paciente = new Paciente(extractValue(result.get(0)), extractValue(result.get(1)), date);
        InfoPaciente ip = extractIP(result.get(3));
        paciente.setInfoPersonal(ip);
        BPlusTree<Diagnostico> bpt = extractHM(result.get(4));
        paciente.setHistorialMedico(bpt);
        ArrayList<Consulta> consultas = extractConsultas(result.get(5));
        paciente.setConsultas(consultas);
        return paciente;
    }

    public static ArrayList<Consulta> extractConsultas(String data) throws ParseException {
        List<String> c = extractSubstringsSquareBrackets(data);
        ArrayList<Consulta> consultas = new ArrayList<>();
        Consulta con;
        for (String s : c) {
            con = extractConsulta(s);
            consultas.add(con);
        }
        return consultas;
    }

    private static Consulta extractConsulta(String data) throws ParseException {
        List<String> result = extractSubstrings(data);
        String dateString = extractValue(result.get(0));
        Date date = dateFormat.parse(dateString);
        Doctor doctor = extractDoctor(result.get(1));
        int id = Integer.parseInt(extractValue(result.get(2)));
        return new Consulta(date, doctor, id);
    }

    public static Doctor extractDoctor(String data) {
        List<String> d = extractSubstrings(data);
        return new Doctor(extractValue(d.get(0)), extractValue(d.get(1)));
    }

    public static Diagnostico extractDiagnostico(String data) throws ParseException {
        List<String> diag = extractSubstrings(data);
        int id = Integer.parseInt(extractValue(diag.get(0)));
        String dateString = extractValue(diag.get(1));
        Date date = dateFormat.parse(dateString);
        ArrayList<Enfermedad> enfermedades = new ArrayList<>();
        List<String> e = extractSubstringsSquareBrackets(diag.get(2));
        for (String s : e) {
            enfermedades.add(extractEnfermedad(s));
        }
        List<String> medi = extractSubstringsSquareBrackets(diag.get(3));
        ArrayList<String> medicacion = new ArrayList<>(medi);
        Doctor doctor = extractDoctor(diag.get(4));
        return new Diagnostico(id, date, enfermedades, medicacion, doctor);
    }

    public static BPlusTree<Diagnostico> extractHM(String data) throws ParseException {
        BPlusTree<Diagnostico> bpt = new BPlusTree<>(5);
        List<String> registros = extractSubstringsSquareBrackets(data);
        List<String> registro;
        Diagnostico diagnostico;
        int key;
        for (String s : registros) {
            registro = extractSubstrings(s);
            key = Integer.parseInt(extractValue(registro.get(0)));
            diagnostico = extractDiagnostico(registro.get(1));
            bpt.insert(key, diagnostico);
        }
        return bpt;
    }

    public static InfoPaciente extractIP(String data) {
        List<String> result = extractSubstrings(data);

        ArrayList<Enfermedad> enfermedadesPreexistentes = new ArrayList<>();
        List<String> e = extractSubstringsSquareBrackets(result.get(0));
        for (String s : e) {
            enfermedadesPreexistentes.add(extractEnfermedad(s));
        }
        List<String> medi = extractSubstringsSquareBrackets(result.get(1));
        List<String> ops = extractSubstringsSquareBrackets(result.get(2));
        List<String> af = extractSubstringsSquareBrackets(result.get(3));
        List<String> alergia = extractSubstringsSquareBrackets(result.get(4));
        ArrayList<String> medicacion = new ArrayList<>(medi);
        ArrayList<String> operaciones = new ArrayList<>(ops);
        ArrayList<String> antecedentesFamiliares = new ArrayList<>(af);
        ArrayList<String> alergias = new ArrayList<>(alergia);
        InfoPaciente ip = new InfoPaciente();
        ip.setEnfermedadesPreexistentes(enfermedadesPreexistentes);
        ip.setMedicacion(medicacion);
        ip.setOperaciones(operaciones);
        ip.setAntecedentesFamiliares(antecedentesFamiliares);
        ip.setAlergias(alergias);
        return ip;
    }

    public static Enfermedad extractEnfermedad(String data) {
        List<String> e = generateListFromCommaSeparatedString(data);
        String nombre = extractValue(e.get(0));
        boolean cronico;
        if (extractValue(e.get(0)).equals("true}")) {
            cronico = true;
        } else {
            cronico = false;
        }
        return new Enfermedad(nombre, cronico);
    }

    public static List<String> generateListFromCommaSeparatedString(String data) {
        if (data == null || data.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> resultList = new ArrayList<>(Arrays.asList(data.split(",")));
        resultList.replaceAll(String::trim);
        return resultList;
    }

    public static String extractValue(String data) {
        int equalsIndex = data.indexOf('=');
        if (equalsIndex == -1) {
            return "";
        }

        String value = data.substring(equalsIndex + 1).trim();

        if (value.startsWith("'") && value.endsWith("'")) {
            value = value.substring(1, value.length() - 1);
        }

        return value;
    }

    public static List<String> extractSubstrings(String data) {
        List<String> result = new ArrayList<>();
        int startIndex = data.indexOf('{') + 1;
        int endIndex = data.lastIndexOf('}');

        if (startIndex == 0 || endIndex == -1 || startIndex >= endIndex) {
            return result;
        }

        String substring = data.substring(startIndex, endIndex);
        StringBuilder current = new StringBuilder();
        int braceCount = 0;
        int bracketCount = 0;

        for (char c : substring.toCharArray()) {
            if (c == '{') {
                braceCount++;
            } else if (c == '}') {
                braceCount--;
            } else if (c == '[') {
                bracketCount++;
            } else if (c == ']') {
                bracketCount--;
            }

            if (c == ',' && braceCount == 0 && bracketCount == 0) {
                result.add(current.toString().trim());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }

        if (current.length() > 0) {
            result.add(current.toString().trim());
        }

        return result;
    }

    public static List<String> extractSubstringsSquareBrackets(String data) {
        List<String> result = new ArrayList<>();
        int startIndex = data.indexOf('[') + 1;
        int endIndex = data.lastIndexOf(']');

        if (startIndex == 0 || endIndex == -1 || startIndex >= endIndex) {
            return result;
        }

        String substring = data.substring(startIndex, endIndex);
        StringBuilder current = new StringBuilder();
        int braceCount = 0;
        int bracketCount = 0;

        for (char c : substring.toCharArray()) {
            if (c == '{') {
                braceCount++;
            } else if (c == '}') {
                braceCount--;
            } else if (c == '[') {
                bracketCount++;
            } else if (c == ']') {
                bracketCount--;
            }

            if (c == ',' && braceCount == 0 && bracketCount == 0) {
                result.add(current.toString().trim());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }

        if (current.length() > 0) {
            result.add(current.toString().trim());
        }

        return result;
    }

    // Método para actualizar un paciente en el archivo
    // Método para actualizar un paciente en el archivo
    public static void actualizarPaciente(String filePath, String buscar, String reemplazar) {
        File archivo = new File(filePath);
        List<String> lineas = new ArrayList<>();
        System.out.println(buscar);
        System.out.println(reemplazar);
        // Leer el archivo y almacenar las líneas en una lista
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.equals(buscar)) {
                    System.out.println("Tu puedes");
                    lineas.add(reemplazar); // Reemplazar la línea que coincide
                } else {
                    lineas.add(linea); // Mantener las otras líneas
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Escribir las líneas nuevamente en el archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}