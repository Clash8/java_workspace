package it.prova.dao;

import java.sql.Connection;
import java.util.List;

public interface IBaseDAO<T> {

	List<T> list() throws Exception;

	T get(Long idInput) throws Exception;

	int update(T input) throws Exception;

	int insert(T input) throws Exception;

	int delete(Long idDaRimuovere) throws Exception;

	List<T> findByExample(T input) throws Exception;

//	//questo mi serve per la injection della connection
	void setConnection(Connection connection);

}
