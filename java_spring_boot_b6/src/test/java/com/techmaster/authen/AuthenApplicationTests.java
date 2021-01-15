package com.techmaster.authen;

import com.techmaster.authen.service.AuthenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AuthenApplicationTests {

    @Autowired
    private AuthenService authenService;

    @Test
    public void testHashedPasswordMock(){
        String hashedPass = authenService.hashPassword("abcde");
        System.out.println(hashedPass);
        assertThat(hashedPass.length()).isGreaterThan(10);
    }

}
