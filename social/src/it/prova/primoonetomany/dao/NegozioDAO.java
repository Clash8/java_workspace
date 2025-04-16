package it.prova.primoonetomany.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.prova.primoonetomany.connection.MyConnection;
import it.prova.primoonetomany.model.Articolo;
import it.prova.primoonetomany.model.Negozio;

public class NegozioDAO {

	public List<Negozio> list() {

		List<Negozio> result = new ArrayList<>();
		Negozio negozioTemp;

		try (Connection c = MyConnection.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery("select * from negozio a ")) {

			while (rs.next()) {
				negozioTemp = new Negozio();
				negozioTemp.setId(rs.getLong("id"));
				negozioTemp.setNome(rs.getString("nome"));
				negozioTemp.setIndirizzo(rs.getString("indirizzo"));
				negozioTemp.setDataApertura(
						rs.getDate("dataapertura") != null ? rs.getDate("dataapertura").toLocalDate() : null);

				result.add(negozioTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	public Negozio findById(Long idNegozioInput) {

		if (idNegozioInput == null || idNegozioInput < 1)
			throw new RuntimeException("Impossibile caricare Negozio: id mancante!");

		Negozio result = null;
		try (Connection c = MyConnection.getConnection();
				PreparedStatement ps = c.prepareStatement("select * from negozio i where i.id=?")) {

			ps.setLong(1, idNegozioInput);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					result = new Negozio();
					result.setId(rs.getLong("id"));
					result.setNome(rs.getString("nome"));
					result.setIndirizzo(rs.getString("indirizzo"));
					result.setDataApertura(
							rs.getDate("dataapertura") != null ? rs.getDate("dataapertura").toLocalDate() : null);

				} else {
					result = null;
				}
			} // niente catch qui

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	public int insert(Negozio negozioInput) {

		if (negozioInput == null)
			throw new RuntimeException("Impossibile inserire Negozio: input mancante!");

		int result = 0;
		try (Connection c = MyConnection.getConnection();
				PreparedStatement ps = c
						.prepareStatement("INSERT INTO negozio (nome, indirizzo, dataapertura) VALUES (?, ?, ?)")) {

			ps.setString(1, negozioInput.getNome());
			ps.setString(2, negozioInput.getIndirizzo());
			java.sql.Date dateParsedForSQL = java.sql.Date.valueOf(negozioInput.getDataApertura());
			ps.setDate(3, dateParsedForSQL);

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	// TODO
	public int update(Negozio negozioInput) {
		if (negozioInput == null || negozioInput.getId() == null || negozioInput.getId() < 1)
			throw new RuntimeException("Impossibile inserire Negozio: input mancante!");

		int result = 0;
		try (Connection c = MyConnection.getConnection();
			 PreparedStatement ps = c.prepareStatement("UPDATE negozio SET nome = ?, indirizzo = ?, dataapertura = ? WHERE id = ?")) {

			ps.setString(1, negozioInput.getNome());
			ps.setString(2, negozioInput.getIndirizzo());
			java.sql.Date dateParsedForSQL = java.sql.Date.valueOf(negozioInput.getDataApertura());
			ps.setDate(3, dateParsedForSQL);
			ps.setLong(4, negozioInput.getId());

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	public int delete(Long idToDelete) {

		if (idToDelete == null || idToDelete < 1)
			throw new RuntimeException("Impossibile eliminare Negozio: id mancante o non valido!");
		int result = -1;
		try (Connection c = MyConnection.getConnection();
			 PreparedStatement ps = c.prepareStatement("DELETE FROM negozio i WHERE i.id = ?")) {

			ps.setLong(1, idToDelete);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	// prende negozioInput e grazie al suo id va sulla tabella articoli e poi
	// ad ogni iterazione sul resultset aggiunge agli articoli di negozioInput
	public void populateArticoli(Negozio negozioInput) {
		if (negozioInput == null || negozioInput.getId() == null) {
			throw new RuntimeException("Negozio non valido: impossibile popolare articoli");
		}
		List<Articolo> articoli = new ArrayList<>();
		try(Connection c = MyConnection.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT * FROM articolo WHERE negozio_id = ?")) {
			ps.setLong(1, negozioInput.getId());
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					articoli.add(
							new Articolo(
									rs.getLong("id"),
									rs.getString("nome"),
									rs.getString("matricola"),
									negozioInput)
					);
				}
			}
			negozioInput.setArticoli(articoli);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
    }

	// implementare inoltre
	public List<Negozio> findAllByIniziali(String inizialeInput) {
		List<Negozio> result = new ArrayList<>();
		Negozio negozioTemp;

		try (Connection c = MyConnection.getConnection();
			 PreparedStatement ps = c.prepareStatement("SELECT * FROM negozio WHERE nome LIKE ?")) {
			ps.setString(1, inizialeInput + "%");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					negozioTemp = new Negozio();
					negozioTemp.setId(rs.getLong("id"));
					negozioTemp.setNome(rs.getString("nome"));
					negozioTemp.setIndirizzo(rs.getString("indirizzo"));
					negozioTemp.setDataApertura(
							rs.getDate("dataapertura") != null ? rs.getDate("dataapertura").toLocalDate() : null);

					result.add(negozioTemp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

}
