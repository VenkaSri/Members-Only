package ca.venkasritharan.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/cat")
public class CatController {

    @GetMapping(value = {"/index"})
    public String catIndex() {
        log.trace("CatIndex() called");
        return "cat/index";
    }
}
