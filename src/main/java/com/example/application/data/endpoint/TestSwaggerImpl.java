package com.example.application.data.endpoint;

import java.time.Instant;

public class TestSwaggerImpl implements TestSwagger {
    @Override
    public String testSwagger(String inputTest) {
        return inputTest + " -- " + Instant.now();
    }
}
