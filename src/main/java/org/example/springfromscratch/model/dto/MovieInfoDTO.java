package org.example.springfromscratch.model.dto;

import java.util.List;

public record MovieInfoDTO(MovieDTO movieDTO, List<String> nations, List<String> genres, List<String> directors, List<String> actors, long time) { }