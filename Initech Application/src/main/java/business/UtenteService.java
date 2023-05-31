package business;

import domain.Maestro;
import domain.Socio;
import domain.Utente;
import domain.UtenteRegistrato;

import java.util.List;

public interface UtenteService {

    Utente authenticate(String username, String password) throws UtenteNotFoundException, BusinessException;

    boolean registrazione(UtenteRegistrato utente) throws BusinessException;

    boolean rimuoviUtente(int id) throws BusinessException;

    boolean modificaUtente(Utente utente, String newUsername, boolean usernameModificato) throws BusinessException;

    List<Socio> getAllSoci() throws BusinessException;

    List<Maestro> getAllMaestri() throws BusinessException;

    boolean aggiungiMaestro(Maestro maestro) throws BusinessException;

}