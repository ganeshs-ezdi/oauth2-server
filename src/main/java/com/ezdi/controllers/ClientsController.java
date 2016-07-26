package com.ezdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by EZDI\ganesh.s on 25/7/16.
 */
@RestController
public class ClientsController {
    @Autowired
    private ClientDetailsService service;

    @RequestMapping("/clients/{client_id}")
    public ClientDetails getClients(@PathVariable("client_id") String client_id) {
        return service.loadClientByClientId(client_id);
    }
}
