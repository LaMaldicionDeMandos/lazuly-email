package co.lazuly.email.model;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by boot on 15/12/2017.
 */
public class Email {
    private final String code;
    private final List<String> to;
    private final Map<String, String> payload;

    Email() {
        code = null;
        to = null;
        payload = null;
    }

    public Email(final String code, final String to, Map<String, String> payload) {
        this(code, asList(to), payload);
    }

    public Email(final String code, final List<String> to, Map<String, String> payload) {
        this.code = code;
        this.to = to;
        this.payload = payload;
    }

    public String getCode() {
        return code;
    }

    public List<String> getTo() {
        return to;
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        if (code != null ? !code.equals(email.code) : email.code != null) return false;
        if (to != null ? !to.equals(email.to) : email.to != null) return false;
        return payload != null ? payload.equals(email.payload) : email.payload == null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (payload != null ? payload.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Email{" +
                "code='" + code + '\'' +
                ", to=" + to +
                ", payload=" + payload +
                '}';
    }
}
