package business.implementazioneRam;

import business.BusinessException;
import business.UtenteNotFoundException;
import business.UtenteService;
import domain.Amministratore;
import domain.Cliente;
import domain.Utente;

import java.util.HashSet;


public class RAMUtenteServiceImpl implements UtenteService {

    // Lista di Utenti
    public HashSet<Utente> listaUtenti;
    private int contatoreID = 3; // inizializzato a 3 poiché abbiamo creato 3 utenti iniziali

    public RAMUtenteServiceImpl() {
        // creazione lista utenti
        this.listaUtenti = new HashSet<Utente>();


        Utente amministratore = new Amministratore(
                0, "Alessandro", "Brini", 40, "HNVDQW80L65E578A", "a", "a");
        listaUtenti.add(amministratore);

        Cliente cliente = new Cliente(
                2, "Lucio", "Rosa", 18, "RZTNTX98E29D884P", "c", "c");
        listaUtenti.add(cliente);


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
        Utente nuovoCliente = new Cliente(contatoreID, nome, cognome, eta, CF, username, password);
        contatoreID++;
        this.listaUtenti.add(nuovoCliente);
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
    public boolean modificaUtente(String nome, String cognome, int eta, String codiceFiscale, String
            username, String password, int id, String newUsername) throws BusinessException {
        // ritorna falso se il metodo ritorna true (ovvero se quello username è esistente)
        if (controlloEsistenza(newUsername)) return false;
        for (Utente utente : listaUtenti) {
            if (utente.getId() == id) {
                utente.setNome(nome);
                utente.setCognome(cognome);
                utente.setEta(eta);
                utente.setCodiceFiscale(codiceFiscale);
                utente.setUsername(username);
                utente.setPassword(password);
            }
        }
        return true;
    }


    @Override
    public void creaAssociazioni() {

    }

    @Override
    public void rimuoviUtente(int id) throws BusinessException {

    }
}


