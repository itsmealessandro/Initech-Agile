package domain;

import java.util.Objects;

public class ImpiantoSportivo {
    private Integer id;
    private String tipologia;
    private int prezzo;
    private String terreno;

    public ImpiantoSportivo(Integer id, String tipologia, int prezzo, String terreno) {
        this.id = id;
        this.tipologia = tipologia;
        this.prezzo = prezzo;
        this.terreno = terreno;
    }
    public ImpiantoSportivo(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ImpiantoSportivo{" +
                "id=" + id +
                ", tipologia='" + tipologia + '\'' +
                ", prezzo=" + prezzo +
                ", terreno='" + terreno + '\'' +
                '}';
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
