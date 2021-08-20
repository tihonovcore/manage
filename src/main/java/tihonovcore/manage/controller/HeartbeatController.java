package tihonovcore.manage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatController {
    @GetMapping("/heartbeat")
    public String heartbeat() {
        return "alive";
    }
}
