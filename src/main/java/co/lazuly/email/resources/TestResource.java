package co.lazuly.email.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by boot on 14/12/2017.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class TestResource {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<String> test() {
        return ResponseEntity.ok("Joya!!");
    }
}
