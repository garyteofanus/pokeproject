package com.project.pokeproject.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Question {
    private String id;
    private String name;
    private List<Map<String, Integer>> options = new ArrayList<>();

    public Question(String id, String name, List<Map<String, Integer>> options) {
        this.id = id;
        this.name = name;
        for (Map<String, Integer> op : options) {
            this.options.add(op);
        }
    }

    public Question() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOptions(List<Map<String, Integer>> options) {
        this.options = options;
    }

    public List<Map<String, Integer>> getOptions() {
        return this.options;
    }

    public String toString() {
        return String.format("%s?", name);
    }
}