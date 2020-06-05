package com.project.pokeproject.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Question {

    private String id;
    private String name;
    private List<Map<String, Integer>> options = new ArrayList<>();

    /**
     * Constructor for Question class.
     * 
     * @param id      String number of question id
     * @param name    String name representation of question
     * @param options ArrayList of options to choose
     */
    public Question(String id, String name, List<Map<String, Integer>> options) {
        this.id = id;
        this.name = name;
        for (Map<String, Integer> op : options) {
            this.options.add(op);
        }
    }

    /**
     * Constructor for Question class.
     */
    public Question() {
    }

    /**
     * Getter for id variable.
     * 
     * @return id String number of id variable
     */
    public String getId() {
        return id;
    }

    /**
     * Getter for name variable.
     * 
     * @return name String representation of question name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for options variable.
     * 
     * @return options ArrayList representation of options available
     */
    public List<Map<String, Integer>> getOptions() {
        return this.options;
    }

    /**
     * Setter for id variable.
     * 
     * @param id String number of question id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Setter for name variable.
     * 
     * @param name String representation of question name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for options variable.
     * 
     * @param options ArrayList representation of options available
     */
    public void setOptions(List<Map<String, Integer>> options) {
        this.options = options;
    }

    /**
     * To string method for Question class.
     * 
     * @return String representation of Question class
     */
    public String toString() {
        return String.format("%s", name);
    }
}