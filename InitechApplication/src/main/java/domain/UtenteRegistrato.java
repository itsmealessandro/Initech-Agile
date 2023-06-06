package domain;

import java.util.Objects;

public class UtenteRegistrato extends Utente{

    private double wallet;

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "UtenteRegistrato{" +
                "wallet=" + wallet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
    
}
