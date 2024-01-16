package leo.satellite.capstoneuiserver.repository;

import leo.satellite.capstoneuiserver.entity.SatTestTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatTestTableRepository extends JpaRepository<SatTestTableEntity, Long> {
}
