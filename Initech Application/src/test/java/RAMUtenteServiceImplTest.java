import business.BusinessException;
import business.implementazioneRam.RAMUtenteServiceImpl;
import domain.Amministratore;
import domain.Socio;
import domain.TipologiaSocio;
import domain.Utente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RAMUtenteServiceImplTest {


    RAMUtenteServiceImpl ramUtenteService;

    @BeforeEach
    void init() {
        ramUtenteService = new RAMUtenteServiceImpl();
    }

    @AfterEach
    void end() {
        ramUtenteService = null;
    }

    @Test
    void entraAmministratore() {


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

    @Test
    void modificaProfiloUsername() {
        try {
            Utente utente = ramUtenteService.authenticate("s", "s");
            Utente nuovoUtente = new Utente();
            nuovoUtente.setUsername(utente.getUsername());
            nuovoUtente.setEmail(utente.getEmail());
            nuovoUtente.setPassword(utente.getPassword());
            nuovoUtente.setId(utente.getId());

            ramUtenteService.modificaUtente(nuovoUtente, "AAA", true);
            nuovoUtente.setUsername("AAA");

            Utente utenteModificato = ramUtenteService.authenticate("AAA", "s");
            assertEquals(nuovoUtente, utenteModificato);
        } catch (BusinessException e) {
            e.printStackTrace();
        }


    }

    @Test
    void modificaProfiloNonUsername() {
        try {
            Utente utente = ramUtenteService.authenticate("s", "s");

            Utente nuovoUtente = new Utente();
            nuovoUtente.setUsername(utente.getUsername());
            nuovoUtente.setEmail("x");
            nuovoUtente.setPassword("x");
            nuovoUtente.setId(utente.getId());

            ramUtenteService.modificaUtente(nuovoUtente, nuovoUtente.getUsername(), false);

            Utente utenteModificato = ramUtenteService.authenticate("s", "x");
            assertEquals(nuovoUtente, utenteModificato);
        } catch (BusinessException e) {
            e.printStackTrace();
        }


    }
}