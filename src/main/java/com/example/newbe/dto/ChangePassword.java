package com.example.newbe.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePassword {
    private String userName;
    private String oldPassword;
    private String newPassword;
}
