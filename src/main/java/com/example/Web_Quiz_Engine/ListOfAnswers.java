package com.example.Web_Quiz_Engine;

import java.util.ArrayList;

public class ListOfAnswers {
    private ArrayList<Integer> answer;

    public ListOfAnswers() {
    }

    public ArrayList<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<Integer> answer) {
        this.answer = answer == null ? new ArrayList<>() : answer;
    }
}
