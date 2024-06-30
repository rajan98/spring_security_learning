package com.rajan.eazybank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

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

    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        /*
         * Approach 1 where we use withDefaultPasswordEncoder() method.
         * This is shown as deprecated as this is the simplest password encoder
         * and should not be used due to security reasons.
         * */
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .authorities("admin")
//                .build();
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("user")
//                .authorities("read")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);


        /*
         * Approach 2 where we use NoOpPasswordEncoder Bean while creating
         * the user details.
         * */
        UserDetails admin = User.withUsername("admin")
                .password("admin")
                .authorities("admin")
                .build();
        UserDetails user = User.withUsername("user")
                .password("user")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    /*
     * NoOpPasswordEncoder is not recommended for production usage.
     * Use only for non-prod.
     * @return PasswordEncoder
     * */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
