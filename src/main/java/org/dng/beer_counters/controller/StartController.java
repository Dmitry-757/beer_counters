package org.dng.beer_counters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
    private final String prefixUrl = "/";
    @GetMapping(prefixUrl)
    public String showStartPage(){
        return "start";
    }

}
