package notagoodidea.supertask.authentication.controllers.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import notagoodidea.supertask.authentication.database.DatabaseRegistrar;
import notagoodidea.supertask.authentication.model.User;
import notagoodidea.supertask.authentication.utils.annotations.LogInfoFromPostMethod;


@Controller
public class RegisterPageController {

    @Autowired
    DatabaseRegistrar databaseRegistrar;

    @GetMapping(value = "register")
    public String getView() {
        return "register";
    }

    @LogInfoFromPostMethod
    @PostMapping(value = "register")
    public void registerUser(@ModelAttribute User user) {
        databaseRegistrar.registerOnDatabase(user);
    }

}
