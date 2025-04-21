package Consultas;

import static org.junit.jupiter.api.Assertions.*;

import Pacientes.Paciente;
import org.junit.jupiter.api.Test;

import java.util.Date;


public class DoctorTest {


    @Test
    public void testConstructorSerializado() {
        String serializado = "Doctor{nombre=Dr. Pérez, especialidad=Cardiología, cola=QueueLink{}}";
        Doctor doctor = new Doctor(serializado);

        assertEquals("Dr. Pérez", doctor.getNombre());
        assertEquals("Cardiología", doctor.getEspecialidad());
        assertTrue(doctor.getCola().isEmpty());
    }


    @Test
    public void testManejoDeColaPacientes() {
        Doctor doctor = new Doctor("Dr. Ana", "Pediatría");
        Paciente paciente1 = new Paciente("Paciente 1", "DNI1", new Date());
        Paciente paciente2 = new Paciente("Paciente 2", "DNI2", new Date());

        doctor.getCola().enqueue(paciente1);
        doctor.getCola().enqueue(paciente2);

        assertEquals(2, doctor.getCola().count());
        assertEquals(paciente1, doctor.getCola().dequeue());
    }
}

