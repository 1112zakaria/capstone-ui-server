package leo.satellite.capstoneuiserver.controller;

import leo.satellite.capstoneuiserver.dto.matlab.SatTestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SatTestController {

    @Value("${matlab-sim.satTest}")
    private String satTestEndpoint;

    @GetMapping("/run/satTest")
    public String runSatTest() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = satTestEndpoint;
        return uri;
    }
}
