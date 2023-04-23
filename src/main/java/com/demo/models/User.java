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

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_age")
    private Long userAge;

    @Column(name = "passport_number")
    private String passportNumber;
}
