package com.lens.auth.config;

/**
 * Desc:
 * 授权服务配置
 *
 * @author Lens Chen
 * @created 2020-10-15 4:52 PM
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;


@Configuration
public class AuthorizationServerConfig {


    private final String KeyPair = "lens.jks";
    private final String StorePassword = "123456";
    private final String Alias = "lens";
    private final String Password = "123456";

    @Bean
    public KeyPair keyPair() {
        KeyStoreKeyFactory factory = new KeyStoreKeyFactory(
                new ClassPathResource(KeyPair), StorePassword.toCharArray());
        KeyPair keyPair = factory.getKeyPair(
                Alias, Password.toCharArray());
        return keyPair;
    }
}
