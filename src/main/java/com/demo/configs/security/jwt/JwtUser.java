package com.demo.configs.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;

public class JwtUser implements UserDetails {

    private final Long id;
    private final String userName;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final boolean enabled;
    private final LocalDateTime lastResetPassword;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(Long id,
                   String userName,
                   String firstName,
                   String lastName,
                   String password,
                   boolean enabled,
                   LocalDateTime lastResetPassword,
                   Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.enabled = enabled;
        this.lastResetPassword = lastResetPassword;
        this.authorities = authorities;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @JsonIgnore
    public LocalDateTime getLastResetPassword() {
        return lastResetPassword;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
