package com.example.PP_3_1_2_SpringBoot.repositories;

import com.example.PP_3_1_2_SpringBoot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
