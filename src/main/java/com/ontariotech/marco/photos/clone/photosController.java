package com.ontariotech.marco.photos.clone;

//spring looks at all
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class photosController {

    private Map<String, Photo> db = new HashMap<>() {{
        put ("1", new Photo("1" , "hello.jpg"));
    }};

    //no need since converting to a hashmap
    //private List<Photo> db = List.of(new Photo ("1", "hello.jpg" ));

    @GetMapping("/")
    public String hello() {
        return "Hello World";

    }

    @GetMapping("/photos")
    public Collection<Photo> get() {
        //get method returns the list of photos
        return db.values();
    }

    //getter method to return a specific photo
    //change the GetMapping to the id of the specific photo
    @GetMapping("/photos/{id}")
    public Photo get (@PathVariable String id) {
        Photo photo = db.get(id);
        // error catching
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photos {id}")
    public void delete(@PathVariable String id) {
        //get method returns the list of photos
        Photo photo = db.remove(id);
        // error catching
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    //create PostMapping methods next

}
