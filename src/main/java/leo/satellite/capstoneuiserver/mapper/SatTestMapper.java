package leo.satellite.capstoneuiserver.mapper;

import leo.satellite.capstoneuiserver.dto.matlab.SatTestDto;
import leo.satellite.capstoneuiserver.entity.SatTestRowEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SatTestMapper {
    SatTestRowEntity toSatTestEntity(SatTestDto satTestDto);
    List<SatTestRowEntity> toSatTestEntity(List<SatTestDto> satTestDtos);
}
