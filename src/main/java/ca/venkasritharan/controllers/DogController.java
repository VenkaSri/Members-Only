package ca.venkasritharan.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/dog")
public class DogController {

    @GetMapping(value = {"/index"})
    public String dogIndex() {
        log.trace("dogIndex() called");
        return "dog/index";
    }
}
