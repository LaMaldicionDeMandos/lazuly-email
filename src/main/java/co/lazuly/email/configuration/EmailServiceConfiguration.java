package co.lazuly.email.configuration;

import com.mailjet.client.MailjetClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by boot on 09/11/2017.
 */
@Configuration
public class EmailServiceConfiguration {

    @Value("${mailjet.apiKey}")
    private String apiKey;

    @Value("${mailjet.secret}")
    private String secret;

    @Bean
    public MailjetClient mailjetClient() {
        MailjetClient client = new MailjetClient(apiKey, secret);
        return client;
    }
}
