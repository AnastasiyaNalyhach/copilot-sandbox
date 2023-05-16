package org.example.api.steps;

import org.example.api.client.dto.UserInfo;
import org.example.api.client.implementation.HerokuAppClient;

import java.util.List;

public class HerokuAppSteps {
    private HerokuAppClient herokuAppClient;

    public HerokuAppSteps() {
        this.herokuAppClient = new HerokuAppClient();
    }

    public List<UserInfo> getAllUsers() {
       return herokuAppClient.getAllUsers();
    }

    public String updateUserInfo(UserInfo userInfo) {
        return herokuAppClient.updateUserInfo(userInfo);
    }

    public String deleteUser(long id) {
        return herokuAppClient.deleteUser(id);
    }

    public void checkUserIsDeleted(long id) {
        herokuAppClient.getAllUsers().stream()
                .filter(userInfo -> userInfo.getId() == id)
                .findFirst()
                .ifPresent(userInfo -> {
                    throw new RuntimeException("User with id %s is not deleted".formatted(id));
                });
    }

    public void checkUserIsUpdated(long id, String name, String username) {
        herokuAppClient.getAllUsers().stream()
                .filter(userInfo -> userInfo.getId() == id)
                .findFirst()
                .ifPresent(userInfo -> {
                    if (!userInfo.getName().equals(name) || !userInfo.getUsername().equals(username)) {
                        throw new RuntimeException("User with id %s is not updated".formatted(id));
                    }
                });
    }
}
