package com.encurtadorurlk.link.controller;

import com.encurtadorurlk.link.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shorten")
@RequiredArgsConstructor
public class UrlController {

    private final UrlService service;

    @PostMapping
    public ResponseEntity<String> encurtar(@RequestParam String urlRequest){
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(service.encurtadorDeURL(urlRequest));
    }
    @GetMapping("/link/{*shortUrl}")
    public ResponseEntity<String> carregarUrl(@PathVariable String shortUrl){
        String url = shortUrl.substring(1);
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(service.searchUrl(url));
    }
}
