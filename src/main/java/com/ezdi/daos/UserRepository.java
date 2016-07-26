package com.ezdi.daos;

import com.ezdi.beans.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by EZDI\ganesh.s on 25/7/16.
 */
public interface UserRepository extends CrudRepository<User, String> {
}
