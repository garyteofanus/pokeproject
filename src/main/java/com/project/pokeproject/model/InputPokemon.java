package com.project.pokeproject.model;

import eu.iamgio.pokedex.exception.PokedexException;
import eu.iamgio.pokedex.pokemon.Pokemon;
import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.util.Pair;

import java.util.*;

public class InputPokemon {

    private static List<Pokemon> listPokemon = new ArrayList<>();
    private String name;
    private PokemonType type1;
    private PokemonType type2;
    private static Map<String, String> typeMap = new HashMap<>();

    /**
     * Getter method for name variable.
     * @return String name of InputPokemon
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method for type1 variable.
     * @return PokemonType type1
     */
    public PokemonType getType1() {
        return this.type1;
    }

    /**
     * Getter method for type2 variable.
     * @return PokemonType type2
     */
    public PokemonType getType2() {
        return this.type2;
    }

    /**
     * Getter method for listPokemon variable.
     * @return ArrayList of Pokemon variable
     */
    public static List<Pokemon> getListPokemon() {
        return listPokemon;
    }

    /**
     * Setter method for name variable.
     * @param name String name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for type1 variable.
     * @param type1 PokemonType type1 to set
     */
    public void setType1(PokemonType type1) {
        this.type1 = type1;
    }

    /**
     * Setter method for type2 variable.
     * @param type2 PokemonType type2 to set
     */
    public void setType2(PokemonType type2) {
        this.type2 = type2;
    }

    /**
     * Add pokemon object to listPokemon.
     * @param pokemon Pokemon object to add
     */
    public static void addPokemon(Pokemon pokemon) {
        listPokemon.add(pokemon);
    }

    /**
     * Create Pokemon based on name.
     * @return Pokemon object created
     */
    public Pokemon createPokemon() {
        return Pokemon.fromName(name.toLowerCase());
        // return Pokemon.fromName(String.valueOf(id));
    }

    /**
     * Create Pokemon based on id.
     * @param id Number id of pokemon to create
     * @return Pokemon object created
     * @throws PokedexException Exception if pokemon id doesn't exist
     */
    public Pokemon fromId(Number id) throws PokedexException {
        return Pokemon.fromName(String.valueOf(id));
    }

    /**
     * Get and set type1 and type2 from created pokemon.
     */
    public void getPokemonType() {
        Pair<PokemonType, PokemonType> types = createPokemon().getTypes();
        this.type1 = types.getFirst();
        this.type2 = types.getSecond();
    }

    /**
     * String representation of type.
     * @return String representation about type
     */
    public String typeToString() {
        return String.format("You are %s", typeMap.get(type1.toString()));
    }

    /**
     * Method to generate randomized pokemon name
     * and set typeMap list.
     */
    private static int getRandomNumberInRange(int min, int max){
        if (min >= max){
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    public static Pokemon getRandomPokemon(){
        Pokemon returnedPokemon = Pokemon.fromId(getRandomNumberInRange(1, 808));
        return returnedPokemon;
    }
    
    
    // public static void main(String[] args){
    //     System.out.println(getRandomPokemonBasedonType("electric"));
    // }

}