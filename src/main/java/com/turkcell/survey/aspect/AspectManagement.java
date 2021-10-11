package com.turkcell.survey.aspect;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.turkcell.survey.authentication.model.UserType;
import com.turkcell.survey.authentication.model.response.UserOutput;
import com.turkcell.survey.model.response.ApiResponse;
import com.turkcell.survey.util.PropertyKeys;

@Aspect
@Component
public class AspectManagement {

	@Autowired
	private HttpSession session;

	@Autowired
	private PropertyKeys propertyKeys;

	@Around("@annotation(com.turkcell.survey.aspect.EnableSecurity)")
	public Object aroud(ProceedingJoinPoint joinPoint) throws Throwable {

		UserOutput user = (UserOutput) session.getAttribute(propertyKeys.getUserSession());

		if (!user.getUserType().equals(UserType.ADMIN_USER)) {
			ApiResponse<String> response = new ApiResponse<>();
			response.setMessage("İşlem yapmaya yetkili değildir.");
			return response;
		}
		return joinPoint.proceed();
	}
}
