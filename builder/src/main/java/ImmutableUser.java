import java.util.Date;

public class ImmutableUser {
    public final String login;
    public final String password;
    public final String name;
    public final String surname;
    public final String phone;
    public final String email;
    public final String country;
    public final Date dateOfBirth;
    private ImmutableUser(
            String login,
            String password,
            String name,
            String surname,
            String phone,
            String email,
            String country,
            Date dateOfBirth
    ){
        this.login=login;
        this.password=password;
        this.name=name;
        this.surname=surname;
        this.phone=phone;
        this.email=email;
        this.country=country;
        this.dateOfBirth=dateOfBirth;
    }

}
