package business.implementazioneRam;


import business.BusinessException;
import business.ImpiantoService;
import business.InitechBusinessFactory;
import business.UtenteService;
import domain.ImpiantoSportivo;
import domain.Socio;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RAMInitechFactoryImpl extends InitechBusinessFactory {


    private UtenteService utenteService;
    private ImpiantoService impiantoService;


    public RAMInitechFactoryImpl() {
        utenteService = new RAMUtenteServiceImpl();
        impiantoService = new RAMImpiantoServiceImpl();
        creaAssociazioni();
    }

    // Simula uno stato intermedio dell'applicazione
    private void creaAssociazioni() {
        try {
            List<Socio> socioArrayList = utenteService.getAllSoci();

            List<ImpiantoSportivo> impiantoSportivoList = impiantoService.getAllImpianti();

            ImpiantoSportivo campo1 = impiantoSportivoList.get(0);
            Iterator<Socio> socioIterator = socioArrayList.iterator();

            Socio socio1 = socioIterator.next();
            Socio socio2 = socioIterator.next();
            socio1.setImpiantoSportivo(campo1);
            socio2.setImpiantoSportivo(campo1);

            Set<Socio> socioSet = new HashSet<>();
            socioSet.add(socio1);
            socioSet.add(socio2);
            campo1.setElencoSoci(socioSet);
        } catch (BusinessException e) {
            e.printStackTrace();
            System.out.println("Errore nella creazione delle associazioni");
        }

    }

    @Override
    public UtenteService getUtenteService() {
        return utenteService;
    }

    @Override
    public ImpiantoService getImpiantoService() {
        return impiantoService;
    }

}

