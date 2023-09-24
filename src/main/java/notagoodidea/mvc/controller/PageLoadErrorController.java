package notagoodidea.mvc.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PageLoadErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        if (request == null)
            return "error.html";

        Integer statusCode = Integer.valueOf(request.toString());

        if (statusCode == HttpStatus.NOT_FOUND.value())
            return "/not_found.html";
        else
            return "error";
    }

}
