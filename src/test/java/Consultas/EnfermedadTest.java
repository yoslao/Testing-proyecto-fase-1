package Consultas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class EnfermedadTest {


    @Test
    public void testConstructorSerializadoInvalido() {
        String serializadoInvalido = "Enfermedad{nombre=, cronico=true}"; // Nombre vacío
        assertThrows(IllegalArgumentException.class, () -> {
            new Enfermedad(serializadoInvalido);
        });
    }


    @Test
    public void testSerializacionConsistente() {
        Enfermedad enfermedad = new Enfermedad("Diabetes", true);
        String serializadoEsperado = "Enfermedad{nombre='Diabetes', cronico=true}";
        assertEquals(serializadoEsperado, enfermedad.serialized());
    }
}

