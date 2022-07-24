package com.example.application.data.endpoint;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Tag(name = "TestSwagger")
@RestController
@RequestMapping("/v1/TestSwagger")
public interface TestSwagger {
    @PostMapping(path = "/testSwagger", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "test swagger", description = "test swagger UI")
    public String testSwagger(@RequestHeader("inputTest") String inputTest);
}
