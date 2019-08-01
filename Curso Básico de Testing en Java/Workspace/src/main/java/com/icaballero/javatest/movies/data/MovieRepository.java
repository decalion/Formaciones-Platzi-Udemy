package com.icaballero.javatest.movies.data;

import com.icaballero.javatest.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {

    Movie findById(long id);
    Collection<Movie> findAlll();
    void saveOrUpdate(Movie movie);


}
