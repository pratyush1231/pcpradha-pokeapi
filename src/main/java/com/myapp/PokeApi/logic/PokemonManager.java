package com.myapp.PokeApi.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.PokeApi.model.Pokemon;
import com.myapp.PokeApi.util.LRUCache;

public class PokemonManager {
	LRUCache cache;
	HttpsURLConnection conn;
	
	public PokemonManager() {
		cache = new LRUCache(10);
	}
	
	public PokemonManager(int capacity) {
		cache = new LRUCache(capacity);
	}
	
	private HttpsURLConnection createConnection(String urlString) throws IOException {
        URL url = new URL(String.format(urlString));
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "pokeapi");
        connection.setRequestProperty("Accept", "application/json");
        return connection;
    } 
	
	public int getPokemonByName(String name) {
		try {
			if (isNumeric(name)) {
				System.out.println("Please enter a valid pokemon name.");
				return 404;
			}
			name = name.toLowerCase();
			Pokemon ret = cache.get(name);
			if (ret != null) {
				System.out.println("Found " + name.toUpperCase() + " in memory.");
				return 200;
			}
			conn = createConnection("https://pokeapi.co/api/v2/pokemon/" + name);
			int responseCode = conn.getResponseCode();
			if (responseCode == 404) {
				System.out.println("Pokemon not found");
				return responseCode;
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder strBuild = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null) {
				strBuild.append(line);
			}
			ObjectMapper objMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			ret = objMapper.readValue(strBuild.toString(), Pokemon.class);
			if (cache.isFull()) System.out.println("Memory capacity exceeded, replaced oldest pokemon entry.");
			System.out.println("Inserted " + name.toUpperCase() + " in memory.");
			cache.set(name, ret);
			return responseCode;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) conn.disconnect();
		}
		return -1;
	}

	public void displayMemoryList() {
		System.out.println(cache.getPokemonNames());
	}
	
	public void displayReport() {
		if (cache.isEmpty()) {
			System.out.println("No Pokemon in Memory");
			return;
		}
		for(Pokemon pokemon: cache.getValues()) {
			System.out.println(pokemon);
		}
	}
	
	public LRUCache getCache() {
		return cache;
	}

	public void setCache(LRUCache cache) {
		this.cache = cache;
	}
	
	private boolean isNumeric(String name) {
		if (name == null) {
	        return false;
	    }
	    try {
	        int num = Integer.parseInt(name);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
