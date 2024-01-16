package leo.satellite.capstoneuiserver.repository;

import leo.satellite.capstoneuiserver.entity.SatTestRowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatTestRowRepository extends JpaRepository<SatTestRowEntity, Long> {
}
