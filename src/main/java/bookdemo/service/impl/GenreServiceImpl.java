package bookdemo.service.impl;


import bookdemo.domain.Genre;
import bookdemo.repository.GenreRepository;
import bookdemo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *Implementation of genre service interface.
 */
@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    /**
     * Auto created instance of genre repository.
     */
    @Autowired
    private GenreRepository genreRepository;

    /**
     * Method to find all genres.
     *
     * @return list of all genres
     */
    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    /**
     * Method to save single book.
     *
     * @param genre genre to save
     * @return saved instance of genre
     */
    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    /**
     * Method to remove genre.
     *
     * @param id id genre to remove
     */
    @Override
    public void delete(int id) {
        genreRepository.delete(id);
    }

    /**
     * Method to find genre by id.
     *
     * @param id id to look for
     * @return genre with current id
     */
    @Override
    public Genre getOne(int id) {
        return genreRepository.getOne(id);
    }

}
