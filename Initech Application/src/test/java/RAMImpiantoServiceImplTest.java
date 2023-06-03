import business.BusinessException;
import business.implementazioneRam.RAMImpiantoServiceImpl;
import domain.ImpiantoSportivo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RAMImpiantoServiceImplTest {

    @Test
    void aggiungiImpianto() throws BusinessException {
        RAMImpiantoServiceImpl ramImpiantoService = new RAMImpiantoServiceImpl();
        ImpiantoSportivo campo1 = new ImpiantoSportivo();
        campo1.setId(0);
        campo1.setNome("Palazzo Maradona");
        campo1.setPrezzo(50);
        campo1.setTerreno("sintetico");
        campo1.setTipologia("calcio");
        boolean a = true;
        assertEquals(a, ramImpiantoService.aggiungiImpianto(campo1));

    }

    @Test
    void modificaImpianto() throws BusinessException {
        RAMImpiantoServiceImpl ramImpiantoService = new RAMImpiantoServiceImpl();
        ImpiantoSportivo campo1 = new ImpiantoSportivo();
        campo1.setId(0);
        campo1.setNome("Palazzo Maradona");
        campo1.setPrezzo(50);
        campo1.setTerreno("sintetico");
        campo1.setTipologia("calcio");
        boolean a = true;
        assertEquals(a, ramImpiantoService.modificaImpianto(campo1));
    }

    @Test
    void rimuoviUtente() throws BusinessException {
        RAMImpiantoServiceImpl ramImpiantoService = new RAMImpiantoServiceImpl();
        ImpiantoSportivo campo1 = new ImpiantoSportivo();
        campo1.setId(0);
        campo1.setNome("Palazzo Maradona");
        campo1.setPrezzo(50);
        campo1.setTerreno("sintetico");
        campo1.setTipologia("calcio");
        boolean a = true;
        assertEquals(a, ramImpiantoService.rimuoviImpianto(campo1));
    }
}
