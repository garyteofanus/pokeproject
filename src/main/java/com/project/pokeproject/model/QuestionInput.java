package com.project.pokeproject.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
public class QuestionInput {
    private Integer[] answers;
    private int score;
}

class TestLombok {
    {
        QuestionInput q = new QuestionInput();
    }
}