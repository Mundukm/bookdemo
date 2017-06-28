package bookdemo.repository;


import bookdemo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Implementation of Jpa repository to minimize work with database.
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
}
