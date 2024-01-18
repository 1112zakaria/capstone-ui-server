package leo.satellite.capstoneuiserver.entity;

import jakarta.persistence.*;
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
    @OneToOne(cascade = CascadeType.ALL)
    private ConfigEntity config;

    public SatTestTableEntity() {
        config = new ConfigEntity();
    }

    public SatTestTableEntity(Long userId, List<SatTestRowEntity> rowEntities) {
        this(userId);
        this.satTestRow = rowEntities;
    }

    public SatTestTableEntity(Long userId) {
        this();
        this.userId = userId;
    }
}
