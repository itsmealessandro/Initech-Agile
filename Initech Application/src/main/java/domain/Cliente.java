package domain;


public class Cliente extends Utente {
    //ASSOCIAZIONI

    public Cliente(Integer id, String nome, String cognome, int eta, String codiceFiscale, String username, String password) {
        super(id, nome, cognome, eta, codiceFiscale, username, password);
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        if (cliente.getCodiceFiscale() == this.getCodiceFiscale())
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Cliente: { " + super.toString() + " }";
    }
}
