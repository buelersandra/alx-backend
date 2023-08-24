package com.alx.infoms.repository;

import com.alx.infoms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
     User findByEmailAddress(String emailAddress);
}
