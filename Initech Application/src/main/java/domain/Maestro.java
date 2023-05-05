package domain;

public class Maestro extends Utente {
    //ASSOCIAZIONI

    public Maestro(Integer id, String nome, String cognome, int eta, String codiceFiscale, String username, String password) {
        super(id, nome, cognome, eta, codiceFiscale, username, password);
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Maestro)) return false;
        Maestro Maestro = (Maestro) o;
        if (Maestro.getCodiceFiscale() == this.getCodiceFiscale())
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Maestro: { " + super.toString() + " }";
    }
}
