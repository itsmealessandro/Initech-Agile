package domain;

public class Socio extends Utente {
    //ASSOCIAZIONI

    private String nome, cognome;
    private TipologiaSocio tipologiaSocio;

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

    @Override
    public String toString() {
        return super.toString();
    }
}
