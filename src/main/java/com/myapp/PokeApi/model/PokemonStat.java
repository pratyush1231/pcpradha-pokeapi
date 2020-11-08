package com.myapp.PokeApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonStat {
	
	@JsonProperty(value = "effort")
	protected int effort;
	
	@JsonProperty(value = "base_stat")
	protected int base_stat;
	
	@JsonProperty(value = "stat")
	protected Stat stat;
	
	public PokemonStat() {}

	public int getEffort() {
		return effort;
	}

	public void setEffort(int effort) {
		this.effort = effort;
	}

	public int getBase_stat() {
		return base_stat;
	}

	public void setBase_stat(int base_stat) {
		this.base_stat = base_stat;
	}

	public Stat getStat() {
		return stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}

	@Override
	public String toString() {
		return "PokemonStat [effort=" + effort + ", base_stat=" + base_stat + ", stat=" + stat + "]";
	}
	
}
