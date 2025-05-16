package it.prova.gestionetratte;

import it.prova.gestionetratte.model.Airbus;
import it.prova.gestionetratte.model.StatoTratta;
import it.prova.gestionetratte.model.Tratta;
import it.prova.gestionetratte.service.AirbusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class GestioneTratteApplication implements CommandLineRunner {

    @Autowired
    private AirbusService airbusService;

    public static void main(String[] args) {
        SpringApplication.run(GestioneTratteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Set<Airbus> airbusSet = Set.of(
			new Airbus("AB123", "Airbus A320", LocalDate.of(2020, 1, 1), 150),
			new Airbus("AB456", "Airbus A330", LocalDate.of(2019, 5, 15), 250),
			new Airbus("AB789", "Airbus A350", LocalDate.of(2021, 3, 10), 300),
			new Airbus("AB101", "Airbus A380", LocalDate.of(2018, 7, 20), 500),
			new Airbus("AB112", "Airbus A220", LocalDate.of(2022, 8, 5), 130),
			new Airbus("AB113", "Airbus A321", LocalDate.of(2020, 2, 28), 200),
			new Airbus("AB114", "Airbus A310", LocalDate.of(2017, 11, 11), 180),
			new Airbus("AB115", "Airbus A319", LocalDate.of(2023, 4, 1), 140),
			new Airbus("AB116", "Airbus A340", LocalDate.of(2016, 6, 30), 250)
        );

		List<Set<Tratta>> trattaList = List.of(
			Set.of(
				new Tratta("AZ10054", "New York - Roccasecca", 		LocalDate.of(2025, 7, 1), LocalTime.of(6, 0), LocalTime.of(7, 30), 		StatoTratta.ANNULLATA),
				new Tratta("AZ10355", "Roccasecca - Dubai", 			LocalDate.of(2025, 7, 1), LocalTime.of(8, 0), LocalTime.of(9, 30), 		StatoTratta.ATTIVA)),
			Set.of(
				new Tratta("AZ20034", "Tokyo - Canicattì", 			LocalDate.of(2025, 7, 2), LocalTime.of(10, 0), LocalTime.of(11, 45), 	StatoTratta.CONCLUSA),
				new Tratta("AZ20643", "Canicattì - Rio de Janeiro", 	LocalDate.of(2025, 7, 2), LocalTime.of(12, 30), LocalTime.of(14, 0), 	StatoTratta.ATTIVA)),
			Set.of(
				new Tratta("AZ30636", "Los Angeles - Campobasso", 		LocalDate.of(2025, 7, 3), LocalTime.of(7, 0), LocalTime.of(8, 15), 		StatoTratta.CONCLUSA),
				new Tratta("AZ30362", "Campobasso - Seoul", 			LocalDate.of(2025, 7, 3), LocalTime.of(9, 0), LocalTime.of(10, 30), 	StatoTratta.ATTIVA)),
			Set.of(
				new Tratta("AZ40641", "Shanghai - Vigevano", 			LocalDate.of(2025, 7, 4), LocalTime.of(5, 0), LocalTime.of(6, 20), 		StatoTratta.CONCLUSA),
				new Tratta("AZ43462", "Vigevano - Sydney", 			LocalDate.of(2025, 7, 4), LocalTime.of(7, 0), LocalTime.of(9, 0), 		StatoTratta.ATTIVA)),
			Set.of(
				new Tratta("AZ50031", "Londra - Caltanissetta", 		LocalDate.of(2025, 7, 5), LocalTime.of(6, 30), LocalTime.of(8, 0), 		StatoTratta.ATTIVA),
				new Tratta("AZ52342", "Caltanissetta - Buenos Aires",	LocalDate.of(2025, 7, 5), LocalTime.of(8, 45), LocalTime.of(10, 30), 	StatoTratta.ATTIVA)),
			Set.of(
				new Tratta("AZ63261", "Parigi - Matera", 				LocalDate.of(2025, 7, 6), LocalTime.of(6, 0), LocalTime.of(7, 20), 		StatoTratta.ATTIVA),
				new Tratta("AZ60252", "Matera - Bangkok", 				LocalDate.of(2025, 7, 6), LocalTime.of(8, 0), LocalTime.of(9, 45), 		StatoTratta.CONCLUSA)),
			Set.of(
				new Tratta("AZ70351", "Mosca - Treviso", 				LocalDate.of(2025, 7, 7), LocalTime.of(7, 15), LocalTime.of(8, 30), 	StatoTratta.ANNULLATA),
				new Tratta("AZ70232", "Treviso - Città del Capo", 		LocalDate.of(2025, 7, 7), LocalTime.of(9, 0), LocalTime.of(11, 0), 		StatoTratta.ATTIVA)),
			Set.of(
				new Tratta("AZ80201", "Berlino - Aosta", 				LocalDate.of(2025, 7, 8), LocalTime.of(6, 20), LocalTime.of(7, 40), 	StatoTratta.ATTIVA),
				new Tratta("AZ82532", "Aosta - Lima", 					LocalDate.of(2025, 7, 8), LocalTime.of(8, 30), LocalTime.of(10, 30), 	StatoTratta.CONCLUSA)),
			Set.of(
				new Tratta("AZ90231", "Oslo - Trapani", 				LocalDate.of(2025, 7, 9), LocalTime.of(5, 45), LocalTime.of(7, 0), 		StatoTratta.CONCLUSA),
				new Tratta("AZ90342", "Trapani - Singapore", 			LocalDate.of(2025, 7, 9), LocalTime.of(8, 0), LocalTime.of(10, 0), 		StatoTratta.ATTIVA))
		);


        int i = 0;
        for (Airbus airbus : airbusSet) {
            airbusService.inserisciNuovo(airbus);
            if (i < trattaList.size()) {
                for (Tratta tratta : trattaList.get(i)) {
                    tratta.setAirbus(airbus);
                    airbus.getTratte().add(tratta);
                }
                airbusService.aggiorna(airbus);
            }
            i++;
        }

        System.out.println(airbusService.listAllElements());

    }

}
