package com.ontariotech.marco.photos.clone;

//spring looks at all
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class photosController {

    @GetMapping("/")
    public String hello() {
        return "Hello World";

    }
}
