package org.lessons.java.gestoreEventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Eventi> programmaEventi = new ArrayList<>();

        boolean aggiungereAltroEvento = true;

        while (aggiungereAltroEvento) {
            // Input dei dati dell'evento
            System.out.println("Inserisci il titolo dell'evento:");
            String titolo = scanner.nextLine();

            System.out.println("Inserisci il numero totale di posti disponibili:");
            int numeroPostiTotale = Integer.parseInt(scanner.nextLine());

            System.out.println("Inserisci la data dell'evento (formato: dd-MM-yyyy):");
            LocalDate data = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            // Creazione dell'oggetto Eventi
            Eventi evento = new Eventi(titolo, data, numeroPostiTotale);

            System.out.println("Data: " + evento.getData());

            // Chiedere all'utente quante prenotazioni vuole fare
            System.out.println("Quante prenotazioni vuoi fare?");
            int numeroPrenotazioni = Integer.parseInt(scanner.nextLine());

            // Effettuazione delle prenotazioni
            for (int i = 0; i < numeroPrenotazioni; i++) {
                String risultatoPrenotazione = evento.prenota();
                System.out.println(risultatoPrenotazione);
            }

            // Chiedere all'utente quante disdette vuole fare
            System.out.println("Quante disdette vuoi fare?");
            int numeroDisdette = Integer.parseInt(scanner.nextLine());

            // Effettuazione delle disdette
            for (int i = 0; i < numeroDisdette; i++) {
                String risultatoDisdetta = evento.disdici();
                System.out.println(risultatoDisdetta);
            }

            // Stampare l'evento prenotato
            System.out.println("Evento prenotato:");
            System.out.println(evento);

            // Chiedere all'utente se l'evento è un concerto
            System.out.println("L'evento è un concerto? (si/no):");
            String risposta = scanner.nextLine();

            if (risposta.equals("si")) {
                System.out.println("Inserisci l'ora del concerto (formato: HH:mm):");
                LocalTime ora = LocalTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("HH:mm"));

                System.out.println("Inserisci il prezzo del concerto:");
                double prezzo = Double.parseDouble(scanner.nextLine());

                Concerto concerto = new Concerto(titolo, data, numeroPostiTotale, ora, prezzo);

                // Stampare l'evento prenotato come concerto
                System.out.println("Il tuo evento prenotato è un Concerto:");
                System.out.println(concerto);

                // Aggiungere il concerto alla lista del programma
                programmaEventi.add(concerto);
            } else {   
            	// Aggiungere l'evento alla lista del programma
            programmaEventi.add(evento);
            }

            // Chiedere se l'utente vuole aggiungere un altro evento
            System.out.println("Vuoi aggiungere un altro evento? (si/no):");
            String rispostaAggiungiAltroEvento = scanner.nextLine();

            if (!rispostaAggiungiAltroEvento.equals("si")) {
                aggiungereAltroEvento = false;
            }
        }

        // Stampare tutti gli eventi nel programma
        System.out.println("Ecco tutti gli eventi nel programma:");
        for (Eventi e : programmaEventi) {
            System.out.println(e);
        }
    }
}
