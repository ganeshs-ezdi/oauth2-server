package com.ezdi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by EZDI\ganesh.s on 25/7/16.
 */
public class CustomTokenEnhancer implements TokenEnhancer {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        String name = oAuth2Authentication.getName();
        Collection<? extends GrantedAuthority> authorities = oAuth2Authentication.getAuthorities();
        Map<String,Object> additionalInfo = new HashMap<>();
        additionalInfo.put("principalName", name);
        additionalInfo.put("additional-authorities", Arrays.toString(authorities.toArray()));
        ((DefaultOAuth2AccessToken)oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        return oAuth2AccessToken;
    }


}
