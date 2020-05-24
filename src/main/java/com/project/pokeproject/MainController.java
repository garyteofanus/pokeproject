package com.project.pokeproject;

import com.project.pokeproject.model.InputPokemon;

import eu.iamgio.pokedex.pokemon.Stat;
import eu.iamgio.pokedex.pokemon.move.PokemonPersonalMove;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import eu.iamgio.pokedex.pokemon.Pokemon;
import eu.iamgio.pokedex.pokemon.PokemonAbility;
import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.util.Pair;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        Pokemon zorua = Pokemon.fromName("zorua");
        model.addAttribute("namaPokemon", zorua.getName());
        model.addAttribute(zorua);
        return "index";
    }

    @GetMapping("/form")
    public String formInputPokemon(Model model) {
        model.addAttribute("pokemon", new InputPokemon());
        return "form";
    }

    @PostMapping("/form")
    public String submitFormInputPokemon(@ModelAttribute InputPokemon pokemon) {
        return "form-result";
    }

//    public static void main(String[] args) {
//        Pokemon zorua = Pokemon.fromName("zorua");
//        System.out.printf("You caught a %s!\n", zorua.getSpeciesName());
//        Pair<PokemonType, PokemonType> type_zorua = zorua.getTypes();
//        System.out.println(zorua.getStat(Stat.Type.SPECIAL_ATTACK));
//        System.out.printf("Type : %s, %s", type_zorua.getFirst(), type_zorua.getSecond());
//
//        PokemonAbility ditto_ability = PokemonAbility.fromName("imposter");
//        System.out.println(ditto_ability);
//    }
}