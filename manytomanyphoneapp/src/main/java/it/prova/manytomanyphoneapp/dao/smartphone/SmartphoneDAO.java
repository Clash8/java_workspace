package it.prova.manytomanyphoneapp.dao.smartphone;

import it.prova.manytomanyphoneapp.dao.IBaseDAO;
import it.prova.manytomanyphoneapp.model.Smartphone;

public interface SmartphoneDAO extends IBaseDAO<Smartphone> {
	void unlinkAppsFromSmartphone(Smartphone input) throws Exception;
}
