package org.example.springfromscratch.controller;

import org.example.springfromscratch.model.dto.MovieDTO;
import org.example.springfromscratch.model.dto.MovieInfoDTO;
import org.example.springfromscratch.service.GeminiService;
import org.example.springfromscratch.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class MovieController {
    final MovieService movieService;
    final GeminiService geminiService;

    public MovieController(MovieService movieService, GeminiService geminiService) {
        this.movieService = movieService;
        this.geminiService = geminiService;
    }

    @GetMapping("/")
    public String index(Model model) throws Exception {
//        List<MovieDTO> movies = movieService.getMovies();
        List<MovieInfoDTO> movies = movieService.getMovieInfos();
        model.addAttribute("movies", movies);
        String prompt = "%s, 앞의 데이터를 바탕으로 영화를 추천하고 그 이유를 작성. no markdown, just plain-text, in korean language".formatted(movies.toString());
        String recommendation = geminiService.callGemini(prompt);
        model.addAttribute("recommendation", recommendation);
        return "index";
    }
}
