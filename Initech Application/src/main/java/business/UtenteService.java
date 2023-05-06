package business;

import domain.Utente;

public interface UtenteService {

    Utente authenticate(String username, String password) throws UtenteNotFoundException, BusinessException;
    boolean registrazione(String nome, String cognome, int eta, String CF, String username, String password) throws BusinessException;


    void rimuoviUtente(int id) throws BusinessException;

    boolean modificaUtente(Utente utente,String newUsername) throws BusinessException;

}