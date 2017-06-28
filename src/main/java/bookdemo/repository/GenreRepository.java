package bookdemo.repository;


import bookdemo.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Implementation of Jpa repository to minimize work with database.
 */
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
