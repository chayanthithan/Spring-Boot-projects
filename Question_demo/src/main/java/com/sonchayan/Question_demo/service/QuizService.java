package com.sonchayan.Question_demo.service;

import com.sonchayan.Question_demo.Repostory.QuestionRepository;
import com.sonchayan.Question_demo.Repostory.QuizRepository;
import com.sonchayan.Question_demo.model.Question;
import com.sonchayan.Question_demo.model.QuestionWrapper;
import com.sonchayan.Question_demo.model.Quiz;
import com.sonchayan.Question_demo.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

//    public QuizService(QuestionRepository questionRepository) {
//        this.questionRepository = questionRepository;
//    }
    @Autowired
    private QuestionRepository questionRepository;
//    public QuizService(QuizRepository quizRepository) {
//        this.quizRepository = quizRepository;
//    }

    public ResponseEntity<String> createQuiz(String category,int numQ,String title){
        List<Question> questions=questionRepository.findRandomQuestionByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id) {
        Optional<Quiz> quiz=quizRepository.findById(id);
        //this is for get questions from database
        List<Question> questionFromDB=quiz.get().getQuestions();

        //this is for sending question for user
        List<QuestionWrapper> QuestionsForUser = new ArrayList<>();
        for(Question q:questionFromDB){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            QuestionsForUser.add(qw);
        }
        return new ResponseEntity<>(QuestionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
