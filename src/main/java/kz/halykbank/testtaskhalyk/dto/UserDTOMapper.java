package kz.halykbank.testtaskhalyk.dto;

import kz.halykbank.testtaskhalyk.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public UserDTO mapUserToUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User mapUserDTOToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
