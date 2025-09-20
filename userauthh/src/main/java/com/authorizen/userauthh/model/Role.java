package com.authorizen.userauthh.model;

import java.util.Collections;
import java.util.Set;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {
    USER(Collections.emptySet()),
    ADMIN(
        Set.of(
            permissions.ADMIN_READ,
            permissions.ADMIN_CREATE,
            permissions.ADMIN_UPDATE,
            permissions.ADMIN_DELETE

        )       
    ),
    MANAGER(
        Set.of(
            permissions.MANAGER_READ,
            permissions.MANAGER_CREATE,
            permissions.MANAGER_UPDATE,
            permissions.MANAGER_DELETE
        )
    );

    @Getter
    private final Set<Permissions> permissions;

}
