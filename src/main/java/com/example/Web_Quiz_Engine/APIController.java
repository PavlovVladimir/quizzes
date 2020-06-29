package com.example.Web_Quiz_Engine;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;

@RestController
public class APIController {
    private Answer goodAnswer = new Answer(true, "Congratulations, you're right!");
    private Answer badAnswer = new Answer(false, "Wrong answer! Please, try again.");
    private ArrayList<Quiz> quizzes = new ArrayList<>();

    public APIController() {
    }

    @PostMapping(path = "/api/quizzes", consumes = "application/json", produces = "application/json")
    public Quiz addQuiz(@Valid @RequestBody Quiz quiz) {
        System.out.println("POST " + quiz.getAnswer());
        quiz.setId(quizzes.size());
        quizzes.add(quiz);
        return quiz;
    }

    @GetMapping(path = "/api/quizzes/{id}")
    public Quiz getQuiz(@PathVariable int id) {
        if (quizzes.size() > id) {
            return quizzes.get(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }

    @GetMapping(path = "/api/quizzes", produces = "application/json")
    public ArrayList<Quiz> getAllQuizzes() {
        return quizzes;
    }

    @PostMapping(path = "/api/quizzes/{id}/solve", consumes = "application/json", produces = "application/json")
    public Answer postAnswer(@RequestBody ListOfAnswers answer, @PathVariable int id) {
        ArrayList<Integer> rightAnswers = quizzes.get(id).getAnswer();
        System.out.println("ID: " + id);
        ArrayList<Integer> answers = answer.getAnswer();

        Collections.sort(rightAnswers);
        Collections.sort(answers);
        System.out.println("RESPONCE " + rightAnswers.toString());
        if (answers.equals(rightAnswers)) {
            return goodAnswer;
        } else {
            return badAnswer;
        }
    }
}
