package com.techmaster.authen;

import com.techmaster.authen.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserTest {

    @Autowired
    private TestEntityManager tem;

    @Test
    public void createNewUser(){
        String hashedPassword = "qwew3221321-";
        User user = new User("Nguyễn Tiến Nam","namtien97@gmail.com",hashedPassword);
        System.out.println(user.getId());
        assertThat(user.getId().length()).isGreaterThan(10);
    }
}
