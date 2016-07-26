package com.ezdi.beans;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.*;
import java.util.*;

/**
 * Created by EZDI\ganesh.s on 25/7/16.
 */
@Entity
@Table(name="oauth2_client")
public class OAuth2ClientDetails implements ClientDetails {
    @Id
    private String clientId;
    private String clientSecret;
    private boolean scope;
    private int accessTokenValiditySeconds;
    private int refreshTokenValiditySeconds;
    private boolean autoApprove;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="resourceids",
            joinColumns = @JoinColumn(name="client_id")
    )
    @Column(name="resourceId")
    private Set<String> resourceIds;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="grant_types",
            joinColumns = @JoinColumn(name="client_id")
    )
    @Column(name="grant_type")
    private Set<String> authorizedGrantTypes;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="redirect_url",
            joinColumns = @JoinColumn(name="client_id")
    )
    @Column(name="registered_redirect_url")
    private Set<String> registeredRedirectUri;

    @Override
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public Set<String> getScope() {
        return new HashSet<String>(Arrays.asList("scope","read","write"));
    }

    @Override
    public boolean isScoped() {
        return scope;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    public void setAccessTokenValiditySeconds(int accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(int refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return true;
    }

    public boolean isAutoApprove() {
        return autoApprove;
    }

    public void setAutoApprove(boolean autoApprove) {
        this.autoApprove = autoApprove;
    }

    @Override
    public Set<String> getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(Set<String> resourceIds) {
        this.resourceIds = resourceIds;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return registeredRedirectUri;
    }

    public void setRegisteredRedirectUri(Set<String> registeredRedirectUri) {
        this.registeredRedirectUri = registeredRedirectUri;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ALLOW"));
        return grantedAuthorities;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
