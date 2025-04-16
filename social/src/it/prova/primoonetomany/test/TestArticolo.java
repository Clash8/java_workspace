package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.ArticoloDAO;
import it.prova.primoonetomany.model.Articolo;

import java.util.List;

public class TestArticolo {

    //public Articolo findByIdEager(Long idInput) {
    //		return null;
    //	}
    //
    //	public int update(Articolo articoloInput) {
    //		return 0;
    //	}
    //
    //	public int delete(Long idToDelete) {
    //		return 0;
    //	}
    //
    //	// implementare inoltre
    //	public List<Articolo> findAllByNegozio(Negozio negozioInput) {
    //		return null;
    //	}
    //
    //	public List<Articolo> findAllByMatricola(String matricolaInput) {
    //		return null;
    //	}
    //
    //	public List<Articolo> findAllByIndirizzoNegozio(String indirizzoNegozioInput) {
    //		return null;
    //	}
    public static void main(String[] args) {

        ArticoloDAO dao = new ArticoloDAO();

        Articolo articoloTrovato = dao.findByIdEager(1L);
        System.out.println("Cerco Articolo con id 1:");
        System.out.println(articoloTrovato);

        articoloTrovato.setNome(articoloTrovato.getNome() + "_" + articoloTrovato.getId());
        System.out.println("Modifico articolo:");
        int rows_afected = dao.update(articoloTrovato);
        if (rows_afected == 1) {
            System.out.println("Articolo aggiornato con successo");
            System.out.println(articoloTrovato);
        } else {
            System.out.println("Articolo non aggiornato");
        }

//        rows_afected = dao.delete(articoloTrovato.getId());
//        if (rows_afected == 1) {
//            System.out.println("Articolo eliminato con successo");
//        } else {
//            System.out.println("Articolo non eliminato");
//        }

        List<Articolo> listaArticoli = dao.findAllByNegozio(articoloTrovato.getNegozio());

        System.out.println("Articoli del negozio " + articoloTrovato.getNegozio().getNome() + ":");
        for (Articolo articolo : listaArticoli) {
            System.out.println(articolo);
        }
        List<Articolo> listaArticoliByMatricola = dao.findAllByMatricola("matricola1");

        System.out.println("Articoli con matricola matricola1:");
        for (Articolo articolo : listaArticoliByMatricola) {
            System.out.println(articolo);
        }
        List<Articolo> listaArticoliByIndirizzo = dao.findAllByIndirizzoNegozio("via dei mille 14");
        System.out.println("Articoli del negozio con indirizzo via dei mille 14:");
        for (Articolo articolo : listaArticoliByIndirizzo) {
            System.out.println(articolo);
        }





    }
}
