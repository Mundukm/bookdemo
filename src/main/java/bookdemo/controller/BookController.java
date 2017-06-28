package bookdemo.controller;


import bookdemo.domain.Book;
import bookdemo.domain.Genre;
import bookdemo.service.BookService;
import bookdemo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * MVC controller for book instance.
 */
@Controller
public class BookController {

    /**
     * Auto created book service.
     */
    @Autowired
    private BookService bookService;

    /**
     * Auto created genre service.
     */
    @Autowired
    private GenreService genreService;

    /**
     * Handles request to main book page.
     *
     * @param model model to use on page
     * @return book page jsp
     */
    @RequestMapping(value = "book", method = RequestMethod.GET)
    public String bookPage(Model model) {
        List<Book> bookList = bookService.findAll();
        List<Genre> genreList = genreService.findAll();
        model.addAttribute("bookList", bookList);
        model.addAttribute("genreList", genreList);
        return "book";
    }

    /**
     * Handles request to add new book.
     *
     * @return book page jsp
     */
    @RequestMapping(value = "book/add", method = RequestMethod.POST)
    public String addBook(@RequestParam("name") String name, @RequestParam("genreId") String genreId) {
        if (!name.equals("")) {
            Book book = new Book();
            book.setName(name);
            Genre genre = genreService.getOne(Integer.parseInt(genreId));
            book.setGenre(genre);
            bookService.save(book);
        }
        return "redirect:/book";
    }

    /**
     * Handles request to delete book.
     *
     * @param id to define what book to remove
     * @return book page jsp
     */
    @RequestMapping(value = "book/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable int id) {

        bookService.delete(id);

        return "redirect:/book";
    }

}
