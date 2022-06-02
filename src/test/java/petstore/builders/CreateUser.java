package petstore.builders;

import petstore.models.User;

public class CreateUser {
    public static User createTheUser() {
        return User.builder()
                .id(1)
                .username("user")
                .firstName("firstName")
                .lastName("lastName")
                .email("email@email.com")
                .password("test123")
                .phone("1234587890")
                .userStatus(1)
                .build();
    }
}
