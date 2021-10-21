package at.htl.fit.boundary;

import at.htl.fit.control.PersonRepository;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/person")
public class PersonEndpoint {

    @Inject
    PersonRepository personRepository;

    @Inject
    Logger LOG;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addPerson(
            @FormParam("firstName") String firstName,
            @FormParam("lastName") String lastName,
            @FormParam("email") String email,
            @FormParam("phoneNumber") String phoneNumber
    ) {
        personRepository.add(firstName, lastName, email, phoneNumber);

        LOG.info("added new person");

        return Response.ok().build();
    }
}
