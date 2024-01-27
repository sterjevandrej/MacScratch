package spring.listsmicroservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
/*Because "User" is a reserved word, the entity table needs to be renamed */
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    private String username;
    private String name;
    private String surname;

    private String password;
    /*For the feedback form, where users can submit their feedback + whether they are satisfied with the app */
    private String feedback;
    private boolean isSatisfied;

    public User(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.feedback = null;
        this.isSatisfied = true;
    }
}
