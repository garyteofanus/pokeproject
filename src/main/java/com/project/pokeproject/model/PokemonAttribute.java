package com.project.pokeproject.model;

import java.util.*;
// import eu.iamgio.pokedex.util.Pair;
// import org.apache.commons.lang3.tuple.Pair;

import org.apache.commons.lang3.tuple.Pair;

@SuppressWarnings("serial")
public class PokemonAttribute {

    // BISA DI INSTANSIASI LANGSUNG(keknya)
    private Map<String, Map<String, Map<String, Integer>>> questionsMap = new HashMap<>();
    private int natureAttribute = 0;
    private int shadowAttribute = 0;
    private int fireAttribute = 0;
    private int waterAttribute = 0;

    /**
     * Getter for natureAttribute variable.
     * @return int natureAttribute value
     */
    public int getNatureAttribute() {
        return this.natureAttribute;
    }

    /**
     * Getter for shadowAttribute variable.
     * @return int shadowAttribute value
     */
    public int getShadowAttribute() {
        return this.shadowAttribute;
    }

    /**
     * Getter for fireAttribute variable.
     * @return int fireAttribute value
     */
    public int getFireAttribute() {
        return this.fireAttribute;
    }

    /**
     * Getter for natureAttribute variable.
     * @return int natureAttribute value
     */
    public int getWaterAttribute() {
        return this.waterAttribute;
    }

    /**
     * Setter method for natureAttribute variable.
     * @param value int value to set
     */
    public void setNatureAttribute(final int value) {
        this.natureAttribute = value;
    }

    /**
     * Setter method for shadowAttribute variable.
     * @param value int value to set
     */
    public void setShadowAttribute(final int value) {
        this.shadowAttribute = value;
    }

    /**
     * Setter method for fireAttribute variable.
     * @param value int value to set
     */
    public void setFireAttribute(final int value) {
        this.fireAttribute = value;
    }

    /**
     * Setter method for waterAttribute variable.
     * @param value int value to set
     */
    public void setWaterAttribute(final int value) {
        this.waterAttribute = value;
    }

    /**
     * Randomize question from questionsMap variable.
     * @return String question randomized
     */
    public String getRandomQuestion() {
        Random rand = new Random();
        List<String> keysAsArray = new ArrayList<String>(questionsMap.keySet());
        return keysAsArray.get(rand.nextInt(keysAsArray.size()));
    }

    /**
     * Get answer map of given question.
     * @param question String question given
     * @return HashMap answer of the question
     */
    public Map<String, Map<String, Integer>> getAnswerMapByQuestion(String question) {
        return questionsMap.get(question);
    }

    /**
     * Get answer list of given question.
     * @param question String question given
     * @return ArrayList representation of questionsMap's answer of given question
     */
    public List<String> getAnswerListByQuestion(String question) {
        return new ArrayList<String>(getAnswerMapByQuestion(question).keySet());
    }

    /**
     * Get attribute map of answerMap.
     * @param answerMap HashMap of String and mapped String and Integer
     * @param answer String answer given
     * @return HashMap of answerMap's given answer
     */
    public Map<String, Integer> getAttributeIncrementByAnswer(Map<String, Map<String, Integer>> answerMap,
            String answer) {
        return answerMap.get(answer);
    }

    /**
     * Method to parse information.
     */
    public void parseInformation() {
        // List<String> answers = new ArrayList<>();
        // for (Questionnaire q : questionnaires) {
        // answers.add(q.getAnswer());
        // }
        // System.out.println(answers);
        for (Map.Entry<String, Map<String, Map<String, Integer>>> entry : questionsMap.entrySet()) {
            for (Map.Entry<String, Map<String, Integer>> entry2 : entry.getValue().entrySet()) {
                System.out.println(entry2.getKey() + " " + entry2.getValue());
                // List<String> answersList = attributeGlobal.getAnswerListByQuestion(question);
                for (Map.Entry<String, Integer> entry3 : entry2.getValue().entrySet()) {
                    String attribute = entry3.getKey();
                    int increment = entry3.getValue();
                    if (attribute.equalsIgnoreCase("shadow")) {
                        setShadowAttribute(getShadowAttribute() + increment);
                    } else if (attribute.equalsIgnoreCase("nature")) {
                        setNatureAttribute(getNatureAttribute() + increment);
                    } else if (attribute.equalsIgnoreCase("water")) {
                        setWaterAttribute(getWaterAttribute() + increment);
                    } else if (attribute.equalsIgnoreCase("fire")) {
                        setFireAttribute(getFireAttribute() + increment);
                    }
                }
            }
        }
    }

    // Welcome, ini lumayan straight forward sih.
    /**
     * Method to initialize questionsMap variable.
     */
    public void initializePokemonAttribute() {
        questionsMap.put("Kamu suka sama siapa?", new HashMap<String, Map<String, Integer>>() {
            {
                put("Mario Serano", new HashMap<String, Integer>() {
                    {
                        put("Shadow", 50);
                    }
                });
                put("Teofanus Gary", new HashMap<String, Integer>() {
                    {
                        put("Fire", 50);
                    }
                });
                put("Antonius Anggito Arrisaputro", new HashMap<String, Integer>() {
                    {
                        put("Nature", 50);
                    }
                });
                put("Jonathan Nicholas", new HashMap<String, Integer>() {
                    {
                        put("Water", 50);
                    }
                });
            }
        });
    }

}