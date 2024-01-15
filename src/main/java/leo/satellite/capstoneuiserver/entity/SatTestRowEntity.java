package leo.satellite.capstoneuiserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class SatTestRowEntity {
    @Id @GeneratedValue
    private Long id;
    private Long userId; // corresponds to requesting userId
    private Long idx; // row index for maintaining sorted order
    private int txData;
}
