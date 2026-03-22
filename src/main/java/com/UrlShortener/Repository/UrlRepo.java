package com.UrlShortener.Repository;

import com.UrlShortener.Model.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepo extends JpaRepository<UrlModel, Long> {

    Optional<UrlModel> findByShortUrl(String shortUrl);
}
