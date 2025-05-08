package com.example.catenadimontaggio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatenadimontaggioApplication implements CommandLineRunner {

//	@Autowired
//	private SlotcatenadimontaggioDAO esameService;

	public static void main(String[] args) {
		SpringApplication.run(CatenadimontaggioApplication.class, args);
	}



//	@Override
//	public void run(String... args) throws Exception {
//		SlotcatenadimontaggioDAO esame = esameService.caricaEsame(1);
//
//		// aggiungo uno studente
//		Automobile studente = new Automobile(44L, "Antonio", "Mollo");
//
//		// aggiungo lo studente all'esame caricato in tabella
//		esameService.aggiungiStudenteAdEsame(studente, esame);
//
//		// avvio
//		esameService.avviaEsame(esame);
//	}
	@Override
	public void run(String... args) throws Exception {}
}
