package Consultas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;


public class DiagnosticoTest {


    @Test
    public void testConvertirFechaAEntero() {
        Date fecha = new Date();
        Diagnostico diagnostico = new Diagnostico(fecha, new Doctor("Dr. Smith", "Neurología"));
        int id = diagnostico.getId();

        // Verificar que el ID es un número de 8 dígitos (yyyyMMdd)
        assertTrue(id >= 10000000 && id <= 99999999);
    }


    @Test
    public void testAgregarEnfermedadYMedicamento() {
        Diagnostico diag = new Diagnostico(new Date(), new Doctor("Dr. House", "Diagnóstico"));
        diag.agregarEnfermedad(new Enfermedad("Gripe", false));
        diag.agregarMedicamento("Paracetamol");

        assertEquals(1, diag.getEnfermedades().size());
        assertEquals(1, diag.getMedicamentos().size());
    }
}

