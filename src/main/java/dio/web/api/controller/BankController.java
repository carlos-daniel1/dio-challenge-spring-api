package dio.web.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class BankController {

    @GetMapping
    public String welcome() {
        return "Welcome to my Spring WEB API ok";
    }

    @PostMapping
    public String hello() {
        return "hello";
    }
}
