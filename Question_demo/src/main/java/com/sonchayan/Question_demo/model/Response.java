package com.sonchayan.Question_demo.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
    private Integer id;
    private String response;
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}