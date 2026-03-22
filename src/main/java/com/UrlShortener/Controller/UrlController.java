package com.UrlShortener.Controller;

import com.UrlShortener.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class UrlController {

    @Autowired
    private UrlService service;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam String url){
        return "http://localhost:8080/"+service.shortenUrl(url);
    }

    @GetMapping("/{shortCode}")
    public String redirect(@PathVariable String shortCode){
        String originalUrl = service.getOriginalUrl(shortCode);
        return originalUrl;
    }
}
