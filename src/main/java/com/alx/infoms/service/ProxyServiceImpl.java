package com.alx.infoms.service;

import com.alx.infoms.dto.BaseResponseDTO;
import com.alx.infoms.dto.JokeDTO;
import com.alx.infoms.dto.anime.AnimeDTO;
import com.alx.infoms.dto.anime.AnimeWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProxyServiceImpl implements ProxyService {

    RestTemplate restTemplate = new RestTemplate();
    @Value("${url.joke}")
    private String urlJoke;

    @Value("${url.anime}")
    private String urlAnime;


    @Override
    public JokeDTO[] fetchJokes() {
        ResponseEntity<JokeDTO[]> response = restTemplate.getForEntity(urlJoke,JokeDTO[].class);
        return response.getBody();
    }

    @Override
    public AnimeWrapper fetchAnime() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.api+json");
        headers.set("Content-Type", "application/vnd.api+json");
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<AnimeWrapper> response = restTemplate.exchange(
                urlAnime,
                HttpMethod.GET,
                requestEntity, AnimeWrapper.class);
        return response.getBody();
    }
}
