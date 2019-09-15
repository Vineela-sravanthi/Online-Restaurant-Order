package org.launchcode.Online.restaurant.order.models.data;


import org.launchcode.Online.restaurant.order.models.forms.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface UserDao extends CrudRepository<User,Long> {
    User findByEmail(String email);
}


