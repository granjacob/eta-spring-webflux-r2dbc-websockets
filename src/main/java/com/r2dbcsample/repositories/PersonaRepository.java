package com.r2dbcsample.repositories;

import com.r2dbcsample.model.PersonaR2dbc;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonaRepository extends R2dbcRepository<PersonaR2dbc, UUID> {

}
