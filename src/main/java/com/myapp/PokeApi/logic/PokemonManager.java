package com.myapp.PokeApi.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.PokeApi.model.Pokemon;

public class PokemonManager {
	HttpsURLConnection conn;
	private HttpsURLConnection createConnection(String urlString) throws IOException {
        URL url = new URL(String.format(urlString));
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "pokeapi");
        connection.setRequestProperty("Accept", "application/json");
        return connection;
    } 
	
	public void getPokemonByName(String name) {
		try {
			conn = createConnection("https://pokeapi.co/api/v2/pokemon/" + name);
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder strBuild = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null) {
				strBuild.append(line);
			}
			ObjectMapper objMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			Pokemon pokemon = objMapper.readValue(strBuild.toString(), Pokemon.class);
			System.out.println(pokemon);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			conn.disconnect();
		}
	}
}
