package com.printmaster.nk.service.user;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}