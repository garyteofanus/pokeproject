package com.project.pokeproject.model;

import java.util.*;

public class Questionnaire {
    private String answer;
    private static Map<String, Map<String, Map<String, Integer>>> questionsMap = new HashMap<>();;
    
    public String getAnswer(){
        return this.answer;
    }

    public void setAnswer(String value){
        this.answer = value;
    } 
}