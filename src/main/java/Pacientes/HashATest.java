package Pacientes;

import java.util.Random;

public class HashATest {

    public static void main(String[] args) {
        int n = 50000; // Número de elementos a insertar
        HashA<Integer> hashTable = new HashA<>(n);

        Random rand = new Random();
        int numCollisions = 0;
        int totalElements = 0;

        // Insertar elementos aleatorios en la tabla hash
        for (int i = 0; i < n; i++) {
            int key = rand.nextInt(100000); // Claves aleatorias en el rango de 0 a 9999
            hashTable.insert(key, key);
        }

        // Calcular el número de colisiones
        for (int i = 0; i < hashTable.getM(); i++) {
            HashA<Integer>.Element element = ((HashA<Integer>) hashTable).table.get(i);
            if (element.mark == 1) {
                totalElements++;
                if (!element.tree.isEmpty()) {
                    numCollisions += element.tree.inOrder().size();
                }
            }
        }

        double collisionRate = (double) numCollisions / totalElements * 100;
        System.out.println("Total de Elementos: " + totalElements);
        System.out.println("Numero de colisones: " + numCollisions);
        System.out.println("Porcentaje de Colisones: " + collisionRate + "%");
    }
}

