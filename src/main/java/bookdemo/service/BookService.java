package bookdemo.service;

import bookdemo.domain.Book;

import java.util.List;

/**
 * Interface to define methods for book service.
 */
public interface BookService {

    /**
     * Method to save single book.
     *
     * @param book book to save
     * @return saved instance of book
     */
    Book save(Book book);

    /**
     * Method to find all books.
     *
     * @return list of all books
     */
    List<Book> findAll();

    /**
     * Method to remove book.
     *
     * @param id id book to remove
     */
    void delete(int id);

    /**
     * Method to find book by id.
     *
     * @param id id to look for
     * @return book with current id
     */
    Book getOne(int id);

}
