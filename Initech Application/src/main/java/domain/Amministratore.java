package domain;


public class Amministratore extends Utente {
    //ASSOCIAZIONI


    public Amministratore(Integer id, String nome, String cognome, int eta, String codiceFiscale, String username, String password) {
        super(id, nome, cognome, eta, codiceFiscale, username, password);
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Amministratore)) return false;
        Amministratore amministratore = (Amministratore) o;
        if (amministratore.getCodiceFiscale() == this.getCodiceFiscale())
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Amministratore: { " + super.toString() + " }";
    }
}
