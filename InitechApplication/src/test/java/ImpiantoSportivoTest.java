import domain.ImpiantoSportivo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ImpiantoSportivoTest {

    @Test
    void getSetId() {
        ImpiantoSportivo impiantoSportivo = new ImpiantoSportivo();
        impiantoSportivo.setId(0);
        assertEquals(0, impiantoSportivo.getId());

    }

    @Test
    void getSetNome() {
        ImpiantoSportivo impiantoSportivo = new ImpiantoSportivo();
        impiantoSportivo.setNome("Palazzo Maradona");
        assertEquals("Palazzo Maradona", impiantoSportivo.getNome());

    }

    @Test
    void getSetPrezzo() {
        ImpiantoSportivo impiantoSportivo = new ImpiantoSportivo();
        impiantoSportivo.setPrezzo(50);
        assertEquals(50, impiantoSportivo.getPrezzo());

    }

    @Test
    void getSetTipologia() {
        ImpiantoSportivo impiantoSportivo = new ImpiantoSportivo();
        impiantoSportivo.setTipologia("Calcio");
        assertEquals("Calcio", impiantoSportivo.getTipologia());

    }

    @Test
    void getSetTerreno() {
        ImpiantoSportivo impiantoSportivo = new ImpiantoSportivo();
        impiantoSportivo.setTerreno("Sintetico");
        assertEquals("Sintetico", impiantoSportivo.getTerreno());

    }


}
