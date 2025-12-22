package com.example.BankApplication.registration.repository;

import com.example.BankApplication.registration.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer>
{

    boolean existsByUserName(String userName);
    User findByUserName(String userName);

}
