package leo.satellite.capstoneuiserver.repository;

import leo.satellite.capstoneuiserver.entity.ConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<ConfigEntity, Long> {
}
