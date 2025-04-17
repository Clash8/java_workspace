package it.prova.service.televisore;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.prova.connection.MyConnection;
import it.prova.dao.Constants;
import it.prova.dao.televisore.TelevisoreDAO;
import it.prova.model.Televisore;

public class TelevisoreServiceImpl implements TelevisoreService {

	private TelevisoreDAO televisoreDao;

	public void setTelevisoreDao(TelevisoreDAO televisoreDao) {
		this.televisoreDao = televisoreDao;
	}

	@Override
	public List<Televisore> listAll() throws Exception {
		List<Televisore> result;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public Televisore findById(Long idInput) throws Exception {
		if (idInput == null || idInput < 1)
			throw new Exception("Valore di input non ammesso.");

		Televisore result;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.get(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int aggiorna(Televisore input) throws Exception {
		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.update(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int inserisciNuovo(Televisore input) throws Exception {
		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.insert(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int rimuovi(Long idDaRimuovere) throws Exception {
		if (idDaRimuovere == null || idDaRimuovere < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.delete(idDaRimuovere);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public List<Televisore> findByExample(Televisore input) throws Exception {
		List<Televisore> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.findByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	public Televisore getBigger() throws Exception {
		Televisore result;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.getBigger();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	public int quantiTelTraDate(LocalDate from, LocalDate to) throws Exception {
		int result = -1;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.quantiTelTraDate(from, to);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public List<String> list30anni() throws Exception {
		List<String> result = new ArrayList<>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.list30anni();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	// ##########################################################################################


}
