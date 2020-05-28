package com.project.pokeproject;

import java.util.Random;
import java.util.*;

import com.project.pokeproject.model.InputPokemon;
import com.project.pokeproject.model.PokemonAttribute;
import com.project.pokeproject.model.Questionnaire;

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
    private static PokemonAttribute attributeGlobal = new PokemonAttribute();
    // TODO: Ini possible bug di private method ini, karena declare di controllernya,
    // Gue ga tau gimana caranya, tapi buat attribute ini tuh constantly bisa di update,
    // Di dalem attribute model di Spring Bootnya.
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/generate")
    public String generate(@ModelAttribute InputPokemon inputPokemon) {
        inputPokemon.getRandomPokemon();
        return "generate";
    }

    @GetMapping("/form")
    public String formQuestionnaire(Model model) {
        // TODO:
        // Stuck di sini, kalo mau bantu:
        // Refactor buat modelattribute ini biar gimana caranya ga di call terlalu banyak,
        // Ataupun buat di form-success sama form ini kalo bisa dijadiin satu juga oke,
        attributeGlobal.initializePokemonAttribute(); // Contoh: Ini kalo bisa diinitialize sekali jg gpp, ini cuman initialize buat pertanyaannya
        String question = attributeGlobal.getRandomQuestion(); 
        List<String> answersList = attributeGlobal.getAnswerListByQuestion(question); 
        model.addAttribute("questionnaire", new Questionnaire());
        model.addAttribute("question", question);
        model.addAttribute("answers", answersList);
        model.addAttribute("attributes", attributeGlobal);
        return "form";
    }

    @PostMapping("/form-success")
    public String resultFormQuestionnaire(Model model, @ModelAttribute Questionnaire questionnaire){
        // TODO:
        // Stuck di sini, kalo mau bantu:
        // Cari cara buat data-data dari get bisa ditampiliki di sini,
        // Variabel "questions" dibutuhin buat di PokemonAttribute,
        // Buat ngequery attribute yang bakal di increment yang mana.
        // Abis itu, di query panggil method parseInformation yg udah gue bikin di PokemonAttribute
        model.addAttribute("answer", questionnaire.getAnswer());
        model.addAttribute("attributes", attributeGlobal);
        return "form-result";
    }

    // public static void main(String[] args) {
    // Pokemon bulbasaur = Pokemon.fromName("bulbasaur");
    // Pokemon ditto = Pokemon.fromName("ditto");
    // Pokemon charmander = Pokemon.fromName("charmander");

    // Pair<PokemonType, PokemonType> type_charmander = charmander.getTypes();
    // System.out.println(type_charmander.getFirst());
    // System.out.println(type_charmander.getSecond());

    // PokemonAbility ditto_ability = PokemonAbility.fromName("imposter");
    // System.out.println(ditto_ability);

    // Pair<PokemonType, PokemonType> types = bulbasaur.getTypes();
    // System.out.println(types.getFirst());
    // System.out.println(types.getSecond());
    // }
}