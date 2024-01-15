package leo.satellite.capstoneuiserver.controller;

import leo.satellite.capstoneuiserver.dto.matlab.SatTestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class SatTestController {

    @Value("${matlab-sim.satTest}")
    private String satTestEndpoint;

    @GetMapping("/run")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping("/run/satTest")
    public SatTestDto[] runSatTest() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = satTestEndpoint;
        ResponseEntity<SatTestDto[]> responseEntity =
                restTemplate.getForEntity(uri, SatTestDto[].class);
        SatTestDto[] responseArray = responseEntity.getBody();
        return responseArray;
    }
}
