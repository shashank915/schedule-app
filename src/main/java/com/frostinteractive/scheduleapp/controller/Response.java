package com.frostinteractive.scheduleapp.controller;

import lombok.Data;

@Data
public class Response {
    private String responseMsg;
    public Response(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}
