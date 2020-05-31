package com.project.pokeproject.model;

import java.util.*;

public class Questionnaire {
    private String answer;
    private static Map<String, Map<String, Map<String, Integer>>> questionsMap = new HashMap<>();;

    public String getAnswer() {
        // for (Map.Entry<String, Map<String, Map<String, Integer>>> entry :
        // questionsMap.entrySet()) {
        // // System.out.println(entry.getKey() + "/" + entry.getValue());
        // for (Map.Entry<String, Map<String, Integer>> entry2 :
        // entry.getValue().entrySet()) {
        // for (Map.Entry<String, Integer> entry3 : entry2.getValue().entrySet()) {
        // System.out.println(entry3.getKey() + " " + entry3.getValue());
        // }
        // }
        // }
        // System.out.println("yo");
        return this.answer;
    }

    public void setAnswer(String value) {
        this.answer = value;
    }
}