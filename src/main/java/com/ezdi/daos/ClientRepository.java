package com.ezdi.daos;

import com.ezdi.beans.OAuth2ClientDetails;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by EZDI\ganesh.s on 25/7/16.
 */
public interface ClientRepository extends CrudRepository<OAuth2ClientDetails, String> {
}
