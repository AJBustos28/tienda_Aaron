package com.tienda.security;

import com.tienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author aaron
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserService userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserService getUserService() {
        return new UserService();
    }
    @Bean 
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(getUserService());
        return daoAuthenticationProvider;
    }
    
    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler() {
        return new AppAuthenticationSuccessHandler();
    }
    public SecurityConfig(UserService userPrincipalDetailsService) {
        this.userDetailsService = userPrincipalDetailsService;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }
    
    //Este metodo funciona para realizar la autenticacion del usuario
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/persona","/login")
                .hasRole("ADMIN")
                .antMatchers("/personaN","/persona","/","/login")
                .hasAnyRole("USER","VENDEDOR","ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }
    //El siguiente metodo funciona para realizar la autorizacion de accesos
    //il8n
}
