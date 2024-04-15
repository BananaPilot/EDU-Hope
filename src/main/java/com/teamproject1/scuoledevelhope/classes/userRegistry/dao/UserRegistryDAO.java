package com.teamproject1.scuoledevelhope.classes.userRegistry.dao;

import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRegistryDAO extends JpaRepository<UserRegistry, UUID> {
}
