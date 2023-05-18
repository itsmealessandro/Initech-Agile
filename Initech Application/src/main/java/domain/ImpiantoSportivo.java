package domain;

import java.util.Objects;
import java.util.Set;

public class ImpiantoSportivo {
    private Integer id;
    private String nome;
    private String tipologia;
    private int prezzo;
    private String terreno;

    // Associazioni
    Set<Socio> elencoSoci;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public Set<Socio> getElencoSoci() {
        return elencoSoci;
    }

    public void setElencoSoci(Set<Socio> elencoSoci) {
        this.elencoSoci = elencoSoci;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImpiantoSportivo that = (ImpiantoSportivo) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
