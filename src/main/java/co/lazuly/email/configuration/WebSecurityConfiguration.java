package co.lazuly.email.configuration;

import co.lazuly.email.filters.SecretFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.Filter;

/**
 * Created by boot on 14/12/2017.
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Value("${app.secret}")
    private String secret;

    @Bean
    public Filter secretFilter() {
        SecretFilter secretFilter = new SecretFilter(secret);
        return secretFilter;
    }

    @Bean
    public FilterRegistrationBean secretFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(secretFilter());
        return registration;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll()
        .and().csrf().disable();
    }

}
