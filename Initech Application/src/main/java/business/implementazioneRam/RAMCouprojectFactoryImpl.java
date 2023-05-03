package business.implementazioneRam;


import business.InitechBusinessFactory;
import business.UtenteService;

public class RAMCouprojectFactoryImpl extends InitechBusinessFactory {


    private UtenteService utenteService;


    public RAMCouprojectFactoryImpl() {
        utenteService = new RAMUtenteServiceImpl();

    }

    @Override
    public UtenteService getUtenteService() {
        return utenteService;
    }

}

