package com.example.catenadimontaggio.model;

import java.util.ArrayList;
import java.util.List;

public class Slotcatenadimontaggio {
//(brand, country, automobili)
	private Long id;
	private String brand;
	private String country;
	private List<Automobile> automobili = new ArrayList<>();

	public Slotcatenadimontaggio() {}
	public Slotcatenadimontaggio(String brand, String country) {
		this.brand = brand;
		this.country = country;
	}
	public Slotcatenadimontaggio(String brand, String country, List<Automobile> automobili) {
		this.brand = brand;
		this.country = country;
		this.automobili = automobili;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	public List<Automobile> getAutomobili() {
		return automobili;
	}
	public void setAutomobili(List<Automobile> automobili) {
		this.automobili = automobili;
	}
	public void addAutomobile(Automobile automobile) {
		this.automobili.add(automobile);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(brand);
		automobili.forEach(automobile -> builder.append("\n\t").append(automobile.toString()));
		return builder.toString();
	}
}
