package com.project.pokeproject;

import java.util.*;

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
        food.setId("1");
        food.setName("Favorite food");
        Map<String, Integer> map1 = new HashMap<String, Integer>() {
            {
                put("Pizza", 200);
            }
        };
        Map<String, Integer> map2 = new HashMap<String, Integer>() {
            {
                put("Burger", 150);
            }
        };
        Map<String, Integer> map3 = new HashMap<String, Integer>() {
            {
                put("Steak Isabella", 50);
            }
        };
        food.setOptions(Arrays.asList(map1, map2, map3));
        questionRepo.put(food.getId(), food);

        Question hobby = new Question();
        hobby.setId("2");
        hobby.setName("What do you prefer playing");
        questionRepo.put(hobby.getId(), hobby);
        map1 = new HashMap<String, Integer>() {
            {
                put("Leetcode", 200);
            }
        };
        map2 = new HashMap<String, Integer>() {
            {
                put("Nintendo Switch", 150);
            }
        };
        map3 = new HashMap<String, Integer>() {
            {
                put("LoGiSiM", -250);
            }
        };
        hobby.setOptions(Arrays.asList(map1, map2, map3));

        Question pets = new Question();
        pets.setId("3");
        pets.setName("What is your preferred pet");
        questionRepo.put(pets.getId(), pets);
        map1 = new HashMap<String, Integer>() {
            {
                put("Turtle", 200);
            }
        };
        map2 = new HashMap<String, Integer>() {
            {
                put("Rock", 250);
            }
        };
        map3 = new HashMap<String, Integer>() {
            {
                put("Cat", 250);
            }
        };
        pets.setOptions(Arrays.asList(map1, map2, map3));

        Question style = new Question();
        style.setId("4");
        style.setName("What do you prefer playing");
        questionRepo.put(style.getId(), style);
        style.setOptions(Arrays.asList(map1, map2, map3));

        Question vacation = new Question();
        vacation.setId("5");
        vacation.setName("What is your preferred vacation");
        questionRepo.put(vacation.getId(), vacation);
        map1 = new HashMap<String, Integer>() {
            {
                put("LoGiSiM", -200);
            }
        };
        map2 = new HashMap<String, Integer>() {
            {
                put("Sleep", 100);
            }
        };
        map3 = new HashMap<String, Integer>() {
            {
                put("Semester Pendek", 350);
            }
        };
        vacation.setOptions(Arrays.asList(map1, map2, map3));
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