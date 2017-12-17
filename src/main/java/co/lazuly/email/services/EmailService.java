package co.lazuly.email.services;

import co.lazuly.email.model.Email;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created by boot on 15/12/2017.
 */
@Service
public class EmailService {
    private final MailjetClient mailjet;
    private final String fromEmail;
    private final String fromName;

    @Autowired
    public EmailService(final MailjetClient mailjet,
                        @Value("${mailjet.from.email}") final String fromEmail,
                        @Value("${mailjet.from.name}") final String fromName) {
        this.mailjet = checkNotNull(mailjet);
        this.fromEmail = checkNotNull(fromEmail);
        this.fromName = checkNotNull(fromName);
    }

    public int send(final Email email) {
        JSONArray recipes = new JSONArray();
        email.getTo().forEach(mail -> recipes.put(new JSONObject().put("Email", mail)));
        try {
            MailjetRequest request = new MailjetRequest(com.mailjet.client.resource.Email.resource)
                    .property(com.mailjet.client.resource.Email.FROMNAME, fromName)
                    .property(com.mailjet.client.resource.Email.FROMEMAIL, fromEmail)
                    .property(com.mailjet.client.resource.Email.MJTEMPLATEID, email.getCode())
                    .property(com.mailjet.client.resource.Email.MJTEMPLATELANGUAGE, true)
                    .property(com.mailjet.client.resource.Email.RECIPIENTS, recipes)
                    .property(com.mailjet.client.resource.Email.VARS, email.getPayload());
            MailjetResponse response = mailjet.post(request);
            return response.getCount();
        } catch (Exception e) {
            return 0;
        }
    }
}
