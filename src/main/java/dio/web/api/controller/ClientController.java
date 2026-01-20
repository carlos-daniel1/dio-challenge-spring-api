package dio.web.api.controller;

import dio.web.api.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;

    @GetMapping
    public String welcome() {
        return "Welcome to my Spring WEB API ok";
    }

    @PostMapping
    public String hello() {
        return "hello";
    }
}
