package domain;

public class Utente {
    /*
     * La classe Utente è stata creata per convogliare le 5 classi (Amministratore,Cliente,Maestro)
     * In una sola classe, in modo da poter passare al dispatcher solo l'Utente permettendoci di non dover creare
     * un metodo per ogni classe nel dispatcher. Permettendo così un miglior riuso del codice.
     *
     * */

    private Integer id;
    private String username;
    private String password;

    private String email;

    public Utente() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Utente)) return false;
        Utente utente = (Utente) o;
        if (
                utente.getUsername().equals(this.username) &&
                        utente.getEmail().equals(this.email) &&
                        utente.getPassword().equals(this.password)
        )
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return this.getClass() +"{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
