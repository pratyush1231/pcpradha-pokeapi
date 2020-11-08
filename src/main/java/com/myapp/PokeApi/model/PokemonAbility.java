package com.myapp.PokeApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonAbility {
	
	@JsonProperty(value= "is_hidden")
	protected boolean isHidden;
	
	@JsonProperty(value = "slot")
	protected int slot;
	
	@JsonProperty(value="ability")
	protected Ability ability;
	
	@Override
	public String toString() {
		return "PokemonAbility [isHidden=" + isHidden + ", slot=" + slot + ", ability=" + ability + "]";
	}

	public PokemonAbility() {}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public Ability getAbility() {
		return ability;
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
	}
	
}
