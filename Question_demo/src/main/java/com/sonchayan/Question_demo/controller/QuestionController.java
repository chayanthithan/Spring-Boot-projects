package com.sonchayan.Question_demo.controller;


import com.sonchayan.Question_demo.service.QuestionService;
import com.sonchayan.Question_demo.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;
//-------------fetch all the question------------------
    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestion();
    }
//-------------fetch by category [java/python,ect...]
    @GetMapping("/question/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }
//-------------add Question--------------
    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @PostMapping("/adds")
    public List<Question> addQuestions(@RequestBody List<Question> question){
        return questionService.addQuestions(question);
    }
//----------------delete---------------
    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable int id){
        questionService.deleteQuestion(id);
        return "deleted";
    }

    @PutMapping("/update")
    public String updateQuestion(@RequestBody Question question){
        questionService.updateQuestion(question);
        return "successfully updated";
    }
}
