package com.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors(chain = true)
public class UserDto {

    private Long id;

    private String name;

    private Long age;

    private String passportNumber;
}
