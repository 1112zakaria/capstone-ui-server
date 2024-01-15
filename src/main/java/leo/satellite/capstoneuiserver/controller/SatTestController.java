package leo.satellite.capstoneuiserver.controller;

import leo.satellite.capstoneuiserver.dto.matlab.SatTestDto;
import leo.satellite.capstoneuiserver.entity.SatTestRowEntity;
import leo.satellite.capstoneuiserver.mapper.SatTestMapper;
import leo.satellite.capstoneuiserver.repository.SatTestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class SatTestController {

    @Value("${matlab-sim.satTest}")
    private String satTestEndpoint;
    private final SatTestRepository repository;
    private final SatTestMapper mapper;

    @GetMapping("/run")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping("/run/satTest")
    public List<SatTestRowEntity> runSatTest() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = satTestEndpoint;
//        ResponseEntity<SatTestDto[]> responseEntity =
//                restTemplate.getForEntity(uri, SatTestDto[].class);
        ResponseEntity<List<SatTestDto>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<SatTestDto>>() {});
//        SatTestDto[] responseArray = responseEntity.getBody();
        List<SatTestDto> responseArray = responseEntity.getBody();

        List<SatTestRowEntity> entities = mapper.toSatTestEntity(responseArray);
        log.info(entities.toString());
        //SatTestTableEntity entity = mapper.toSatTestTableEntity(1L, entities);
//        SatTestTableEntity tableEntity = new SatTestTableEntity(1L, entities);
        repository.saveAll(entities);
//        return responseArray;
        return entities;
    }
}
