package business;

import business.implementazioneRam.RAMInitechFactoryImpl;

public abstract class InitechBusinessFactory {

    private static InitechBusinessFactory factory = new RAMInitechFactoryImpl();

    public static InitechBusinessFactory getInstance() {
        return factory;
    }

    public abstract UtenteService getUtenteService();
    public abstract ImpiantoService getImpiantoService();
}
