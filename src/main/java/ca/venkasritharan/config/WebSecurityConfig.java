package ca.venkasritharan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    DataSource dataSource;

    WebSecurityConfig(
            UserDetailsService userDetailsService,
            AuthenticationManagerBuilder auth,
            DataSource dataSource,
            PasswordEncoder passwordEncoder
    ) throws Exception {
        this.dataSource = dataSource;
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }





    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // remove "h2-console" from the program in production
                .antMatchers("/css/**", "/images/**", "/js/**", "/index", "/", "/h2-console/**")
                .permitAll();
                http.authorizeRequests()
                .antMatchers("/cat/**").hasRole("CAT")
                .antMatchers("/dog/**").hasRole("DOG")
                .anyRequest()
                .authenticated();
                http.formLogin()
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll()
                        .and()
                .logout()
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/index")
                        .permitAll();
    }


}
