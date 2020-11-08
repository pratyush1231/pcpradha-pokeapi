package com.myapp.PokeApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonSprite {
	
	@JsonProperty("front_default")
	protected String frontDefault;
	
	public PokemonSprite() {}

	@Override
	public String toString() {
		return "PokemonSprite [frontDefault=" + frontDefault + "]";
	}
	
}
