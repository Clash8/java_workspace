package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.ArticoloDAO;
import it.prova.primoonetomany.dao.NegozioDAO;
import it.prova.primoonetomany.model.Articolo;
import it.prova.primoonetomany.model.Negozio;

import java.util.List;

public class TestNegozio {

    //	public int update(Negozio negozioInput) {
    //		return 0;
    //	}
    //
    //	public int delete(Long idToDelete) {
    //		return 0;
    //	}
    //
    //	// prende negozioInput e grazie al suo id va sulla tabella articoli e poi
    //	// ad ogni iterazione sul resultset aggiunge agli articoli di negozioInput
    //	public void populateArticoli(Negozio negozioInput) {
    //
    //	}
    //
    //	// implementare inoltre
    //	public List<Negozio> findAllByIniziali(String inizialeInput) {
    //		return null;
    //	}
    public static void main(String[] args) {
        NegozioDAO dao = new NegozioDAO();
        ArticoloDAO articoloDAO = new ArticoloDAO();

        Negozio negozio = dao.findById(1L);
        System.out.println("Cerco Negozio con id 1:");
        System.out.println(negozio);
        negozio.setNome("Zara");
        System.out.println("Modifico negozio:");
        int rows_afected = dao.update(negozio);
        if (rows_afected > 0) {
            System.out.println("Negozio aggiornato con successo");
            System.out.println(negozio);
        } else {
            System.out.println("Negozio non aggiornato");
        }
//        System.out.println("Elimino negozio:");
//        rows_afected = dao.delete(negozio.getId());
//        if (rows_afected > 0) {
//            System.out.println("Negozio eliminato con successo");
//        } else {
//            System.out.println("Negozio non eliminato");
//        }
        System.out.println(negozio.getArticoli());
        System.out.println("Popolo negozio:");
        dao.populateArticoli(negozio);
        System.out.println(negozio.getArticoli());

        System.out.println("cerco Negozio con nome che inizia per z:");
        List<Negozio> listaNegozi = dao.findAllByIniziali("z");
        for (Negozio negozioItem : listaNegozi) {
            System.out.println(negozioItem);
        }




    }
}
