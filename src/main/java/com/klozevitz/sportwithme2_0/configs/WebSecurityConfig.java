package com.klozevitz.sportwithme2_0.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String[] endpointsForAll = {"/" ,"/login", "/home_page", "/register",
            "/onLoad", "/error_page", "/checkLoginForRegistration"};
    private static final String[] endpointsForAdmin = {"/admin_page"};

    private static String[] endpointsForAuthenticated = {"/profile", "/loadCitiesCountries"};

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/styles/**", "/scripts/**");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .httpBasic().disable()
                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
                .authorizeRequests()
                .antMatchers(endpointsForAuthenticated).hasAnyRole("ADMIN", "USER", "STRIKED")
                .antMatchers(endpointsForAdmin).hasRole("ADMIN")
                .antMatchers(endpointsForAll).permitAll()
                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login").defaultSuccessUrl("/").failureUrl("/").permitAll()
                .and()
                .logout().permitAll().logoutSuccessUrl("/");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {return super.authenticationManagerBean();}

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
