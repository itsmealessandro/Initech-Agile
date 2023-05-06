package business.implementazioneRam;


import business.InitechBusinessFactory;
import business.UtenteService;

public class RAMInitechFactoryImpl extends InitechBusinessFactory {


    private UtenteService utenteService;


    public RAMInitechFactoryImpl() {
        utenteService = new RAMUtenteServiceImpl();

    }

    @Override
    public UtenteService getUtenteService() {
        return utenteService;
    }

}

