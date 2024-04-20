package com.teamproject1.scuoledevelhope.classes.userRegistry.userRegistryDAO;

import com.teamproject1.scuoledevelhope.classes.userRegistry.UserRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistryDAO extends JpaRepository<UserRegistry, Long> {
}
