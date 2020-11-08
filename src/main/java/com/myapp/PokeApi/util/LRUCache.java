package com.myapp.PokeApi.util;

import java.util.LinkedHashMap;
import java.util.Map;

import com.myapp.PokeApi.model.Pokemon;

public class LRUCache {
	 private LinkedHashMap<String, Pokemon> map; 
	    private final int CAPACITY; 
	    public LRUCache(int capacity) 
	    { 
	        CAPACITY = capacity; 
	        map = new LinkedHashMap<String, Pokemon>(capacity, 0.75f, true) { 
	            protected boolean removeEldestEntry(Map.Entry eldest) { 
	                return size() > CAPACITY; 
	            } 
	        }; 
	    } 
	  
	    public Pokemon get(String key) { 
	        return map.getOrDefault(key, null); 
	    } 
	  
	    public void set(String key, Pokemon value) { 
	        map.put(key, value); 
	    } 
}
