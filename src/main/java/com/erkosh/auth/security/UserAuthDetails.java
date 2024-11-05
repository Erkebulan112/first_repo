package com.erkosh.auth.security;

import com.erkosh.dto.UserAuthDTO;
import com.erkosh.entities.UserAuthEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserAuthDetails implements UserDetails {

    private final UserAuthEntity userAuthEntity;

    public UserAuthDetails(UserAuthEntity userAuthEntity) {
        this.userAuthEntity = userAuthEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return userAuthEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userAuthEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
