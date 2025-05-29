package com.r2dbcsample.services;


import com.r2dbcsample.model.PersonaR2dbc;
import com.r2dbcsample.repositories.PersonaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.util.UUID;

@Service
public class PersonaService {
    private final PersonaRepository repository;
    private final Sinks.Many<String> sink;

    public PersonaService(PersonaRepository repository) {
        this.repository = repository;
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public Mono<PersonaR2dbc> save(PersonaR2dbc persona) {
        return repository.save(persona)
                .doOnSuccess(p -> sink.tryEmitNext("persona-updated"));
    }


    public Mono<PersonaR2dbc> create(PersonaR2dbc persona) {
        return repository.save(persona)
                .doOnSuccess(p -> sink.tryEmitNext("persona-updated"));
    }

    public Mono<PersonaR2dbc> update(UUID id, PersonaR2dbc persona) {
        return repository.findById(id)
                .flatMap(existing -> {
                    existing.setName(persona.getName());
                    existing.setLastname(persona.getLastname());
                    existing.setAddress(persona.getAddress());
                    return repository.save(existing);
                })
                .doOnSuccess(p -> sink.tryEmitNext("persona-updated"));
    }

    public Mono<Void> delete(UUID id) {
        return repository.deleteById(id)
                .doOnSuccess(v -> sink.tryEmitNext("persona-updated"));
    }

    public Flux<PersonaR2dbc> findAll() {
        return repository.findAll();
    }

    public Flux<String> getUpdates() {
        return sink.asFlux();
    }
}