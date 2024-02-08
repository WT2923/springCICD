package com.springboottest.SpringBootTest.repository;

import com.springboottest.SpringBootTest.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {

    UserData findByUsername(String username);
}
