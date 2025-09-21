package com.authorizen.userauthh.model;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
    USER(Collections.emptySet()),
    ADMIN(
        Set.of(
            Permissions.ADMIN_READ,
            Permissions.ADMIN_CREATE,
            Permissions.ADMIN_UPDATE,
            Permissions.ADMIN_DELETE

        )       
    ),
    MANAGER(
        Set.of(
            Permissions.MANAGER_READ,
            Permissions.MANAGER_CREATE,
            Permissions.MANAGER_UPDATE,
            Permissions.MANAGER_DELETE
        )
    );

    @Getter
    private final Set<Permissions> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = getPermissions() Set<Permissions>
                .stream() Stream<Permissions>
                .map(permissions -> new SimpleGrantedAuthority(permissions.name())) Stream<SimpleGrantedAuthority>
                .toList();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
            return authorities;

    }

}
