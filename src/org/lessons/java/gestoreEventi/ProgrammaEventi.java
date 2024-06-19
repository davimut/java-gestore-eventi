package org.lessons.java.gestoreEventi;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammaEventi {
    private String titolo;
    private List<Eventi> eventi;

    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    public void aggiungiEvento(Eventi evento) {
        this.eventi.add(evento);
    }

    public List<Eventi> getEventiByData(LocalDate data) {
        List<Eventi> eventiByData = new ArrayList<>();
        for (Eventi evento : this.eventi) {
            if (evento.getData().equals(data)) {
                eventiByData.add(evento);
            }
        }
        return eventiByData;
    }

    public int getNumeroEventi() {
        return this.eventi.size();
    }

    public void svuotaEventi() {
        this.eventi.clear();
    }

    public String mostraProgramma() {
        String result = this.titolo + "\n";
        List<Eventi> eventiOrdinati = new ArrayList<>(this.eventi);
        Collections.sort(eventiOrdinati, (e1, e2) -> e1.getData().compareTo(e2.getData()));
        for (Eventi evento : eventiOrdinati) {
            result += evento.getData() + " - " + evento.getTitolo() + "\n";
        }
        return result;
    }
}