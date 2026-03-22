package com.UrlShortener.Service;

import com.UrlShortener.Model.UrlModel;
import com.UrlShortener.Repository.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlRepo repo;

    public String shortenUrl(String originalUrl) {
        String shortCode = generateShortCode();

        UrlModel model = new UrlModel(originalUrl, shortCode);
        repo.save(model);
        return shortCode;

    }



    private String generateShortCode(){
        String pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for(int i =0; i<6; i++){
            sb.append(pattern.charAt(random.nextInt(pattern.length())));
        }
        return sb.toString();
    }

    public String getOriginalUrl(String shortCode) {

        return repo.findByShortUrl(shortCode)
                .map(UrlModel::getOriginalUrl)
                .orElseThrow(() -> new RuntimeException("URL not found"));
    }
}
