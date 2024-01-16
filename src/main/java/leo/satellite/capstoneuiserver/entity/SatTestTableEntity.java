package leo.satellite.capstoneuiserver.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class SatTestTableEntity {
    @Id
    private Long userId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SatTestRowEntity> satTestRow;

    public SatTestTableEntity() {}
}
