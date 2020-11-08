package com.myapp.PokeApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stat {
	
	@JsonProperty(value = "id")
	protected int id;
	
	@JsonProperty(value = "name")
	protected String name;
	
	@JsonProperty(value = "game_index")
	protected int gameIndex;
	
	@JsonProperty(value = "is_battle_only")
	protected boolean isBattleOnly;
	
	public Stat() {}

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

	public int getGameIndex() {
		return gameIndex;
	}

	public void setGameIndex(int gameIndex) {
		this.gameIndex = gameIndex;
	}

	public boolean isBattleOnly() {
		return isBattleOnly;
	}

	public void setBattleOnly(boolean isBattleOnly) {
		this.isBattleOnly = isBattleOnly;
	}

	@Override
	public String toString() {
		return "Stat [id=" + id + ", name=" + name + ", gameIndex=" + gameIndex + ", isBattleOnly=" + isBattleOnly
				+ "]";
	}
	
}
