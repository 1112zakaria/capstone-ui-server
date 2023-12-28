package leo.satellite.capstoneuiserver.controller;

import leo.satellite.capstoneuiserver.dto.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginRestController {
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return "Hello world!";
    }
}
