package pl.fizjogabinet.controller;

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

import pl.fizjogabinet.entity.User;
import pl.fizjogabinet.service.SecurityService;
import pl.fizjogabinet.service.UserService;
import pl.fizjogabinet.validator.UserValidator;

@Controller
public class LoginController {
	
	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
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
//  @RequestMapping(value = "/login", method = RequestMethod.GET)
//  public String login(Model model, String error, String logout) {
//  	if (error != null)
//          model.addAttribute("error", "Your username and password is invalid.");
//
//      if (logout != null)
//          model.addAttribute("message", "You have been logged out successfully.");
//
//      return "login";
//  }
//
//  @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
//  public String welcome(Model model) {
//      return "welcome";
//  }

}
