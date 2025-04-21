package HistorialMedico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Persona {
    public static void main(String[] args) {
        String filePath = "banana.txt";
        String oldLine = "fresa con manzana";
        String newLine = "fresa con manzana con pera";

        replaceLineInFile(filePath, oldLine, newLine);
    }

    public static void replaceLineInFile(String filePath, String oldLine, String newLine) {
        List<String> lines = new ArrayList<>();

        // Leer el archivo y almacenar las líneas en el ArrayList
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(oldLine)) {
                    lines.add(newLine);
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Escribir las líneas modificadas de vuelta al archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
