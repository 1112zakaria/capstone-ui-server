package leo.satellite.capstoneuiserver.services;

import leo.satellite.capstoneuiserver.dto.UserDto;
import leo.satellite.capstoneuiserver.dto.matlab.ConfigDto;
import leo.satellite.capstoneuiserver.entity.ConfigEntity;
import leo.satellite.capstoneuiserver.entity.SatTestRowEntity;
import leo.satellite.capstoneuiserver.entity.SatTestTableEntity;
import leo.satellite.capstoneuiserver.entity.User;
import leo.satellite.capstoneuiserver.exception.AppException;
import leo.satellite.capstoneuiserver.mapper.SatTestMapper;
import leo.satellite.capstoneuiserver.repository.ConfigRepository;
import leo.satellite.capstoneuiserver.repository.SatTestTableRepository;
import leo.satellite.capstoneuiserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * TODO: change the name, it's shit
 */
@Service
@RequiredArgsConstructor
public class SatTestService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final SatTestTableRepository tableRepository;
    private final ConfigRepository configRepository;
    private final SatTestMapper mapper;

    public SatTestTableEntity updateUserTable(String username, List<SatTestRowEntity> rowEntities) {
        // FIXME: do not access another service's repository
        User user = userRepository.findByLogin(username).orElse(null);
        SatTestTableEntity tableEntity;

        assert user != null;
        tableEntity = new SatTestTableEntity(user.getId(), rowEntities);
        tableRepository.deleteById(user.getId()); // clear existing table
        tableRepository.save(tableEntity);

        return tableEntity;
    }

    public ConfigDto getUserConfig(UserDto user) {
        // FIXME: do not access another service's repository
        ConfigEntity config;
        Optional<SatTestTableEntity> table;

        table = tableRepository.findById(user.getId());
        if (table.isEmpty()) {
            throw new AppException("User table not found", HttpStatus.BAD_REQUEST);
        }
        config = table.get().getConfig();
        return mapper.toConfigDto(config);
    }



//    public SatTestTableEntity initializeTable(User user) {
//        // FIXME: stop passing fucking strings, pass the User entity object damnit!
//        Optional<SatTestTableEntity> table;
//        SatTestTableEntity newTable;
//
//        // get existing table, if it does exist create new one
//        table = tableRepository.findById(user.getId());
//        if (table.isPresent()) {
//            return table.get();
//        }
//        newTable = new SatTestTableEntity(user.getId());
//        tableRepository.save(newTable);
//        return newTable;
//    }
}
