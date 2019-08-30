package org.launchcode.Online.restaurant.order.models.data;


import org.launchcode.Online.restaurant.order.models.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface AdminDao extends CrudRepository<Admin,Integer> {

}

