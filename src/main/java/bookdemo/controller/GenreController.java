package bookdemo.controller;


import bookdemo.domain.Genre;
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
 * MVC controller for genre instance.
 */
@Controller
public class GenreController {

    /**
     * Auto created genre service.
     */
    @Autowired
    private GenreService genreService;

    /**
     * Handles request to main genre page.
     *
     * @param model model to use on page
     * @return genre page jsp
     */
    @RequestMapping(value = "genre", method = RequestMethod.GET)
    public String genrePage(Model model) {
        List<Genre> genreList = genreService.findAll();
        model.addAttribute("genreList", genreList);
        return "genre";
    }

    /**
     * Handles request to add new genre.
     *
     * @return genre page jsp
     */
    @RequestMapping(value = "genre/add", method = RequestMethod.POST)
    public String addGenre(@RequestParam("name") String name) {
        if (!name.equals("")) {
            Genre genre = new Genre();
            genre.setName(name);
            genreService.save(genre);
        }
        return "redirect:/genre";
    }

    /**
     * Handles request to delete genre.
     *
     * @param id to define what genre to remove
     * @return genre page jsp
     */
    @RequestMapping(value = "genre/delete/{id}", method = RequestMethod.GET)
    public String deleteGenre(@PathVariable int id) {
        genreService.delete(id);
        return "redirect:/genre";
    }


}
