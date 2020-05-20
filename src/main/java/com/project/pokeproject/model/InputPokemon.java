package com.project.pokeproject.model;

import eu.iamgio.pokedex.pokemon.Pokemon;
import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.util.Pair;

public class InputPokemon {
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
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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

    public Pokemon createPokemon() {
        return Pokemon.fromName(name.toLowerCase());
    }

    public void getPokemonType() {
        Pair<PokemonType, PokemonType> types = createPokemon().getTypes();
        this.type1 = types.getFirst();
        this.type2 = types.getSecond();
    }
    
}