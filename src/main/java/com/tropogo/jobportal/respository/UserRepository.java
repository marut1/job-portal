package com.tropogo.jobportal.respository;

import com.tropogo.jobportal.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserAccount, UUID> {

    UserAccount findByEmail(String email);
}
