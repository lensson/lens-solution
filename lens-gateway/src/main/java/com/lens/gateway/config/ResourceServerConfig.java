package com.lens.gateway.config;

/**
 * Desc:
 *
 * @author Lens Chen
 * @created 2020-10-15 5:09 PM
 */
//@AllArgsConstructor
//@Configuration
//@EnableWebFluxSecurity
//public class ResourceServerConfig {
//
//    private WhiteListConfig whiteListConfig;
//
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
//
//        if(whiteListConfig!=null && whiteListConfig.getUrls()!=null && whiteListConfig.getUrls().size()>0){
//            http.authorizeExchange()
//                    .pathMatchers(ArrayUtil.toArray(whiteListConfig.getUrls(),String.class)).permitAll()
//                    .and().csrf().disable();
//        }
//
//        return http.build();
//    }
//}
