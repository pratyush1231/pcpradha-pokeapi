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
    		System.out.println("Please enter a pokemon name to search OR type 'list' to display pokemon names saved in memory OR type 'STOP' to display the report.");
    		input = myScan.nextLine();
    		if (input.equalsIgnoreCase("STOP")) {
    			break;
    		} else if (input.equalsIgnoreCase("list")) {
    			mgr.displayMemoryList();
    		} else {
    			System.out.println("Processing request...");
    			mgr.getPokemonByName(input);
    		}
    	}
    	myScan.close();
    	mgr.displayReport();
    	System.out.println("PokeApi request complete");
    }
}
