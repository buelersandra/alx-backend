package com.alx.infoms.controller;

import com.alx.infoms.common.ApiPaths;
import com.alx.infoms.dto.JokeDTO;
import com.alx.infoms.dto.anime.AnimeDTO;
import com.alx.infoms.dto.anime.AnimeWrapper;
import com.alx.infoms.service.ProxyService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPaths.VERSION)
public class ProxyController {

    @Autowired
    ProxyService proxyService;

    @Operation(summary = "Get Jokes")
    @GetMapping(value =  "/jokes")
    public JokeDTO[] getJokes()  {

        return proxyService.fetchJokes();
    }

    @Operation(summary = "Get Anime")
    @GetMapping(value =  "/anime")
    public AnimeWrapper getAnime()  {
        return proxyService.fetchAnime();
    }
}
