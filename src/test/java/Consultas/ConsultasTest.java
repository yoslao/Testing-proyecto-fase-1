package Consultas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ConsultasTest {

    @Test
    public void testConstructorAndGetters() {
        Date fecha = new Date();
        Doctor doctor = new Doctor("Dr. Pérez", "Cardiología");
        Consulta consulta = new Consulta(fecha, doctor, 123);

        assertEquals(fecha, consulta.getFechaConsulta());
        assertEquals(doctor, consulta.getDoctor());
        assertEquals(123, consulta.getIdPaciente());
    }


    @Test
    public void testToStringFormatoCorrecto() {
        Date fecha = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Doctor doctor = new Doctor("Dr. López", "Pediatría");
        Consulta consulta = new Consulta(fecha, doctor, 456);

        String esperado = "Consulta{fechaConsulta='" + sdf.format(fecha)
                + "', doctor=" + doctor.toString()
                + ", idPaciente=456}";

        assertEquals(esperado, consulta.toString());
    }
}
