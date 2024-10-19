package com.asiri.tms.service;

import com.asiri.tms.to.UserTo;

public interface UserService {

    void signUp(UserTo userTo);

    String signIn(UserTo userTo);
}
