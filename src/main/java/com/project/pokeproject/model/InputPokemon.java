package com.project.pokeproject.model;

import eu.iamgio.pokedex.exception.PokedexException;
import eu.iamgio.pokedex.pokemon.Pokemon;
import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.util.Pair;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class InputPokemon {

    private static List<Pokemon> listPokemon = new ArrayList<>();
    private String name;
    private PokemonType type1;
    private PokemonType type2;
    private static Map<String, String> typeMap = new HashMap<>();

    // /**
    //  * Getter method for name variable.
    //  * @return String name of InputPokemon
    //  */
    // public String getName() {
    //     return this.name;
    // }

    // /**
    //  * Getter method for type1 variable.
    //  * @return PokemonType type1
    //  */
    // public PokemonType getType1() {
    //     return this.type1;
    // }

    // /**
    //  * Getter method for type2 variable.
    //  * @return PokemonType type2
    //  */
    // public PokemonType getType2() {
    //     return this.type2;
    // }

    // /**
    //  * Getter method for listPokemon variable.
    //  * @return ArrayList of Pokemon variable
    //  */
    // public static List<Pokemon> getListPokemon() {
    //     return listPokemon;
    // }

    // /**
    //  * Setter method for name variable.
    //  * @param name String name to set
    //  */
    // public void setName(String name) {
    //     this.name = name;
    // }

    // /**
    //  * Setter method for type1 variable.
    //  * @param type1 PokemonType type1 to set
    //  */
    // public void setType1(PokemonType type1) {
    //     this.type1 = type1;
    // }

    // /**
    //  * Setter method for type2 variable.
    //  * @param type2 PokemonType type2 to set
    //  */
    // public void setType2(PokemonType type2) {
    //     this.type2 = type2;
    // }

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
                this.type1 = randomPoke.getTypes().getFirst();
            } else if (i == randNum) {
                randomName += splitName[splitName.length - 1];
            } else {
                randomName += splitName[(int)(Math.random() * splitName.length)];
            }
        }
        this.name = randomName.substring(0, 1).toUpperCase() + randomName.substring(1);
        // Check pokemon name on terminal
        System.out.println(randomName);

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