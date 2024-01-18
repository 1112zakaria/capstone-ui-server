package leo.satellite.capstoneuiserver.controller;

import leo.satellite.capstoneuiserver.dto.UserDto;
import leo.satellite.capstoneuiserver.dto.matlab.ConfigDto;
import leo.satellite.capstoneuiserver.dto.matlab.SatTestDto;
import leo.satellite.capstoneuiserver.entity.ConfigEntity;
import leo.satellite.capstoneuiserver.entity.SatTestRowEntity;
import leo.satellite.capstoneuiserver.entity.SatTestTableEntity;
import leo.satellite.capstoneuiserver.entity.User;
import leo.satellite.capstoneuiserver.mapper.SatTestMapper;
import leo.satellite.capstoneuiserver.repository.SatTestRowRepository;
import leo.satellite.capstoneuiserver.repository.SatTestTableRepository;
import leo.satellite.capstoneuiserver.services.SatTestService;
import leo.satellite.capstoneuiserver.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@Slf4j
public class SatTestController {

    @Value("${matlab-sim.satTest}")
    private String satTestEndpoint;
    private final SatTestService service;
    private final UserService userService;
    private final SatTestMapper mapper;

    @GetMapping("/debug")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping("/debug/satTest")
    public List<SatTestDto> debugRunSatTest() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        RestTemplate restTemplate = new RestTemplate();
        String uri = satTestEndpoint;
        ResponseEntity<List<SatTestDto>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<SatTestDto>>() {});
        List<SatTestDto> responseArray = responseEntity.getBody();
        log.info(responseArray.toString());
        List<SatTestRowEntity> entities = mapper.toSatTestEntity(responseArray);
        log.info(entities.toString());

        log.info(auth.getName());

        // FIXME: add conditional to check if user is not anonymous? Maybe 0 can be anon?
        service.updateUserTable("guest", entities);
        return responseArray;
    }

    @GetMapping("/api/satTest")
    public List<SatTestDto> getSatTestData() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return null;
    }

    @PostMapping("/api/satTest")
    public List<SatTestDto> runSatTest() {
        return null;
    }

    @GetMapping("/api/config")
    public ResponseEntity<ConfigDto> getConfig() {
        ConfigDto config;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto user;

        // fetch user?
        log.info("user's name: " + auth.getName());
        user = (UserDto) auth.getPrincipal(); // IMPORTANT: get principal and cast accordingly...
        // call config fetch service
        config = service.getUserConfig(user);
        // return config dto
        return ResponseEntity.ok(config);
    }

    @PostMapping("/api/config")
    public ResponseEntity<ConfigDto> setConfig(@RequestBody ConfigDto configDto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ConfigDto config;
        UserDto user = (UserDto) auth.getPrincipal();

        config = service.setUserConfig(user, configDto);
        return ResponseEntity.ok(config);
    }
}
