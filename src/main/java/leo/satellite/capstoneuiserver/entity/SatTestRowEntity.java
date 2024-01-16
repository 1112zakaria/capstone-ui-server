package leo.satellite.capstoneuiserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SatTestRowEntity {
    @Id @GeneratedValue
    private Long id;
    private Long rowIdx; // row index for maintaining sorted order
    private int txData;
}
