package it.prova.dao.user;

import it.prova.dao.IBaseDAO;
import it.prova.model.User;

import java.time.LocalDate;
import java.util.List;

public interface UserDAO extends IBaseDAO<User> {
    public List<User> estraiTuttiQuelliCheUsernameIniziaCon(String iniziale) throws Exception;

    public List<User> estraiTuttiQuelliCreatiPrimaDi(LocalDate dataConfronto) throws Exception;

    public List<User> estraiPerCognomeENomeCheInziaCon(String cognomeInput, String inizialeNomeInput) throws Exception;

    public User logIn(String loginInput, String passwordInput) throws Exception;
}
