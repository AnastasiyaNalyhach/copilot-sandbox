package org.example.api.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfo {
    private long id;
    private String name;
    private String username;
    private String password;
}
