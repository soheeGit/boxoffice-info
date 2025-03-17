package org.example.springfromscratch.service;

import org.example.springfromscratch.model.dto.MovieDTO;
import org.example.springfromscratch.model.dto.MovieInfoDTO;
import org.example.springfromscratch.model.dto.MovieParam;
import org.example.springfromscratch.model.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MovieService {
    final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> getMovies() throws Exception {
        // yyyymmdd
        LocalDate nowDate = LocalDate.now();
        nowDate = nowDate.minusDays(1);
        String nowDateStr = nowDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        MovieParam param = new MovieParam(nowDateStr);
        return movieRepository.getMovies(param);
    }

    public List<MovieInfoDTO> getMovieInfos() throws Exception {
        return getMovies().stream().map((v) -> {
            try {
                return movieRepository.getMovieInfo(v);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }
}