package com.techmaster.authen.repository;

import com.techmaster.authen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
}
