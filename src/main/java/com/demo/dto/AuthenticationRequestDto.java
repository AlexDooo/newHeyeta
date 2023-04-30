package com.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class AuthenticationRequestDto {

    private String userName;

    private String password;
}
