package pl.fizjogabinet.controller;

import java.util.Collection;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.fizjogabinet.model.entity.Therapist;
import pl.fizjogabinet.model.entity.User;
import pl.fizjogabinet.model.repository.TherapistRepository;
import pl.fizjogabinet.model.service.SecurityService;
import pl.fizjogabinet.model.service.UserService;
import pl.fizjogabinet.model.validator.UserValidator;

@Controller
public class LoginController {
	
	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private TherapistRepository therapistRepository;
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/homepage";
    }
	
	@RequestMapping(path="/") 
	public String welcomePage() {
		return "loginpage";
	} 
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout) {
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged out successfully");
		}
		model.setViewName("loginpage");
		return model;
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute("passwordForm") User passwordForm, BindingResult bindingResult, Model model) {
        userValidator.validatePasswordChange(passwordForm, bindingResult);
        if (bindingResult.hasErrors()) {
        	model.addAttribute("therapists", therapistRepository.findByActiveTherapists());
            return "controlpanel";
        }
        userService.changePassword(passwordForm);
        return "redirect:/controlpanel";
	}
	
	@RequestMapping("/homepage")
	public String homepage(Model model) {
		String test = securityService.findLoggedInUserName();
		System.out.println(test);
//		Authentication atuthentication = SecurityContextHolder.getContext().getAuthentication();
//		System.out.println(authentication.getName());
//		System.out.println(authentication.getAuthorities());
//		System.out.println(authentication.getDetails());
//		System.out.println(authentication.getCredentials());
//		System.out.println(authentication.getPrincipal());	
		return "homepage";
	}


}
