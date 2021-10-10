package org.melek.producer.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class DeclanController {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/whoTheHellAreYou",
            produces = "application/json")
    @ResponseBody()
    String whoTheHellAreYou(@RequestParam(name = "youKnow") String parameter) {
        return parameter.contains("say my name") ? "Heisenberg" : "Who the hell are you!" ;
    }
}


