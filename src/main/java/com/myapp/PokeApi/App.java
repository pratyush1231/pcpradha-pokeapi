package com.myapp.PokeApi;

import java.util.Scanner;

import com.myapp.PokeApi.logic.PokemonManager;

public class App {
    public static void main( String[] args ) {
    	Scanner myScan = new Scanner(System.in);
    	PokemonManager mgr= new PokemonManager();
    	boolean check = true;
    	String input;
    	while(check) {
    		System.out.println("Please enter a pokemon name to search or type STOP to end.");
    		input = myScan.nextLine();
    		if (input.equalsIgnoreCase("STOP")) {
    			break;
    		} else {
    			System.out.println("Processing request...");
    			System.out.println(mgr.getPokemonByName(input));
    		}
    	}
    	System.out.println("PokeApi request complete");
    }
}
