package leo.satellite.capstoneuiserver.dto.matlab;

import lombok.Data;

@Data
public class ConfigDto {
    private Long userId;
    private double snr;
    private double numBits;
    private double modOrd;
}
