package leo.satellite.capstoneuiserver.dto.matlab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SatTestDto {
    private int rowIdx;
    private int txData;
    private ComplexDto txSig;
    private ComplexDto awgnSig;
    private ComplexDto therSig;
    private ComplexDto phaseSig;
    private List<Integer> rxData;   // FIXME: this might not work... might have to change to list

}
