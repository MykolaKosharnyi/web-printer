package com.printmaster.nk.model.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}