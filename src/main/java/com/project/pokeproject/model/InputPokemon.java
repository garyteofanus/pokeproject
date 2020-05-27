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
        // return Pokemon.fromName(String.valueOf(id));
    }

    public Pokemon fromId(Number id) throws PokedexException {
        return Pokemon.fromName(String.valueOf(id));
    }

    public void getPokemonType() {
        Pair<PokemonType, PokemonType> types = createPokemon().getTypes();
        this.type1 = types.getFirst();
        this.type2 = types.getSecond();
    }

    public String typeToString() {
        return String.format("You are %s", typeMap.get(type1.toString()));
    }

    public void getRandomPokemon() {
        Random rand = new Random();
        String randomName = "";
        int randNum = ((int)(Math.random() * 3) + 1);
        for (int i = 0; i <= randNum; i++) {
//            Pokemon randomPoke = Pokemon.fromId((int)(Math.random() * 808) + 1);
            Pokemon randomPoke = Pokemon.fromId(rand.nextInt(808));
            String[] splitName = randomPoke.getName().split("(?<=[aiueo])");
            // Check randomized splitted pokemon names on terminal
            System.out.println(Arrays.toString(splitName));
            if (i == 0) {
                randomName += splitName[0];
                // Type is based on first randomized pokemon
                Pair<PokemonType, PokemonType> types = randomPoke.getTypes();
                this.type1 = types.getFirst();
            } else if (i == randNum) {
                randomName += splitName[splitName.length - 1];
            } else {
                randomName += splitName[(int)(Math.random() * splitName.length)];
            }
        }
        // Capitalize first letter
        randomName = randomName.substring(0, 1).toUpperCase() + randomName.substring(1);
        // Check pokemon name on terminal
        System.out.println(randomName);
        this.name = randomName;
//        Random rand = new Random();
//        Pokemon pokemon = fromId(rand.nextInt(700));
//        this.name = pokemon.getName();
//        Pair<PokemonType, PokemonType> types = pokemon.getTypes();
//        this.type1 = types.getFirst();
        typeMap.put("GRASS", "Graceful");
        typeMap.put("FIGHTING", "Baku Hantam");
        typeMap.put("FLYING", "Cool");
        typeMap.put("NORMAL", "Normal");
        typeMap.put("POISON", "Toxic");
        typeMap.put("GROUND", "Unmovable");
        typeMap.put("ROCK", "Sturdy");
        typeMap.put("BUG", "Annoying");
        typeMap.put("GHOST", "Gone");
        typeMap.put("STEEL", "Strong");
        typeMap.put("FIRE", "Fierce");
        typeMap.put("WATER", "Playful");
        typeMap.put("ELECTRIC", "Shocking");
        typeMap.put("PSYCHIC", "Mindblowing");
        typeMap.put("ICE", "Cold");
        typeMap.put("DRAGON", "Graceful");
        typeMap.put("DARK", "Edgy");
        typeMap.put("FAIRY", "Magestic");
        typeMap.put("UNKNOWN", "Mysterious");
        typeMap.put("SHADOW", "Mysterious");
    }

}