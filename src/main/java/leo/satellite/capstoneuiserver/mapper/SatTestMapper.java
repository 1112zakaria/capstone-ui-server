package leo.satellite.capstoneuiserver.mapper;

import leo.satellite.capstoneuiserver.dto.matlab.ConfigDto;
import leo.satellite.capstoneuiserver.dto.matlab.SatTestDto;
import leo.satellite.capstoneuiserver.entity.ConfigEntity;
import leo.satellite.capstoneuiserver.entity.SatTestRowEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SatTestMapper {
    @Mappings({
            @Mapping(source = "txSig.real", target = "txSigReal"),
            @Mapping(source = "txSig.imaginary", target = "txSigImag"),
            @Mapping(source = "awgnSig.real", target = "awgnSigReal"),
            @Mapping(source = "awgnSig.imaginary", target = "awgnSigImag"),
            @Mapping(source = "therSig.real", target = "therSigReal"),
            @Mapping(source = "therSig.imaginary", target = "therSigImag"),
            @Mapping(source = "phaseSig.real", target = "phaseSigReal"),
            @Mapping(source = "phaseSig.imaginary", target = "phaseSigImag"),
            @Mapping(expression = "java(satTestDto.mapRxData())", target = "rxData")
    })
    SatTestRowEntity toSatTestEntity(SatTestDto satTestDto);
    List<SatTestRowEntity> toSatTestEntity(List<SatTestDto> satTestDtos);
    ConfigDto toConfigDto(ConfigEntity config);
    ConfigEntity toConfigEntity(ConfigDto config);
}
