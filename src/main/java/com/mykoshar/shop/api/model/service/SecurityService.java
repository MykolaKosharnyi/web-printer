package com.mykoshar.shop.api.model.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}