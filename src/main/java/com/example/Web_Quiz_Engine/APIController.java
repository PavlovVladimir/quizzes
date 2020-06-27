package com.example.Web_Quiz_Engine;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
public class APIController {
    private Answer goodAnswer = new Answer(true, "Congratulations, you're right!");
    private Answer badAnswer = new Answer(false, "Wrong answer! Please, try again.");
    private ArrayList<Quiz> quizzes = new ArrayList<>();

    public APIController() {
    }

    @PostMapping(path = "/api/quizzes", produces = "application/json")
    public Quiz addQuiz(@RequestBody Quiz quiz) {
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

    @PostMapping(path = "/api/quizzes/{id}/solve", produces = "application/json")
    public Answer postAnswer(@PathVariable int id, @RequestParam("answer") int ans) {
        int rigthAnswer = quizzes.get(id).getAnswer();
        System.out.println("RESPONCE " + rigthAnswer);
        if (ans == rigthAnswer) {
            return goodAnswer;
        } else {
            return badAnswer;
        }
    }
}
