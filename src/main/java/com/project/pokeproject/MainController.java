package com.project.pokeproject;

import com.project.pokeproject.model.InputPokemon;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// import eu.iamgio.pokedex.pokemon.Pokemon;
// import eu.iamgio.pokedex.pokemon.PokemonAbility;
// import eu.iamgio.pokedex.pokemon.PokemonType;

// import eu.iamgio.pokedex.util.Pair;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/form")
    public String formInputPokemon(Model model) {
        model.addAttribute("inputPokemon", new InputPokemon());
        return "form";
    }

    @PostMapping("/form")
    public String submitFormInputPokemon(@ModelAttribute InputPokemon inputPokemon) {
        inputPokemon.getPokemonType();
        return "form-result";
    }

    // public static void main(String[] args) {
    //     Pokemon bulbasaur = Pokemon.fromName("bulbasaur");
    //     Pokemon ditto = Pokemon.fromName("ditto");
    //     Pokemon charmander = Pokemon.fromName("charmander");

    //     Pair<PokemonType, PokemonType> type_charmander = charmander.getTypes();
    //     System.out.println(type_charmander.getFirst());
    //     System.out.println(type_charmander.getSecond());

    //     PokemonAbility ditto_ability = PokemonAbility.fromName("imposter");
    //     System.out.println(ditto_ability);

    //     Pair<PokemonType, PokemonType> types = bulbasaur.getTypes();
    //     System.out.println(types.getFirst());
    //     System.out.println(types.getSecond());
    // }
}