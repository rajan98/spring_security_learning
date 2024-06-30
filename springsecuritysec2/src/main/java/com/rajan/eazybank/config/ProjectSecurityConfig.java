package com.rajan.eazybank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    /*
    * We are overriding the bean defined in SpringBootWebSecurityConfiguration.
    * By doing this we can define our own filter configuration. With Spring 6.1
    * the configuration is moved to Lambda DSL configuration which makes the code
    * more readable, eliminates the use of .and() and is similar with the configuration
    * used by Spring Integration, Spring Cloud Gateway.*/
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> {
            requests
                    .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                    .requestMatchers("/notices", "/contact").permitAll();
                })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();

        /*
        * We can use requests.anyRequest().denyAll() to deny all the request
        * that comes to our web application. This can be done to perfrom testing.
        * For Dev/Test environment. We can use @Profile for this configuration.
        * To allow all request we can use requests.anyRequest().permitAll()*/

//        http.authorizeHttpRequests((requests) -> {
//            requests.anyRequest().permitAll();
//                })
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//
//        return http.build();
    }
}
