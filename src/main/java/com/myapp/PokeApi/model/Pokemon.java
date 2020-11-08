package com.myapp.PokeApi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pokemon {
	
	@JsonProperty(value = "id")
	protected int id;
	
	@JsonProperty(value = "name")
	protected String name;
	
	@JsonProperty(value = "base_experience")
	protected int baseExperience;
	
	@JsonProperty(value = "height")
	protected int height;
	
	@JsonProperty(value = "abilities")
	protected List<PokemonAbility> abilities;
	
	@JsonProperty(value = "stats")
	protected List<PokemonStat> stats;
	
	public Pokemon() {}

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

	public int getBaseExperience() {
		return baseExperience;
	}

	public void setBaseExperience(int baseExperience) {
		this.baseExperience = baseExperience;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public List<PokemonAbility> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<PokemonAbility> abilities) {
		this.abilities = abilities;
	}

	public List<PokemonStat> getStats() {
		return stats;
	}

	public void setStats(List<PokemonStat> stats) {
		this.stats = stats;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", baseExperience=" + baseExperience + ", height=" + height
				+ ", abilities=" + abilities + ", stats=" + stats + "]";
	}
}
