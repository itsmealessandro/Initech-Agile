import business.BusinessException;
import business.implementazioneRam.RAMUtenteServiceImpl;
import domain.Amministratore;
import domain.Socio;
import domain.TipologiaSocio;
import domain.Utente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RAMUtenteServiceImplTest {

    @Test
    void entraAmministratore() {

        RAMUtenteServiceImpl ramUtenteService = new RAMUtenteServiceImpl();
        Utente utenteAspettato = new Amministratore();
        utenteAspettato.setEmail("a@gmail.com");
        utenteAspettato.setUsername("a");
        utenteAspettato.setPassword("a");
        utenteAspettato.setId(0);

        try {
            assertEquals(utenteAspettato, ramUtenteService.authenticate("a", "a"));
        } catch (BusinessException e) {
            e.printStackTrace();
        }

    }

    @Test
    void entraSocio() {

        try {
            RAMUtenteServiceImpl ramUtenteService = new RAMUtenteServiceImpl();
            Socio socio = new Socio();
            socio.setNome("Fabio");
            socio.setCognome("Quagliarella");
            socio.setTipologiaSocio(TipologiaSocio.FREE);
            socio.setEmail("s@gmail.com");
            socio.setUsername("s");
            socio.setPassword("s");
            socio.setId(1);

            assertEquals(socio, ramUtenteService.authenticate("s", "s"));
        } catch (BusinessException e) {
            e.printStackTrace();
        }

    }
}