package org.lessons.java.gestoreEventi;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input dei dati dell'evento
        System.out.println("Inserisci il titolo dell'evento:");
        String titolo = scanner.nextLine();

        System.out.println("Inserisci la data dell'evento (formato: dd-MM-yyyy):");
        LocalDate data = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        
        System.out.println("Data: " + data);

        System.out.println("Inserisci il numero totale di posti disponibili:");
        int numeroPostiTotale = scanner.nextInt();

        // Creazione dell'oggetto Eventi
        Eventi evento = new Eventi(titolo, data, numeroPostiTotale);

        // Chiedere all'utente quante prenotazioni vuole fare
        System.out.println("Quante prenotazioni vuoi fare?");
        int numeroPrenotazioni = scanner.nextInt();

        // Effettuazione delle prenotazioni
        for (int i = 0; i < numeroPrenotazioni; i++) {
            String risultatoPrenotazione = evento.prenota();
            System.out.println(risultatoPrenotazione);
        }

        // Chiedere all'utente quante disdette vuole fare
        System.out.println("Quante disdette vuoi fare?");
        int numeroDisdette = scanner.nextInt();

        // Effettuazione delle disdette
        for (int i = 0; i < numeroDisdette; i++) {
            String risultatoDisdetta = evento.disdici();
            System.out.println(risultatoDisdetta);
        }

        // Stampare l'evento prenotato
        System.out.println("Evento prenotato:");
        System.out.println(evento);
      
    }
}