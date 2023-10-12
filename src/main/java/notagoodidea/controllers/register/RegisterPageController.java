package notagoodidea.register;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import notagoodidea.utils.LogInfoFromPostMethod;


@Controller
public class RegisterPageController {

    @GetMapping(value = "register")
    public String getView() {
        return "register";
    }

    @LogInfoFromPostMethod
    @PostMapping(value = "register")
    public void postMethodName(@ModelAttribute UserForm user) {
        System.out.println("User: " + user.getName() + "; With password: " + user.getPassword()
                + " was registered at db.");
    }

}
