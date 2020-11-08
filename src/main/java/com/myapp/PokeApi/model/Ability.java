package com.myapp.PokeApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ability {
	@JsonProperty(value = "id")
	protected int id;
	
	@JsonProperty(value = "name")
	protected String name;
	
	@JsonProperty(value = "is_main_series")
	protected boolean isMainSeries;
	
	public Ability() {}

	@Override
	public String toString() {
		return "Ability [id=" + id + ", name=" + name + ", isMainSeries=" + isMainSeries + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMainSeries() {
		return isMainSeries;
	}

	public void setMainSeries(boolean isMainSeries) {
		this.isMainSeries = isMainSeries;
	}
	
}
