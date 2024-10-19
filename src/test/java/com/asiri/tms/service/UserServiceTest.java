package com.asiri.tms.service;

import jakarta.transaction.Transactional;
import com.asiri.tms.service.exception.ServiceException;
import com.asiri.tms.to.UserTo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void signUp() {
        UserTo user = new UserTo("xxx-asiri", "asiri123", "Asiri Ekanayaka");
        assertDoesNotThrow(() -> {
            userService.signUp(user);
        });
        assertThrows(ServiceException.class, () -> {
            userService.signUp(user);
        });
    }

    @Test
    void signIn() {
        signUp();
        UserTo user = new UserTo("xxx-asiri", "asiri123");
        assertDoesNotThrow(() -> {
            String token = userService.signIn(user);
            System.out.println(token);
        });
        assertThrows(BadCredentialsException.class, ()->{
            user.setPassword("invalid-password");
            userService.signIn(user);
        });
        assertThrows(UsernameNotFoundException.class, ()->{
            user.setUsername("kasun");
            userService.signIn(user);
        });
    }
}