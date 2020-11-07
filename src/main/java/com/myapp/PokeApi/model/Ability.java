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
}
