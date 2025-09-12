package com.ontariotech.marco.photos.clone;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DownloadController {

    @GetMapping("/donwload/{id}")
    //we want to send raw bytes back to the browser
    //using ResponseEntity to wrap the bytes
    public ResponseEntity<byte[]> download(@PathVariable String id) {
        byte[] data;
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}
