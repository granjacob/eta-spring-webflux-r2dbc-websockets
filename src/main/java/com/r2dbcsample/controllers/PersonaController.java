package com.r2dbcsample.controllers;

import com.r2dbcsample.model.PersonaR2dbc;
import com.r2dbcsample.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public Flux<PersonaR2dbc> getAllPersonas() {
        return personaService.findAll();
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public Mono<PersonaR2dbc> postPersona(@RequestBody PersonaR2dbc persona ) {
        return personaService.save( persona );
    }


    @GetMapping("/world")
    public Flux<String> getCadenas()
    {
        return Flux.just("hello", "world");
    }
}
