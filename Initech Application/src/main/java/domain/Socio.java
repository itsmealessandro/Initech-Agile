package domain;

public class Socio extends Utente {
    //ASSOCIAZIONI

    public Socio(Integer id, String nome, String cognome, int eta, String codiceFiscale, String username, String password) {
        super(id, nome, cognome, eta, codiceFiscale, username, password);
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Socio)) return false;
        Socio Socio = (Socio) o;
        if (Socio.getCodiceFiscale() == this.getCodiceFiscale())
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Socio: { " + super.toString() + " }";
    }
}
