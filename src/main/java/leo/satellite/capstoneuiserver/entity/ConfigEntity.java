package leo.satellite.capstoneuiserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class ConfigEntity {
    @Id @GeneratedValue
    private Long id;
    private double snr;
    private double numBits;
    private double modOrd;

    public ConfigEntity() {
        snr = 25;
        numBits = 40;
        modOrd = 64;
    }
}
