package com.turkcell.survey.authentication;

import com.turkcell.survey.authentication.model.response.UserOutput;
import com.turkcell.survey.exception.DataNotFoundException;
import com.turkcell.survey.exception.UserAlreadyLoggedException;
import com.turkcell.survey.exception.WrondUserCredentialException;

public interface ILoginService {

	UserOutput login(String username, String password) throws DataNotFoundException, WrondUserCredentialException, UserAlreadyLoggedException;

	void logout();
}
