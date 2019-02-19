package pl.fizjogabinet.model.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.fizjogabinet.model.entity.User;
import pl.fizjogabinet.model.repository.UserRepository;
import pl.fizjogabinet.model.service.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.userName");
		}
		if (userService.findByUserName(user.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.userName");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.password");
		}

		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}
	}

	public void validatePasswordChange(Object target, Errors errors) {
		User user = (User) target;
		User userCurrentPassword = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		
		if (!user.getCurrentPassword().equals(userCurrentPassword.getPasswordConfirm())) {
			errors.rejectValue("currentPassword", "Curr.userForm.currentPassword");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.password");
		}

		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}
	}

}
