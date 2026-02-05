package com.cursosena.VeciCocina.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/wendy")
    public String helloword(){
        return "helloword";
    }
}
