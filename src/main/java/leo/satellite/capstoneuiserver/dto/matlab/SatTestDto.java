package leo.satellite.capstoneuiserver.dto.matlab;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Setter;
import org.apache.commons.numbers.complex.Complex;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SatTestDto {
    private int idx;
    private int txData;
    private ComplexDto txSig;
    private ComplexDto awgnSig;
    private ComplexDto therSig;
    private ComplexDto phaseSig;
    private int[] rxData;   // FIXME: this might not work... might have to change to list

}
