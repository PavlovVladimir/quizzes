package com.example.Web_Quiz_Engine;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

//@JsonIgnoreProperties(value = {"answer"})
//@Validated
public class Quiz {

    private int id;

    @NotBlank
    private String title;

    @NotBlank
    private String text;

    @NotNull
    @Size(min = 2)
    private ArrayList<String> options;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ArrayList<Integer> answer;

    public Quiz() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Integer> getAnswer() {
        return answer== null ? new ArrayList<>() : answer;
    }

    public void setAnswer(ArrayList<Integer> answer) {
        this.answer = answer == null ? new ArrayList<>() : answer;
    }
}
