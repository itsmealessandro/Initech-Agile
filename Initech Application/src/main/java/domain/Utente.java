package domain;

public class Utente {
    /*
     * La classe Utente è stata creata per convogliare le 5 classi (Amministratore,Cliente,Maestro)
     * In una sola classe, in modo da poter passare al dispatcher solo l'Utente permettendoci di non dover creare
     * un metodo per ogni classe nel dispatcher. Permettendo così un miglior riuso del codice.
     *
     * */

    private Integer id;
    private String nome;
    private String cognome;
    private int eta;
    private String codiceFiscale; // Chiave univoca
    private String username;
    private String password;

    public Utente() {
    }

    public Utente(Integer id, String nome, String cognome, int eta, String codiceFiscale, String username, String password) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.codiceFiscale = codiceFiscale;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Utente)) return false;
        Utente utente = (Utente) o;
        if (utente.getId() == this.id)
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
