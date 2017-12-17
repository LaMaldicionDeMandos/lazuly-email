package co.lazuly.email.resources;

import co.lazuly.email.model.Email;
import co.lazuly.email.services.EmailService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by boot on 14/12/2017.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class EmailResource {
    private final EmailService service;

    @Autowired
    public EmailResource(final EmailService service) {
        this.service = service;
    }

    /**
     * @return Devuelve los emails que fallaron
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<Integer> send(@RequestBody final Email email) {
        return ResponseEntity.ok(service.send(email));
    }
}
