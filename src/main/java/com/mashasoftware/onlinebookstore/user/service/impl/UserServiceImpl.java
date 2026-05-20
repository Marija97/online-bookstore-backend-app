package com.mashasoftware.onlinebookstore.user.service.impl;

import com.mashasoftware.onlinebookstore.user.dto.UserRequestDto;
import com.mashasoftware.onlinebookstore.user.dto.UserResponseDto;
import com.mashasoftware.onlinebookstore.user.entity.User;
import com.mashasoftware.onlinebookstore.user.repository.UserRepository;
import com.mashasoftware.onlinebookstore.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        var user = createEntity(userRequestDto);
        user = userRepository.save(user);

        return createResponse(user);
    }

    @Override
    public UserResponseDto getUserById(Integer id) {
        var user = userRepository.findById(id);
        if (user.isPresent()) return createResponse(user.get());

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User %d doesn't exist".formatted(id));
        // return userRepository
        //        .findById(id)
        //        .map(this::createResponse)
        //        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User %d doesn't exist".formatted(id)));
    }

    private UserResponseDto createResponse(User user) {
        return new UserResponseDto(user.getId(), user.getFullName(), user.getLoyaltyPoints());
    }

    private User createEntity(UserRequestDto userRequestDto) {
        return new User(userRequestDto.fullName());
    }
}
