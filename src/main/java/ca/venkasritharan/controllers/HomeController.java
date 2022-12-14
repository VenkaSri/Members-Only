package ca.venkasritharan.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    @GetMapping(value = {"/", "/index"})
    public String index() {
        log.trace("Index() called");
        return "index";
    }
}
