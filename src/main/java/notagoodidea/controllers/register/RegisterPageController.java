package notagoodidea.controllers.register;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import notagoodidea.database.DatabaseRegistrar;
import notagoodidea.model.User;
import notagoodidea.utils.LogInfoFromPostMethod;


@Controller
public class RegisterPageController {

    @GetMapping(value = "register")
    public String getView() {
        return "register";
    }

    @LogInfoFromPostMethod
    @PostMapping(value = "register")
    public void registerUser(@ModelAttribute User user) {
        new DatabaseRegistrar().registerOnDatabase(user);
    }

}
