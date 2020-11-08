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
			Pokemon ret = cache.get(name);
			if (ret != null) {
				System.out.println(ret);
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
			System.out.println(ret);
			cache.set(name, ret);
			return responseCode;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			conn.disconnect();
		}
		return -1;
	}

	public LRUCache getCache() {
		return cache;
	}

	public void setCache(LRUCache cache) {
		this.cache = cache;
	}
	
}
