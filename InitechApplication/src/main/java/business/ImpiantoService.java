package business;

import domain.ImpiantoSportivo;
import domain.Maestro;

import java.util.List;

public interface ImpiantoService {
    List<ImpiantoSportivo> getAllImpianti() throws BusinessException;

    boolean aggiungiImpianto(ImpiantoSportivo impiantoSportivo) throws BusinessException;
    boolean modificaImpianto(ImpiantoSportivo impiantoSportivo) throws BusinessException;
    boolean rimuoviImpianto(ImpiantoSportivo impiantoSportivo) throws  BusinessException;
}
