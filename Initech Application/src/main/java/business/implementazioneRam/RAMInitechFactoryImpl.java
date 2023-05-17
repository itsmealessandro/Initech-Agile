package business.implementazioneRam;


import business.ImpiantoService;
import business.InitechBusinessFactory;
import business.UtenteService;
import domain.ImpiantoSportivo;

public class RAMInitechFactoryImpl extends InitechBusinessFactory {


    private UtenteService utenteService;
    private ImpiantoService impiantoService;


    public RAMInitechFactoryImpl() {
        utenteService = new RAMUtenteServiceImpl();
        impiantoService = new RAMImpiantoServiceImpl();

    }

    @Override
    public UtenteService getUtenteService() {
        return utenteService;
    }
    @Override
    public ImpiantoService getImpiantoService(){return impiantoService;}

}

