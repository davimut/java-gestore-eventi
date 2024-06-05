package org.lessons.java.gestoreEventi;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Eventi {
	private String titolo;
	private LocalDate data;
	private int numeroPostiTotale;
	private int numeroPostiPrenotati;

	public Eventi(String titolo, LocalDate data, int numeroPostiTotale) {
		this.titolo = titolo;
		this.numeroPostiPrenotati = 0;
		this.numeroPostiTotale = numeroPostiTotale;
		this.data = data;

		if (data.isBefore(LocalDate.now())) {
			System.out.println("La data dell'evento non può essere nel passato. Impostata data di oggi.");
			this.data = LocalDate.now();
		} else {
			this.data = data;
		}
		if (numeroPostiTotale <= 0) {
			System.out.println("Il numero di posti totale deve essere positivo. Impostato a 1.");
			this.numeroPostiTotale = 1;
		} else {
			this.numeroPostiTotale = numeroPostiTotale;
		}
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getData() {
		return this.data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public void setData(LocalDate data) {

		this.data = data;

	}

	public int getNumeroPostiTotale() {
		return numeroPostiTotale;
	}

	public int getNumeroPostiPrenotati() {
		return numeroPostiPrenotati;
	}

		public String prenota() {
		    // Controlla se il numero di posti prenotati è già uguale o superiore al numero totale di posti disponibili
		    if (numeroPostiPrenotati >= numeroPostiTotale) {
		        // Se tutti i posti sono già prenotati, restituisce un messaggio che informa che non ci sono posti disponibili
		        return "Non ci sono posti disponibili.";
		    }
		    // Se ci sono ancora posti disponibili, incrementa il numero di posti prenotati di 1
		    numeroPostiPrenotati++;
		    // Restituisce un messaggio che informa che la prenotazione è stata effettuata con successo
		    return "Prenotazione effettuata con successo.";
		}

	public String disdici() {
		if (numeroPostiPrenotati <= 0) {
			return "Non ci sono prenotazioni da disdire.";
		}
		numeroPostiPrenotati--;
		return "Disdetta effettuata con successo.";
	}

	@Override
	public String toString() {

		return "Titolo: " + titolo + "\n" + "Data: " + getData() + "\n" + "Numero totale di posti disponibili: "
				+ numeroPostiTotale + "\n" + "Numero di posti prenotati: " + numeroPostiPrenotati;
	}
}
