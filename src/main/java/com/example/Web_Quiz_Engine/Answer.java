package com.example.Web_Quiz_Engine;

public class Answer {
    private boolean success;
    private String feedback;

    public Answer() {
    }

    public Answer(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    public static Answer getAnswer(String numberr) {
        return new Answer(true,"Congratulations, you're right!");
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
