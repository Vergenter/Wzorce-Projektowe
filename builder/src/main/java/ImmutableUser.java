import java.util.Date;
import jdk.nashorn.internal.ir.annotations.Immutable;

@Immutable
public class ImmutableUser {
    public final String login;
    public final String password;
    public final String name;
    public final String surname;
    public final String phone;
    public final String email;
    public final String country;
    public final Date dateOfBirth;

    private ImmutableUser(String login, String password, String name, String surname, String phone, String email, String country, Date dateOfBirth) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
    }

    public static final class Builder {
        private String login;
        private String password;
        private String name;
        private String surname;
        private String phone;
        private String email;
        private String country;
        private Date dateOfBirth;

        public Builder() {
        }

        public ImmutableUser.Builder login(String login) {
            this.login = login;
            return this;
        }

        public ImmutableUser.Builder password(String password) {
            this.password = password;
            return this;
        }

        public ImmutableUser.Builder name(String name) {
            this.name = name;
            return this;
        }

        public ImmutableUser.Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public ImmutableUser.Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public ImmutableUser.Builder email(String email) {
            this.email = email;
            return this;
        }

        public ImmutableUser.Builder country(String country) {
            this.country = country;
            return this;
        }

        public ImmutableUser.Builder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public ImmutableUser build() {
            return new ImmutableUser(this.login, this.password, this.name, this.surname, this.phone, this.email, this.country, this.dateOfBirth);
        }
    }
}
