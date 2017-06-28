package bookdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Core servlet controller class.
 *
 * @author Myndyk Mykola
 * @version 1.0
 * @since 24.06.2017
 */
@Controller
public class CoreController {

    /**
     * Handles request to welcome page
     *
     * @return index jps page
     */
    @GetMapping("/")
    public String onIndex() {
        return "index";
    }

}
