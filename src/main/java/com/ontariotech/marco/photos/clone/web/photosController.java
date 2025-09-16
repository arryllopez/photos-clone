package com.ontariotech.marco.photos.clone.web;

//spring looks at all
import com.ontariotech.marco.photos.clone.model.Photo;
import com.ontariotech.marco.photos.clone.service.PhotosService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;

@RestController
public class photosController {

    private final PhotosService photosService;

    public photosController(PhotosService photosService) {
        this.photosService = photosService;
    }

    //no need since converting to a hashmap
    //private List<Photo> photosService = List.of(new Photo ("1", "hello.jpg" ));

    @GetMapping("/")
    public String hello() {
        return "Hello World";

    }

    @GetMapping("/photos")
    public Collection<Photo> get() {
        //get method returns the list of photos
        return photosService.get();
    }

    //getter method to return a specific photo
    //change the GetMapping to the id of the specific photo
    @GetMapping("/photos/{id}")
    public Photo get (@PathVariable String id) {
        Photo photo = photosService.get(id);
        // error catching
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photos {id}")
    public void delete(@PathVariable String id) {
        //photosService.remove()
        Photo photo = photosService.remove(id);
        // error catching
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    //create PostMapping methods next
    @PostMapping("/photos")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        //photosService.put()
        // error catching
        //inline the variable Photos photos =
        return photosService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());

    }

}
