package HistorialMedico;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import exceptions.ItemDuplicated;


public class BPlusTreeExtraTest {


    @Test
    public void testClaveDuplicada() {
        BPlusTree<String> tree = new BPlusTree<>(3);
        tree.insert(100, "Valor100");

        assertThrows(ItemDuplicated.class, () -> {
            tree.insert(100, "Valor200"); // Clave duplicada
        });
    }


    @Test
    public void testBusquedaEnArbolVacio() {
        BPlusTree<String> tree = new BPlusTree<>(3);
        assertNull(tree.search(100)); // Árbol vacío
    }


    @Test
    public void testSplitInternoMultiNivel() {
        BPlusTree<Integer> tree = new BPlusTree<>(3);
        // Inserta 10 claves para forzar múltiples splits
        for (int i = 1; i <= 10; i++) {
            tree.insert(i, i * 10);
        }
        // Verifica que todas las claves existen
        for (int i = 1; i <= 10; i++) {
            assertNotNull(tree.search(i));
        }
    }
}

