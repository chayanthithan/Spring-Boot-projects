package com.sonchayan.Question_demo.model;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.Id;


@Data
@Entity
public class QuestionWrapper {

    @Id
    private int Id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuestionWrapper(int id, String questionTitle, String option1, String option2, String option3, String option4) {
        Id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
