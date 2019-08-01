package com.icaballero.javatest.movies.services;

import com.icaballero.javatest.movies.data.MovieRepository;
import com.icaballero.javatest.movies.model.Genre;
import com.icaballero.javatest.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {
    MovieService movieService;

    @Before
    public void setUp() throws Exception {

        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAlll()).thenReturn(Arrays.asList(new Movie(1,"id1",130,Genre.COMEDY), new Movie(2,"id2",110,Genre.ACTION), new Movie(3,"id3",90,Genre.COMEDY)));

         movieService = new MovieService(movieRepository);
    }



    @Test
    public void return_movies_by_genre() {



        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertThat(getId(movies), CoreMatchers.is(Arrays.asList(1, 3)));

    }


    @Test
    public void return_movies_by_duration() {

        Collection<Movie> movies = movieService.findMoviesByDuration(120);
        assertThat(getId(movies), CoreMatchers.is(Arrays.asList(2, 3)));
    }

    private List<Integer> getId(Collection<Movie> movies) {
        return movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
    }
}