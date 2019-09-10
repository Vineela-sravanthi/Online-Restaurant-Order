package org.launchcode.Online.restaurant.order.services;

import org.launchcode.Online.restaurant.order.models.forms.User;

public interface UserService {

    Long save(User user);
    User findByEmail(String email);
}