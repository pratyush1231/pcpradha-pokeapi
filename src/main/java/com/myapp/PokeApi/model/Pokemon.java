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
	
	@JsonProperty(value = "weight")
	protected int weight;
	
	@JsonProperty(value = "abilities")
	protected List<PokemonAbility> abilities;
	
	@JsonProperty(value = "stats")
	protected List<PokemonStat> stats;
	
	@JsonProperty(value = "sprites")
	protected PokemonSprite sprites;
	
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

	public PokemonSprite getSprites() {
		return sprites;
	}

	public void setSprites(PokemonSprite sprites) {
		this.sprites = sprites;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		strBuild.append(name.toUpperCase() + "(" + id+ ")" +"\n");
		strBuild.append("___________________\n");
		strBuild.append("Base Experience: " + baseExperience + "\n");
		strBuild.append("Height: " + height + "\n");
		strBuild.append("Weight: " + weight + "\n");
		
		if (abilities != null && !abilities.isEmpty()) {
			strBuild.append("Abilities: ");
			String[] abilitiesString = new String[abilities.size()];
			for (int i = 0; i < abilities.size(); i++) {
				if (abilities.get(i).isHidden()) {
					abilitiesString[i] = abilities.get(i).getAbility().getName().toUpperCase() + "(Hidden)";
				} else {
					abilitiesString[i] = abilities.get(i).getAbility().getName().toUpperCase();
				}
			}
			strBuild.append(String.join(", ", abilitiesString) + "\n");
		}
		
		if (stats != null && !stats.isEmpty()) {
			strBuild.append("Stats: ");
			String[] statsString = new String[stats.size()];
			for (int i = 0; i < stats.size(); i++) {
				if (stats.get(i).getStat().isBattleOnly()) {
					statsString[i] = stats.get(i).getStat().getName().toUpperCase() + "(" + stats.get(i).getBase_stat() + ")" + " (Battle Only)";
				} else {
					statsString[i] = stats.get(i).getStat().getName().toUpperCase() + "(" + stats.get(i).getBase_stat() + ")";
				}
			}
			strBuild.append(String.join(", ", statsString) + "\n");
		}
		
		return strBuild.toString();
	}
}
