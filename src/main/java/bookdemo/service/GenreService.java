package bookdemo.service;


import bookdemo.domain.Genre;

import java.util.List;

/**
 * Interface to define methods for book service.
 */
public interface GenreService {

    /**
     * Method to find all genres.
     *
     * @return list of all genres
     */
    List<Genre> findAll();

    /**
     * Method to save single book.
     *
     * @param genre genre to save
     * @return saved instance of genre
     */
    Genre save(Genre genre);

    /**
     * Method to remove genre.
     *
     * @param id id genre to remove
     */
    void delete(int id);

    /**
     * Method to find genre by id.
     *
     * @param id id to look for
     * @return genre with current id
     */
    Genre getOne(int id);

}
