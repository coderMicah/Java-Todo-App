package com.micah.todoApp.login;

import org.springframework.beans.factory.annotation.Autowired;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {

    @Autowired
    private AuthenticationService authenticationService;

    // private Logger logger = LoggerFactory.getLogger(getClass());

    // when user enters /login return a login form
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goToLoginPage() {

        return "login";
    }

    // track the login form with method POST and redirect user to welcome page
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

        // authenticate the user b4 redirecting to welcome page
        if (authenticationService.authenticate(name, password)) {
        
            model.put("name", name);

            return "welcome";
        }

        model.put("errorMessage", "Invalid Credentials");
        return "login";
    }

    // @RequestMapping("/login")
    // public String login(@RequestParam String name, @RequestParam String email,
    // ModelMap model) {
    // model.put("name", name);
    // model.put("email", email);

    // // System.out.println("Request parama name is " + name); // NOT RECOMMENDED
    // FOR
    // // PROD CODE USE LOGGER
    // // logger.debug("Request parama name is {}", name); //RECOMMENDED APPROACH IS
    // TO
    // // USE LOGGER
    // return "login";
    // }

}
