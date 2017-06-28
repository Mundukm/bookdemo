package bookdemo.service.impl;


import bookdemo.domain.Book;
import bookdemo.repository.BookRepository;
import bookdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of book service interface.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    /**
     * Auto created instance of book repository.
     */
    @Autowired
    private BookRepository bookRepository;

    /**
     * Method to save single book.
     *
     * @param book book to save
     * @return saved instance of book
     */
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    /**
     * Method to find all books.
     *
     * @return list of all books
     */
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * Method to remove book.
     *
     * @param id id book to remove
     */
    @Override
    public void delete(int id) {
        bookRepository.delete(id);
    }

    /**
     * Method to find book by id.
     *
     * @param id id to look for
     * @return book with current id
     */
    @Override
    public Book getOne(int id) {
        return bookRepository.getOne(id);
    }

}
