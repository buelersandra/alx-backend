package com.alx.infoms.dto.anime;

import lombok.Data;

import java.util.List;

@Data
public class AnimeWrapper {
    private List<AnimeDTO> data;
}
