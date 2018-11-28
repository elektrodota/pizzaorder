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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public WebSecurityConfig() {
        super();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder().encode("1234")).roles("USER")
                .and()
                .withUser("user2").password(passwordEncoder().encode("12345")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/h2_console/**").permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable()
                .and().authorizeRequests().antMatchers("/Login*").anonymous()
                .and().authorizeRequests().antMatchers("/Checkout").authenticated()
                .and().formLogin()
                .defaultSuccessUrl("/")
                .failureUrl("/?error=true")
                .failureHandler(authenticationFailureHandler())
                .and()
                .logout().deleteCookies("JSESSIONID").logoutRequestMatcher(new AntPathRequestMatcher("/Logout")).logoutSuccessUrl("/Index.html").logoutSuccessHandler(logoutSuccessHandler()).and()
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