package controller;

import java.util.List;

import domain.Person;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.core.Response.Status;
import services.interfaces.PersonService;

@Path("/People")
@Stateless
public class PersonController {

    @Inject
    private PersonService personService;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Person> getPeople() {
        System.out.println("Entro" );
        return personService.getAllPersons();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Person getPerson(@PathParam("id") int id) {
        System.out.println("Entro" );
        return personService.getPersonById(new Person((long) id));
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addPerson(Person person) {
        System.out.println("Entro post: " + person.getId() + " " + person.getLastname() );
        try {
            personService.addPerson(person);
            return Response.ok().entity(person).build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response updatePerson(@PathParam("id") int id, Person personModified) {
        System.out.println("Entro" + id + " " + personModified.getLastname());
        try {
            Person persona = personService.getPersonById(new Person((long) id));
            if (persona != null) {
                personService.updatePerson(personModified);
                return Response.ok().entity(personModified).build();
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deletePerson(@PathParam("id") int id) {
        try {
            personService.deletePerson(new Person((long) id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }

}
