package com.mashasoftware.onlinebookstore.user.service;

import com.mashasoftware.onlinebookstore.user.dto.UserRequestDto;
import com.mashasoftware.onlinebookstore.user.dto.UserResponseDto;

public interface UserService {
    UserResponseDto createUser(UserRequestDto user);

    UserResponseDto getUserById(Integer id);
}