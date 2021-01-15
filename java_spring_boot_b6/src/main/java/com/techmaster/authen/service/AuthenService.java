package com.techmaster.authen.service;

import com.techmaster.authen.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenService  implements IAuthenService{

    private final PasswordEncoder encoder;

    public AuthenService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Override
    public void createAccount(String fullname, String email, String password) throws AuthenException {

    }

    @Override
    public void updateAccount(String fullname, String email) throws AuthenException {

    }

    @Override
    public String hashPassword(String password) {
        return null;
    }

    @Override
    public User findUserByID(String userid) {
        return null;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public boolean isAdmin(String userid) {
        return false;
    }

    @Override
    public boolean hasRole(String userid, String role) {
        return false;
    }

    @Override
    public void updateRole(String userid, List<String> roles) {

    }

    @Override
    public List<String> getRoles(String userid) {
        return null;
    }
}
