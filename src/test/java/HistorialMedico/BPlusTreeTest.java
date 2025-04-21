package HistorialMedico;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;


public class BPlusTreeTest {


    @Test
    public void testInsertarYBuscar() {
        BPlusTree<String> tree = new BPlusTree<>(3);
        tree.insert(100, "Valor100");
        tree.insert(200, "Valor200");

        List<String> resultado = tree.search(100);
        assertEquals("Valor100", resultado.get(0));
    }


    @Test
    public void testBusquedaPorRango() {
        BPlusTree<Integer> tree = new BPlusTree<>(4);
        for (int i = 1; i <= 10; i++) {
            tree.insert(i, i * 10);
        }

        List<Key<Integer>> resultados = tree.search(5, 8);
        assertEquals(4, resultados.size()); // Debería incluir claves 5,6,7,8
    }
}
