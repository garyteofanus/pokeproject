package com.project.pokeproject;

import java.util.*;

import com.project.pokeproject.model.InputPokemon;
import com.project.pokeproject.model.PokemonAttribute;
import com.project.pokeproject.model.Question;
import com.project.pokeproject.model.QuestionInput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MainController {

    private static Map<String, Question> questionRepo = new HashMap<>();
    static {

        // Question 1, favorite food
        Question food = new Question();
        food.setId("1");
        food.setName("Favorite food");

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Pizza", 200); 

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Burger", 150);

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("Steak Isabella", 50);

        food.setOptions(Arrays.asList(map1, map2, map3));
        questionRepo.put(food.getId(), food);

        // Question 2, favorite game
        Question hobby = new Question();
        hobby.setId("2");
        hobby.setName("What do you prefer playing");
        questionRepo.put(hobby.getId(), hobby);

        map1 = new HashMap<>();
        map1.put("Leetcode", 200);

        map2 = new HashMap<>();
        map2.put("Nintendo Switch", 150);

        map3 = new HashMap<>();
        map3.put("LoGiSiM", -250);

        hobby.setOptions(Arrays.asList(map1, map2, map3));

        // Question 3, favorite pet
        Question pets = new Question();
        pets.setId("3");
        pets.setName("What is your preferred pet");
        questionRepo.put(pets.getId(), pets);

        map1 = new HashMap<>();
        map1.put("Turtle", 200);

        map2 = new HashMap<>();
        map2.put("Rock", 250);

        map3 = new HashMap<>();
        map3.put("Cat", 250);

        pets.setOptions(Arrays.asList(map1, map2, map3));

        // Question 4, favorite study place
        Question study = new Question();
        study.setId("4");
        study.setName("Where are your favorite study place");
        questionRepo.put(study.getId(), study);

        map1 = new HashMap<>();
        map1.put("Pucil Atas", 250);

        map2 = new HashMap<>();
        map2.put("Pucil Bawah", 250);

        map3 = new HashMap<>();
        map3.put("Perpusat", 100);

        study.setOptions(Arrays.asList(map1, map2, map3));

        // Question 5, favorite vacation 
        Question vacation = new Question();
        vacation.setId("5");
        vacation.setName("What is your preferred vacation");
        questionRepo.put(vacation.getId(), vacation);

        map1 = new HashMap<>();
        map1.put("Zimbabwe", -200);

        map2 = new HashMap<>();
        map2.put("Sleep", 100);

        map3 = new HashMap<>();
        map3.put("Semester Pendek", 350);

        vacation.setOptions(Arrays.asList(map1, map2, map3));

        // Question 6, favorite snack
        Question snack = new Question();
        snack.setId("6");
        snack.setName("What is your favorite snack");
        questionRepo.put(snack.getId(), snack);

        map1 = new HashMap<>();
        map1.put("French Fires", 120);

        map2 = new HashMap<>();
        map2.put("Chocolate Chip Cookies", 97);

        map3 = new HashMap<>();
        map3.put("Candy", 113);

        snack.setOptions(Arrays.asList(map1, map2, map3));

        // Question 7, hated person
        Question person = new Question();
        person.setId("7");
        person.setName("Who do you hate the most");
        questionRepo.put(person.getId(), person);

        map1 = new HashMap<>();
        map1.put("You", -100);

        map2 = new HashMap<>();
        map2.put("Yourself", -100);

        map3 = new HashMap<>();
        map3.put("The One Who's Playing", -100);

        person.setOptions(Arrays.asList(map1, map2, map3));
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/questions")
    public ResponseEntity<Object> getquestion() {
        return new ResponseEntity<>(questionRepo.values(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/questions/{id}")
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
    @PutMapping(value = "/questions/{id}")
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
    @PostMapping(value = "/questions")
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
        inputPokemon.getRandomPokemon();
        return "generate";
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/pokeform")
    public String formQuestionnaire(Model model) {
        model.addAttribute("questionInput", new QuestionInput());
        model.addAttribute("questions", questionRepo.values());
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
        int score = 0;
        for (int i : questionInput.getAnswers()) {
            score += i;
        }
        model.addAttribute("score", score);
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