package com.ontariotech.marco.photos.clone;

//spring looks at all
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class photosController {

    private List<Photo> db = List.of(new Photo ("1", "hello.jpg" ));

    @GetMapping("/")
    public String hello() {
        return "Hello World";

    }

    @GetMapping("/photos")
    public List<Photo> get() {

    }
}
