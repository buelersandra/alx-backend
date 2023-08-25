package com.alx.infoms.service;

import com.alx.infoms.dto.JokeDTO;
import com.alx.infoms.dto.anime.AnimeDTO;
import com.alx.infoms.dto.anime.AnimeWrapper;
import org.springframework.http.ResponseEntity;

public interface ProxyService {

    JokeDTO[] fetchJokes();

    AnimeWrapper fetchAnime();
}
