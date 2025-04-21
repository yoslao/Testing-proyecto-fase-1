package Integration;

import static org.junit.jupiter.api.Assertions.*;

import Consultas.Diagnostico;
import Consultas.Doctor;
import HistorialMedico.BPlusTree;
import org.junit.jupiter.api.Test;
import java.util.Date;


public class IntegrationTest {


    @Test
    public void testGuardarYCargarDiagnostico() throws Exception {
        BPlusTree<Diagnostico> tree = new BPlusTree<>(3);
        Diagnostico diag = new Diagnostico(new Date(), new Doctor("Dr. X", "Radiología"));
        tree.insert(diag.getId(), diag);

        tree.save("diagnosticos.txt");
        BPlusTree<Diagnostico> treeCargado = new BPlusTree<>(3);
        treeCargado.load("diagnosticos.txt", Diagnostico.class);

        assertNotNull(treeCargado.search(diag.getId()));
    }
}

