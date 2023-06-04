import business.BusinessException;
import business.implementazioneRam.RAMUtenteServiceImpl;
import domain.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void loginErrato() {
        try {
            RAMUtenteServiceImpl ramUtenteService = new RAMUtenteServiceImpl();
            UtenteRegistrato utenteRegistrato = new UtenteRegistrato();
            utenteRegistrato.setEmail("u@gmail.com");
            utenteRegistrato.setUsername("u");
            utenteRegistrato.setPassword("u");
            utenteRegistrato.setId(1);

            ramUtenteService.authenticate("l", "l");
        } catch (BusinessException e) {
            assert true;
        }

    }

    @Test
    void entraAmministratore() {


        Utente amministratore = new Amministratore();
        amministratore.setEmail("a@gmail.com");
        amministratore.setUsername("a");
        amministratore.setPassword("a");
        amministratore.setId(0);

        try {
            assertEquals(amministratore, ramUtenteService.authenticate("a", "a"));
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
    void entraUtenteRegistrato() {

        try {
            RAMUtenteServiceImpl ramUtenteService = new RAMUtenteServiceImpl();
            UtenteRegistrato utenteRegistrato = new UtenteRegistrato();
            utenteRegistrato.setEmail("u@gmail.com");
            utenteRegistrato.setUsername("u");
            utenteRegistrato.setPassword("u");
            utenteRegistrato.setId(1);

            assertEquals(utenteRegistrato, ramUtenteService.authenticate("u", "u"));
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

    @Test
    void aggiungiNuovoMaestro() throws BusinessException {

        Maestro maestro = new Maestro();
        maestro.setId(5);
        maestro.setEmail("m");
        maestro.setUsername("ma");
        maestro.setPassword("ma");

        ramUtenteService.aggiungiMaestro(maestro);
        assertEquals(maestro, ramUtenteService.authenticate("ma", "ma"));
    }

    @Test
    void aggiungiNuovoMaestroErrato() throws BusinessException {

        Maestro maestro = new Maestro();
        maestro.setId(6);
        maestro.setEmail("m");
        maestro.setUsername("alalala");
        maestro.setPassword("ma");

        ramUtenteService.aggiungiMaestro(maestro);
        assertThrows(BusinessException.class, () -> {
            assertEquals(maestro, ramUtenteService.authenticate("ma", "ma"));
        });
    }

    @Test
    void aggiungiNuovoMaestroStessoNome() throws BusinessException {

        Maestro maestro = new Maestro();
        maestro.setId(7);
        maestro.setEmail("rocco@gmail");
        maestro.setUsername("Mimmo");
        maestro.setPassword("m");

        assertThrows(BusinessException.class, () -> {
            assertEquals(maestro, ramUtenteService.aggiungiMaestro(maestro));
        });
        ramUtenteService.authenticate("Mimmo", "m");
    }

    @Test
    void rimozioneCorrettaMaestro() throws BusinessException {

        Maestro maestro = new Maestro();
        maestro.setId(8);
        maestro.setEmail("m");
        maestro.setUsername("ma");
        maestro.setPassword("ma");

        ramUtenteService.aggiungiMaestro(maestro);
        assertEquals(true, ramUtenteService.rimuoviUtente(maestro.getId()));
    }

    @Test
    void maestroUtenteNonTrovato() throws BusinessException {

        Maestro maestro = new Maestro();
        maestro.setId(8);
        maestro.setEmail("m");
        maestro.setUsername("ma");
        maestro.setPassword("ma");

        assertThrows(BusinessException.class, () -> {
            assertEquals(true, ramUtenteService.rimuoviUtente(maestro.getId()));
        });
    }

    @Test
    void modificaCorrettaMaestro() throws BusinessException {

        Maestro maestro = new Maestro();
        maestro.setId(8);
        maestro.setEmail("giorgio@gmail");
        maestro.setUsername("Giorgio");
        maestro.setPassword("gio");

        ramUtenteService.aggiungiMaestro(maestro);

        assertEquals(true, ramUtenteService.modificaUtente(maestro, "Veronica", true));
    }

    @Test
    void maestroUsernameGiaPresente() throws BusinessException {

        Maestro maestro = new Maestro();
        maestro.setId(8);
        maestro.setEmail("giorgio@gmail");
        maestro.setUsername("Giorgio");
        maestro.setPassword("gio");

        Maestro maestro1 = new Maestro();
        maestro1.setId(9);
        maestro1.setEmail("veronica@gmail");
        maestro1.setUsername("Veronica");
        maestro1.setPassword("ver");

        ramUtenteService.aggiungiMaestro(maestro);
        ramUtenteService.aggiungiMaestro(maestro1);

        assertThrows(BusinessException.class, () -> {
            assertEquals(true, ramUtenteService.modificaUtente(maestro, "Veronica", true));
        });
    }

}