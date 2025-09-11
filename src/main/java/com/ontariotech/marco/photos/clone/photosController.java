package com.ontariotech.marco.photos.clone;

//spring looks at all
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
        //db.remove()
        Photo photo = db.remove(id);
        // error catching
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    //create PostMapping methods next
    @PostMapping("/photos")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(file.getOriginalFilename());
        photo.setData(file.getBytes());
        //db.put()
        db.put(photo.getId(), photo);
        // error catching
        return photo;

    }

}
