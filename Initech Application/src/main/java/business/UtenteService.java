package business;

import domain.Utente;

public interface UtenteService {

    Utente authenticate(String username, String password) throws UtenteNotFoundException, BusinessException;
    boolean registrazione(String nome, String cognome, int eta, String CF, String username, String password) throws BusinessException;


    void creaAssociazioni();

    void rimuoviUtente(int id) throws BusinessException;

    boolean modificaUtente(String nome, String cognome, int eta, String codiceFiscale, String
            username, String password, int id,String newUsername) throws BusinessException;

}