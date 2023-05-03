package business.implementazioneRam;


import business.CouprojectBusinessFactory;
import business.UtenteService;

public class RAMCouprojectFactoryImpl extends CouprojectBusinessFactory {


    private UtenteService utenteService;


    public RAMCouprojectFactoryImpl() {
        utenteService = new RAMUtenteServiceImpl();

    }

    @Override
    public UtenteService getUtenteService() {
        return utenteService;
    }

}

