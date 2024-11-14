package com.codecool.model;

public enum BaseUrls{
    HOMEPAGE ("http://localhost:3000/"),
    LOGIN ("http://localhost:3000/login"),
    SIGN_UP ("http://localhost:3000/register"),
    ALL_QUIZZES ("http://localhost:3000/quiz/all"),
    MY_QUIZZES ("http://localhost:3000/quiz/my");


    private final String url;

    BaseUrls(String string) {
        this.url = string;
    }

    public String getUrl() {
        return url;
    }
}
