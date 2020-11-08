package com.myapp.PokeApi;

import org.junit.Test;

import com.myapp.PokeApi.logic.PokemonManager;

import junit.framework.TestCase;

public class TestPokemonManager extends TestCase{

	PokemonManager pokemonManager;
	public TestPokemonManager() {
		pokemonManager = new PokemonManager(3);
	}
	
	@Test
	public void testGetPokemonByName() {
		//test a valid response
		assertEquals(pokemonManager.getPokemonByName("pikachu"), 200);
		
		//test an invalid response
		assertEquals(pokemonManager.getPokemonByName("0"), 404);
		
		//test cache
		assertNotNull(pokemonManager.getCache().get("pikachu"));
		pokemonManager.getPokemonByName("bulbasaur");
		pokemonManager.getPokemonByName("charmeleon");
		pokemonManager.getPokemonByName("raichu");
		
		//after exceeding the capacity for cache, least recently used pokemon is to be removed
		assertNull(pokemonManager.getCache().get("pikachu"));
	}
}
