package leo.satellite.capstoneuiserver.mapper;

import leo.satellite.capstoneuiserver.dto.SignUpDto;
import leo.satellite.capstoneuiserver.dto.UserDto;
import leo.satellite.capstoneuiserver.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User userDto);
    User toUserEntity(UserDto userDto);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto userDto);
}
