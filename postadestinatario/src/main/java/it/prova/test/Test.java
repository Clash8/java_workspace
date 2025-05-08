package it.prova.test;

import it.prova.model.Destinatario;
import it.prova.model.PostaDiPaese;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        // Test the MockData class
        List<PostaDiPaese> list = MockData.POSTA_DI_PAESE;

        list.forEach(System.out::println);

        System.out.println("ottieni poste in cui lindirizzo contenga '(MI)'");
        System.out.println(getPostaDiPaeseIlCuiIndirizzoContenga());

        System.out.println("ottieni poste aperte dopo il 2019, 3, 1");
        System.out.println(getPostaAperteDopoIl());
        System.out.println("la lista di indirizzi delle poste il cui numero dipendenti sia superiore a 20;");
        System.out.println(getIndirizziNumeroDipendentisuperiorea());
        System.out.println("la lista di indirizzi di destinatari di poste con almeno 10 dipendenti;");

        System.out.println(getIndirizziDestinatariDiPosteConAlmenoNDipendenti());
        System.out.println("la lista di destinatari possessori di conto corrente ma appartenenti a poste con numero dipendenti compreso tra 50 e 100;");
        System.out.println(getDestinatariwithContoAndNumeroDipendenti());
        System.out.println("la lista delle età dei destinatari delle poste che contengano nel campo denominazione la stringa ‘Centrale’ e siano state aperta almeno dal primo gennaio 2000.");

        System.out.println(getEtaDestinatariConStringaEData());

        System.out.println("Calcolare la somma totale del numero totale di dipendenti di tutte le poste.");

        System.out.println(getTotalNumeroDipendenti());
        System.out.println("Estrarre la lista con solo i cognomi dei dipendenti di tutte le poste.");

        System.out.println(getCognomi());

        System.out.println("Verificare ed estrarre se esiste un destinatario con età maggiore di 60 anni in tutte le poste.");


        System.out.println(verificaSeEsisteDestinatarioConEtaMaggioreDi());


        System.out.println("Calcolare il numero di poste che abbiano clienti che non possiedono conti correnti");
        System.out.println(calcolaNumeroDiPosteCheNonAbbianoClientiConContoCorrente());



    }

    private static List<PostaDiPaese> getPostaDiPaeseIlCuiIndirizzoContenga() {
        final String filtro = "(MI)";
        return MockData.POSTA_DI_PAESE.stream()
                .filter(postaDiPaese -> postaDiPaese.getIndirizzoSede().contains(filtro))
                .collect(Collectors.toList());
    }

    private static List<PostaDiPaese> getPostaAperteDopoIl() {
        final LocalDate data = LocalDate.of(2019, 3, 1);
        return MockData.POSTA_DI_PAESE.stream()
                .filter(p -> p.getDataApertura().isAfter(data))   // ← compare dates
                .collect(Collectors.toList());
    }

    private static List<String> getIndirizziNumeroDipendentisuperiorea() {
        int numeroDipendenti = 20;
        return MockData.POSTA_DI_PAESE.stream().filter(postaDiPaese -> postaDiPaese.getNumeroDipendenti() > numeroDipendenti)
                .map(PostaDiPaese::getIndirizzoSede)
                .collect(Collectors.toList());
    }

    private static List<String> getIndirizziDestinatariDiPosteConAlmenoNDipendenti() {
        int numeroDipendenti = 10;
        return MockData.POSTA_DI_PAESE.stream().filter(postaDiPaese -> postaDiPaese.getNumeroDipendenti() > numeroDipendenti)
                .flatMap(postaDiPaese -> postaDiPaese.getDestinatari().stream())
                .map(Destinatario::getIndirizzo)
                .collect(Collectors.toList());
    }

    private static List<Destinatario> getDestinatariwithContoAndNumeroDipendenti() {
        int numeroDipendentiMIN = 50;
        int numeroDipendentiMAX = 100;
        return MockData.POSTA_DI_PAESE.stream().filter(postaDiPaese -> postaDiPaese.getNumeroDipendenti() >= numeroDipendentiMIN && postaDiPaese.getNumeroDipendenti() <= numeroDipendentiMAX)
                .flatMap(postaDiPaese -> postaDiPaese.getDestinatari().stream())
                .filter(Destinatario::isPossessoreDiContoCorrente)
                .collect(Collectors.toList());
    }

    // la lista delle età dei destinatari delle poste che contengano nel campo denominazione la stringa ‘Centrale’ e siano state aperta almeno dal primo gennaio 2000.
    private static List<Integer> getEtaDestinatariConStringaEData() {
        String denominazione = "Centrale";
        LocalDate data = LocalDate.of(2000, 1, 1);
        return MockData.POSTA_DI_PAESE.stream().filter(p -> p.getDenominazione().contains(denominazione) && p.getDataApertura().isBefore(data))
                .flatMap(p -> p.getDestinatari().stream())
                .map(Destinatario::getEta)
                .collect(Collectors.toList());
    }


    private static int getTotalNumeroDipendenti() {
        return MockData.POSTA_DI_PAESE.stream()
                .map(PostaDiPaese::getNumeroDipendenti)
                .reduce(0, Integer::sum);
    }

    //Estrarre la lista con solo i cognomi dei dipendenti di tutte le poste.
    private static List<String> getCognomi() {
        return MockData.POSTA_DI_PAESE.stream()
                .flatMap(p ->p.getDestinatari().stream())
                .map(Destinatario::getCognome)
                .collect(Collectors.toList());
    }

    //Verificare ed estrarre se esiste un destinatario con età maggiore di 60 anni in tutte le poste.

    private static Destinatario verificaSeEsisteDestinatarioConEtaMaggioreDi() {
        int eta = 60;
        return MockData.POSTA_DI_PAESE.stream()
                .flatMap(p ->p.getDestinatari().stream())
                .filter(d -> d.getEta() > eta).findAny().orElse(null);
    }

    //Calcolare il numero di poste che abbiano clienti che non possiedono conti correnti
    private static int calcolaNumeroDiPosteCheNonAbbianoClientiConContoCorrente() {
        return (int) MockData.POSTA_DI_PAESE.stream()
                .filter(p -> p.getDestinatari().stream().noneMatch(Destinatario::isPossessoreDiContoCorrente))
                .count();
    }
}
