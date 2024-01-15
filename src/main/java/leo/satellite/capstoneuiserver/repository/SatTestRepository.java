package leo.satellite.capstoneuiserver.repository;

import leo.satellite.capstoneuiserver.entity.SatTestRowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SatTestRepository extends JpaRepository<SatTestRowEntity, Long> {
}
