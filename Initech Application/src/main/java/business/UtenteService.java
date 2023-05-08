package business;

import domain.Utente;
import domain.UtenteRegistrato;

public interface UtenteService {

    Utente authenticate(String username, String password) throws UtenteNotFoundException, BusinessException;
    boolean registrazione(UtenteRegistrato utente) throws BusinessException;


    void rimuoviUtente(int id) throws BusinessException;

    boolean modificaUtente(Utente utente,String newUsername) throws BusinessException;

}