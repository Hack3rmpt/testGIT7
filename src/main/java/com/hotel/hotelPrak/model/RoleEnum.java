package com.hotel.hotelPrak.model;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {
    USER, ADMIN, HOUSEKEEPER;

    @Override
    public String getAuthority() {
        return name();
    }
}