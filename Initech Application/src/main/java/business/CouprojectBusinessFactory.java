package business;

import business.implementazioneRam.RAMCouprojectFactoryImpl;

public abstract class CouprojectBusinessFactory {

    private static CouprojectBusinessFactory factory = new RAMCouprojectFactoryImpl();

    public static CouprojectBusinessFactory getInstance() {
        return factory;
    }

    public abstract UtenteService getUtenteService();
}
