package com.mashasoftware.onlinebookstore.user.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDto(@NotBlank @Size(max = 50) String fullName) {

}
