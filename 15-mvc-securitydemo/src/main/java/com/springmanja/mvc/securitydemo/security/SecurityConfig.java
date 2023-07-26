package com.springmanja.mvc.securitydemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails mayura = User.builder()
                    .username("mayura")
                    .password("{noop}mayuramvc")
                    .roles("ADMIN","MANAGER")
                    .build();
        
        UserDetails jon = User.builder()
                    .username("jon")
                    .password("{noop}jonmvc")
                    .roles("EMPLOYEE")
                    .build();
        
        return new InMemoryUserDetailsManager(mayura, jon);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> 
        configurer
            .requestMatchers("/").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
            .requestMatchers("leaders/**").hasRole("MANAGER")
            .requestMatchers("systems/**").hasRole("ADMIN") 
            .anyRequest().authenticated()
          )
          .formLogin(form -> 
            form   
                    .loginPage("/showMyLoginPage")
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll()
                    )
                    .logout(logout -> 
                    logout
                    //.logoutUrl("/showMyLoginPage")
                    .logoutSuccessUrl("/showMyLoginPage")
                    .permitAll(true)
                    )
                    .exceptionHandling(configurer -> 
                    configurer.accessDeniedPage("/access-denied"));
        return http.build();
    }
    

    
}
