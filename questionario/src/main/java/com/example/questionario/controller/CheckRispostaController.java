package com.example.questionario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckRispostaController {

    // Metodo per mostrare la pagina principale del questionario
    @GetMapping("/")
    public String mostraQuesito() {
        return "quesito";
    }

    // Metodo per gestire la risposta inviata dall'utente
    @PostMapping("/verificaRisposta")
    public String verificaRisposta(@RequestParam("risposta") String risposta) {
        // Verifica se la risposta è corretta (ignorando case e spazi)
        String rispostaCorretta = "roma";
        String rispostaUtente = risposta.trim().toLowerCase();

        if (rispostaUtente.equals(rispostaCorretta)) {
            return "rispostaGiusta";
        } else {
            return "rispostaSbagliata";
        }
    }
}