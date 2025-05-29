package com.r2dbcsample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("persona")
public class PersonaR2dbc  {

    @Id
    private UUID id;
    String name;
    String lastname;
    String address;

    public PersonaR2dbc() {
        //this.id = UUID.randomUUID();
    }

    public PersonaR2dbc(String name, String lastname, String address) {

        this.name = name;
        this.lastname = lastname;
        this.address = address;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
