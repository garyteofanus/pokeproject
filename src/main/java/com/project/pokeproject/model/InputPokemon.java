package com.project.pokeproject.model;

import eu.iamgio.pokedex.pokemon.Pokemon;
import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class InputPokemon {

    private static List<Pokemon> listPokemon = new ArrayList<>();
    private String name;
    private PokemonType type1;
    private PokemonType type2;

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the type1
     */
    public PokemonType getType1() {
        return this.type1;
    }

    /**
     * @return the type2
     */
    public PokemonType getType2() {
        return this.type2;
    }

    public static List<Pokemon> getListPokemon() {
        return listPokemon;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param type1 the type to set
     */
    public void setType1(PokemonType type1) {
        this.type1 = type1;
    }

    /**
     * @param type2 the type to set
     */
    public void setType2(PokemonType type2) {
        this.type2 = type2;
    }


    public static void addPokemon(Pokemon pokemon) {
        listPokemon.add(pokemon);
    }

    public Pokemon createPokemon() {
        return Pokemon.fromName(name.toLowerCase());
    }

    public void getPokemonType() {
        Pair<PokemonType, PokemonType> types = createPokemon().getTypes();
        this.type1 = types.getFirst();
        this.type2 = types.getSecond();
    }
    
}