package Exceptions;

import static org.junit.jupiter.api.Assertions.*;

import HistorialMedico.BPlusTree;
import org.junit.jupiter.api.Test;
import exceptions.ItemNotFound;

import java.util.List;


public class ExceptionesTest {


    @Test
    public void testItemNotFoundEnBusqueda() {
        BPlusTree<String> tree = new BPlusTree<>(3);
        assertThrows(ItemNotFound.class, () -> {
            List<String> result = tree.search(999); // Clave inexistente
        });
    }
}

