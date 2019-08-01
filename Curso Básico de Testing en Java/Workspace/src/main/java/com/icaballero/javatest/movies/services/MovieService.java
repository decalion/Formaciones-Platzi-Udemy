package com.icaballero.javatest.movies.services;

import com.icaballero.javatest.movies.data.MovieRepository;
import com.icaballero.javatest.movies.model.Genre;
import com.icaballero.javatest.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {


        return movieRepository.findAlll().stream().filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByDuration(int duration) {

        return movieRepository.findAlll().stream().filter(movie -> movie.getMinutes() <= duration).collect(Collectors.toList());
    }
}
