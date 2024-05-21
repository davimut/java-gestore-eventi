package org.lessons.java.gestoreEventi;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Eventi {
    private LocalTime ora;
    private double prezzo;

    public Concerto(String titolo, LocalDate data, int numeroPostiTotale, LocalTime ora, double prezzo) {
        super(titolo, data, numeroPostiTotale);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getOraFormattata() {
        return this.ora.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public String getPrezzoFormattato() {
        return String.format("%.2f€", this.prezzo);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Ora: " + getOraFormattata() + "\n" +
                "Prezzo: " + getPrezzoFormattato();
    }
}
