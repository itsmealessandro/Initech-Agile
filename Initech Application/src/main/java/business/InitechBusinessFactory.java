package business;

import business.implementazioneRam.RAMCouprojectFactoryImpl;

public abstract class InitechBusinessFactory {

    private static InitechBusinessFactory factory = new RAMCouprojectFactoryImpl();

    public static InitechBusinessFactory getInstance() {
        return factory;
    }

    public abstract UtenteService getUtenteService();
}
