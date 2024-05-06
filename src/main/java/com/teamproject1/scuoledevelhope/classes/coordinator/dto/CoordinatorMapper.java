package com.teamproject1.scuoledevelhope.classes.coordinator.dto;

import com.teamproject1.scuoledevelhope.classes.classP.dto.ClassRegisterMapper;
import com.teamproject1.scuoledevelhope.classes.coordinator.Coordinator;
import com.teamproject1.scuoledevelhope.classes.user.User;
import com.teamproject1.scuoledevelhope.classes.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoordinatorMapper {

    private final ClassRegisterMapper classRegisterMapper;

    private final UserMapper userMapper = new UserMapper();

    public CoordinatorMapper(ClassRegisterMapper classRegisterMapper) {
        this.classRegisterMapper = classRegisterMapper;
    }

    public CoordinatorDto toCoordinatorDto(Coordinator coordinator) {
        return CoordinatorDto.CoordinatorDtoBuilder.aCoordinatorDto()
                .withClasses(coordinator.getClasses() != null ? classRegisterMapper.toListOfClassRegisterDto(coordinator.getClasses()) : null)
                .withUser(userMapper.userToUserDto(coordinator.getUser()))
                .build();
    }

    public List<CoordinatorDto> toCoordinatorDtoList(List<Coordinator> coordinators) {
        List<CoordinatorDto> toReturn = new ArrayList<>();
        for (Coordinator coordinator : coordinators) {
            toReturn.add(toCoordinatorDto(coordinator));
        }
        return toReturn;
    }

    public Coordinator userToCoordinator(User user) {
        return Coordinator.CoordinatorBuilder.aCoordinator()
                .withUser(user)
                .build();
    }
}
