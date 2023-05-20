package business.implementazioneRam;

import business.BusinessException;
import business.ImpiantoService;
import domain.ImpiantoSportivo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class RAMImpiantoServiceImpl implements ImpiantoService {

    public HashSet<ImpiantoSportivo> listaImpianti;
    private int contatoreID = 0;

    public RAMImpiantoServiceImpl() {
        this.listaImpianti = new HashSet<>();

        ImpiantoSportivo campo1 = new ImpiantoSportivo();
        campo1.setId(contatoreID);
        campo1.setNome("Palazzo Maradona");
        campo1.setPrezzo(50);
        campo1.setTerreno("sintetico");
        campo1.setTipologia("calcio");
        contatoreID++;
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
    @Override
    public boolean modificaImpianto(ImpiantoSportivo impiantoSportivo) throws BusinessException {
        for (ImpiantoSportivo i : listaImpianti) {
            if (i.getId() == impiantoSportivo.getId()) {
                i.setNome(impiantoSportivo.getNome());
                i.setPrezzo(impiantoSportivo.getPrezzo());
                i.setTipologia(impiantoSportivo.getTipologia());
                i.setTerreno(impiantoSportivo.getTerreno());
            }
        }
        return true;

    }
    @Override
    public boolean rimuoviImpianto(ImpiantoSportivo impiantoSportivo) throws BusinessException {
        Iterator<ImpiantoSportivo> impiantoSportivoIterator = listaImpianti.iterator();
        while (impiantoSportivoIterator.hasNext()) {
            ImpiantoSportivo impiantoInstance = impiantoSportivoIterator.next();
            if (impiantoInstance.getId() == impiantoSportivo.getId()) {
                impiantoSportivoIterator.remove();
                return true;
            }
        }
        return false;
    }
}
