package it.prova.dao.televisore;

import it.prova.dao.IBaseDAO;
import it.prova.model.Televisore;

import java.time.LocalDate;
import java.util.List;

public interface TelevisoreDAO extends IBaseDAO<Televisore> {
    public Televisore getBigger() throws Exception;
    public int quantiTelTraDate(LocalDate from, LocalDate to) throws Exception;
    public List<String> list30anni() throws Exception;
}
