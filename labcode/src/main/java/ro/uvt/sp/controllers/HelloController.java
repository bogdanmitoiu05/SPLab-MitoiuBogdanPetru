package ro.uvt.sp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.sp.components.ClientComponent;

@RestController
public record HelloController(ClientComponent clientComponent) {
    @GetMapping("/")
    public String sayHi(){
        return "Hello from ClientComponent "+clientComponent;
    }
}
