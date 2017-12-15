package co.lazuly.email.filters;

import org.springframework.web.filter.GenericFilterBean;

import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by boot on 14/12/2017.
 */
public class SecretFilter extends GenericFilterBean {
    private final static String SECRET_HEADER = "X-Authorization-Secret";

    private final String secret;

    public SecretFilter(final String secret) {
        this.secret = secret;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        RequestWrapper request = new RequestWrapper((HttpServletRequest) req);
        HttpServletResponse response = (HttpServletResponse) res;

        if (shouldDoFilter(request)) {
            doFilter(request);
        }

        chain.doFilter(request, response);
    }

    private boolean shouldDoFilter(final RequestWrapper request) {
        return true;
    }

    private void doFilter(final RequestWrapper request) throws AuthenticationException {
        String header = request.getHeader(SECRET_HEADER);

        if (!secret.equals(header)) {
            throw new AuthenticationException("Invalid secret.");
        }
    }

}
