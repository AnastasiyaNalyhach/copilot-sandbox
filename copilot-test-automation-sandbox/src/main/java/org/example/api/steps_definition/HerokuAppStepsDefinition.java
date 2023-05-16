package org.example.api.steps_definition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.api.client.dto.UserInfo;
import org.example.api.steps.HerokuAppSteps;

public class HerokuAppStepsDefinition {

    private HerokuAppSteps herokuAppSteps;

    public HerokuAppStepsDefinition() {
        this.herokuAppSteps = new HerokuAppSteps();
    }

    @When("^user deletes user with id (\\d+)$")
    public void userDeletesUserWithId(long id) {
        herokuAppSteps.deleteUser(id);
    }

    @When("^user updates user with id (\\d+) name \"([^\"]*)\" and username \"([^\"]*)\"$")
    public void userUpdatesUserWithIdToNameAndUsername(long id, String name, String username) {
        var userInfo = UserInfo.builder()
                .id(id)
                .name(name)
                .username(username)
                .build();
        herokuAppSteps.updateUserInfo(userInfo);
    }

    @Then("^user checks that user with id (\\d+) is deleted$")
    public void userChecksThatUserWithIdIsDeleted(long id) {
        herokuAppSteps.checkUserIsDeleted(id);
    }
    @Then("^user checks that user with id (\\d+) is updated to name \"([^\"]*)\" and username \"([^\"]*)\" is updated$")
    public void userChecksThatUserIsUpdated(long id, String name, String username) {
        herokuAppSteps.checkUserIsUpdated(id, name, username);
    }

    @When("user creates user with name {string} and username {string}")
    public void userCreatesUserWithNameAndUsername(String arg0, String arg1, String arg2, String arg3) {

    }

    @Then("user checks that user with name {string} and username {string} is created")
    public void userChecksThatUserWithNameAndUsernameIsCreated(String arg0, String arg1, String arg2, String arg3) {
    }
}
