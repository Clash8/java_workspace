package it.prova.lavoratorejdbc.test;

import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.prova.lavoratorejdbc.dao.LavoratoreDAO;
import it.prova.lavoratorejdbc.model.Lavoratore;

public class TestCercaPerNomeECognomeInterattivo {

	public static void main(String[] args) {

		System.out.println("Inizio....");

		// questo risulta l'oggetto incaricato di operazioni dao
		LavoratoreDAO lavoratoreDaoInstance = new LavoratoreDAO();

		// #####################################################################
		System.out.println("############### test per ricerca nome e cognome ###########################");

		// ##########################################################################
		// Logica di creazione finestra di input: ESULA DAI FINI DIDATTICI DI JDBC!!!
		// ##########################################################################

		// creo due campi di input che poi finiranno in un pannello
		JTextField xField = new JTextField(20);
		JTextField yField = new JTextField(20);

		// creo un pannello dove vado ad aggiungere delle label e i campi sopra creati
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Nome:"));
		myPanel.add(xField);
		myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		myPanel.add(new JLabel("Cognome:"));
		myPanel.add(yField);

		// mi salvo il risultato della scelta utente in una variabile intero 0 = OK e 2
		// = CANCEL
		int tastoPremuto = JOptionPane.showConfirmDialog(null, myPanel, "Prego immettere Nome and Cognome da cercare",
				JOptionPane.OK_CANCEL_OPTION);

		// se annulli esco altrimenti eseguo la ricerca
		if (tastoPremuto == JOptionPane.OK_OPTION) {
			String nomeDaInput = xField.getText();
			String cognomeDaInput = yField.getText();

			// il vero test di JDBC risulta questo:
			List<Lavoratore> result = lavoratoreDaoInstance.selectByNomeCognomeIniziaPer(nomeDaInput, cognomeDaInput);

			StringBuilder stampaEleganteRisultati = new StringBuilder("");
			// se vi sono dei risultati costruisco una string ad hoc
			for (Lavoratore lavoratoreItem : result) {
				stampaEleganteRisultati.append(lavoratoreItem);
				stampaEleganteRisultati.append("\n");
			}

			JOptionPane.showMessageDialog(null,
					"Sono presenti " + result.size() + " record in tabella:\n" + stampaEleganteRisultati);
		}

	}

}
