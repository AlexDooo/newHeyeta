package com.demo.models;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "user_id_generator")
    @GenericGenerator(
            name = "user_id_generator",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "passport_number")
    private String passportNumber;

    public User(String name, Long age, String passportNumber) {
        this.name = name;
        this.age = age;
        this.passportNumber = passportNumber;
    }
}
