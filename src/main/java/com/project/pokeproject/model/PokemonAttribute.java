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

    public int getNatureAttribute() {
        return this.natureAttribute;
    }

    public int getShadowAttribute() {
        return this.shadowAttribute;
    }

    public int getFireAttribute() {
        return this.fireAttribute;
    }

    public int getWaterAttribute() {
        return this.waterAttribute;
    }

    public void setNatureAttribute(final int value) {
        this.natureAttribute = value;
    }

    public void setShadowAttribute(final int value) {
        this.shadowAttribute = value;
    }

    public void setFireAttribute(final int value) {
        this.fireAttribute = value;
    }

    public void setWaterAttribute(final int value) {
        this.waterAttribute = value;
    }

    public String getRandomQuestion() {
        Random rand = new Random();
        List<String> keysAsArray = new ArrayList<String>(questionsMap.keySet());
        return keysAsArray.get(rand.nextInt(keysAsArray.size()));
    }

    public Map<String, Map<String, Integer>> getAnswerMapByQuestion(String question) {
        return questionsMap.get(question);
    }

    public List<String> getAnswerListByQuestion(String question) {
        return new ArrayList<String>(getAnswerMapByQuestion(question).keySet());
    }

    public Map<String, Integer> getAttributeIncrementByAnswer(Map<String, Map<String, Integer>> answerMap,
            String answer) {
        return answerMap.get(answer);
    }

    public void parseInformation() {
        // String attribute;
        // int increment;
        // Map<String, Integer> attributeIncrementer =
        // getAttributeIncrementByAnswer(getAnswerMapByQuestion(question),
        // answer);
        // attribute = (new ArrayList<String>(attributeIncrementer.keySet())).get(0);
        // increment = attributeIncrementer.get(attribute);
        for (Map.Entry<String, Map<String, Map<String, Integer>>> entry : questionsMap.entrySet()) {
            // System.out.println(entry.getKey() + "/" + entry.getValue());
            for (Map.Entry<String, Map<String, Integer>> entry2 : entry.getValue().entrySet()) {
                for (Map.Entry<String, Integer> entry3 : entry2.getValue().entrySet()) {
                    // System.out.println(entry3.getKey() + " " + entry3.getValue());
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