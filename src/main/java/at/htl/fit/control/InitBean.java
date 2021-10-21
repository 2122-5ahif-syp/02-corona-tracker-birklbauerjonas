package at.htl.fit.control;

import at.htl.fit.entity.Person;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.Instant;

public class InitBean {

    @Inject
    Logger LOG;

    @Inject
    PersonRepository personRepository;

    @Transactional
    public void init(@Observes StartupEvent event) {

        var p1 = new Person("Jonas", "Birklbauer", "jonas@birklbauer.com", "06502440059", Instant.now());

        personRepository.persist(p1);

        LOG.info(personRepository.list("").size());
    }

}
