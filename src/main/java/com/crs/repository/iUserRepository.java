package com.crs.repository;

import com.crs.model.user;

public interface iUserRepository {
    user findByEmailAndPassword(String email, String password);
}
