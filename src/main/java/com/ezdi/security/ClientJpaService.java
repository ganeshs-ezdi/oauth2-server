package com.ezdi.security;

import com.ezdi.daos.ClientRepository;
import com.ezdi.daos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

/**
 * Created by EZDI\ganesh.s on 25/7/16.
 */
public class ClientJpaService implements ClientDetailsService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        System.out.println("Searching for client " + s);
        ClientDetails details = clientRepository.findOne(s);
        if(details == null) {
            throw new ClientRegistrationException("Unable to register the client");
        }
        return details;
    }
}
