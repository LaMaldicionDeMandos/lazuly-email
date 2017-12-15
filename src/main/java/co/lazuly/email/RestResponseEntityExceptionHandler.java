package co.lazuly.email;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import javax.security.sasl.AuthenticationException;

/**
 * Created by boot on 14/12/2017.
 */
@Controller
public class RestResponseEntityExceptionHandler extends DefaultHandlerExceptionResolver {
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    protected void handleUnauthorized(AuthenticationException ex) {
    }
}
