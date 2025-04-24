package edu.chorn.myproject.model;

/*
    @author chorn
    @project myproject
    @class User
    @version 1.0.0
    @since 08.04.2025 - 17.30
*/

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Document
public class User {

    @Id
    private String id;
    private String name;
    private String code;
    private String description;

    public User(String name, String code, String description) {
        this.name = name;
        this.code = code;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
