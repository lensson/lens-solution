package com.lens.auth.service.impl;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;

import java.util.Map;

/**
 * Desc:
 *
 * @author Lens Chen
 * @created 2020-10-20 2:05 PM
 */
public class HardCodingClientDetailServiceImpl extends InMemoryClientDetailsService {

    public HardCodingClientDetailServiceImpl(Map<String, ? extends ClientDetails> map){

        this.setClientDetailsStore(map);
    }
}
