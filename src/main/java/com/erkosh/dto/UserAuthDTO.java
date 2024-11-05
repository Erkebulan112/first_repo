package com.erkosh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAuthDTO {
    private String username;
    private String password;
}
