package hu.teamnamerequired.pizzaorder.configuration;

import hu.teamnamerequired.pizzaorder.security.AuthFailureHandler;
import hu.teamnamerequired.pizzaorder.security.CustomAccessDeniedHandler;
import hu.teamnamerequired.pizzaorder.security.CustomLogoutSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public WebSecurityConfig() {
        super();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
        auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder().encode("1234")).roles("USER")
                .and()
                .withUser("user2").password(passwordEncoder().encode("12345")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
        // @formatter:on
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
          .antMatchers("/Login*").anonymous()
          .anyRequest().authenticated()
          .and()
          .formLogin()
          .loginPage("/Login.html")
          .defaultSuccessUrl("/welcome")
          .failureUrl("/Login.html?error=true")
          .failureHandler(authenticationFailureHandler())
          .and()
          .logout().deleteCookies("JSESSIONID").logoutSuccessUrl("/Login.html").logoutSuccessHandler(logoutSuccessHandler()).and()
          .exceptionHandling().accessDeniedPage("/accessDenied").accessDeniedHandler(accessDeniedHandler());
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomLogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }

    @Bean
    public CustomAccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public AuthFailureHandler authenticationFailureHandler() {
        return new AuthFailureHandler();
    }
}