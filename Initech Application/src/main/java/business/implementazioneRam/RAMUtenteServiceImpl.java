package business.implementazioneRam;

import business.BusinessException;
import business.UtenteNotFoundException;
import business.UtenteService;
import domain.Amministratore;
import domain.Socio;
import domain.Utente;
import domain.UtenteRegistrato;

import java.util.HashSet;


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
        listaUtenti.add(amministratore);
        contatoreID++;

        Utente socio = new Socio();
        socio.setEmail("s@gmail.com");
        socio.setUsername("s");
        socio.setPassword("s");
        listaUtenti.add(socio);
        contatoreID++;

        Utente utenteRegistrato = new UtenteRegistrato();
        utenteRegistrato.setEmail("u@gmail.com");
        utenteRegistrato.setUsername("u");
        utenteRegistrato.setPassword("u");
        listaUtenti.add(utenteRegistrato);
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
    public boolean registrazione(String nome, String cognome, int eta, String CF, String username, String password)
            throws BusinessException {
        if (controlloEsistenza(username)) return false;
        // TODO da completare
        Utente nuovoCliente;
        contatoreID++;
        // this.listaUtenti.add(nuovoCliente);
        return true;
    }


    // Il metodo ritorna True se è presente un utente con quello username, False altrimenti
    private boolean controlloEsistenza(String newUsername) {
        for (Utente utente : listaUtenti) {
            if (utente.getUsername().equals(newUsername))
                return true; //
        }
        return false;
    }

    @Override
    // ritorna falso se il metodo ritorna true (ovvero se quello username è esistente)
    public boolean modificaUtente(Utente utente, String newUsername) throws BusinessException {


        return true;
    }


    @Override
    public void rimuoviUtente(int id) throws BusinessException {

    }
}


