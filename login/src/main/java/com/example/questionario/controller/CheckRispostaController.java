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

    @PostMapping("/login")
    public String login(@RequestParam("user") String user, @RequestParam("pass") String pass) {
        String userName = "admin";
        String password = "admin";

        if (user.equals(userName) && pass.equals(password)) {
            return "rispostaGiusta";
        } else {
            return "rispostaSbagliata";
        }
    }
    @PostMapping("/numero")
    public String login(@RequestParam("numero") String numero) {
        int num = Integer.parseInt(numero);

        if (num % 2 == 0) {
            return "pari";
        } else {
            return "dispari";
        }
    }
}