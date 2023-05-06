package domain;

public class Socio extends Utente {
    //ASSOCIAZIONI

    private TipologiaSocio tipologiaSocio;

    public TipologiaSocio getTipologiaSocio() {
        return tipologiaSocio;
    }

    public void setTipologiaSocio(TipologiaSocio tipologiaSocio) {
        this.tipologiaSocio = tipologiaSocio;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
