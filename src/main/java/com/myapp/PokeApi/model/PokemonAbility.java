package com.myapp.PokeApi.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonAbility {
	
	@XmlElement(name = "is_hidden")
	protected boolean isHidden;
	
	@XmlElement(name = "slot")
	protected int slot;
	
	@JsonProperty(value="ability")
	protected Ability ability;
	
	@Override
	public String toString() {
		return "PokemonAbility [isHidden=" + isHidden + ", slot=" + slot + ", ability=" + ability + "]";
	}

	public PokemonAbility() {}
}
