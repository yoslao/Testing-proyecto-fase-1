package main;

import Consultas.Diagnostico;
import Consultas.Doctor;
import Consultas.Enfermedad;
import Pacientes.HashA;
import Pacientes.InfoPaciente;
import Pacientes.Paciente;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import static main.FileManager.deserialized;
import static main.FileManager.leerTablaPacientesDesdeArchivo;

public class SistemaSalud {

    private static final Random RANDOM = new Random();
    private static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("yyyy-MM-dd");

    // Nombres aleatorios para pacientes (ejemplo básico)
    private static final String[] NOMBRES = {"María", "José", "Ana", "Carlos", "Laura", "Jorge", "Elena", "Martín", "Sofía", "Diego"};

    // Enfermedades preexistentes y medicamentos para ejemplos
    private static final String[] ENFERMEDADES = {"Diabetes", "Hipertensión", "Asma", "Cáncer", "Artritis", "Depresión"};
    private static final String[] MEDICAMENTOS = {"Paracetamol", "Ibuprofeno", "Amoxicilina", "Loratadina", "Omeprazol", "Insulina"};

    public static HashA<Paciente> pacientes;
    private HashA historialesMedicos; // Estructura para almacenar diagnósticos por fecha
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public SistemaSalud(int capacidad) {
        pacientes = new HashA<>(capacidad);
        historialesMedicos = new HashA(capacidad);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
        SistemaSalud sistema = new SistemaSalud(100); // Capacidad inicial del hash table
        Scanner scanner = new Scanner(System.in);

        String filePath = "paciente.txt"; // Replace with your desired file path

        File textFile = new File(filePath);

        try {
            if (textFile.createNewFile()) {
                System.out.println("File created: " + textFile.getName());
                int numberToAdd = 42; // Reemplaza con el número que quieras agregar

                try (FileWriter writer = new FileWriter(filePath, true)) { // true para append
                    writer.write(numberToAdd + System.lineSeparator());
                } catch (IOException e) {
                    System.err.println("Error al escribir en el archivo: " + e.getMessage());
                }
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.err.println("An error occurred creating the file: " + e.getMessage());
        }

        // Menú y operaciones del sistema
        int opcion;
        pacientes = leerTablaPacientesDesdeArchivo(filePath);
        do {
            System.out.println("Menú del Sistema de Salud:");
            System.out.println("1. Crear Paciente");
            System.out.println("2. Asignar Diagnóstico");
            System.out.println("3. Buscar Paciente");
            System.out.println("4. Buscar Diagnóstico Específico");
            System.out.println("5. Generar Pacientes de Prueba"); // Nueva opción en el menú
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    sistema.crearPaciente(scanner);
                    break;

                case 3:
                    sistema.buscarPaciente("12345678");
                    break;
                case 4:
                    sistema.buscarDiagnostico(scanner);
                    break;
                case 5:
                    System.out.print("Ingrese la cantidad de pacientes de prueba a generar: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    generarPacientesDePrueba(sistema, cantidad);

                    break;

                case 0:
                    System.out.println("Saliendo del sistema.");
                    guardarTablaPacientesEnArchivo(pacientes, filePath);

                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    public static long medidorTiempoBusquedaPaciente(String DNI) {
        int dni = Integer.parseInt(DNI);
        long inicio = System.nanoTime();
        Paciente paciente = pacientes.search(dni);
        long fin = System.nanoTime();

        if (paciente != null) {
            System.out.println("Paciente encontrado: " + paciente);
        } else {
            System.out.println("No se encontró ningún paciente con ese DNI.");
        }

        return fin - inicio; // Devolver la diferencia en nanosegundos
    }

    public static void crearPaciente(Scanner scanner) {
        try {
            InfoPaciente ip = new InfoPaciente();

            System.out.print("Ingrese el nombre del paciente: ");
            String nombre = scanner.nextLine();
            validarNombre(nombre);

            System.out.print("Ingrese el DNI del paciente: ");
            String DNI = scanner.nextLine();
            validarDNI(DNI);

            System.out.print("Ingrese la fecha de nacimiento del paciente (formato yyyy-MM-dd): ");
            Date fechaNacimiento = sdf.parse(scanner.nextLine());

            System.out.print("Ingrese enfermedades preexistentes del paciente: ");
            String enfermedadesPreexistentes = scanner.nextLine();
            ip.agregarEnfermedadPreexistente(new Enfermedad(enfermedadesPreexistentes, true));

            System.out.print("Ingrese medicación actual del paciente (dejar vacío si no aplica): ");
            String medicacion = scanner.nextLine();
            ip.agregarMedicacion(medicacion);

            System.out.print("Ingrese operaciones realizadas por el paciente (dejar vacío si no aplica): ");
            String operaciones = scanner.nextLine();
            ip.agregarOperaciones(operaciones);

            System.out.print("Ingrese antecedentes familiares del paciente (dejar vacío si no aplica): ");
            String antecedentesFamiliares = scanner.nextLine();
            ip.agregarAntecedentesFamiliares(antecedentesFamiliares);

            System.out.print("Ingrese alergias del paciente (dejar vacío si no aplica): ");
            String alergias = scanner.nextLine();
            ip.agregarAlergias(alergias);

            // Crear objeto Paciente con toda la información
            Paciente paciente = new Paciente(nombre, DNI, fechaNacimiento);
            paciente.setInfoPersonal(ip);
            // Insertar paciente en la estructura de datos correspondiente

            // Guardar paciente en el archivo pacientes.txt
            guardarPacienteEnArchivo(paciente);

            System.out.println("Paciente creado correctamente: " + paciente);

            pacientes.insert(Integer.parseInt(paciente.getDNI()), paciente);
            System.out.println(pacientes.getAllElements());

        } catch (Exception e) {
            System.out.println("Error al crear el paciente: " + e.getMessage());
        }
    }

    public static void guardarPacienteEnArchivo(Paciente paciente) {
        String nombreArchivo = "paciente.txt";
        try {
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
                writer.write(paciente.toString());
                writer.newLine();
                System.out.println("Paciente guardado en el archivo: " + nombreArchivo);
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el paciente en el archivo: " + e.getMessage());
        }
    }


    public static int convertirFechaAEntero(Date fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
        String fechaStr = formato.format(fecha);
        return Integer.parseInt(fechaStr);
    }

    public static HashA<Paciente> cargarTabla () throws IOException, ParseException{
        String filePath = "paciente.txt";
        try {
            pacientes = leerTablaPacientesDesdeArchivo(filePath);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaSalud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacientes;
    }

    public static Paciente buscarPaciente(String DNI) throws ParseException, IOException{
        pacientes = cargarTabla();
        int dni = Integer.parseInt(DNI);
        System.out.print(pacientes.getAllElements());
        Paciente paciente = pacientes.search(dni); // Usar el método search de HashA

        if (paciente == null) {
            System.out.println("No se encontró ningún paciente con ese DNI.");
        } else {
            System.out.println("Paciente encontrado: " + paciente);
        }

        return paciente;
    }

    public static Paciente searchPaciente(String DNI) throws ParseException, IOException{
        pacientes = cargarTabla();
        System.out.println(pacientes.getAllElements());
        int dni = Integer.parseInt(DNI);
        System.out.print(pacientes.getAllElements());
        Paciente paciente = pacientes.search(dni); // Usar el método search de HashA

        System.out.println(paciente.toString());
        return paciente;
    }

    public void buscarDiagnostico(Scanner scanner) {
        System.out.print("Ingrese el DNI del paciente: ");
        String DNI = scanner.nextLine();
        int dni = Integer.parseInt(DNI);

        Paciente paciente = pacientes.search(dni);
        if (paciente == null) {
            System.out.println("No se encontró ningún paciente con ese DNI.");
            return;
        }
        System.out.print("Ingrese la fecha del diagnóstico (formato yyyy-MM-dd): ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaConsulta = null;
        try {
            fechaConsulta = sdf.parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Diagnostico diagnostico = paciente.getHistorialMedico().search(convertirFechaAEntero(fechaConsulta)).get(0);
        if (diagnostico == null) {
            System.out.println("No se encontró ningún diagnóstico para esa fecha.");
        } else {
            System.out.println("Diagnóstico encontrado: " + diagnostico);
        }
    }

    public static void validarNombre(String nombre) {
        if (!Pattern.matches("[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ\\s]+", nombre)) {
            throw new IllegalArgumentException("El nombre debe contener solo caracteres alfabéticos.");
        }
    }

    public static void validarDNI(String DNI) {
        if (!Pattern.matches("\\d{8}", DNI)) {
            throw new IllegalArgumentException("El DNI debe contener exactamente 8 dígitos numéricos.");
        }
    }

    public static void validarTextoAlfabetico(String texto) {
        if (!Pattern.matches("[a-zA-ZáéíóúüñÁÉÍÓÚÜÑ\s]+", texto)) {
            throw new IllegalArgumentException("El texto debe contener solo caracteres alfabéticos.");
        }
    }

    public static String generarNombreAleatorio() {
        return NOMBRES[RANDOM.nextInt(NOMBRES.length)];
    }

    public static String generarDNIAleatorio() {
        StringBuilder dni = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            dni.append(RANDOM.nextInt(10));
        }
        return dni.toString();
    }

    public static Date generateRandomDate() {
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();

        // Genera un año aleatorio entre 1970 y 2023
        int year = 1970 + random.nextInt(54);

        // Genera un mes aleatorio (0-11)
        int month = random.nextInt(12);

        // Genera un día aleatorio (1-28/29/30/31 dependiendo del mes y año)
        calendar.set(year, month, 1);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int day = 1 + random.nextInt(maxDay);

        calendar.set(year, month, day);
        return calendar.getTime();
    }

    public static Enfermedad generarEnfermedadAleatoria() {
        return new Enfermedad(ENFERMEDADES[RANDOM.nextInt(ENFERMEDADES.length)], true);
    }

    public static String generarMedicamentoAleatorio() {
        return MEDICAMENTOS[RANDOM.nextInt(MEDICAMENTOS.length)];
    }

    private static void generarPacientesDePrueba(SistemaSalud sistema, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            String nombre = SistemaSalud.generarNombreAleatorio();
            String dni = SistemaSalud.generarDNIAleatorio();
            Date fechaNacimiento = SistemaSalud.generateRandomDate();
            Enfermedad enfermedad = SistemaSalud.generarEnfermedadAleatoria();
            String medicamento = SistemaSalud.generarMedicamentoAleatorio();

            InfoPaciente info = new InfoPaciente();
            info.agregarEnfermedadPreexistente(generarEnfermedadAleatoria());
            info.agregarMedicacion(medicamento);

            Paciente paciente = new Paciente(nombre, dni, fechaNacimiento);
            paciente.setInfoPersonal(info);
            sistema.pacientes.insert(Integer.parseInt(dni), paciente);
            sistema.guardarPacienteEnArchivo(paciente);

            System.out.println("Paciente generado automáticamente: " + paciente);
        }
    }

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
}
