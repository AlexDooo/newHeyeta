package com.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
public class UserDto {

    private UUID id;

    private String name;

    private Long age;

    private String passportNumber;
}
