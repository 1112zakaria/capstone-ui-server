package leo.satellite.capstoneuiserver.dto.matlab;

import org.apache.commons.numbers.complex.Complex;

import java.util.List;

public class SatTestDto {
    private int idx;
    private int txData;
    private Complex txSig;
    private Complex awgnSig;
    private Complex therSig;
    private Complex phaseSig;
    private int[] rxData;   // FIXME: this might not work... might have to change to list

}
