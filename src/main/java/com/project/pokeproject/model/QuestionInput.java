package com.project.pokeproject.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionInput {
    private Integer[] answers;
    private int score;

    /**
     * @return the answers
     */
    public Integer[] getAnswers() {
        return answers;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param answers the answers to set
     */
    public void setAnswers(Integer[] answers) {
        this.answers = answers;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    public QuestionInput() {
        // Empty constructor
    }
}

// class TestLombok {
//     {
//         QuestionInput q = new QuestionInput();
//     }
// }