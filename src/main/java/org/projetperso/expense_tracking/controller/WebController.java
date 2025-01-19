package org.projetperso.expense_tracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // Notez l'utilisation de @Controller au lieu de @RestController
public class WebController {

    @GetMapping(value = {"/", "/{path:^(?!api|actuator).*$}/**"})
    public String forward() {
        return "forward:/index.html";
    }
}
