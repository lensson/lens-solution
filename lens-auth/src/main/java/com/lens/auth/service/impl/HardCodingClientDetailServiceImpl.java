package com.lens.auth.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Desc:
 *
 * @author Lens Chen
 * @created 2020-10-20 2:05 PM
 */
public class HardCodingClientDetailServiceImpl extends InMemoryClientDetailsService {

    public HardCodingClientDetailServiceImpl(){
        ClientDetails c = new ClientDetails() {
            @Override
            public String getClientId() {
                return "lens-admin-app";
            }

            @Override
            public Set<String> getResourceIds() {
                return null;
            }

            @Override
            public boolean isSecretRequired() {
                return false;
            }

            @Override
            public String getClientSecret() {
                return null;
            }

            @Override
            public boolean isScoped() {
                return false;
            }

            @Override
            public Set<String> getScope() {
                return null;
            }

            @Override
            public Set<String> getAuthorizedGrantTypes() {
                return null;
            }

            @Override
            public Set<String> getRegisteredRedirectUri() {
                return null;
            }

            @Override
            public Collection<GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Integer getAccessTokenValiditySeconds() {
                return null;
            }

            @Override
            public Integer getRefreshTokenValiditySeconds() {
                return null;
            }

            @Override
            public boolean isAutoApprove(String s) {
                return false;
            }

            @Override
            public Map<String, Object> getAdditionalInformation() {
                return null;
            }
        };

        Map<String,ClientDetails> map = new HashMap<>();

        map.put(c.getClientId(),c);
        this.setClientDetailsStore(map);
    }


    public HardCodingClientDetailServiceImpl(Map<String, ? extends ClientDetails> map){

        this.setClientDetailsStore(map);
    }
}
