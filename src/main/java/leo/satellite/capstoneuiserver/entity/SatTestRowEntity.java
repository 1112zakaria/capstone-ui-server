package leo.satellite.capstoneuiserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import leo.satellite.capstoneuiserver.dto.matlab.ComplexDto;
import lombok.Data;

@Entity
@Data
public class SatTestRowEntity {
    @Id @GeneratedValue
    private Long id;
    private int rowIdx; // row index for maintaining sorted order
    private int txData;
    private double txSigReal;
    private double txSigImag;
    private double awgnSigReal;
    private double awgnSigImag;
    private double therSigReal;
    private double therSigImag;
    private double phaseSigReal;
    private double phaseSigImag;
    private String rxData;

}
