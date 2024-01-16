package leo.satellite.capstoneuiserver.services;

import leo.satellite.capstoneuiserver.entity.SatTestRowEntity;
import leo.satellite.capstoneuiserver.entity.SatTestTableEntity;
import leo.satellite.capstoneuiserver.entity.User;
import leo.satellite.capstoneuiserver.repository.SatTestTableRepository;
import leo.satellite.capstoneuiserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO: change the name, it's shit
 */
@Service
@RequiredArgsConstructor
public class SatTestService {
    private final UserRepository userRepository;
    private final SatTestTableRepository tableRepository;

    public SatTestTableEntity updateUserTable(String username, List<SatTestRowEntity> rowEntities) {
        User user = userRepository.findByLogin(username).orElse(null);
        SatTestTableEntity tableEntity;

        assert user != null;
        tableEntity = new SatTestTableEntity(user.getId(), rowEntities);
        tableRepository.deleteById(user.getId()); // clear existing table
        tableRepository.save(tableEntity);

        return tableEntity;
    }
}
