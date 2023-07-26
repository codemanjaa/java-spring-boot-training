package com.springmanja.dbdemo.dbcruddemo.security;
import java.beans.BeanProperty;
import org.springframework.security.config.Customizer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.http.HttpMethod;
import javax.sql.DataSource;
import org.springframework.security.provisioning.UserDetailsManager;


@Configuration
public class SecurityConfig {

    //Add support for JDBC
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    /**
     * 
     * @param http
     * @return
     * @throws Exception
     */
    /*
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest()
      .authenticated())
      .httpBasic(Customizer.withDefaults())
      .formLogin(Customizer.withDefaults())  
      .csrf(AbstractHttpConfigurer::disable);
    return http.build();
}
*/

    /*
     * 
     */
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> 
            configurer 
                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
                );
                // Use the Basic auth
                http.httpBasic(Customizer.withDefaults());

                // disable csrf as not required for the stateless REST API
                http.csrf(csrf -> csrf.disable());

                return http.build();
    }


    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails jon = User.builder()
                .username("jon")
                .password("{noop}1234")
                .roles("EMPLOYEE")
                .build();

         UserDetails cholan = User.builder()
                .username("cholan")
                .password("{noop}2345")
                .roles("EMPLOYEE", "MANAGER")
                .build();
         UserDetails mayura = User.builder()
                .username("mayura")
                .password("{noop}mayura")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();
        
        return new InMemoryUserDetailsManager(jon, cholan,mayura);
    }
    */
}
