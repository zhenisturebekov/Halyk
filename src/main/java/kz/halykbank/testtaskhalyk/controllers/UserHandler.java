package kz.halykbank.testtaskhalyk.controllers;

import kz.halykbank.testtaskhalyk.dto.UserDTO;
import kz.halykbank.testtaskhalyk.dto.UserDTOMapper;
import kz.halykbank.testtaskhalyk.entities.User;
import kz.halykbank.testtaskhalyk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserDTOMapper mapper;

    @Autowired
    public UserController(UserRepository userRepository, UserDTOMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserByPersonnelNumber(@Valid @RequestParam int personnelNumber) {

        // If perNum = 0 then returns a list of users
        if (personnelNumber == 0){
            List<UserDTO> resultList = new ArrayList<>();
            List<User> userList = userRepository.findAll();

            for (User user: userList){
                UserDTO userDTO = mapper.mapUserToUserDTO(user);
                resultList.add(userDTO);
            }

            return new ResponseEntity<>(resultList, HttpStatus.OK);
        }

        // If perNum not = 0 then returns a user by PersonnelNumber
        UserDTO result = mapper.mapUserToUserDTO(userRepository.findByPersonnelNumber(personnelNumber));

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody UserDTO userDTO){
        User user = mapper.mapUserDTOToUser(userDTO);
        userRepository.save(user);
    }
}
