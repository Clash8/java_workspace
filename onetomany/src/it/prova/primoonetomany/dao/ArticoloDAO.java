package it.prova.primoonetomany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.primoonetomany.connection.MyConnection;
import it.prova.primoonetomany.model.Articolo;
import it.prova.primoonetomany.model.Negozio;

public class ArticoloDAO {

	public List<Articolo> list() {

		List<Articolo> result = new ArrayList<>();

		try (Connection c = MyConnection.getConnection();
				Statement s = c.createStatement();
				// STRATEGIA EAGER FETCHING
				ResultSet rs = s.executeQuery("select * from articolo a inner join negozio n on n.id=a.negozio_id")) {

			while (rs.next()) {
				Articolo articoloTemp = new Articolo();
				articoloTemp.setNome(rs.getString("a.NOME"));
				articoloTemp.setMatricola(rs.getString("matricola"));
				articoloTemp.setId(rs.getLong("a.id"));

				Negozio negozioTemp = new Negozio();
				negozioTemp.setId(rs.getLong("n.id"));
				negozioTemp.setNome(rs.getString("n.nome"));
				negozioTemp.setIndirizzo(rs.getString("indirizzo"));
				negozioTemp.setDataApertura(
						rs.getDate("dataapertura") != null ? rs.getDate("dataapertura").toLocalDate() : null);


				articoloTemp.setNegozio(negozioTemp);
				result.add(articoloTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

	public Articolo findById(Long idArticoloInput) {

		if (idArticoloInput == null || idArticoloInput < 1)
			throw new RuntimeException("Impossibile recuperare Articolo: id mancante!");

		Articolo result = null;
		try (Connection c = MyConnection.getConnection();
				PreparedStatement ps = c.prepareStatement("select * from articolo a where a.id=?")) {

			ps.setLong(1, idArticoloInput);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					result = new Articolo();
					result.setNome(rs.getString("NOME"));
					result.setMatricola(rs.getString("matricola"));
					result.setId(rs.getLong("id"));
				} else {
					result = null;
				}
			} // niente catch qui

		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

	public int insert(Articolo articoloInput) {

		if (articoloInput.getNegozio() == null || articoloInput.getNegozio().getId() < 1)
			throw new RuntimeException("Impossibile inserire Articolo: Negozio mancante!");

		int result = 0;
		try (Connection c = MyConnection.getConnection();
				PreparedStatement ps = c
						.prepareStatement("INSERT INTO articolo (nome, matricola,negozio_id) VALUES (?, ?, ?)")) {

			ps.setString(1, articoloInput.getNome());
			ps.setString(2, articoloInput.getMatricola());
			ps.setLong(3, articoloInput.getNegozio().getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

	// TODO
	public Articolo findByIdEager(Long idInput) {
		Articolo result;

		try (Connection c = MyConnection.getConnection();
			 PreparedStatement ps = c
					 .prepareStatement("select * from articolo a inner join negozio n on n.id=a.negozio_id WHERE a.id = ?")) {
			ps.setLong(1, idInput);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Articolo articoloTemp = new Articolo();
					articoloTemp.setNome(rs.getString("a.NOME"));
					articoloTemp.setMatricola(rs.getString("matricola"));
					articoloTemp.setId(rs.getLong("a.id"));

					Negozio negozioTemp = new Negozio();
					negozioTemp.setId(rs.getLong("n.id"));
					negozioTemp.setNome(rs.getString("n.nome"));
					negozioTemp.setIndirizzo(rs.getString("indirizzo"));
					negozioTemp.setDataApertura(
							rs.getDate("dataapertura") != null ? rs.getDate("dataapertura").toLocalDate() : null);


					articoloTemp.setNegozio(negozioTemp);
					result = articoloTemp;
				} else {
					result = null;
				}
			} // niente catch qui
		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

	public int update(Articolo articoloInput) {
		if (articoloInput == null)
			throw new RuntimeException("Impossibile modificare Articolo: oggetto nullo!");
		if (articoloInput.getId() == null || articoloInput.getId() < 1)
			throw new RuntimeException("Impossibile modificare Articolo: ID mancante o non valido!");
		if (articoloInput.getNegozio() == null || articoloInput.getNegozio().getId() == null || articoloInput.getNegozio().getId() < 1)
			throw new RuntimeException("Impossibile modificare Articolo: Negozio mancante o non valido!");

		int result = 0;
		try (Connection c = MyConnection.getConnection();
			 PreparedStatement ps = c
					 .prepareStatement("UPDATE articolo SET nome = ?, matricola = ?, negozio_id = ? WHERE id = ?")) {

			ps.setString(1, articoloInput.getNome());
			ps.setString(2, articoloInput.getMatricola());
			ps.setLong(3, articoloInput.getNegozio().getId());
			ps.setLong(4, articoloInput.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

	public int delete(Long idToDelete) {

		if (idToDelete == null || idToDelete < 1)
			throw new RuntimeException("Impossibile eliminare Articolo: id mancante!");

		int result = -1;
		try (Connection c = MyConnection.getConnection();
			 PreparedStatement ps = c.prepareStatement("DELETE from articolo a where a.id=?")) {

			ps.setLong(1, idToDelete);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

	// implementare inoltre
	public List<Articolo> findAllByNegozio(Negozio negozioInput) {
		List<Articolo> result = new ArrayList<>();

		try(Connection c = MyConnection.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT * FROM articolo WHERE negozio_id = ?")) {
			ps.setLong(1, negozioInput.getId());
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Articolo articoloTemp = new Articolo();
					articoloTemp.setNome(rs.getString("nome"));
					articoloTemp.setMatricola(rs.getString("matricola"));
					articoloTemp.setId(rs.getLong("id"));
					articoloTemp.setNegozio(negozioInput);

					result.add(articoloTemp);
				}
			} // niente catch qui

		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

	public List<Articolo> findAllByMatricola(String matricolaInput) {
		List<Articolo> result = new ArrayList<>();

		try(Connection c = MyConnection.getConnection(); PreparedStatement ps = c.prepareStatement("SELECT * FROM articolo WHERE matricola LIKE ?")) {
			ps.setString(1, matricolaInput);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Articolo articoloTemp = new Articolo();
					articoloTemp.setId(rs.getLong("id"));
					articoloTemp.setNome(rs.getString("nome"));
					articoloTemp.setMatricola(rs.getString("matricola"));

					result.add(articoloTemp);
				}
			} // niente catch qui

		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

	public List<Articolo> findAllByIndirizzoNegozio(String indirizzoNegozioInput) {
		List<Articolo> result = new ArrayList<>();

		try(Connection c = MyConnection.getConnection();
			PreparedStatement ps = c.prepareStatement(
					"SELECT a.* FROM articolo a " +
							"JOIN negozio n ON a.negozio_id = n.id " +
							"WHERE n.indirizzo LIKE ?")) {
			ps.setString(1, "%" + indirizzoNegozioInput + "%");
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Articolo articoloTemp = new Articolo();
					articoloTemp.setNome(rs.getString("nome"));
					articoloTemp.setMatricola(rs.getString("matricola"));
					articoloTemp.setId(rs.getLong("id"));

					result.add(articoloTemp);
				}
			} // niente catch qui

		} catch (Exception e) {
			e.printStackTrace();
			// rilancio in modo tale da avvertire il chiamante
			throw new RuntimeException(e);
		}
		return result;
	}

}
