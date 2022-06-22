package com.demo;

import com.demo.domain.Person;
import com.demo.repository.PersonRepository;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/person")
public class PersonResource {


    @Inject
    PersonRepository personRepository;

    @GET
    public Uni<Person> getPerson() {
        return personRepository.findById(1L);
    }

    @POST
    public Uni<Person> createPerson(Person person) {
        System.out.println("createPerson " + person.toString());

        return personRepository.persist(person);
    }
}