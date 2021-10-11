package com.turkcell.survey.authentication;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.survey.authentication.model.UserInfo;

public interface IUserInfoRepository extends JpaRepository<UserInfo, Long> {

}
