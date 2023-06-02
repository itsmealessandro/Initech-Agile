package business.implementazioneRam;

import business.BusinessException;
import business.UtenteNotFoundException;
import business.UtenteService;
import domain.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class RAMUtenteServiceImpl implements UtenteService {

    // Lista di Utenti
    public HashSet<Utente> listaUtenti;
    private int contatoreID = 0;

    public RAMUtenteServiceImpl() {

        this.listaUtenti = new HashSet<Utente>();

        // Utenti presenti all'avvio dell'applicazione
        Utente amministratore = new Amministratore();
        amministratore.setEmail("a@gmail.com");
        amministratore.setUsername("a");
        amministratore.setPassword("a");
        amministratore.setId(contatoreID);
        listaUtenti.add(amministratore);
        contatoreID++;

        Socio socio = new Socio();
        socio.setNome("Fabio");
        socio.setCognome("Quagliarella");
        socio.setTipologiaSocio(TipologiaSocio.FREE);
        socio.setEmail("s@gmail.com");
        socio.setUsername("s");
        socio.setPassword("s");
        socio.setId(contatoreID);
        listaUtenti.add(socio);
        contatoreID++;

        Socio socio2 = new Socio();
        socio2.setNome("Luca");
        socio2.setCognome("Signori");
        socio2.setTipologiaSocio(TipologiaSocio.PREMIUM);
        socio2.setEmail("s2@gmail.com");
        socio2.setUsername("s2");
        socio2.setPassword("s");
        socio2.setId(contatoreID);
        listaUtenti.add(socio2);
        contatoreID++;

        Utente utenteRegistrato = new UtenteRegistrato();
        utenteRegistrato.setEmail("u@gmail.com");
        utenteRegistrato.setUsername("u");
        utenteRegistrato.setPassword("u");
        utenteRegistrato.setId(contatoreID);
        listaUtenti.add(utenteRegistrato);
        contatoreID++;

        Maestro maestro0 = new Maestro();
        maestro0.setEmail("m@gmail.com");
        maestro0.setUsername("Mimmo");
        maestro0.setPassword("m");
        maestro0.setId(contatoreID);
        listaUtenti.add(maestro0);
        contatoreID++;
    }

    @Override
    public Utente authenticate(String username, String password) throws BusinessException {
        for (Utente u : listaUtenti) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password))
                return u;
        }
        throw new UtenteNotFoundException();
    }


    @Override
    public boolean registrazione(UtenteRegistrato utente)
            throws BusinessException {
        if (controlloEsistenza(utente.getUsername())) return false;
        utente.setId(contatoreID);
        contatoreID++;
        this.listaUtenti.add(utente);
        return true;
    }


    // Il metodo ritorna True se è presente un utente con quello username, False altrimenti
    private boolean controlloEsistenza(String newUsername) {
        for (Utente utente : listaUtenti) {
            if (utente.getUsername().equals(newUsername))
                return true;
        }
        return false;
    }

    @Override
    // ritorna falso se il metodo ritorna true (ovvero se quello username è esistente)
    public boolean modificaUtente(Utente utente, String newUsername, boolean usernameModificato) throws BusinessException {


        if (usernameModificato) {
            // Controllo se esiste già un username con quel nome
            if (controlloEsistenza(newUsername)) {
                throw new BusinessException("Username già presente");
            }
        }
        for (Utente utenteX : listaUtenti) {
            // Il controllo va fatto con l'ID e non con l'equalse
            // Perché gli passiamo l'utente modificato quindi non potrà mai essere uguale
            if (utenteX.getId() == utente.getId()) {
                utenteX.setUsername(newUsername);
                utenteX.setEmail(utente.getEmail());
                utenteX.setPassword(utente.getPassword());
            }
        }
        return true;
    }

    @Override
    public boolean aggiungiMaestro(Maestro maestro) throws BusinessException {

        boolean esito = controlloEsistenza(maestro.getUsername());
        if (esito == true) throw new BusinessException("username già esistente");

        maestro.setId(contatoreID);
        contatoreID++;
        this.listaUtenti.add(maestro);
        return true;
    }


    @Override
    public boolean rimuoviUtente(int id) throws BusinessException {
        Iterator<Utente> utenteIterator = listaUtenti.iterator();
        while (utenteIterator.hasNext()) {
            Utente utente = utenteIterator.next();
            if (utente.getId() == id) {
                utenteIterator.remove();
                return true;
            }
        }
        throw new BusinessException("Utente non trovato");
    }

    @Override
    public List<Socio> getAllSoci() throws BusinessException {
        List<Socio> socioList = new ArrayList<>();

        for (Utente utente : listaUtenti) {
            if (utente instanceof Socio) {
                socioList.add((Socio) utente);
            }
        }

        if (socioList.size() == 0) throw new BusinessException("Non sono presenti Soci");
        return socioList;
    }

    @Override
    public List<Maestro> getAllMaestri() throws BusinessException {
        List<Maestro> maestroList = new ArrayList<>();

        for (Utente utente : listaUtenti) {
            if (utente instanceof Maestro) {
                maestroList.add((Maestro) utente);
            }
        }

        if (maestroList.size() == 0) throw new BusinessException("Non sono presenti Maestri");
        return maestroList;
    }
}


