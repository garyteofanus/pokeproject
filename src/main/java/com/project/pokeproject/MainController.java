package com.project.pokeproject;

import java.util.*;

import eu.iamgio.pokedex.exception.PokedexException;
import eu.iamgio.pokedex.pokemon.Pokemon;
import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.util.Pair;

import com.project.pokeproject.model.InputPokemon;
import com.project.pokeproject.model.PokemonAttribute;
import com.project.pokeproject.model.Question;
import com.project.pokeproject.model.QuestionInput;
import com.project.pokeproject.model.Questionnaire;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MainController {

    private static Map<String, Question> questionRepo = new HashMap<>();

    static {
        Question food = new Question();
        List<Map<String, Integer>> answer = new ArrayList<>();
        food.setId("1");
        food.setName("What food would you prefer out of these three?");
        Map<String, Integer> map1 = new HashMap<String, Integer>() {
            {
                put("Fried Chicken", -2);
            }
        };
        Map<String, Integer> map2 = new HashMap<String, Integer>() {
            {
                put("Ice cream", 2);
            }
        };
        Map<String, Integer> map3 = new HashMap<String, Integer>() {
            {
                put("Padang Rice", 0);
            }
        };
        answer = Arrays.asList(map1, map2, map3);
        Collections.shuffle(answer);
        food.setOptions(answer);
        questionRepo.put(food.getId(), food);

        Question hobby = new Question();
        hobby.setId("2");
        hobby.setName("Which of these activity do you prefer?");
        questionRepo.put(hobby.getId(), hobby);
        map1 = new HashMap<String, Integer>() {
            {
                put("Sleeping", -5);
            }
        };
        map2 = new HashMap<String, Integer>() {
            {
                put("Traveling", 5);
            }
        };
        map3 = new HashMap<String, Integer>() {
            {
                put("Studying", 0);
            }
        };
        answer = Arrays.asList(map1, map2, map3);
        Collections.shuffle(answer);
        hobby.setOptions(answer);

        Question subject = new Question();
        subject.setId("3");
        subject.setName("What is your favorite subject?");
        questionRepo.put(subject.getId(), subject);
        map1 = new HashMap<String, Integer>() {
            {
                put("Art", -3);
            }
        };
        map2 = new HashMap<String, Integer>() {
            {
                put("Science", 0);
            }
        };
        map3 = new HashMap<String, Integer>() {
            {
                put("Sports", 3);
            }
        };
        answer = Arrays.asList(map1, map2, map3);
        Collections.shuffle(answer);
        subject.setOptions(answer);

        Question genre = new Question();
        genre.setId("4");
        genre.setName("What is favorite music genre?");
        questionRepo.put(genre.getId(), genre);
        map1 = new HashMap<String, Integer>(){
            {
                put("Anime Song", 0);
            }
        };
        map2 = new HashMap<String, Integer>(){
            {
                put("Chillhop", -2);
            }
        };
        map3 = new HashMap<String, Integer>(){
            {
                put("Pop", 2);
            }
        };
        answer = Arrays.asList(map1, map2, map3);
        Collections.shuffle(answer);
        genre.setOptions(answer);

        Question color = new Question();
        color.setId("5");
        color.setName("What is your favorite color?");
        questionRepo.put(color.getId(), color);
        map1 = new HashMap<String, Integer>() {
            {
                put("Blue", -2);
            }
        };
        map2 = new HashMap<String, Integer>() {
            {
                put("Red", 3);
            }
        };
        map3 = new HashMap<String, Integer>() {
            {
                put("Black", 0);
            }
        };
        answer = Arrays.asList(map1, map2, map3);
        Collections.shuffle(answer);
        color.setOptions(answer);

        Question sleep = new Question();
        sleep.setId("6");
        sleep.setName("At what time do you go to bed?");
        questionRepo.put(sleep.getId(), sleep);

        map1 = new HashMap<String, Integer>(){
            {
                put("After 12AM", -4);
            }
        };

        map2 = new HashMap<String, Integer>(){
            {
                put("10pm - 12pm", 0);
            }
        };

        map3 = new HashMap<String, Integer>(){
            {
                put("8pm - 10pm", 2);
            }
        };
        answer = Arrays.asList(map1, map2, map3);
        Collections.shuffle(answer);
        sleep.setOptions(answer);


        Question movie = new Question();
        movie.setId("7");
        movie.setName("What is your favorite movie genre?");
        questionRepo.put(movie.getId(), movie);

        map1 = new HashMap<String, Integer>(){
            {
                put("Horror", 0);
            }
        };

        map2 = new HashMap<String, Integer>(){
            {
                put("Romance", 1);
            }
        };

        map3 = new HashMap<String, Integer>(){
            {
                put("Action", 3);
            }
        };
        answer = Arrays.asList(map1, map2, map3);
        Collections.shuffle(answer);
        movie.setOptions(answer);
    }

    /**
     * 
     * @return
     */
    @RequestMapping(value = "/questions")
    public ResponseEntity<Object> getquestion() {
        return new ResponseEntity<>(questionRepo.values(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/questions/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        questionRepo.remove(id);
        return new ResponseEntity<>("Question is deleted successsfully", HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @param question
     * @return
     */
    @RequestMapping(value = "/questions/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Question question) {
        questionRepo.remove(id);
        question.setId(id);
        questionRepo.put(id, question);
        return new ResponseEntity<>("Question is updated successsfully", HttpStatus.OK);
    }

    /**
     *
     * @param question
     * @return
     */
    @RequestMapping(value = "/questions", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Question question) {
        questionRepo.put(question.getId(), question);
        return new ResponseEntity<>("Question is created successfully", HttpStatus.CREATED);
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    /**
     *
     * @param inputPokemon
     * @return
     */
    @PostMapping("/generate")
    public String generate(@ModelAttribute InputPokemon inputPokemon) {
        // inputPokemon.getRandomPokemon();
        return "generate";
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/pokeform")
    public String formQuestionnaire(Model model) {
        // List<Question> questionRepo = questionRepo.values();
        List<Question> al = new ArrayList<Question>(questionRepo.values());
        Collections.shuffle(al);
        for(Question thing : al){
            List<Map<String,Integer>> newThing = thing.getOptions();
            Collections.shuffle(newThing);
            thing.setOptions(newThing);
        }
        al = al.subList(0, 7);
        model.addAttribute("questionInput", new QuestionInput());
        model.addAttribute("questions", al);
        return "pokeform";
    }

    /**
     * 
     * @param model
     * @param questionInput
     * @return
     */
    @PostMapping("/pokeform-result")
    public String formResult(Model model, QuestionInput questionInput) {
        // model.addAttribute("questionInput", questionInput);
        // TODO: if range score segini, pokemonnya tipe Dark, Normal, atau Fire
        // TODO: rapihin html/css dan deskripsi tiap tipe
        // Get Pokemon sesuai tipe dia, terus randomize, sama informasi-informasi pokemonnya di bawa ke HTML-nya.
        int score = 0;
        Pokemon newPoke = null;
        String adj = "";
        String desc = "";
        String[] descList = new String[3];
        descList[0] = "You got a normal type pokemon! It seems like you are a chill person and prefer not to get too much attention.";
        descList[1] = "You got a fire type pokemon! Your aura blazes among others, you have the spirit to experience various things you really want.";
        descList[2] = "You got a dark type pokemon! You like spending time on your own, sometimes there is too much thing going on outside.";
        String[] normalAdj = {"Ordinary", "Common", "Traditional", "Simple", "Natural", "Trivial"};
        String[] fireAdj = {"Fiery", "Blazing", "Spirited", "Dynamic", "Vibrant", "Enthusiastic"};
        String[] darkAdj = {"Shy", "Reserved", "Modest", "Quiet", "Relaxed", "Calm"};

        for (int i : questionInput.getAnswers()) {
            score += i;
        }
        System.out.println(score);
        if (score >= -2 && score <= 2) {
            newPoke = InputPokemon.getRandomPokemon("normal");
            adj = normalAdj[(int)(Math.random() * 6) + 0];
            desc = descList[0];
        } else if (score > 2) {
            newPoke = InputPokemon.getRandomPokemon("fire");
            adj = fireAdj[(int)(Math.random() * 6) + 0];
            desc = descList[1];
        } else if (score < -2) {
            newPoke = InputPokemon.getRandomPokemon("dark");
            adj = darkAdj[(int)(Math.random() * 6) + 0];
            desc = descList[2];
        }
        model.addAttribute("score", score);
        model.addAttribute("pokemon", newPoke);
        model.addAttribute("name", "The " + adj + " " + newPoke.getName().substring(0, 1).toUpperCase() + newPoke.getName().substring(1));
        model.addAttribute("desc", desc);
        model.addAttribute("sprite", newPoke.getSprites()[0].getUrl());
        return "pokeform-result";
    }

    // @GetMapping("/form")
    // public String formQuestionnaire(Model model) {
    // attributeGlobal.initializePokemonAttribute(); // Contoh: Ini kalo bisa
    // diinitialize sekali jg gpp, ini cuman
    // // initialize buat pertanyaannya
    // String question = attributeGlobal.getRandomQuestion();
    // List<String> answersList = attributeGlobal.getAnswerListByQuestion(question);
    // model.addAttribute("questionnaire", new Questionnaire());
    // model.addAttribute("question", question);
    // model.addAttribute("answers", answersList);
    // model.addAttribute("attributes", attributeGlobal);
    // return "form";
    // }

    // @PostMapping("/form-success")
    // public String resultFormQuestionnaire(Model model, @ModelAttribute
    // Questionnaire questionnaire) {

    // attributeGlobal.parseInformation();
    // model.addAttribute("answer", questionnaire.getAnswer());
    // model.addAttribute("attributes", attributeGlobal);
    // return "form-result";
    // }
}