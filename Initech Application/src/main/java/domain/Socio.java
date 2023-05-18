package domain;

public class Socio extends Utente {


    private String nome, cognome;
    private TipologiaSocio tipologiaSocio;

    //ASSOCIAZIONI
    private ImpiantoSportivo impiantoSportivo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public TipologiaSocio getTipologiaSocio() {
        return tipologiaSocio;
    }

    public void setTipologiaSocio(TipologiaSocio tipologiaSocio) {
        this.tipologiaSocio = tipologiaSocio;
    }

    public ImpiantoSportivo getImpiantoSportivo() {
        return impiantoSportivo;
    }

    public void setImpiantoSportivo(ImpiantoSportivo impiantoSportivo) {
        this.impiantoSportivo = impiantoSportivo;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
