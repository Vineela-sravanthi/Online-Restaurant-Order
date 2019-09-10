package org.launchcode.Online.restaurant.order.services;

public interface SecurityService {
    void login(String username, String password);
    void logout();
}