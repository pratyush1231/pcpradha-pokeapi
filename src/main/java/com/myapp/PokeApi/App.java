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
    		System.out.println("Please enter the pokemon name: ");
    		input = myScan.next();
    		System.out.println("Processing request...");
    		mgr.getPokemonByName(input);
    		System.out.println("Do you want to continue (y/n) ?");
    		check = myScan.next().equalsIgnoreCase("y");
    	}
    	System.out.println("PokeApi request complete");
    }
}
