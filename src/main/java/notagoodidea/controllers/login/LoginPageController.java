package notagoodidea.controllers.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

    @GetMapping("login")
    public String getView() {
        return "login.html";
    }
}
