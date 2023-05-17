package business.implementazioneRam;

import business.BusinessException;
import business.ImpiantoService;
import domain.ImpiantoSportivo;
import domain.Maestro;
import domain.Utente;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RAMImpiantoServiceImpl implements ImpiantoService {

    public HashSet<ImpiantoSportivo> listaImpianti;
    private int contatoreID = 1;
    public RAMImpiantoServiceImpl(){
        this.listaImpianti= new HashSet<ImpiantoSportivo>();

        ImpiantoSportivo campo1=new ImpiantoSportivo();
        campo1.setId(0);
        campo1.setPrezzo(50);
        campo1.setTerreno("sintetico");
        campo1.setTipologia("calcio");
        listaImpianti.add(campo1);
    }
    @Override
    public List<ImpiantoSportivo> getAllImpianti() throws BusinessException {
        List<ImpiantoSportivo> impiantiList = new ArrayList<>(listaImpianti);

        if (impiantiList.size() == 0) throw new BusinessException("Non sono presenti Impianti sportivi");
        return impiantiList;

    }

    @Override
    public boolean aggiungiImpianto(ImpiantoSportivo impiantoSportivo) throws BusinessException {

        impiantoSportivo.setId(contatoreID);
        contatoreID++;
        this.listaImpianti.add(impiantoSportivo);
        return true;
    }
}
