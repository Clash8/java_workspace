package com.example.catenadimontaggio.dao;


import com.example.catenadimontaggio.model.Automobile;
import com.example.catenadimontaggio.model.Slotcatenadimontaggio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DbMock {
	
	public static final List<Slotcatenadimontaggio> SLOTCATENADIMONTAGGIO = new ArrayList<>();
	
	static {
		//(brand, country, automobili)
		Slotcatenadimontaggio slot1 = new Slotcatenadimontaggio("Fiat", "Italy");
		Slotcatenadimontaggio slot2 = new Slotcatenadimontaggio("Ford", "USA");
		Slotcatenadimontaggio slot3 = new Slotcatenadimontaggio("Renault", "France");
		Slotcatenadimontaggio slot4 = new Slotcatenadimontaggio("BMW", "Germany");

		Automobile automobile1 = new Automobile("Panda", "Fiat", LocalDate.now());
		Automobile automobile2 = new Automobile("Focus", "Ford", LocalDate.now());
		Automobile automobile3 = new Automobile("Clio", "Renault", LocalDate.now());
		Automobile automobile4 = new Automobile("X1", "BMW", LocalDate.now());
		Automobile automobile5 = new Automobile("Yaris", "Toyota", LocalDate.now());
		Automobile automobile6 = new Automobile("Civic", "Honda", LocalDate.now());
		Automobile automobile7 = new Automobile("Golf", "Volkswagen", LocalDate.now());

		slot1.addAutomobile(automobile1);
		slot2.addAutomobile(automobile2);
		slot3.addAutomobile(automobile3);
		slot4.addAutomobile(automobile4);
		slot1.addAutomobile(automobile5);
		slot2.addAutomobile(automobile6);
		slot3.addAutomobile(automobile7);
		SLOTCATENADIMONTAGGIO.add(slot1);
		SLOTCATENADIMONTAGGIO.add(slot2);
		SLOTCATENADIMONTAGGIO.add(slot3);
		SLOTCATENADIMONTAGGIO.add(slot4);


	}

}
