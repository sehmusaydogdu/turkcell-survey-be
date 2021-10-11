package com.turkcell.survey.authentication;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turkcell.survey.authentication.model.User;
import com.turkcell.survey.authentication.model.UserType;
import com.turkcell.survey.authentication.model.response.UserOutput;
import com.turkcell.survey.exception.DataNotFoundException;
import com.turkcell.survey.exception.UserAlreadyLoggedException;
import com.turkcell.survey.exception.WrondUserCredentialException;
import com.turkcell.survey.model.AuditLog;
import com.turkcell.survey.repository.IUserRepository;
import com.turkcell.survey.service.IAuditLogService;
import com.turkcell.survey.util.PropertyKeys;

@Service
public class LoginService implements ILoginService {

	@Autowired
	private IUserRepository repository;

	@Autowired
	private IAuditLogService auditService;

	@Autowired
	private HttpSession session;

	@Autowired
	private PropertyKeys propertyKeys;

	@Override
	public UserOutput login(String username, String password)
			throws DataNotFoundException, WrondUserCredentialException, UserAlreadyLoggedException {

		User user = repository.findByUserName(username);
		checkAlreadyUserExists(user);
		checkUserRegistered(user);
		checkUserPassword(user, password);

		Long userId = user.getUserId();
		String name = user.getUserInfo().getName();
		UserType userType = user.getUserInfo().getUserType();

		UserOutput userOutput = UserOutput.builder().userId(userId).name(name).userType(userType).build();
		setUserSession(userOutput);

		saveAuditLog(userId, name);

		return userOutput;
	}

	@Override
	public void logout() {
		session.removeAttribute(propertyKeys.getUserSession());
	}

	private void checkAlreadyUserExists(User user) throws UserAlreadyLoggedException {
		UserOutput userOutput = (UserOutput) session.getAttribute(propertyKeys.getUserSession());
		if (!Optional.ofNullable(userOutput).isEmpty() && user.getUserId().compareTo(userOutput.getUserId()) == 0) {
			throw new UserAlreadyLoggedException(
					"Kullanıcı sisteme daha önceden giriş yapmıştır. Oturum kapatıp, yeniden deneyin");
		}
	}

	private void checkUserRegistered(User user) throws DataNotFoundException {
		if (!Optional.ofNullable(user).isPresent())
			throw new DataNotFoundException("Sistemde kayıtlı kullanıcı bulunamadı.");
	}

	private void checkUserPassword(User user, String password) throws WrondUserCredentialException {
		if (!user.getPassword().equals(password))
			throw new WrondUserCredentialException(
					"Kullanıcı bilgileri hatalıdır. Lütfen kontrol edip, tekrar deneyiniz.");
	}

	private void setUserSession(UserOutput userOutput) {
		session.setAttribute(propertyKeys.getUserSession(), userOutput);
	}

	private void saveAuditLog(Long userId, String name) {
		AuditLog model = new AuditLog();
		model.setName(name);
		model.setUserId(userId);
		model.setLoginDate(new Date());
		auditService.saveAuditLog(model);
	}
}
