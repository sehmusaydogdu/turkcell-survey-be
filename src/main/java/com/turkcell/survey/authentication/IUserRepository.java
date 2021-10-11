package com.turkcell.survey.authentication;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.survey.authentication.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {

	User findByUserName(String username);
}
